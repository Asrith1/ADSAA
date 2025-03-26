import java.util.*;
class Quicksort {
	public static int partition(int[] a,int low,int high) {
		int pivot=a[low];
		int i=low+1;
		int j=high;
		while(i<=j) {
			while(a[i]<=pivot) 
				i++;
			while(a[j]>=pivot)
				j--;
			if(i<j)
				interchange(a,i,j);
		}
		interchange(a,low,j);
		return j;
	}
	public static void interchange(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void quicksort(int[] a,int low,int high) {
		if(low<high) {
			int j=partition(a,low,high);
			quicksort(a,low,j-1);
			quicksort(a,j+1,high);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no.of elements in array: ");
		int n=sc.nextInt();
		int[] a=new int[n];
		System.out.println("enter elements of array: ");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		quicksort(a,0,a.length-1);
		System.out.println("Sorted array: ");
		for(int num: a) {
			System.out.println(num+" ");
		}
		sc.close();
	}
}
	
			
