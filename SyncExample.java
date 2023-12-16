/*
    count=count+1
    A thread has to do two operations
    First, it has to fetch the count value
    Second, increment value of count
    In this program if synchronized is not used
    Suppose thread1 fetches value of count as 700, then it goes to the next count++ statement
    At the same time thread2 comes and fetches the count as 700
    In this way we won't get the desired output
 */

class Counter
{
    static int count;
    public static synchronized void increment()
    {
        count=count+1;
    }
}

class Thread1 extends Thread
{
    public void run()
    {
        for(int i=0;i<100000;i++)
        {
            Counter.increment();
        }
    }
}

class Thread2 extends Thread
{
    public void run()
    {
        for(int i=0;i<100000;i++)
        {
            Counter.increment();
        }
    }
}

public class SyncExample
{
    public static void main(String args[])
    {
        Thread1 t1=new Thread1();
        Thread t2=new Thread2();
        
        t1.start();
        t2.start();

        try  //if join is not used the printing statement of count get executed first by CPU
        {    //count=0          join makes CPU wait
            t1.join();
            t2.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Exception arrises : "+ex);
        }

        System.out.println("Count : "+Counter.count);
    }
}