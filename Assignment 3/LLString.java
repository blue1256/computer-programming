public class LLString
{
	/* Add internal field variables here. */

	
	LLNode front;
	
	/* Constructor. */
	public LLString(String str){
		int i=1;
		if(str.length()!=0) {
			front = new LLNode();
			front.character=str.charAt(0);
		}
		LLNode tar = front;
		while(i<str.length()){
			LLNode newNode = new LLNode();
			newNode.character = str.charAt(i);
			tar.next=newNode;
			tar=tar.next;
			i++;
		}
	}
	public LLString() {
		front=null;
	}

	/* Add methods here. */
	/* For example. */
	public char charAt(int index){
		int i=0;
		LLNode tar=front;
		while(i<index) {
			tar=tar.next;
			i++;
		}
		return tar.character;
	}
	
	//compareTo
	public int compareTo(String anotherString) {
		LLString another = new LLString(anotherString);
		return compareTo(another);
	}
	public int compareTo(LLString anotherLLString) {
		return compareTo(anotherLLString, false);
	}
	public int compareToIgnoreCase(String anotherString) {
		LLString another = new LLString(anotherString);
		return compareToIgnoreCase(another);
	}
	public int compareToIgnoreCase(LLString anotherLLString) {
		return compareTo(anotherLLString, true);
	}
	private int compareTo(LLString anotherLLString, boolean ignore) {
		LLNode thisTar=front, anotherTar=anotherLLString.front;
		if(ignore) {
			thisTar = this.toLowerCase().front;
			anotherTar = anotherLLString.toLowerCase().front;
		}
		while(thisTar!=null&&anotherTar!=null) {
			if(thisTar.character!=anotherTar.character) {
				break;
			}
			thisTar=thisTar.next;
			anotherTar=anotherTar.next;
		}
		if(anotherTar!=null&&thisTar!=null) {
			return thisTar.character-anotherTar.character;
		} else {
			return this.length()-anotherLLString.length();
		}
	}
	private LLString toLowerCase() {
		LLString ret = new LLString(this.toString());
		LLNode tar = ret.front;
		while(tar!=null) {
			if(tar.character>='A'&&tar.character<='Z') {
				tar.character=(char)(tar.character-('A'-'a'));
			}
			tar=tar.next;
		}
		return ret;
	}
	
	//concat
	public LLString concat(String str) {
		LLString llstr = new LLString(str);
		return concat(llstr);
	}
	public LLString concat(LLString llstr) {
		LLString ret = new LLString(this.toString());
		LLNode tar = ret.front;
		LLNode anotherTar = llstr.front;
		while(tar!=null&&tar.next!=null) {
			tar=tar.next;
		}
		while(anotherTar!=null) {
			if(tar==null) {
				tar=new LLNode();
				tar.character=anotherTar.character;
				ret.front=tar;
			} else {
				tar.next=anotherTar;
				tar=tar.next;
			}
			anotherTar=anotherTar.next;
		}
		return ret;
	}
	
	//indexOf
	public int indexOf(int ch) {
		return indexOf(ch,0);
	}
	public int indexOf(int ch, int fromIndex) {
		int i=fromIndex;
		while(i<this.length()) {
			if(this.charAt(i)==ch)
				break;
			i++;
		}
		if(i>=this.length()) {
			i=-1;
		}
		return i;
	}
	public int indexOf(String str) {
		return indexOf(str,0);
	}
	public int indexOf(String str, int fromIndex) {
		int i=fromIndex;
		LLString llstr = new LLString(str);
		while(llstr.length()!=0&&i<this.length()) {
			if(this.charAt(i)==llstr.charAt(0)) {
				int k=1;
				while(i+k<this.length()&&k<llstr.length()&&this.charAt(i+k)==llstr.charAt(k)) {
					k++;
				}
				if(k==llstr.length())
					break;
			}
			i++;
		}
		if(i>=this.length()) {
			i=-1;
		}
		if(fromIndex>=this.length()&&llstr.length()==0) {
			i=this.length();
		}
		return i;
	}
	
	//length
	public int length() {
		int length=0;
		LLNode tar=front;
		while(tar!=null) {
			tar=tar.next;
			length++;
		}
		return length;
	}
	
	//replace
	public LLString replace(char oldChar, char newChar) {
		LLString ret = new LLString(this.toString());
		LLNode tar = ret.front;
		while(tar!=null) {
			if(tar.character==oldChar) {
				tar.character=newChar;
			}
			tar=tar.next;
		}
		return ret;
	}
	
	//substring
	public LLString substring(int beginIndex) {
		return substring(beginIndex,this.length());
	}
	public LLString substring(int beginIndex, int endIndex) {
		LLString ret = new LLString(this.toString());
		LLNode tar = ret.front;
		if(beginIndex<0||endIndex>this.length()||beginIndex>endIndex)
			throw new IndexOutOfBoundsException();
		if(beginIndex==endIndex) {
			ret.front.character='\0';
			ret.front.next=null;
			return ret;
		}
		int i=0;
		while(i<endIndex-1) {
			if(i==beginIndex)
				ret.front=tar;
			tar=tar.next;
			i++;
		}
		if(beginIndex>=endIndex-1) {
			ret.front=tar;
		}
		tar.next=null;
		return ret;
	}
	
	public String toString() {
		LLNode tar = front;
		String ret="";
		while(tar!=null) {
			ret=ret+tar.character;
			tar=tar.next;
		}
		return ret;
	}
}
class LLNode{
    char character;
    LLNode next;
}
