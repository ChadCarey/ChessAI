package moves;

import java.util.LinkedList;
import java.util.List;
import chess_boards.GameBoard;

public class WestMoveAbility implements IMoveAbility {

	int limit;
	
	public WestMoveAbility(int limit) {
		super();
		this.limit = limit;
	}

	@Override
	public List<GameBoard> getMoves(int row, int col, GameBoard board) {
		List<GameBoard> out = new LinkedList<>();

		for(int i = 0, newCol = col-1; 
				newCol >= 0 && i < this.limit; 
				--newCol, ++i) {
			GameBoard b = board.clone();
			b.move(row, col, row, newCol);
			out.add(b);
		}
		
		return out;
	}

}
