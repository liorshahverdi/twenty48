import java.util.Random;
import java.util.ArrayList;

public class Main {

	
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

	public static void insertNumToRandomOpenCell(int[][] x)
	{
		ArrayList<Cell> freeCells = new ArrayList<Cell>();
		for (int i = 0; i < 4; i++) {
			for (int j=0; j < 4; j++) {
				if (x[i][j] == 0) {
					Cell openCell = new Cell(i,j);
					freeCells.add(openCell);
				}
			}
		}

		System.out.println("Length = "+freeCells.size());
	}
	
	public static void main(String[] args) {
		Grid mainGrid = new Grid();
		
		int[][] mat = mainGrid.getGrid();

		mainGrid.setTile(3,0,0);
		mainGrid.setTile(3,1,0);
		mainGrid.setTile(3,2,0);
		mainGrid.setTile(3,3,4096);

		//printMat(mat);
		insertNumToRandomOpenCell(mat);
		System.out.println("\n---------------------\n");

		//printMat(mat);
	}
}
