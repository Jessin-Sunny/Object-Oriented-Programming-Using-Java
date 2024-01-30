/*Program for reversing a String*/

public class StringReversal
{
    public static void main(String args[]) 
    {
        char strarr[],revarr[];
        String str,rev;
        int len,i,j=0;
        str=args[0];
        strarr=str.toCharArray();
        len=strarr.length;
        revarr=new char[len];
        i=len-1;
        System.out.println("String Before Reversal : "+str);
        while(i>=0)
        {
            revarr[j]=strarr[i];
            j++;i--;
        }
        rev=String.valueOf(revarr);
        System.out.println("String After Reversal : "+rev);
    }  
}