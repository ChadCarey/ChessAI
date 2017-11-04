package chess_boards;

import token.Token;

// TODO: create some kind of tile abstraction to contain the token and location
public class GameBoard {
	private Token[][]  board;
	private Integer size;
	static final Token EMPTY_SPACE = null;
	
	// CONSTRUCTORS
	
	public GameBoard(int size) {
		this.size = size;
		this.board = new Token[size][size];
	}
	
	public GameBoard(GameBoard copy) {
		this.size = copy.size;
		this.board = new Token[size][size];
		for(int row = 0; row < this.size; ++row) {
			for(int col = 0; col < this.size; ++col) {
				this.board[row][col] = copy.board[row][col]; 
			}
		}
	}
	

	// GETTERS
	
	public Token get(int row, int col) {
		assert(row < this.size);
		assert(row >= 0);
		assert(col < this.size);
		assert(col >= 0);
		
		return this.board[row][col];
	}
	
	public Integer getSize() {
		return this.size;
	}

	public GameBoard clone() {
		return new GameBoard(this);
	}
	
	
	public Boolean equals(GameBoard other) {
		if( !this.size.equals(other.size) ) {
			return false;
		}
		
		for(int row = 0; row < this.size; ++row) {
			for( int col = 0; col < this.size; ++col) {
				if( !this.board[row][col].equals(other.board[row][col]) ) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		String out = "";
		for(int i = 0; i < this.getSize(); ++i) {
			out += "| ";
			for(int j = 0; j < this.getSize(); ++ j) {
				Token t = this.get(i, j);
				if(t != null) {
					out += t.toString();
				} else {
					out += "-";
				}
				
				out += " | ";
			}
			out += "\n";
		}
		return out;
	}

	// SETTERS
	
	public GameBoard set(int row, int col, Token token) {
		assert(row < this.size);
		assert(row >= 0);
		assert(col < this.size);
		assert(col >= 0);
		
		this.board[row][col] = token;
		
		return this;
	}
	
	public GameBoard move(int fromRow, int fromCol, int toRow, int toCol) {
		Token movedToken = this.get(fromRow, fromCol);
		this.remove(fromRow, fromCol);
		this.set(toRow, toCol, movedToken);
		
		return this;
	}
	
	public GameBoard remove(int row, int col) {
		this.set(row, col, EMPTY_SPACE);
		return this;
	}
	
	public GameBoard swap(int row1, int col1, int row2, int col2) {
		Token t = this.get(row1, col1);
		this.move(row2, col2, row1, col1);
		this.set(row2, col2, t);
		return this;
	}
	
	// TODO: change this class so I can stream the board tiles
	// public Steam<Token> stream() {}
	
}
