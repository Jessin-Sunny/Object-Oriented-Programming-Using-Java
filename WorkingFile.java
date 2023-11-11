/*hello.txt contains

hello
I am here
Good
Thank You

 */
import java.io.*;
class Readingfile
{
    public static void main(String[] args)
    {
        //writing to file
        try
        {
            char c;
            FileOutputStream writer=new FileOutputStream("hello.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter characters,1 to quit : ");
            do
            {
                c=(char) br.read();
                if (c!='1')
                {
                    writer.write(c);
                }
            } while(c!='1');
            writer.close();
        }
        catch(FileNotFoundException not)
        {
            System.out.println(not+" File doesn't exist");
        }
        catch(IOException io)
        {
            System.out.println(io+ " Error Reading");
        }
        //Reading File
        try
        {
            int i=0;
            FileInputStream reader=new FileInputStream("hello.txt");
            System.out.println();
            System.out.println("The Contents of file : ");
            while (i!=-1)
            {
                i=reader.read();
                if (i!=-1)
                {
                    System.out.print((char)i);
                }
            }
            reader.close();
        }
        catch(FileNotFoundException not)
        {
            System.out.println(not+" File doesn't exist");
        }
        catch(IOException io)
        {
            System.out.println(io+" File Empty");
        }
    }
}
