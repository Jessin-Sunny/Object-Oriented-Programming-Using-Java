/*Java program for reading and writing file using FileReader and FileWriter*/
import java.io.*;

public class Pgm7 
{
    public static void main(String args[]) 
    {
        try
        {
            // Writing to a file using FileWriter
            FileWriter writer = new FileWriter("output.txt");
            writer.write("This is a sample text.\nWe are writing it to a file using FileWriter.\n");
            writer.close();
            System.out.println("Successfully wrote to the file.");

            // Reading from a file using FileReader
            FileReader reader = new FileReader("output.txt");
            int character;
            while ((character = reader.read()) != -1) 
            {
                System.out.print((char) character);
            }
            reader.close();
        } 
        catch (IOException ex) 
        {
            System.out.println("An error occurred."+ex);
        }
    }
}

