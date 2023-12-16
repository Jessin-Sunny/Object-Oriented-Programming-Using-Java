class Data
{
    int num;
    boolean estatus=false;
    boolean ostatus=false;
    synchronized void edisplay(int num)
    {
        while(estatus)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception Arrises : "+ex);
            }
        }
        System.out.println("Even Number : "+num);
        estatus=true;
        ostatus=false;
        notify();
    }
    synchronized void odisplay(int num)
    {
        while(ostatus)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception Arrises : "+ex);
            }
        }
        System.out.println("Odd Number : "+num);
        ostatus=true;
        estatus=false;
        notify();
    }
}

class EvenNumber implements Runnable
{
    Data obj;
    public EvenNumber(Data obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        for(int i=0;i<500000;i=i+2)
        {
            obj.edisplay(i);
        
            try
            {
                Thread.sleep(3000);
            
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception Arrises : "+ex);
            }
        }
    }
}

class OddNumber implements Runnable
{
    Data obj;
    public OddNumber(Data obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        for(int i=1;i<500000;i=i+2)
        {
            obj.odisplay(i);
        
            try
            {
                Thread.sleep(3000);
            
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception Arrises : "+ex);
            }
        }
    }
}

public class ThreadSynch
{
    public static void main(String args[])
    {
        Data obj=new Data();

        EvenNumber even=new EvenNumber(obj);
        OddNumber odd=new OddNumber(obj);

        Thread t1=new Thread(even,"Even Number");
        Thread t2=new Thread(odd,"Odd Number");

        t1.start();
        t2.start();
    }
}
