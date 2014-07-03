public class Grid {
	private int[][] mat;
	
	public Grid() {
		mat = new int[4][4];			
	}
	
	public int[][] getGrid() { return mat; }
	
	public void setTile(int r, int c, int val) { mat[r][c] = val; }

	public void shiftDown()
	{
		if (mat[3][0] != 0) {
			if (mat[2][0] != 0) {
				if (mat[3][0] == mat[2][0]) {
					mat[3][0] += mat[2][0];
					mat[2][0] = 0;
					if ( (mat[1][0] != 0) && (mat[0][0] != 0) && (mat[1][0] == mat[0][0])) {
						mat[2][0] = mat[1][0] + mat[0][0];
						mat[1][0] = 0;
						mat[0][0] = 0;
					}
					else {
						
					}
				}
			}	
			else if (mat[1][0] != 0) {
				if (mat[3][0] == mat[1][0]) {
					mat[3][0] += mat[1][0];
					mat[1][0] = 0;
				} 
			}
			else if (mat[0][0] != 0) {
				if (mat[3][0] == mat[0][0]) {
					mat[3][0] += mat[0][0];
					mat[0][0] = 0;
				} 
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
