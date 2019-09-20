import java.util.Arrays;

public class StringSorterTest {
	public static void main(String[] args) {
		String[] seq = {"crazy","strrlin","st","ban","string","spider","zebra","stri","amazed","ama","java","str","strin","s","banana"};
		String[] ins = Arrays.copyOf(seq,seq.length);
		String[] sel = Arrays.copyOf(seq,seq.length);
		String[] bub = Arrays.copyOf(seq, seq.length);
		String[] mer = Arrays.copyOf(seq, seq.length);
		StringSorter.insertionSort(ins);
		StringSorter.selectionSort(sel);
		StringSorter.bubbleSort(bub);
		StringSorter.mergeSort(mer);
		Arrays.sort(seq);
		System.out.println("Answer: "+Arrays.toString(seq));
		System.out.println("insertion: "+Test(seq,ins));
		System.out.println("selection: "+Test(seq,sel));
		System.out.println("bubble: "+Test(seq,bub));
		System.out.println("merge: "+Test(seq,mer));
	}
	public static String Test(String[] ans, String[] output) {
		for(int i=0;i<ans.length;i++) {
			if(!ans[i].equals(output[i]))
				return "Fail";
		}
		return "Success";
	}
}
