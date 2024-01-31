/*Program to count the number of charcaters,words and lines in a text file*/

import java.io.*;
import java.util.*;

public class CountTextFile
{
    public static void main(String args[])
    {
        int charcount=0,wordcount=0,linecount=0;
        char ch;
        char[] arr;
        String str,substr;
        try
        {
            BufferedReader bw=new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw=new FileWriter("Text.txt");
            System.out.println("Enter the text (1 to quit)");
            while((ch=(char)bw.read())!='1')
            {
                fw.write(ch);
            }
            fw.close();
            bw.close();

            BufferedReader br=new BufferedReader(new FileReader("Text.txt"));
            while((str=br.readLine())!=null)
            {
                StringTokenizer st=new StringTokenizer(str," ");
                while(st.hasMoreTokens())
                {
                    substr=st.nextToken();
                    charcount+=substr.length();
                    wordcount++;
                }
                linecount++;
            }
        }
        catch(IOException ex)
        {
            System.out.println("Exception : "+ex);
        }

        System.out.println("Total number of words : "+wordcount);
        System.out.println("Total number of characters : "+charcount);
        System.out.println("Total number of lines : "+linecount);
    }
}