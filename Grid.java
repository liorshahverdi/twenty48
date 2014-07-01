public class Grid {
	private int[][] mat;
	
	public Grid() {
		mat = new int[4][4];			
	}
	
	public int[][] getGrid() { return mat; }
	
	public void setTile(int r, int c, int val) { mat[r][c] = val; }
}
