/*Java Program for generating three threads
1)Generating a Random Number
2)Finding its square if it is even
3)Finding its cube if it is odd
*/
import java.util.Random;
class Square extends Thread
{
    int n,sqr;
    Square(int n)
    {
        this.n=n;
    }
    public void run()
    {
        sqr=n*n;
        System.out.println("Square of "+n+" = "+sqr);
    }
}
class Cube extends Thread
{
    int n,cube;
    Cube(int n)
    {
        this.n=n;
    }
    public void run()
    {
        cube=n*n*n;
        System.out.println("Cube of "+n+" = "+cube);
    }
}
class NumberGenerator extends Thread
{
    int num;
    Random randnum=new Random();
    public void run()
    {
        while(true)
        {
            num=randnum.nextInt(100);
            System.out.println("Number Generated : "+num);
            if(num%2==0)
            {
                Square s=new Square(num);
                s.start();
            }
            else
            {
                Cube c=new Cube(num);
                c.start();
            }
            try
            {
                Thread.sleep(1000);         //suspends thread for 1s
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception : "+ex);
            }
        }
    }
}

public class Pgm11
{
    public static void main(String args[])
    {
        NumberGenerator n=new NumberGenerator();
        n.start();              //keep thread on CPU for execution
    
    }
    
}
