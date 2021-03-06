package moves;

import java.util.LinkedList;
import java.util.List;

import chess_boards.GameBoard;

public class SouthWestMoveAbility implements IMoveAbility {

	int limit;
	
	public SouthWestMoveAbility(int limit) {
		super();
		this.limit = limit;
	}

	@Override
	public List<GameBoard> getMoves(int row, int col, GameBoard board) {
		List<GameBoard> out = new LinkedList<>();

		for(int i = 0, newRow = row+1, newCol = col-1; 
				newRow < board.getSize()  && newCol >= 0 && i < this.limit; 
				++newRow, --newCol, ++i) {
			GameBoard b = board.clone();
			b.move(row, col, newRow, newCol);
			out.add(b);
		}
		
		return out;
	}

}
