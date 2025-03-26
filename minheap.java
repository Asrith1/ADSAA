import java.util.*;
class MinHeap {
	 static int[] a;
	 static int maxsize,heapsize=0;
	public MinHeap(int maxsize) {
		this.maxsize=maxsize;
		this.heapsize=heapsize;
		this.a=new int[maxsize];
	}
	int lChild(int i) {
		return 2*i+1;
	}
	int rChild(int i) {
		return 2*i+2;
	}
	int parent(int i) {
		return (i-1)/2;
	}
	void insertKey(int x) {
		if(heapsize == maxsize) {
			System.out.println("Heap Overflow");
			return;
		}
		int i=heapsize;
		a[i]=x;
		heapsize++;
		while(i!=0 && a[parent(i)]>a[i]) {
			int temp=a[i];
			a[i]=a[parent(i)];
			a[parent(i)]=temp;
			i=parent(i);
		}
	}
	void removeMin() {
		if(heapsize<=0) {
			System.out.println("Heap is empty");
			return;
		}
		if(heapsize == 1) {
			heapsize--;
		}else {
			a[0]=a[heapsize-1];
			heapsize--;
			minHeapify(0);
		}
	}
	void minHeapify(int i) {
		int l=lChild(i);
		int r=rChild(i);
		int smallest=i;
		if(l<heapsize && a[l]<a[smallest])
			smallest=l;
		if(r<heapsize && a[r]<a[smallest])
			smallest=r;
		if(smallest!=i) {
			int temp=a[i];
			a[i]=a[smallest];
			a[smallest]=temp;
		        minHeapify(smallest);
		}
	}
	int getMin() {
		return a[0];
	}
	int currentSize() {
		return heapsize;
	}
	public static void printHeap() {
		for(int i=0;i<heapsize;i++) {
			System.out.println(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		MinHeap h=new MinHeap(15);
		int elements[]={3,10,12,8,2,14};
		for(int e:elements)
			h.insertKey(e);
		System.out.println("Current size of heap: "+h.currentSize());
		System.out.println("Current max element of heap: "+h.getMin());
		MinHeap.printHeap();
		h.removeMin();
		System.out.println("Current size of heap: "+h.currentSize());
		MinHeap.printHeap();
		h.insertKey(15);
		h.insertKey(5);
		System.out.println("Current size of heap: "+h.currentSize());
		System.out.println("Current max element of heap: "+h.getMin());
		MinHeap.printHeap();
	}
}
		
		
		
		
