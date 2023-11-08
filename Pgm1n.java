class string1
{
    char[] str;//instance variable
    int i;
    void input(char a[])
    {
        //a={'M','A','L','A','Y','L','A','M'};
    }
    string1(char a[])//constructor
    {
        str=a;
    }
    int length()//methods
    {
        for (i=0;str[i]!='\0';i++);
        return i;
    }
    int palindrome()
    {
        int s=0,e;
        e=i-1;
        while(e>s)
        {
            if (str[s]!=str[e])
            {
                return 0;
            }
            s=s+1;
            e=e-1;
        }
        return 1;
    }
}



public class Pgm1n 
{
    public static void main(String[] args)
    {
        int len;
        char[] s={'M','A','L','A','Y','A','L','A','M','\0'};//string initialization
        string1 s1;//defining an object
        s1=new string1(s);//instance creation
        len=s1.length();
        System.out.println("Length="+len);
        if (s1.palindrome()==1)
        {
            System.out.println("The given string is palindrome");
        }
        else
        {
            System.out.println("The given string is NOT palindrome");
        }
    }     
}
