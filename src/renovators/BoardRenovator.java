package renovators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import chess_boards.GameBoard;

public class BoardRenovator implements IRenovation {
	
	private List<IRenovation> renovations;
	
	public BoardRenovator() {
		this.renovations = new ArrayList<IRenovation>();
	}
	@Override
	public GameBoard renovate(GameBoard board) {
		GameBoard out = board.clone();
		for(IRenovation r : renovations) {
			out = r.renovate(out);
		}
		return out;
	}
	public void add(IRenovation renovation) {
		this.renovations.add(renovation);
	}
	
}
