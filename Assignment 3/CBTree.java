public class CBTree {
	public CBNode root;
	
	public CBTree(String st, String con) {
		root = construct(root,st,con);
	}
	
	private CBNode construct(CBNode tar,String st,String con) {
		tar = new CBNode();
		char sti = st.charAt(0);
		if(sti=='0') {
			int lrst=find(st,'s');
			int lrcon=find(st,'c');
			tar.label=sti;
			tar.character=con.charAt(0);
			con=con.substring(1);
			tar.left = construct(tar.left,st.substring(1,lrst),con.substring(0,lrcon));
			tar.right = construct(tar.right,st.substring(lrst),con.substring(lrcon));
		} else {
			tar.label=sti;
		}
		return tar;
	}
	private int find(String st,char sc) {
		int num0=0,num1=0;
		int index=1;
		while(num0+1!=num1) {
			if(st.charAt(index)=='0') {
				num0++;
			} else {
				num1++;
			}
			index++;
		}
		if(sc=='s') {
			return index;
		} else {
			return num0;
		}
	}
	
	public String postOrderTraversal() {
		String ret = "";
		ret=postOrder(root, ret, 't');
		return ret;
	}
	public String postOrderStructure() {
		String ret = "";
		ret=postOrder(root, ret, 's');
		return ret;
	}
	public String inOrderTraversal() {
		String ret = "";
		ret=inOrder(root, ret, 't');
		return ret;
	}
	public String inOrderStructure() {
		String ret = "";
		ret=inOrder(root, ret, 's');
		return ret;
	}
	private String postOrder(CBNode tar, String ret, char ts) {
		if(tar!=null) {
			ret=postOrder(tar.left, ret, ts);
			ret=postOrder(tar.right, ret, ts);
			if(ts=='t')
				ret=ret+tar.character;
			else if(ts=='s') 
				ret=ret+tar.label;
		}
		return ret;
	}
	private String inOrder(CBNode tar, String ret, char ts) {
		if(tar!=null) {
			ret=inOrder(tar.left, ret, ts);
			if(ts=='t')
				ret=ret+tar.character;
			else if(ts=='s')
				ret=ret+tar.label;
			ret=inOrder(tar.right, ret, ts);
		}
		return ret;
	}
	
	/* Helper method. */
	public CBNode getRoot()
	{
		return root;
	}
}
