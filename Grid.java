package twenty48;
public class Grid {
	private int[][] mat;
	
	public Grid() {
		mat = new int[4][4];			
	}
	
	public int[][] getGrid() { return mat; }
	
	public void setTile(int r, int c, int val) { mat[r][c] = val; }

	public int getTile(int r, int c) { return mat[r][c]; }

	public boolean equals(int[][] x) {
		for (int i = 0; i < 4; i++) {
			for (int j=0; j < 4; j++) {
				/*System.out.println("xij->"+x[i][j]);
				System.out.println("ths->"+this.getTile(i,j));
				System.out.println(); */
				if (x[i][j] == this.getTile(i,j)) continue;
				else return false;
			}
		}
		return true;
	}

	public Grid deepCopy() {
		Grid temp = new Grid();
		for (int i = 0; i < 4; i++) {
			for (int j=0; j < 4; j++) {
				temp.setTile(i,j,this.getTile(i,j));
			}
		}
		return temp;
	}

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
					else if ((mat[1][k] == 0) && (mat[0][k] != 0))
					{
						mat[1][k] = mat[0][k];
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
					else if (mat[2][k] == 0){
						mat[2][k] = mat[3][k];
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
							if (mat[3][k]!=0) {
								mat[2][k] = mat[3][k];
							}
							mat[3][k] = 0;
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
	{// [row3][colk] -> [rowk][col3]
	 	for (int k=0; k<4; k++) {
			if (mat[k][3] != 0) {
				if (mat[k][2] != 0) {
					if (mat[k][3] == mat[k][2]) {
						mat[k][3] += mat[k][2];
						mat[k][2] = 0;
						if ( (mat[k][1] != 0) && (mat[k][0] != 0) && (mat[k][1] == mat[k][0]) ) {
							mat[k][2] = mat[k][1] + mat[k][0];
							mat[k][1] = 0;
							mat[k][0] = 0;
						}
						else {//row1 != row0
							if (mat[k][1] == 0) {
								mat[k][2] = mat[k][0];
								mat[k][0] = 0;
							}
							else {
								mat[k][2] = mat[k][1];
								mat[k][1] = mat[k][0]; 
								mat[k][0] = 0;
							}							
						}
					}
					else if (mat[k][2] == mat[k][1]) {
						mat[k][2] += mat[k][1];
						if (mat[k][0] != 0) {
							mat[k][1] = mat[k][0];
							mat[k][0] = 0;
						}
						else {
							mat[k][1] = 0;
						} 
					}
					else if ((mat[k][2] == mat[k][0]) && (mat[k][1]==0)) {
						mat[k][2] += mat[k][0];
						mat[k][0] = 0;
					}
					else if (mat[k][1] == mat[k][0]) {
						mat[k][1] += mat[k][0];
						mat[k][0] = 0;
					}
					else if ((mat[k][1] == 0) && (mat[k][0]!= 0) ) {
						mat[k][1] = mat[k][0];
						mat[k][0] = 0;
					}
				}	
				else if (mat[k][1] != 0) {
					if (mat[k][3] == mat[k][1]) {
						mat[k][3] += mat[k][1];
						mat[k][1] = 0;
						if (mat[k][0] != 0) {
							mat[k][2] = mat[k][0];
							mat[k][0] = 0;
						}
					} 
					else {//[3][k]taken [2][k]empty [1][k]taken
						if (mat[k][1] == mat[k][0]) {
							mat[k][2] = mat[k][1] + mat[k][0];
							mat[k][1] = 0;
							mat[k][0] = 0;
						}
						else {
							mat[k][2] = mat[k][1];
							mat[k][1] = 0;
							if (mat[k][0] != 0) {
								mat[k][1] = mat[k][0];
								mat[k][0] = 0;
							}
						}
					}
				}
				else if (mat[k][0] != 0) {
					if (mat[k][3] == mat[k][0]) {
						mat[k][3] += mat[k][0];
						mat[k][0] = 0;
					}
					else {
						mat[k][2] = mat[k][0];
						mat[k][0] = 0;
					} 
				}
			}
			else {//mat[3][k] empty
				if (mat[k][2] != 0) {
					if (mat[k][1] != 0) {
						if (mat[k][2] == mat[k][1]) {
							mat[k][3] = mat[k][2] + mat[k][1];
							mat[k][2] = mat[k][0];
							mat[k][1] = 0;
							mat[k][0] = 0;
						}
						else {//[2][k] != [1][k] AND [3][k] is empty
							if (mat[k][0] != 0) {
								if (mat[k][1] == mat[k][0]) {
									mat[k][3] = mat[k][2];
									mat[k][2] = mat[k][1] + mat[k][0];
									mat[k][1] = 0;
									mat[k][0] = 0;
								}
								else {
									mat[k][3] = mat[k][2];
									mat[k][2] = mat[k][1];
									mat[k][1] = mat[k][0];
									mat[k][0] = 0;
								}
							}
							else {
								mat[k][3] = mat[k][2];
								mat[k][2] = mat[k][1];
								mat[k][1] = 0;
							}			
						}
					}
					else {//[3][k] empty, [2][k] occupied, [1][k] empty
						if (mat[k][2] == mat[k][0]) {
							mat[k][3] = mat[k][2] + mat[k][0];
							mat[k][2] = 0;
							mat[k][0] = 0;
						}
						else {
							mat[k][3] = mat[k][2];
							mat[k][2] = mat[k][0];
							mat[k][0] = 0;
						}
					}
				}
				else {//mat[2][k] AND mat[3][k] empty
					if (mat[k][1] != 0) {
						if (mat[k][0] != 0) {
							if (mat[k][1] == mat[k][0]) {
								mat[k][3] = mat[k][1] + mat[k][0];
								mat[k][1] = 0;
								mat[k][0] = 0;
							}
							else {
								mat[k][3] = mat[k][1];
								mat[k][2] = mat[k][0];
								mat[k][1] = 0;
								mat[k][0] = 0;
							}
						}
						else {
							mat[k][3] = mat[k][1];
							mat[k][1] = 0;
						}
					} 
					else {
						mat[k][3] = mat[k][0];
						mat[k][0] = 0;
					}
				}
			}	
		}	
	}
	
	public void shiftLeft()
	{// [row0][colk] -> [rowk][col0]
		for (int k=0; k<4; k++) {
			if (mat[k][0] != 0) {
				if (mat[k][1] != 0) {
					if (mat[k][0] == mat[k][1]) {
						mat[k][0] += mat[k][1];
						mat[k][1] = 0;
						if ( (mat[k][2] != 0) && (mat[k][3] != 0) && (mat[k][2] == mat[k][3]) ) {
							mat[k][1] = mat[k][2] + mat[k][3];
							mat[k][2] = 0;
							mat[k][3] = 0;
						}
						else {
							if (mat[k][2] == 0) {
								mat[k][1] = mat[k][3];
								mat[k][3] = 0;
							}
							else {
								mat[k][1] = mat[k][2];
								mat[k][2] = mat[k][3]; 
								mat[k][3] = 0;
							}
							
						}
					}
					else if (mat[k][1] == mat[k][2]) {
						mat[k][1] += mat[k][2];
						if (mat[k][3] != 0) {
							mat[k][2] = mat[k][3];
							mat[k][3] = 0;
						}
						else {
							mat[k][2] = 0;
						} 
					}
					else if ((mat[k][1] == mat[k][3]) && (mat[k][2]==0)) {
						mat[k][1] += mat[k][3];
						mat[k][3] = 0;
					}
					else if (mat[k][2] == mat[k][3]) {
						mat[k][2] += mat[k][3];
						mat[k][3] = 0;
					}
					else {
						if ((mat[k][2] == 0) && (mat[k][3] != 0)) {
							mat[k][2] = mat[k][3];
							mat[k][3] = 0;
						}
					}
				}	
				else if (mat[k][2] != 0) {
					if (mat[k][0] == mat[k][2]) {
						mat[k][0] += mat[k][2];
						mat[k][2] = 0;
						if (mat[k][3] != 0) {
							mat[k][1] = mat[k][3];
							mat[k][3] = 0;
						}
					} 
					else {
						if (mat[k][2] == mat[k][3]) {
							mat[k][1] = mat[k][2] + mat[k][3];
							mat[k][2] = 0;
							mat[k][3] = 0;
						}
						else {
							mat[k][1] = mat[k][2];
							mat[k][2] = 0;
							if (mat[k][3] != 0) {
								mat[k][2] = mat[k][3];
								mat[k][3] = 0;
							}
						}
					}
				}
				else if (mat[k][3] != 0) {
					if (mat[k][0] == mat[k][3]) {
						mat[k][0] += mat[k][3];
						mat[k][3] = 0;
					}
					else {
						mat[k][1] = mat[k][3];
						mat[k][3] = 0;
					}
				}
			}
			else {
				if (mat[k][1] != 0) {
					if (mat[k][2] != 0) {
						if (mat[k][1] == mat[k][2]) {
							mat[k][0] = mat[k][1] + mat[k][2];
							mat[k][1] = mat[k][3];
							mat[k][2] = 0;
							mat[k][3] = 0;
						}
						else {//[2][k] != [1][k] AND [3][k] is empty
							if (mat[k][3] != 0) {
								if (mat[k][2] == mat[k][3]) {
									mat[k][0] = mat[k][1];
									mat[k][1] = mat[k][2] + mat[k][3];
									mat[k][2] = 0;
									mat[k][3] = 0;
								}
								else {
									mat[k][0] = mat[k][1];
									mat[k][1] = mat[k][2];
									mat[k][2] = mat[k][3];
									mat[k][3] = 0;
								}
							}
							else {
								mat[k][0] = mat[k][1];
								mat[k][1] = mat[k][2];
								mat[k][2] = 0;
							}			
						}
					}
					else {//[3][k] empty, [2][k] occupied, [1][k] empty
						if (mat[k][1] == mat[k][3]) {
							mat[k][0] = mat[k][1] + mat[k][3];
							mat[k][1] = 0;
							mat[k][3] = 0;
						}
						else {
							mat[k][0] = mat[k][1];
							mat[k][1] = mat[k][3];
							mat[k][3] = 0;
						}
					}
				}
				else {//mat[2][k] AND mat[3][k] empty
					if (mat[k][2] != 0) {
						if (mat[k][3] != 0) {
							if (mat[k][2] == mat[k][3]) {
								mat[k][0] = mat[k][2] + mat[k][3];
								mat[k][2] = 0;
								mat[k][3] = 0;
							}
							else {
								mat[k][0] = mat[k][2];
								mat[k][1] = mat[k][3];
								mat[k][2] = 0;
								mat[k][3] = 0;
							}
						}
						else {
							mat[k][0] = mat[k][2];
							mat[k][2] = 0;
						}
					} 
					else {
						mat[k][0] = mat[k][3];
						mat[k][3] = 0;
					}
				}
			}	
		}
	}

}
