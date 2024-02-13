/*One thread for reading from File and other thread for writing to file */

import java.io.*;
class Worker
{
    int c;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    boolean wstatus=false;
    synchronized void writer()
    {
        while(wstatus)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception : "+ex);
            }
        }
        System.out.println("Enter the File Contents(1 to quit) : ");
        try
        {
            FileWriter fw=new FileWriter("File.txt");
            while((c=br.read())!='1')
            {
                fw.write(c);
            }
            fw.close();
        }
        catch(IOException ex)
        {
            System.out.println("Exception : "+ex);
        }
        wstatus=true;
        notify();
    }
    synchronized void reader()
    {
        while(!wstatus)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception : "+ex);
            }
        }
        System.out.println("File Contents : ");
        try
        {
            FileReader fr=new FileReader("File.txt");
            while((c=fr.read())!=-1)
            {
                System.out.print((char)c);
            }
        }
        catch(IOException ex)
        {
            System.out.println("Exception : "+ex);
        }
        wstatus=false;
        notify();
    }
}

class Writing implements Runnable
{
    Worker obj;
    FileWriter fw;
    Thread t;
    Writing(Worker obj)
    {
        this.obj=obj;
        t=new Thread(this,"Write");
        t.start();
    }
    public void run()
    {
        obj.writer();
    }
}

class Reading implements Runnable
{
    Worker obj;
    FileReader fr;
    Thread t;
    Reading(Worker obj)
    {
        this.obj=obj;
        t=new Thread(this,"Read");
        t.start();
    }
    public void run()
    {
        obj.reader();
    }
}

public class ThreadFile
{
    public static void main(String args[])
    {
        Writing wr;
        Reading re;
        Worker obj=new Worker();
        try
        {
            wr=new Writing(obj);
            wr.t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Exception : "+ex);
        }
        try
        {
            re=new Reading(obj);
            re.t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Exception : "+ex);
        }

    }
}
