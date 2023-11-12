class Search
{
    int low=0,high,mid,sno,n;
    int arr[];
    Search(int a[],int sno,int n)
    {
        arr=a;
        this.sno=sno;
        this.n=n;
    }
    protected int binarysearch()
    {
        high=n-1;
        while(low<=high)
        {
            mid=(low+high)/2;
            if (arr[mid]==sno)
            {
                return mid;
            }
            if (arr[mid]>sno)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }

}

public class Pgm18
{
    public static void main(String args[])
    {
        int a[]={10,20,30,40,50};
        int n=5;
        int sno=40;
        int result;
        Search obj=new Search(a,sno,n);
        result=obj.binarysearch();
        if (result==-1)
        {
            System.out.println(sno+" Not Found");
        }
        else
        {
            System.out.println(sno+" is present at "+result);
        }

    }
}