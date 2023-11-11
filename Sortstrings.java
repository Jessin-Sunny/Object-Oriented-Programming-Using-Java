/*
Program for sorting array of strings from commandline
*/

public class Sortstrings 
{
    public static void main(String args[])
    {
        //String arr[]=new String[args.length];
        String arr[]={"Now","is","the","time","for","men","country"};
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            if (arr[i].compareTo(arr[j]) > 0)
            {
                String temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        System.out.println("Array After Sorting : ");
        for (int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
