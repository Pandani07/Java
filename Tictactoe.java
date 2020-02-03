import java.util.*;
public class tictactoe {
	static ArrayList<Integer> playerpos= new ArrayList<Integer>();
	static ArrayList<Integer> cpuposition= new ArrayList<Integer>();
	public static void main(String args[]) {
		char[][] gameBoard= {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
		
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your placement:1-9\n");
			int pos=sc.nextInt();
			
			while(playerpos.contains(pos)||cpuposition.contains(pos)) {
				System.out.println("Position taken. Enter another\n");
				pos=sc.nextInt();
			}
			
			choosepos(pos,gameBoard,"player");
			
			Random rand=new Random();
			int cpupos=rand.nextInt(9)+1;
			while(playerpos.contains(cpupos)||cpuposition.contains(cpupos)) {
				System.out.println("Position taken. Enter another\n");
				cpupos=rand.nextInt(9)+1;
			}
			
			choosepos(cpupos,gameBoard,"cpu");
			printGameBoard(gameBoard);
			
			String victory=wincheck();
			if(victory.length()>0) {
				System.out.println(victory);
				break;
			}
		}
	}
	public static void printGameBoard(char[][] gameBoard1) {
		for(char[] row:gameBoard1) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void choosepos(int pos,char[][] gameBoard,String user) {
		char symbol;
		symbol=' ';
		if(user.equals("player")) {
			symbol='x';
			playerpos.add(pos);
		}
		else {
			symbol='o';
			cpuposition.add(pos);
		}
		switch(pos) {
			case 1:gameBoard[0][0]=symbol;break;
			case 2:gameBoard[0][2]=symbol;break;
			case 3:gameBoard[0][4]=symbol;break;
			case 4:gameBoard[2][0]=symbol;break;
			case 5:gameBoard[2][2]=symbol;break;
			case 6:gameBoard[2][4]=symbol;break;
			case 7:gameBoard[4][0]=symbol;break;
			case 8:gameBoard[4][2]=symbol;break;
			case 9:gameBoard[4][4]=symbol;break;
		}
	}
	public static String wincheck() {
		List toprow=Arrays.asList(1,2,3);
		List midrow=Arrays.asList(4,5,6);
		List botrow=Arrays.asList(7,8,9);
		List leftcol=Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List rightcol=Arrays.asList(3,6,9);
		List diag1=Arrays.asList(1,5,9);
		List diag2=Arrays.asList(3,5,7);
		
		List<List> winconditions=new ArrayList<List>();
		winconditions.add(toprow);
		winconditions.add(midrow);
		winconditions.add(botrow);
		winconditions.add(leftcol);
		winconditions.add(midcol);
		winconditions.add(rightcol);
		winconditions.add(diag1);
		winconditions.add(diag2);
		
		for(List l:winconditions) {
			if(playerpos.containsAll(l)) {
				return "Amazing!You won!!";
			}
			else if(cpuposition.containsAll(l)) {
				return "CPU wins";
			}
			else if(playerpos.size()+cpuposition.size()==9) {
				return "Tie";
			}
		}
		return "";
	}
}
