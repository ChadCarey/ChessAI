package moves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import chess_boards.GameBoard;
import common.TokenPosition;
import token.Token;

public class NorthMoveAbility implements IMoveAbility {

	private Integer limit;
	
	public NorthMoveAbility(Integer limit) {
		this.limit = limit;
	}

	@Override
	public List<GameBoard> getMoves(int row, int col, GameBoard board) {
		List<GameBoard> out = new LinkedList<>();

		for(int i = 0, newRow = row-1; 
				newRow >= 0 && i < this.limit; 
				--newRow, ++i) {
			GameBoard b = board.clone();
			b.move(row, col, newRow, col);
			out.add(b);
		}
		
		return out;
	}

}
