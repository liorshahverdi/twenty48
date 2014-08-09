package twenty48;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	
	public static int randInt(int min, int max) {

	    // Usually this should be a field rather than a method variable so
	    // that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void printMat(int[][] x)
	{
		for (int[] row : x)
		{
		    for (int value : row)
		    {
		    	if (value==0) System.out.print("-\t");
		    	else System.out.print(value+"\t");
		    }
		    System.out.println();
		}
	}

	public static void convert(int[][] x, int num1)
	{
		int[] options = {2,4};
		if (num1 == 1) {
			x[0][0] = options[randInt(0,1)];
		}
		else if (num1 == 2) {
			x[0][1] = options[randInt(0,1)];
		}
		else if (num1 == 3) {
			x[0][2] = options[randInt(0,1)];
		}
		else if (num1 == 4) {
			x[0][3] = options[randInt(0,1)];
		}
		else if (num1 == 5) {
			x[1][0] = options[randInt(0,1)];
		}
		else if (num1 == 6) {
			x[1][1] = options[randInt(0,1)];
		}
		else if (num1 == 7) {
			x[1][2] = options[randInt(0,1)];
		}
		else if (num1 == 8) {
			x[1][3] = options[randInt(0,1)];
		}
		else if (num1 == 9) {
			x[2][0] = options[randInt(0,1)];
		}
		else if (num1 == 10) {
			x[2][1] = options[randInt(0,1)];
		}
		else if (num1 == 11) {
			x[2][2] = options[randInt(0,1)];
		}
		else if (num1 == 12) {
			x[2][3] = options[randInt(0,1)];
		}
		else if (num1 == 13) {
			x[3][0] = options[randInt(0,1)];
		}
		else if (num1 == 14) {
			x[3][1] = options[randInt(0,1)];
		}
		else if (num1 == 15) {
			x[3][2] = options[randInt(0,1)];
		}
		else if (num1 == 16) {
			x[3][3] = options[randInt(0,1)];
		}

	}

	public static void initialize(int[][] x) {
		int[] arr = new int[16];
		int num1 = randInt(1, 16);
		int num2 = randInt(1, 16);
		while (num1 == num2) {
			num2 = randInt(1,16);
		}
		//System.out.println("1 = "+num1+"\t\t2 = "+num2)

		convert(x, num1);
		convert(x, num2);

	}

	public static boolean insertNewNumber(int[][] x)
	{
		int[] numOptions = {2,4};
		ArrayList<Cell> freeCells = new ArrayList<Cell>();
		for (int i = 0; i < 4; i++) {
			for (int j=0; j < 4; j++) {
				if (x[i][j] == 0) {
					Cell openCell = new Cell(i,j);
					freeCells.add(openCell);
				}
			}
		}
		//System.out.println("Length = "+freeCells.size());
		if (freeCells.size() != 0) {
			int numberToInsert = numOptions[randInt(0,1)];
			Cell roc = freeCells.get(randInt(0, freeCells.size()-1));
			//System.out.println("------>"+ randomOpenCell.toString());
			x[roc.getRow()][roc.getCol()] = numberToInsert;
			return true;
		}
		else return false;
	}

	public static boolean canBeShiftedUp(Grid x)
	{
		//make a copy
		Grid gridToPlayWith = x.deepCopy();

		//modify copy, not x
		gridToPlayWith.shiftUp();

		boolean result = gridToPlayWith.equals(x.getGrid());
		if (result) return false;
		else return true;
	}
	
	public static boolean canBeShiftedLeft(Grid x)
	{
		//make a copy
		Grid gridToPlayWith = x.deepCopy();

		//modify copy, not x
		gridToPlayWith.shiftLeft();

		boolean result = gridToPlayWith.equals(x.getGrid());
		if (result) return false;
		else return true;
	}

	public static boolean canBeShiftedDown(Grid x)
	{
		//make a copy
		Grid gridToPlayWith = x.deepCopy();

		//modify copy, not x
		gridToPlayWith.shiftDown();

		boolean result = gridToPlayWith.equals(x.getGrid());
		if (result) return false;
		else return true;
	}

	public static boolean canBeShiftedRight(Grid x)
	{
		//make a copy
		Grid gridToPlayWith = x.deepCopy();

		//modify copy, not x
		gridToPlayWith.shiftRight();

		boolean result = gridToPlayWith.equals(x.getGrid());
		if (result) return false;
		else return true;
	}

	public static boolean canShiftAnything(Grid x)
	{
		if ( canBeShiftedUp(x) || canBeShiftedLeft(x) || canBeShiftedDown(x) || canBeShiftedRight(x) ) return true;
		else return false;
	}

	public static boolean searchForIt(int[][] x)
	{
		for (int i = 0; i < 4; i++) {
			for (int j=0; j < 4; j++) {
				if (x[i][j] == 2048) {
					return true;
				}
			}
		}
		return false;
	}

	public static void startGame() {
		Grid mainGrid = new Grid();
		int[][] mat = mainGrid.getGrid();
		initialize(mat);
		boolean keepPlaying = true;
		boolean twenty48 = false;

		while (keepPlaying){
			System.out.println("--------------------------");
			printMat(mat);
			System.out.println("--------------------------");
			if (canShiftAnything(mainGrid)) {
				Scanner gameScan = new Scanner(System.in);
				String nextShift = gameScan.next().toUpperCase();
				
				if (nextShift.equals("W")) {
					if(canBeShiftedUp(mainGrid)) mainGrid.shiftUp();
					else {
						System.out.println("Cannot be shifted up. A S D are your options");
						continue;
					}
				}
				else if (nextShift.equals("A")) {
					if(canBeShiftedLeft(mainGrid)) mainGrid.shiftLeft();
					else {
						System.out.println("Cannot be shifted left. W S D are your options");
						continue;
					}
				}
				else if (nextShift.equals("S")) {
					if(canBeShiftedDown(mainGrid)) mainGrid.shiftDown();
					else {
						System.out.println("Cannot be shifted down. W A D are your options");
						continue;
					}
				}
				else if (nextShift.equals("D")) {
					if(canBeShiftedRight(mainGrid)) mainGrid.shiftRight();
					else {
						System.out.println("Cannot be shifted right. W A S are your options");
						continue;
					}
				}
				
				keepPlaying = insertNewNumber(mat);
				twenty48 = searchForIt(mat);
				if (twenty48) {
					System.out.println("YOU REACHED 2048!");
					System.exit(0);
				}
			}
			else keepPlaying = false;
		}

	}
		
	public static void main(String[] args) {
		boolean play = true;
		while (play) {
			Scanner myScan = new Scanner(System.in);
			System.out.print("Welcome to LS 2048!\nUse WASD to shift, Enter to submit.\nReady to Start? (y/n)\t");
			String initChar = myScan.next();
			if (initChar.toUpperCase().equals("Y")) {
				startGame();
			}
			else {
				System.out.println("Goodbye!");
				break;	
			}
			System.out.println("Game Over!! :'(\t\tPlay Again? (y/n)");
			String playAgain = myScan.next();
			if (playAgain.toUpperCase().equals("Y")) play = true;
			else {
				System.out.println("Goodbye!");
				play = false;
			}
		}
		/*Shift Tester
		*
		*
		Grid mainGrid = new Grid();
		int[][] mat = mainGrid.getGrid();
		
		mainGrid.setTile(0,0,4);
		mainGrid.setTile(0,1,0);
		mainGrid.setTile(0,2,2);
		mainGrid.setTile(0,3,4); //shiftRight
		

		mainGrid.setTile(0,0,4);
		mainGrid.setTile(1,0,2);
		mainGrid.setTile(2,0,0);
		mainGrid.setTile(3,0,4);
		
		System.out.println("********************");
		printMat(mat);
		System.out.println("********************");
		mainGrid.shiftRight();
		printMat(mat);
		System.out.println("********************");
		*/
	}
}
