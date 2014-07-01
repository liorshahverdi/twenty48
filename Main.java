import java.util.Random;

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
		    	if (value==0) System.out.print("- ");
		    	else System.out.print(value+" ");
		    }
		    System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Grid mainGrid = new Grid();
		
		int[][] mat = mainGrid.getGrid();
		
		mainGrid.setTile(1, 3, 2);
		mainGrid.setTile(2, 3, 2);
		
		printMat(mat);
	}

}
