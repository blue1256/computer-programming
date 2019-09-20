import java.util.*;

public class StringSorter {
	public static void selectionSort(String[] arr) {
		int i=0,j=0;
		for(i=0;i<arr.length-1;i++) {
			int min=i;
			for(j=i+1;j<arr.length;j++) {
				if(compare(arr[min],arr[j]))
					min=j;
			}
			swap(arr,i,min);
		}
	}
	public static void insertionSort(String[] arr) {
		int i,j,k;
		for(i=1;i<arr.length;i++) {
			String m = arr[i];
			j=0;
			while(compare(arr[i],arr[j])&&i>j) {
				j++;
			}
			for(k=0;k<i-j;k++) {
				arr[i-k]=arr[i-k-1];
			}
			arr[j]=m;
		}
	}
	public static void bubbleSort(String[] arr) {
		int i=0,j=0;
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr.length-i-1;j++) {
				if(compare(arr[j],arr[j+1])) {
					swap(arr,j,j+1);
				}
			}
		}
	}
	public static void mergeSort(String[] arr) {
		if(arr.length>1) {
			String[] left = Arrays.copyOfRange(arr, 0, arr.length/2);
			String[] right = Arrays.copyOfRange(arr, arr.length/2,arr.length);
			mergeSort(left);
			mergeSort(right);
			merge(arr,left,right);
		}
	}
	private static void merge(String[] result,String[] left,String[] right) {
		int i=0, j=0,k=0;
		while(i<left.length&&j<right.length) {
			if(compare(right[j],left[i])) {
				result[k++]=left[i++];
			} else {
				result[k++]=right[j++];
			}
		}
		while(i<left.length)
			result[k++]=left[i++];
		while(j<right.length) {
			result[k++]=right[j++];
		}
	}
	private static void swap(String[] arr,int i,int j) {
		if(i!=j) {
			String tmp = arr[i];
			arr[i]=arr[j];
			arr[j]=tmp;
		}
	}
	private static boolean compare(String str1, String str2) {
		char[] sa1 = str1.toCharArray();
		char[] sa2 = str2.toCharArray();
		int min=0;
		if(sa1.length>sa2.length)
			min=sa2.length;
		else
			min=sa1.length;
		for(int i=0;i<min;i++) {
			if(sa1[i]>sa2[i])
				return true;
			else if(sa1[i]<sa2[i])
				return false;
		}
		if(min==sa1.length)
			return false;
		else 
			return true;
	}
}
