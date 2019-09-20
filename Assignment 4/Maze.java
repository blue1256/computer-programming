import java.util.*;
import java.io.*;

public class Maze {
	public static int rSize=0;
	public static int cSize=0;
	public static Queue q;
	public static int[][] board;
	public static boolean[][] chk;
	public static void main(String[] args) throws FileNotFoundException {
		File input = new File(args[0]);
		File output = new File(args[1]);
		Scanner in = new Scanner(input);
		PrintStream out = new PrintStream(output);
		q = new Queue();
		chk = new boolean[130][130];
		board = new int[130][130];
		int row=0,col=0;
		String line="";
		while(in.hasNextLine()) {
			line=in.nextLine();
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNextInt()) { 
				board[row][col]=lineScan.nextInt();
				col++;
			}
			cSize=col;
			col=0;
			lineScan.close();
			row++;
		}
		rSize=row;
        System.out.println(rSize+","+cSize);
		String result = bfs();
		out.println(result);
		in.close();
		out.close();
	}
	public static String bfs() {
		int rstart=rSize-1,cstart=0;
		int rdest=0,cdest=cSize-1;
		int drow[] = {0,1,-1,0};
		int dcol[] = {1,0,0,-1};
		Node head = new Node(rstart,cstart,toLocation(rstart,cstart));
		chk[rstart][cstart]=true;
		q.push(head);
		Node cur=null;
		while(!q.isEmpty()) {
			cur = q.pop();
			for(int i=0;i<4;i++) {
				String newPath = cur.path+"-"+toLocation(cur.row+drow[i],cur.col+dcol[i]);
				Node tmp = new Node(cur.row+drow[i],cur.col+dcol[i],newPath);
				if(check(tmp)) {
					if(tmp.row==rdest&&tmp.col==cdest)
						return tmp.path;
					q.push(tmp);
					chk[tmp.row][tmp.col]=true;
				}
			}
		}
		if(cur==head)
			return head.path;
		else
			return "not Found";
	}
	public static boolean check(Node tar) {
		if(tar.row>=rSize||tar.col>=cSize||tar.row<0||tar.col<0)
			return false;
		if(board[tar.row][tar.col]==0)
			return false;
		if(chk[tar.row][tar.col])
			return false;
		return true;
	}
	public static String toLocation(int row,int col) {
		int ret = row*cSize+col+1;
		return ""+ret;
	}
}
class Queue{
	Node head;
	public void push(Node newNode){
		Node cur = head;
		if(cur==null) {
			head = newNode;
		} else {
			while(cur.next!=null) {
				cur=cur.next;
			}
			cur.next=newNode;
		}
	}
	public Node pop() {
		Node ret = head;
		head = head.next;
		return ret;
	}
	public boolean isEmpty() {
		if(head==null)
			return true;
		else
			return false;
	}
}
class Node{
	int row;
	int col;
	String path;
	Node next;
	
	public Node(int row,int col,String path) {
		this.row = row;
		this.col = col;
		this.path = path;
	}
}
