import java.util.*;
class MaxHeap {
	 static int[] a;
	 static int maxsize,heapsize=0;
	MaxHeap(int ms) {
		this.a=new int[ms];
		this.maxsize=ms;
		this.heapsize=heapsize;
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
		while(i!=0 && a[parent(i)]<a[i]) {
			int temp=a[i];
			a[i]=a[parent(i)];
			a[parent(i)]=temp;
			i=parent(i);
		}
	}
	void removeMax() {
		if(heapsize<=0) {
			System.out.println("Heap is empty");
			return;
		}
		if(heapsize == 1) {
			heapsize--;
		}else {
			a[0]=a[heapsize-1];
			heapsize--;
			maxHeapify(0);
		}
	}
	void maxHeapify(int i) {
		int l=lChild(i);
		int r=rChild(i);
		int largest=i;
		if(l<heapsize && a[l]>a[largest])
			largest=l;
		if(r<heapsize && a[r]>a[largest])
			largest=r;
		if(largest!=i) {
			int temp=a[i];
			a[i]=a[largest];
			a[largest]=temp;
		        maxHeapify(largest);
		}
	}
	int getMax() {
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
		MaxHeap h=new MaxHeap(15);
		int elements[]={3,10,12,8,2,14};
		for(int e:elements)
			h.insertKey(e);
		System.out.println("Current size of heap: "+h.currentSize());
		System.out.println("Current max element of heap: "+h.getMax());
		MaxHeap.printHeap();
		h.removeMax();
		System.out.println("Current size of heap: "+h.currentSize());
		MaxHeap.printHeap();
		h.insertKey(15);
		h.insertKey(5);
		System.out.println("Current size of heap: "+h.currentSize());
		System.out.println("Current max element of heap: "+h.getMax());
		MaxHeap.printHeap();
	}
}
		
		
		
