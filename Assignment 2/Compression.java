import java.util.*;
import java.io.*;

public class Compression {
	public static String[] token(String str) {
		int[] comma = new int[10];
		Arrays.fill(comma, -1);
		int i=0,n=1;
		for(i=0;i<str.length();i++) {
			if(str.charAt(i)==',') {
				comma[n]=i;
				n++;
			}
		}
		String[] ret = new String[10];
		for(i=1;i<n;i++) {
			ret[i-1] = str.substring(comma[i-1]+1, comma[i]);
		}
		ret[i-1] = str.substring(comma[i-1]+1,str.length());
		return ret;
	}
	public static String compress(String target,char type,char mode,String[] str,String[] codeword) {
		String tar;
		String ret="";
		String[] in = new String[0];
		String[] out = new String[0];
		int slice = 0;
		int index = 0;
		if(mode=='C') {
			in=str;
			out=codeword;
		}
		if(mode=='D') {
			in=codeword;
			out=str;
		}
		if((type=='H'&&mode=='C')||(type=='T'&&mode=='D')) {
			slice = in[0].length();
		}
		if((type=='T'&&mode=='C')||(type=='H'&&mode=='D')) {
			int max = 0;
			for(int i=0;i<in.length;i++) {
				if(max<in[i].length()) {
					max=in[i].length();
				}
			}
			slice = max;
		}
		while(index<target.length()) {
			int i = 0;
			int s = slice;
			while(s+index-1>=target.length()) {
				s--;
				if(s<1) {
					return "";
				}
			}
			while(i<str.length) {
				tar=target.substring(index, index+s);
				if(tar.equals(in[i])) {
					ret = ret + out[i];
					break;
				}
				i++;
				if(i==str.length) {
					s--;
					if(s<1) {
						return "";
					}
					i=0;
				}
			}
			index+=s;
		}
		return ret;
	}
	public static void main(String[] args) throws FileNotFoundException {
		File dict = new File("dictionary.txt");
		File in = new File("input.txt");
		File out = new File("output.txt");
		
		Scanner dictIn = new Scanner(dict);
		Scanner input = new Scanner(in);
		PrintStream output = new PrintStream(out);
		String line="";
		String result="";
		
		int dictNum = 0;
		while(dictIn.hasNextLine()) {
			line = dictIn.nextLine();
			dictNum++;
		}
		String[] str = new String[dictNum];
		String[] codeword = new String[dictNum];
		dictIn = new Scanner(dict);
		dictNum = 0;
		while(dictIn.hasNextLine()) {
			line = dictIn.nextLine();
			String[] tokens = token(line);
			str[dictNum] = tokens[0];
			codeword[dictNum] = tokens[1];
			dictNum++;
		}
		line = input.nextLine();
		String[] toks = token(line);
		char type = toks[0].charAt(0);
		char mode = toks[1].charAt(0);
		result = compress(toks[2],type,mode,str,codeword);
		output.println(result);
	}
}