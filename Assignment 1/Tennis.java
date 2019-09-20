import java.util.*;

public class Tennis {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		String input="";
		String open="";
		String gender="";
		String score="";
		String savedScore="";
		int totalSet=0;
		int rSet=0;
		int lSet=0;
		int rGame=0;
		int lGame=0;
		int rPoint=0;
		int lPoint=0;
		boolean duece=false;
		boolean rAdvantage=false;
		boolean lAdvantage=false;
		boolean Australia=false;
		boolean noTieBreak=false;
		System.out.print("Type the match (A: Australian Open/U: US Open): ");
		input=console.next();
		if(input.equals("A")) {
			open="Australian Open";
			Australia=true;
		} else if(input.equals("U")) {
			open="US Open";
			Australia=false;
		}
		System.out.print("Type the gender (F: Female/M: Male): ");
		input=console.next();
		if(input.equals("M")) {
			gender="Male";
			totalSet=5;
		} else if(input.equals("F")) {
			gender="Female";
			totalSet=3;
		}
		System.out.println(open+"/"+gender+" chosen.");
		while((rSet<totalSet/2+1)&&(lSet<totalSet/2+1)) {
			if(lSet+rSet==totalSet-1&&Australia) {
				noTieBreak=true;
			}
			if(lGame==0&&rGame==0&&lSet+rSet>0) {
				score=savedScore;
			} else {
				score=savedScore.concat(lGame+"-"+rGame);
			}
			System.out.println("Current: "+score );
			if(lGame==0&&rGame==0&&lSet+rSet>0) {
				score=score.concat(lGame+"-"+rGame);
			}
			while(true) {
				duece=false;
				System.out.print("Type the winner (L: Left/R: Right): ");
				input=console.next();
				if(input.equals("L")) {
					lPoint+=15;
					if(lPoint==45) {
						lPoint-=5;
					}
				} else if(input.equals("R")) {
					rPoint+=15;
					if(rPoint==45) {
						rPoint-=5;
					}
				}
				if(lPoint>40&&rPoint<40) {
					lGame++;
					rPoint=0;
					lPoint=0;
					break;
				} else if(rPoint>40&&lPoint<40) {
					rGame++;
					rPoint=0;
					lPoint=0;
					break;
				} else if(rPoint==40&&lPoint==40) {
					duece=true;
				}
				System.out.println("Current: "+score.concat("("+lPoint+"-"+rPoint+")"));
				while(duece) {
					System.out.print("Type the winner (L: Left/R: Right): ");
					input=console.next();
					if(input.equals("L")&&lAdvantage==false&&rAdvantage==false) {
						lAdvantage=true;
					} else if(input.equals("L")&&lAdvantage==true&&rAdvantage==false) {
						lGame++;
						break;
					} else if(input.equals("L")&&lAdvantage==false&&rAdvantage==true) {
						rAdvantage=false;
					} else if(input.equals("R")&&lAdvantage==false&&rAdvantage==false) {
						rAdvantage=true;
					} else if(input.equals("R")&&lAdvantage==true&&rAdvantage==false) {
						lAdvantage=false;
					} else if(input.equals("R")&&lAdvantage==false&&rAdvantage==true) {
						rGame++;
						break;
					}
					if(lAdvantage) {
						System.out.println("Current: "+score.concat("("+lPoint+"A"+"-"+rPoint+")"));
					} else if(rAdvantage) {
						System.out.println("Current: "+score.concat("("+lPoint+"-"+rPoint+"A"+")"));
					} else {
						System.out.println("Current: "+score.concat("("+lPoint+"-"+rPoint+")"));
					}
				}
				if(duece) {
					duece=false;
					lAdvantage=false;
					rAdvantage=false;
					rPoint=0;
					lPoint=0;
					break;
				}

			}
			if(rGame>=6&&rGame-lGame>=2) {
				rSet++;
				score=savedScore.concat(lGame+"-"+rGame);
				savedScore=score+" ";
				rGame=0;
				lGame=0;
			} else if(lGame>=6&&lGame-rGame>=2) {
				lSet++;
				score=savedScore.concat(lGame+"-"+rGame);
				savedScore=score+" ";
				rGame=0;
				lGame=0;
			} else if(lGame==6&&rGame==6&&!noTieBreak) {
				score=savedScore.concat(lGame+"-"+rGame);
				while(true) {
					if(lPoint!=0||rPoint!=0) {
						System.out.println("Current: "+score.concat("("+lPoint+"-"+rPoint+")"));
					} else {
						System.out.println("Current: "+score);
					}
					System.out.print("Type the winner (L: Left/R: Right): ");
					input=console.next();
					if(input.equals("L")) {
						lPoint++;
					} else if(input.equals("R")) {
						rPoint++;
					}
					if(lPoint>=7&&lPoint-rPoint>=2) {
						lGame++;
						score=savedScore.concat(lGame+"-"+rGame);
						savedScore=score.concat("("+lPoint+"-"+rPoint+") ");
						lSet++;
						lGame=0;
						rGame=0;
						lPoint=0;
						rPoint=0;
						break;
					} else if(rPoint>=7&&rPoint-lPoint>=2) {
						rGame++;
						score=savedScore.concat(lGame+"-"+rGame);
						savedScore=score.concat("("+lPoint+"-"+rPoint+") ");
						rSet++;
						rGame=0;
						lGame=0;
						lPoint=0;
						rPoint=0;
						break;
					}
				}
			}
		}
		System.out.println("Current: "+savedScore.substring(0, savedScore.length()-1));
		System.out.println("Game finished!");
	}
}
