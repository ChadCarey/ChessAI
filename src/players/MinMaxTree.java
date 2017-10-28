package players;

public class MinMaxTree {
	private IPlayer tiebreaker;
	
	public MinMaxTree(IPlayer tiebreaker) {
		this.tiebreaker = tiebreaker;
	}
}
