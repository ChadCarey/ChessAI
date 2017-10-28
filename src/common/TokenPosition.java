package common;

public class TokenPosition {
	int row;
	int col;

	public TokenPosition(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
}
