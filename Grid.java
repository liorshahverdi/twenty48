public class Grid {
	private int[][] mat;
	
	public Grid() {
		mat = new int[4][4];			
	}
	
	public int[][] getGrid() { return mat; }
	
	public void setTile(int r, int c, int val) { mat[r][c] = val; }

	public void shiftDown()
	{
		for (int k=0; k<4; k++) {
			if (mat[3][k] != 0) {
				if (mat[2][k] != 0) {
					if (mat[3][k] == mat[2][k]) {
						mat[3][k] += mat[2][k];
						mat[2][k] = 0;
						if ( (mat[1][k] != 0) && (mat[0][k] != 0) && (mat[1][k] == mat[0][k]) ) {
							mat[2][k] = mat[1][k] + mat[0][k];
							mat[1][k] = 0;
							mat[0][k] = 0;
						}
						else {//row1 != row0
							if (mat[1][k] == 0) {
								mat[2][k] = mat[0][k];
								mat[0][k] = 0;
							}
							else {
								mat[2][k] = mat[1][k];
								mat[1][k] = mat[0][k]; 
								mat[0][k] = 0;
							}
							
						}
					}
					else if (mat[2][k] == mat[1][k]) {
						mat[2][k] += mat[1][k];
						if (mat[0][k] != 0) {
							mat[1][k] = mat[0][k];
							mat[0][k] = 0;
						}
						else {
							mat[1][k] = 0;
						} 
					}
					else if ((mat[2][k] == mat[0][k]) && (mat[1][k]==0)) {
						mat[2][k] += mat[0][k];
						mat[0][k] = 0;
					}
					else if (mat[1][k] == mat[0][k]) {
						mat[1][k] += mat[0][k];
						mat[0][k] = 0;
					}
				}	
				else if (mat[1][k] != 0) {
					if (mat[3][k] == mat[1][k]) {
						mat[3][k] += mat[1][k];
						mat[1][k] = 0;
						if (mat[0][k] != 0) {
							mat[2][k] = mat[0][k];
							mat[0][k] = 0;
						}
					} 
					else {//[3][k]taken [2][k]empty [1][k]taken
						if (mat[1][k] == mat[0][k]) {
							mat[2][k] = mat[1][k] + mat[0][k];
							mat[1][k] = 0;
							mat[0][k] = 0;
						}
						else {
							mat[2][k] = mat[1][k];
							mat[1][k] = 0;
						}
					}
				}
				else if (mat[0][k] != 0) {
					if (mat[3][k] == mat[0][k]) {
						mat[3][k] += mat[0][k];
						mat[0][k] = 0;
					}
					else {
						mat[2][k] = mat[0][k];
						mat[0][k] = 0;
					} 
				}
			}
			else {//mat[3][k] empty
				if (mat[2][k] != 0) {
					if (mat[1][k] != 0) {
						if (mat[2][k] == mat[1][k]) {
							mat[3][k] = mat[2][k] + mat[1][k];
							mat[2][k] = mat[0][k];
							mat[1][k] = 0;
							mat[0][k] = 0;
						}
						else {//[2][k] != [1][k] AND [3][k] is empty
							if (mat[0][k] != 0) {
								if (mat[1][k] == mat[0][k]) {
									mat[3][k] = mat[2][k];
									mat[2][k] = mat[1][k] + mat[0][k];
									mat[1][k] = 0;
									mat[0][k] = 0;
								}
								else {
									mat[3][k] = mat[2][k];
									mat[2][k] = mat[1][k];
									mat[1][k] = mat[0][k];
									mat[0][k] = 0;
								}
							}
							else {
								mat[3][k] = mat[2][k];
								mat[2][k] = mat[1][k];
								mat[1][k] = 0;
							}			
						}
					}
					else {//[3][k] empty, [2][k] occupied, [1][k] empty
						if (mat[2][k] == mat[0][k]) {
							mat[3][k] = mat[2][k] + mat[0][k];
							mat[2][k] = 0;
							mat[0][k] = 0;
						}
						else {
							mat[3][k] = mat[2][k];
							mat[2][k] = mat[0][k];
							mat[0][k] = 0;
						}
					}
				}
				else {//mat[2][k] AND mat[3][k] empty
					if (mat[1][k] != 0) {
						if (mat[0][k] != 0) {
							if (mat[1][k] == mat[0][k]) {
								mat[3][k] = mat[1][k] + mat[0][k];
								mat[1][k] = 0;
								mat[0][k] = 0;
							}
							else {
								mat[3][k] = mat[1][k];
								mat[2][k] = mat[0][k];
								mat[1][k] = 0;
								mat[0][k] = 0;
							}
						}
						else {
							mat[3][k] = mat[1][k];
							mat[1][k] = 0;
						}
					} 
					else {
						mat[3][k] = mat[0][k];
						mat[0][k] = 0;
					}
				}
			}	
		}	
	}
	
	public void shiftUp()
	{
		for (int k=0; k<4; k++) {
			if (mat[0][k] != 0) {
				if (mat[1][k] != 0) {
					if (mat[0][k] == mat[1][k]) {
						mat[0][k] += mat[1][k];
						mat[1][k] = 0;
						if ( (mat[2][k] != 0) && (mat[3][k] != 0) && (mat[2][k] == mat[3][k]) ) {
							mat[1][k] = mat[2][k] + mat[3][k];
							mat[2][k] = 0;
							mat[3][k] = 0;
						}
						else {
							if (mat[2][k] == 0) {
								mat[1][k] = mat[3][k];
								mat[3][k] = 0;
							}
							else {
								mat[1][k] = mat[2][k];
								mat[2][k] = mat[3][k]; 
								mat[3][k] = 0;
							}
							
						}
					}
					else if (mat[1][k] == mat[2][k]) {
						mat[1][k] += mat[2][k];
						if (mat[3][k] != 0) {
							mat[2][k] = mat[3][k];
							mat[3][k] = 0;
						}
						else {
							mat[2][k] = 0;
						} 
					}
					else if ((mat[1][k] == mat[3][k]) && (mat[2][k]==0)) {
						mat[1][k] += mat[3][k];
						mat[3][k] = 0;
					}
					else if (mat[2][k] == mat[3][k]) {
						mat[2][k] += mat[3][k];
						mat[3][k] = 0;
					}
				}	
				else if (mat[2][k] != 0) {
					if (mat[0][k] == mat[2][k]) {
						mat[0][k] += mat[2][k];
						mat[2][k] = 0;
						if (mat[3][k] != 0) {
							mat[1][k] = mat[3][k];
							mat[3][k] = 0;
						}
					} 
					else {
						if (mat[2][k] == mat[3][k]) {
							mat[1][k] = mat[2][k] + mat[3][k];
							mat[2][k] = 0;
							mat[3][k] = 0;
						}
						else {
							mat[1][k] = mat[2][k];
							mat[2][k] = 0;
						}
					}
				}
				else if (mat[3][k] != 0) {
					if (mat[0][k] == mat[3][k]) {
						mat[0][k] += mat[3][k];
						mat[3][k] = 0;
					}
					else {
						mat[1][k] = mat[3][k];
						mat[3][k] = 0;
					}
				}
			}
			else {
				if (mat[1][k] != 0) {
					if (mat[2][k] != 0) {
						if (mat[1][k] == mat[2][k]) {
							mat[0][k] = mat[1][k] + mat[2][k];
							mat[1][k] = mat[3][k];
							mat[2][k] = 0;
							mat[3][k] = 0;
						}
						else {//[2][k] != [1][k] AND [3][k] is empty
							if (mat[3][k] != 0) {
								if (mat[2][k] == mat[3][k]) {
									mat[0][k] = mat[1][k];
									mat[1][k] = mat[2][k] + mat[3][k];
									mat[2][k] = 0;
									mat[3][k] = 0;
								}
								else {
									mat[0][k] = mat[1][k];
									mat[1][k] = mat[2][k];
									mat[2][k] = mat[3][k];
									mat[3][k] = 0;
								}
							}
							else {
								mat[0][k] = mat[1][k];
								mat[1][k] = mat[2][k];
								mat[2][k] = 0;
							}			
						}
					}
					else {//[3][k] empty, [2][k] occupied, [1][k] empty
						if (mat[1][k] == mat[3][k]) {
							mat[0][k] = mat[1][k] + mat[3][k];
							mat[1][k] = 0;
							mat[3][k] = 0;
						}
						else {
							mat[0][k] = mat[1][k];
							mat[1][k] = mat[3][k];
							mat[3][k] = 0;
						}
					}
				}
				else {//mat[2][k] AND mat[3][k] empty
					if (mat[2][k] != 0) {
						if (mat[3][k] != 0) {
							if (mat[2][k] == mat[3][k]) {
								mat[0][k] = mat[2][k] + mat[3][k];
								mat[2][k] = 0;
								mat[3][k] = 0;
							}
							else {
								mat[0][k] = mat[2][k];
								mat[1][k] = mat[3][k];
								mat[2][k] = 0;
								mat[3][k] = 0;
							}
						}
						else {
							mat[0][k] = mat[2][k];
							mat[2][k] = 0;
						}
					} 
					else {
						mat[0][k] = mat[3][k];
						mat[3][k] = 0;
					}
				}
			}	
		}
	}

	public void shiftRight()
	{
	   /*
	    * 
		*
		*
		*
		*/
		
	}
	
	public void shiftLeft()
	{
		
	}

}
