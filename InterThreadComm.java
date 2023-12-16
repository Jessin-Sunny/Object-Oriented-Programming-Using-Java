class Data
{
    int num;
    boolean status=false;
    public synchronized void put(int num)
    {
        while(status)
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
        System.out.println("Producer : "+num);
        status=true;
        notify();       //notifies the consumer thread
    }
    public synchronized void get()
    {
        while(!status)
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
        System.out.println("Consumer : "+num);
        status=false;
        notify();       //notifies the producer thread
    }
}

class Producer implements Runnable
{
    Data obj;
    public Producer(Data obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        int i=0;
        while(true)
        {
            obj.put(i++);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
        
    }
}

class Consumer implements Runnable
{
    Data obj;
    public Consumer(Data obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        while(true)
        {
            obj.get();
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
    }
}

public class InterThreadComm
{
    public static void main(String args[])
    {
        Data obj=new Data();

        //Creating a single instanace
        Producer producer=new Producer(obj);
        Consumer consumer=new Consumer(obj);

        //Creating threads
        Thread t1=new Thread(producer,"Producer");
        Thread t2=new Thread(consumer,"Consumer");

        t1.start();
        t2.start();

    }
    
}
