//Achieving Thread Synchronization in java
class CallMe
{
    synchronized void call(String msg)
    {
        System.out.print("["+msg);
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            System.out.println("Interruption Occurs "+ex);
        }
        System.out.print("]");
    }
}

class Caller implements Runnable
{
    String message;
    CallMe target;
    Thread t;
    public Caller(CallMe target,String message)
    {
        this.message=message;
        this.target=target;
        t=new Thread(this);
        t.start();
    }
    public void run()
    {
        target.call(message);
    }
}

public class Synch
{
    public static void main(String args[])
    {
        CallMe tar=new CallMe();
        Caller t1=new Caller(tar,"Hello");
        Caller t2=new Caller(tar,"Java");
        Caller t3=new Caller(tar,"World");
        try
        {
            t1.t.join();
            t2.t.join();
            t3.t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Interruption Occurs "+ex);
        }
    }    
}
