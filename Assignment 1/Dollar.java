import java.util.*;

public class Dollar {
	
	public static void full(int n) {
		int space;
		int dollar;
		if(n%2==1) {
			space=(n-1)/2;
			dollar=1;
		} else {
			space=(n-2)/2;
			dollar=2;
		}
		int lastDiffer=0;
		int i=0,j=0;
		boolean notFour=false;

		if(n==1) {
			for(i=0;i<3;i++) {
				System.out.println("$");
			}
			return;
		} else if(n==2) {
			for(i=0;i<3;i++) {
				System.out.println("$$");
			}
			return;
		} else if(n==3) {
			for(i=0;i<2;i++) {
				System.out.println(" $");
				System.out.println("$$$");
			}
			System.out.println(" $");
			return;
		}
		while(dollar<=n) {
			for(i=0;i<space;i++) {
				System.out.print(" ");
			}
			for(i=0;i<dollar;i++) {
				System.out.print("$");
			}
			System.out.println();
			if(dollar == n)
				break;
			if(dollar+4>n) {
				dollar+=2;
				space--;
				lastDiffer=2;
			} else {
				dollar+=4;
				space-=2;
				lastDiffer=4;
			}
		}
		
		while(dollar>=n/2.0) {
			if(dollar==n) {
				dollar-=lastDiffer;
				space=space+lastDiffer/2;
				notFour=true;
			} else {
				dollar-=4;
				space+=2;
				notFour=false;
			}
			if(dollar<n/2.0) {
				if(notFour) {
					dollar+=lastDiffer;
					space-=lastDiffer/2;
				} else {
					dollar+=4;
					space-=2;
				}
				break;
			}
			for(j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(j=0;j<dollar;j++) {
				System.out.print("$");
			}
			System.out.println();
		}

		while(dollar<=n) {
			if(dollar+4>n) {
				dollar+=lastDiffer;
				space-=lastDiffer/2;
				notFour=true;
			} else {
				dollar+=4;
				space-=2;
				notFour=false;
			}
			if(dollar>n) {
				if(notFour) {
					dollar-=lastDiffer;
					space+=lastDiffer/2;
				} else {
					dollar-=4;
					space+=2;
				}
				break;
			}
			for(j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(j=0;j<dollar;j++) {
				System.out.print("$");
			}
			System.out.println();
		}
		
		while(dollar>0) {
			if(dollar==n) {
				dollar-=lastDiffer;
				space+=lastDiffer/2;
			} else {
				dollar-=4;
				space+=2;
			}
			if(dollar<=0) {
				break;
			}
			for(i=0;i<space;i++) {
				System.out.print(" ");
			}
			for(i=0;i<dollar;i++) {
				System.out.print("$");
			}
			System.out.println();
		}
		if(n==5) {
			System.out.println("$$$$$\n  $");
		} else if(n==6) {
			System.out.println("$$$$$$\n  $$");
		}
	}
	
	public static void border(int n) {
		int space;
		int dollar;
		if(n%2==1) {
			space=(n-1)/2;
			dollar=1;
		} else {
			space=(n-2)/2;
			dollar=2;
		}
		int lastDiffer=0;
		int i=0,j=0;
		boolean notFour=false;
		if(n==1) {
			for(i=0;i<3;i++) {
				System.out.println("$");
			}
			return;
		} else if(n==2) {
			for(i=0;i<3;i++) {
				System.out.println("$$");
			}
			return;
		} else if(n==3) {
			System.out.println(" $");
			System.out.println("$ $");
			System.out.println("@$@");
			System.out.println("$ $");
			System.out.println(" $");
			return;
		}
		while(dollar<=n) {
			for(i=0;i<space;i++) {
				System.out.print(" ");
			}
			System.out.print("$");
			for(i=0;i<dollar-2;i++) {
				System.out.print(" ");
			}
			if(dollar!=1) {
				System.out.println("$");
			} else {
				System.out.println();
			}
			if(dollar == n)
				break;
			if(dollar+4>n) {
				dollar+=2;
				space--;
				lastDiffer=2;
			} else {
				dollar+=4;
				space-=2;
				lastDiffer=4;
			}
		}
		
		while(dollar>=n/2.0) {
			if(dollar==n) {
				dollar-=lastDiffer;
				space=space+lastDiffer/2;
				notFour=true;
			} else {
				dollar-=4;
				space+=2;
				notFour=false;
			}
			if(dollar<n/2.0) {
				if(notFour) {
					dollar+=lastDiffer;
					space-=lastDiffer/2;
				} else {
					dollar+=4;
					space-=2;
				}
				break;
			}
			for(j=0;j<space-1;j++) {
				System.out.print(" ");
			}
			if(dollar<=n/2) {
				System.out.print("@");
			} else {
				System.out.print(" ");
			}
			System.out.print("$");
			for(j=0;j<dollar-2;j++) {
				System.out.print(" ");
			}
			if(dollar!=1&&dollar<=n/2) {
				System.out.println("$@");
			} else if(n==5) {
				System.out.println("@");
			} else if(dollar!=1) {
				System.out.println("$");
			} else {
				System.out.println();
			}
		}

		while(dollar<=n) {
			if(dollar+4>n) {
				dollar+=lastDiffer;
				space-=lastDiffer/2;
				notFour=true;
			} else {
				dollar+=4;
				space-=2;
				notFour=false;
			}
			if(dollar>n) {
				if(notFour) {
					dollar-=lastDiffer;
					space+=lastDiffer/2;
				} else {
					dollar-=4;
					space+=2;
				}
				break;
			}
			for(j=0;j<space;j++) {
				System.out.print(" ");
			}
			System.out.print("$");
			for(j=0;j<dollar-2;j++) {
				System.out.print(" ");
			}
			if(dollar!=1) {
				System.out.println("$");
			} else {
				System.out.println();
			}
		}
		
		while(dollar>0) {
			if(n==5||n==6) {
				break;
			}
			if(dollar==n) {
				dollar-=lastDiffer;
				space+=lastDiffer/2;
			} else {
				dollar-=4;
				space+=2;
			}
			if(dollar<=0) {
				break;
			}
			for(i=0;i<space;i++) {
				System.out.print(" ");
			}
			System.out.print("$");
			for(i=0;i<dollar-2;i++) {
				System.out.print(" ");
			}
			if(dollar!=1) {
				System.out.println("$");
			} else {
				System.out.println();
			}
		}
		if(n==5) {
			System.out.println(" @$@\n$   $\n  $");
		} else if(n==6) {
			System.out.println(" @$$@\n$    $\n  $$");
		}
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Type the maximum length: ");
		int n=console.nextInt();
		
		System.out.println("(a)");
		full(n);
		System.out.println("(b)");
		border(n);
	}
}
