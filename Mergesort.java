import java.util.*;
class Mergesort {
        private static int[] b;
        public static void mergeSort(int[] a,int low,int high) {
                if(low<high) {
                        int mid=low+(high-low)/2;
                        mergeSort(a,low,mid);
                        mergeSort(a,mid+1,high);
                        merge(a,low,mid,high);
                }
        }
        public static void merge(int[] a,int low,int mid,int high) {
                int i=low,j=mid+1,k=low;
                if(i<=mid && j<=high) {
                    if(a[i]<=a[j])
                      b[k++]=a[i++];
                   else 
                      b[k++]=a[j++];
                }
                while(i<=mid)
                    b[k++]=a[i++];
                while(j<=high)
                    b[k++]=a[j++];
                for(int h=low;h<=high;h++)
                    a[h]=b[h];
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("enter no.of elements in array: ");
            int n=sc.nextInt();
            int[] a=new int[n];
            b =new int[n];
            System.out.println("enter array elements: ");
            for(int i=0;i<n;i++) {
               a[i]=sc.nextInt();
            }
            mergeSort(a,0,a.length-1);
            System.out.println("Sorted Array: ");
            for(int num: a)
                System.out.println(num+" ");
            sc.close();
        }
}
