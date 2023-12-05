class EvenNumbers extends Thread
{
    public void run()
    {
        for(int i=0;i<500000;i=i+2)
        {
            System.out.print("Even Number : ");
            PrintMe.display(i);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception : "+ex);
            }
        }
    }
}

class OddNumbers extends Thread
{
    public void run()
    {
        for(int i=1;i<500000;i=i+2)
        {
            System.out.print("Odd Number : ");
            PrintMe.display(i);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception : "+ex);
            }
        }
    }
}

class PrintMe
{
    synchronized static void display(int num)
    {
        System.out.println(num);
    }
}
public class ThreadSynchronization
{
    public static void main(String args[])
    {  
        EvenNumbers t1=new EvenNumbers();
        OddNumbers t2=new OddNumbers();
        t1.start();
        t2.start();
        try
        {
            t1.join();
            t2.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Exception : "+ex);
        }
    }
}
