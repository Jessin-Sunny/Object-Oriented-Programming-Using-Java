/*Using String Tokenizer */
import java.util.Scanner;
import java.util.StringTokenizer;
public class Pgm9
{
    public static void main(String args[])
    {
        Scanner reader=new Scanner(System.in);
        int n,sum=0;
        System.out.print("Enter the integers : ");
        String S=reader.nextLine();
        StringTokenizer st=new StringTokenizer(S,",");
        while(st.hasMoreTokens())
        {
            n=Integer.parseInt(st.nextToken());
            System.out.println(n);
            sum+=n;
        }
        System.out.println("Sum Of Integers : "+sum);
        reader.close();
    }    
}
