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
		mainGrid.setTile(2,0,2);
		mainGrid.setTile(3,2,2);
		boolean keepPlaying = true;
		boolean twenty48 = false;

		while (keepPlaying){
			System.out.println("--------------------------");
			printMat(mat);
			System.out.println("--------------------------");
			Scanner gameScan = new Scanner(System.in);
			String nextShift = gameScan.next().toUpperCase();
			
			if (nextShift.equals("W")) mainGrid.shiftUp();
			else if (nextShift.equals("A")) mainGrid.shiftLeft();
			else if (nextShift.equals("S")) mainGrid.shiftDown();
			else if (nextShift.equals("D")) mainGrid.shiftRight();
			
			keepPlaying = insertNewNumber(mat);
			twenty48 = searchForIt(mat);
			if (twenty48) {
				System.out.println("YOU REACHED 2048!");
				System.exit(0);
			}
		}
		System.out.println("Game Over! :'(");

	}
		
	public static void main(String[] args) {
		/*
		Scanner myScan = new Scanner(System.in);
		System.out.print("Welcome to LS 2048!\nUse WASD to play.\nReady to Start? (y/n)\t");
		String initChar = myScan.next();
		
		if (initChar.toUpperCase().equals("Y")) startGame();
		else System.out.println("Goodbye!");
		*/

		
		//*Shift Tester
		//*
		//*
		Grid mainGrid = new Grid();
		int[][] mat = mainGrid.getGrid();
		mainGrid.setTile(0,0,4);
		mainGrid.setTile(0,1,2);
		mainGrid.setTile(0,2,0);
		mainGrid.setTile(0,3,4);

		System.out.println("********************");
		printMat(mat);
		System.out.println("********************");
		mainGrid.shiftRight();
		printMat(mat);
		System.out.println("********************");
		//*/
	}
}
