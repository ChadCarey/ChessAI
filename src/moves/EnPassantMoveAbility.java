package moves;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import chess_boards.GameBoard;
import token.Token;

public class EnPassantMoveAbility implements IMoveAbility {
	
	public enum Direction {
		NORTH, SOUTH;
	}
	
	private IMoveAbility eMove;
	private IMoveAbility wMove;
	
	public EnPassantMoveAbility(Direction direction) {
		if(direction == Direction.NORTH){
			eMove = new NorthEastMoveAbility(1);
			wMove = new NorthWestMoveAbility(1);
		} else {
			eMove = new SouthEastMoveAbility(1);
			wMove = new SouthWestMoveAbility(1);
		}
	}
	
	@Override
	public List<GameBoard> getMoves(int row, int col, GameBoard board) {
		List<GameBoard> out = new LinkedList<>();
		Token token = board.get(row, col);
		
		int eastCol = col+1;
		if(eastCol < board.getSize() && eastCol >= 0) {
			Token t = board.get(row, eastCol);
			if(t != null) {
				if(!isMine(token, t)) {
					// for each successful diagonal move, remove the neighboring token
					out.addAll(
							eMove.getMoves(row, col, board)
								.stream()
									.map(b -> b.set(row, eastCol, null))
									.collect(Collectors.toCollection(LinkedList::new))
							);
				}
			}
		}
		
		int westCol = col-1;
		if(westCol < board.getSize() && westCol >= 0) {
			Token t = board.get(row, westCol);
			if(t != null) {
				if(!isMine(token, t)) {
					// for each successful diagonal move, remove the neighboring token
					out.addAll(
							wMove.getMoves(row, col, board)
								.stream()
									.map(b -> b.set(row, westCol, null))
									.collect(Collectors.toCollection(LinkedList::new))
							);
				}
			}
		}
		
		return out;
	}

	private boolean isMine(Token me, Token other) {
		if(other == null) {
			return false;
		} else {
			return me.getPlayerID().equals(other.getPlayerID());
		}
	}
	
}
