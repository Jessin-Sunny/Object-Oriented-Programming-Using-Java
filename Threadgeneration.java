import java.util.Random;
class FlagVariable
{
    public static int num;
    public static boolean status=false;
}

class RandomNumber extends Thread
{
    public void run()
    {
        Random n=new Random();
        while(true)
        {
            FlagVariable.num=n.nextInt(100);
            System.out.println("Random Number Generated : "+FlagVariable.num);
            FlagVariable.status=true;
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Interruption takes place : "+ex);
            }
        }
    }
}

class Square extends Thread
{
    public void run()
    {
        while(true)
        {
            if(FlagVariable.status==true && FlagVariable.num%2==0)
            {
                int num=FlagVariable.num;
                System.out.println("Square : "+num*num);
                FlagVariable.status=false;
            }
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Interruption takes place : "+ex);
            }
        }
    }
}

class Cube extends Thread
{
    public void run()
    {
        while(true)
        {
            if(FlagVariable.status==true && FlagVariable.num%2!=0)
            {
                int num=FlagVariable.num;
                System.out.println("Cube : "+num*num*num);
                FlagVariable.status=false;
            }
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Interruption takes place : "+ex);
            }            
        }
    }

}

public class Threadgeneration
{
    public static void main(String args[])
    {
        RandomNumber t1=new RandomNumber();
        Square t2=new Square();
        Cube t3=new Cube();
        t1.start();
        t2.start();
        t3.start();
    }   
}
