package moves;

import java.util.LinkedList;
import java.util.List;

import chess_boards.GameBoard;
import common.TokenPosition;

public class SouthMoveAbility implements IMoveAbility {

	private Integer limit;
	
	public SouthMoveAbility(Integer limit) {
		this.limit = limit;
	}

	@Override
	public List<GameBoard> getMoves(int row, int col, GameBoard board) {
		List<GameBoard> out = new LinkedList<>();

		for(int i = 0, newRow = row+1; 
				newRow < board.getSize() && i < this.limit; 
				++newRow, ++i) {
			GameBoard b = board.clone();
			b.move(row, col, newRow, col);
			out.add(b);
		}
		
		return out;
	}

}
