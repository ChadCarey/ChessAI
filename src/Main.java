import java.util.UUID;

import chess_boards.BoardFactory;
import moves.MoveGenerator;

/**
 * 
 */

/**
 * @author Chad
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		System.out.println(BoardFactory.ChessBoard(UUID.randomUUID(), UUID.randomUUID()));
		System.out.println(BoardFactory.ChessBoard_Pawn_Promotion(UUID.randomUUID(), UUID.randomUUID()));
	}

}
