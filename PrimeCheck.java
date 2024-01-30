/*Program for checking whether a number is prime or not*/

public class PrimeCheck 
{
    public static void main(String args[])
    {
        int num,i;
        num=Integer.parseInt(args[0]);
        for(i=2;i<num/2;i++)
        {
            if(num%i==0)
            {
                System.out.println(num+" is not a prime number");
                return;
            }
        }
        System.out.println(num+" is a prime number");
    }  
}
