//Using implements Runnable
class EvenNumbers implements Runnable
{
    public void run()
    {
        for(int i=0;i<500000;i+=2)
        {
            System.out.println(+i);
            try
            {
                Thread.sleep(2000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Interruption occurs : "+ex);
            }
        }
    }
}
class OddNumbers implements Runnable
{
    public void run()
    {
        for(int i=1;i<500000;i+=2)
        {
            System.out.println(+i);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Interruption occurs : "+ex);
            }
        }
    }
}
public class Thread2
{
    public static void main(String args[])
    {
        Thread t1=new Thread(new EvenNumbers());
        Thread t2=new Thread(new OddNumbers());
        t1.start();
        t2.start();
        try
        {
            t1.join();
            t2.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Interruption occurs : "+ex);
        }
    }
}

