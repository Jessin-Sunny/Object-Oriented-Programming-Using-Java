/*Problem of Producer and Consumer*/

class Q
{
    int value;
    boolean valueSet=false;
    synchronized void put(int n)
    {
        while(valueSet)
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
        value=n;
        valueSet=true;
        System.out.println("Put : "+value);
        notify();
    }
    synchronized void get()
    {
        while(!valueSet)
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
        valueSet=false;
        System.out.println("Got : "+value);
        notify();
    }
}


class Producer implements Runnable
{
    Q obj;
    Thread t;
    int i=0;
    Producer(Q obj)
    {
        this.obj=obj;
        t=new Thread(this,"Producer");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            obj.put(i++);
        }
    }
}

class Consumer implements Runnable
{
    Thread t;
    Q obj;
    Consumer(Q obj)
    {
        this.obj=obj;
        t=new Thread(this,"Consumer");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            obj.get();
        }
    }
}

public class PC
{
    public static void main(String args[])
    {
        Q obj=new Q();
        Producer pro=new Producer(obj);
        Consumer cons=new Consumer(obj);
        try
        {
            pro.t.join();
            cons.t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Exception : "+ex);
        }
    }
}