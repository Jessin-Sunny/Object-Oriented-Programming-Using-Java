class string2
{
    char[] str;
    char ch;
    int i;
    //void inputstr()
    {
        //str={'M','A','L','A','Y','L','A','M'};
    }
    //void inputchar()
    {
        //c='M';
    }
    string2(char a[],char c)        //Constructor
    {
        str=a;
        ch=c;
    }
    int length()
    {
        for (i=0;str[i]!='\0';i++);
        return i;
    }
    int frequency()
    {
        int count=0,j=0;
        while (str[j]!='\0')
        {
            if (str[j]==ch)
            {
                count=count+1;
            }
        }
        j=j+1;
        return count;
    }
}
public class Pgm2 
{
    public static void main(String[] args)
    {
        char[] s={'M','A','L','A','Y','A','L','A','M','\0'};
        string2 s2;
        char c='M';            //object creation
        s2=new string2(s,c);      //instantion
        int freq;
        freq=s2.frequency();
        System.out.println("Frequency="+freq);
    }
}