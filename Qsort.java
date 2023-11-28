class QuickSort
{
    protected void quicksort(int l,int h,String[] arr)
    {
        if(l<h)
        {
            int partitionIndex=partition(l,h,arr);
            quicksort(l,partitionIndex-1,arr);
            quicksort(partitionIndex+1,h,arr);
        }
    }
    protected int partition(int l,int h,String[] arr)
    {
        String pivot = arr[h];
        int i = l - 1;

        for (int j = l; j < h; j++) {
            if (arr[j].compareToIgnoreCase(pivot) <= 0) {
                i++;

                // Swap arr[i] and arr[j]
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        String temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;

        return i + 1;
    }
    
}
public class Qsort
{
    public static void main(String args[])
    {
        //String[] names={"Adam", "Emma", "Frank", "Grace","Bob", "Charlie", "David",};
        String[] names=new String[args.length];
        System.out.print("Before Quick Sort : ");
        for(int i=0;i<args.length;i++)
        {
            names[i]=args[i];
            System.out.print(names[i]+" ");
        }
        System.out.println();
        QuickSort obj=new QuickSort();
        obj.quicksort(0,names.length-1,names);
        System.out.print("After Quick Sort : ");
        for(int i=0;i<names.length;i++)
        {
            System.out.print(names[i]+" ");
        }
        System.out.println();
    }    
}