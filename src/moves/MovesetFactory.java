package moves;

public class MovesetFactory {
	static public Moveset PawnMoves() {
		Moveset moves = new Moveset();
		return moves;
	}
	static public Moveset KingMoves() {
		Moveset moves = new Moveset();
		return moves;
	}
	static public Moveset QueenMoves() {
		Moveset moves = new Moveset();
		return moves;
	}
	static public Moveset RookMoves() {
		Moveset moves = new Moveset();
		return moves;
	}
	static public Moveset KnightMoves() {
		Moveset moves = new Moveset();
		return moves;
	}
	static public Moveset BishopMoves() {
		return DiagonalMoves(16);
	}
	static public Moveset DiagonalMoves(int maxDistance) {
		Moveset moves = new Moveset();
		moves.add(new NorthMoveAbility(maxDistance));
		moves.add(new SouthMoveAbility(maxDistance));
		moves.add(new EastMoveAbility(maxDistance));
		moves.add(new WestMoveAbility(maxDistance));
		return moves;
	}
	static public Moveset StraightMoves(int maxDistance) {
		Moveset moves = new Moveset();
		moves.add(new NorthMoveAbility(maxDistance));
		moves.add(new SouthMoveAbility(maxDistance));
		moves.add(new EastMoveAbility(maxDistance));
		moves.add(new WestMoveAbility(maxDistance));
		return moves;
	}
}
