package moves;

import java.util.List;
import java.util.UUID;

import chess_boards.GameBoard;
import common.TokenPosition;

public interface IMoveAbility {
	public List<GameBoard> getMoves(int row, int col, GameBoard board);
}
