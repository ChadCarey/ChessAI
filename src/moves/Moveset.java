package moves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import chess_boards.GameBoard;

public class Moveset implements IMoveAbility {

	List<IMoveAbility> moves;
	
	public Moveset() {
		super();
		this.moves = new ArrayList<>();
	}
	
	@Override
	public List<GameBoard> getMoves(int row, int col, GameBoard board) {
		return moves.stream()
				.map(ability->ability.getMoves(row, col, board))
				.flatMap(s->s.stream())
				.collect(Collectors.toCollection(LinkedList::new));
	}

	void add(IMoveAbility a) {
		moves.add(a);
	}
	
	void remove(IMoveAbility a) {
		moves.remove(a);
	}
	
}
