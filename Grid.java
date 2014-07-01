public class Grid {
	private int[][] mat;
	
	public Grid() {
		mat = new int[4][4];			
	}
	
	public int[][] getGrid() { return mat; }
	
	public void setTile(int r, int c, int val) { mat[r][c] = val; }

	public void shiftDown()
	{
		if ( (mat[3][0] != 0) || (mat[2][0] != 0) ) {
			if (mat[3][0] == mat[2][0]) {
				mat[3][0] = mat[3][0] * mat[2][0];
				mat[2][0] = 0;
			}
		}
		
		if ( (mat[3][1] != 0) || (mat[2][1] != 0) ) {
			if (mat[3][1] == mat[2][1]) {
				mat[3][1] = mat[3][1] * mat[2][1];
				mat[2][1] = 0;
			}
		}
		
		if ( (mat[3][2] != 0) || (mat[2][2] != 0) ) {
			if (mat[3][2] == mat[2][2]) {
				mat[3][2] = mat[3][2] * mat[2][2];
				mat[2][2] = 0;
			}
		}
		
		if ( (mat[3][3] != 0) || (mat[2][3] != 0) ) {
			if (mat[3][3] == mat[2][3]) {
				mat[3][3] = mat[3][3] * mat[2][3];
				mat[2][3] = 0;
			}
		}
	}
	
	public void shiftRight()
	{
		
	}
	
	public void shiftUp()
	{
		
	}
	
	public void shiftLeft()
	{
		
	}

}
