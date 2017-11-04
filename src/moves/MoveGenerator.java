package moves;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import chess_boards.GameBoard;
import token.Token;

public class MoveGenerator {
	private Map<Token, List<IMoveAbility> > moves;
	
	public MoveGenerator() {
		moves = new HashMap<Token, List<IMoveAbility> >();
	}
	
	public void register(Token token, List<IMoveAbility> abilities) {
		moves.put(token, abilities);
	}
	
	public void register(Token token, IMoveAbility ability) {
		if(moves.get(token) == null) {
			moves.put(token, new LinkedList<IMoveAbility>());
		}
		moves.get(token).add(ability);
	}
	
	/**
	 * Adds all moves available to the specified player
	 * @param board
	 * @param playerID
	 * @return
	 */
	public List<GameBoard> generate(GameBoard board, UUID playerID) {
		List<GameBoard> output = new LinkedList<GameBoard>();
		for(int row = 0; row < board.getSize(); ++row) {
			for(int col = 0; col < board.getSize(); ++col){
				Token token = board.get(row, col);
				if(token != null) {
					if(token.getPlayerID().equals(playerID)) {
						
						System.out.println("PlayerID: "+playerID);
						output.addAll(generate(board, row, col));
						
					}
				}
			}
		}
		return output;
	}
	
	/**
	 * Adds all moves available for the token found at position(row, col)
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	public List<GameBoard> generate(GameBoard board, int row, int col) {
		Token token = board.get(row, col);
		List<GameBoard> outMoves = new LinkedList<>();
		if(token != null) {
			List<IMoveAbility> tokenMoveAbilities = moves.get(token);
			if(tokenMoveAbilities != null) {
				
				outMoves = tokenMoveAbilities.stream()
						.map(ability -> ability.getMoves(row, col, board))
						.flatMap(x -> x.stream() )
						.collect(Collectors.toCollection(LinkedList::new));
				
			}
		}
		return outMoves;
	}
}
