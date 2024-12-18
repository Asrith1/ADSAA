import java.util.*;
class Selection
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of elements: ");
        int n=sc.nextInt();
        int[] A=new int[n];
        System.out.println("Enter array elements: ");
        for(int i=0;i<n;i++)
        {
            A[i]=sc.nextInt();
        }
        selectionSort(A);
        System.out.println("Sorted Array: ");
        for(int i=0;i<n;i++)
        {
            System.out.println(A[i]);
        }
    }
    static void selectionSort(int[] A)
    {
        int n=A.length;
        int temp;
        for(int i=0;i<n;i++)
        {
            int m=i;
            for(int j=i+1;j<n;j++)
            {
                if(A[m]>A[j])
                {
                    temp=A[m];
                    A[m]=A[j];
                    A[j]=temp;
                }
            }
        }
    }
}
