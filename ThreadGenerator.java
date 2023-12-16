import java.util.Random;

class Data
{
    int num;
    boolean nstatus=false;
    boolean sstatus=false;
    boolean cstatus=false;
    synchronized void ndisplay(int num)
    {
        while(nstatus)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
        this.num=num;
        System.out.println("Number Generated : "+num);
        nstatus=true;
        sstatus=false;
        cstatus=false;
        notify();    
    }
    synchronized void sdisplay(int num)
    {
        while(sstatus)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
        if(num%2==0)
        {
            System.out.println("Square : "+(num*num));
            sstatus=true;
            nstatus=false;
            notify();
        }

    }
    synchronized void cdisplay(int num)
    {
        while(cstatus)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
        if(num%2!=0)
        {
            System.out.println("Cube : "+(num*num*num));
            cstatus=true;
            nstatus=false;
            notify();
        }

    }
}

class NumGenerator extends Thread
{
    Data obj;
    Random n;
    int num;
    public NumGenerator(Data obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        n=new Random();
        while(true)
        {
            num=n.nextInt(100);
            obj.ndisplay(num);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }

    }
}

class Square extends Thread
{
    Data obj;
    public Square(Data obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        while(true)
        {
            obj.sdisplay(obj.num);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
    }
}

class Cube extends Thread
{
    Data obj;
    public Cube(Data obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        while(true)
        {
            obj.cdisplay(obj.num);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
    }
}

public class ThreadGenerator
{
    public static void main(String args[])
    {
        Data obj=new Data();

        NumGenerator number=new NumGenerator(obj);
        Square sq=new Square(obj);
        Cube cb=new Cube(obj);

        number.start();
        sq.start();
        cb.start();
    }
}
