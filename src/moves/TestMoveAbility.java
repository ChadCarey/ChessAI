package moves;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import chess_boards.GameBoard;
import common.TokenPosition;
import token.Token;

public class TestMoveAbility implements IMoveAbility {

	UUID playerID;
	
	public TestMoveAbility(UUID playerID) {
		super();
		this.playerID = playerID;
	}

	@Override
	public List<GameBoard> getMoves(int row, int col, GameBoard board) {
		Token foundToken = board.get(row, col);
		
		return new ArrayList<GameBoard>();
	}

}
