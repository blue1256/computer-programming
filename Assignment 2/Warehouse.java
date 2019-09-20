import java.util.*;
import java.io.*;

public class Warehouse {
	public static String[] token(String str) {
		int[] comma = new int[10];
		Arrays.fill(comma, -1);
		int i=0,n=1;
		for(i=0;i<str.length();i++) {
			if(str.charAt(i)==',') {
				comma[n] = i;
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
	public static int find(String[] name,char[] type,String targetName,char targetType,int stockNum) {
		int i = 0;
		for(i=0;i<stockNum;i++) {
			if(name[i].equals(targetName)&&type[i]==targetType) break;
		}
		return i;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File stock = new File("stock.txt");
		File tx = new File("tx.txt");
		File in = new File("input.txt");
		Scanner input = new Scanner(in);
		Scanner txIn = new Scanner(tx);
		Scanner stockIn = new Scanner(stock);
		
		String line;
		String txLines[] = new String[0];
		int num = 0;
		int txNum = 0;
		int inNum = 0;
		
		while(input.hasNextLine()) {
			line = input.nextLine();
			inNum++;
		}
		while(stockIn.hasNextLine()) {
			line=stockIn.nextLine();
			num++;
		}
		while(txIn.hasNextLine()) {
			line = txIn.nextLine();
			txNum++;
			txLines = Arrays.copyOf(txLines, txNum);
			txLines[txNum-1] = line;
		}
		input = new Scanner(in);
		stockIn = new Scanner(stock);
		
		char[] type = new char[num+inNum];
		String[] name = new String[num+inNum];
		int[] price = new int[num+inNum];
		int[] quantity = new int[num+inNum];
		
		int stockNum = 0;
		while(stockIn.hasNextLine()) {
			line = stockIn.nextLine();
			String[] tokens = token(line);
			type[stockNum] = tokens[1].charAt(0);
			name[stockNum] = tokens[2];
			price[stockNum] = Integer.parseInt(tokens[3]);
			quantity[stockNum] = Integer.parseInt(tokens[4]);
			stockNum++;
		}
		PrintStream txOut = new PrintStream(tx);
		for(int i=0;i<txNum;i++) {
			txOut.println(txLines[i]);
		}
		while(input.hasNextLine()) {
			line = input.nextLine();
			txNum++;
			String[] tokens = token(line);
			char com = tokens[0].charAt(0);
			char targetType = tokens[1].charAt(0);
			String targetName = tokens[2];
			int targetPrice = 0;
			int targetQuantity = 0;
			int id=find(name,type,targetName,targetType,stockNum);
			if(com=='I') {
				targetPrice = Integer.parseInt(tokens[3]);
				targetQuantity = Integer.parseInt(tokens[4]);
				if(id<stockNum) {
					if(targetPrice>price[id]) {
						System.out.println("The part became expensive.");
						price[id]=targetPrice;
					}
					else if(targetPrice<price[id]) {
						System.out.println("The part became cheap");
						price[id]=targetPrice;
					}
					quantity[id]+=targetQuantity;
				} else {
					stockNum++;
					type[id] = targetType;
					name[id] = targetName;
					price[id] = targetPrice;
					quantity[id] = targetQuantity;
				}
			}
			if(com=='S') {
				targetQuantity = Integer.parseInt(tokens[3]);
				if(id<stockNum) {
					targetPrice = price[id];
					if(targetQuantity>quantity[id]) {
						break;
					} else {
						quantity[id]-=targetQuantity;
					}
				} else {
					break;
				}
			}
			if(com=='E') {
				targetQuantity = Integer.parseInt(tokens[3]);
				if(id<stockNum) {
					targetPrice=price[id];
					if(targetQuantity>quantity[id]) {
						targetQuantity = quantity[id];
						System.out.println("The part partially exchanged.");
					}
				} else {
					break;
				}
			}
			txOut.println((txNum)+","+com+","+(id+1)+","+targetPrice+","+targetQuantity+","+targetPrice*targetQuantity);
		}
		PrintStream stockOut = new PrintStream(stock);
		for(int i=0;i<stockNum;i++) {
			stockOut.println((i+1)+","+type[i]+","+name[i]+","+price[i]+","+quantity[i]);
		}
	}
}