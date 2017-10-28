package chess_boards;

import java.util.List;
import java.util.UUID;

import common.TokenPosition;
import token.Token;
import token.TokenFactory;

public class BoardFactory {
	public static GameBoard ChessBoard(UUID white, UUID black){
		GameBoard board = new GameBoard(8);
		// black
		board.set(0, 0, TokenFactory.Rook(black));
		board.set(0, 1, TokenFactory.Knight(black));
		board.set(0, 2, TokenFactory.Bishop(black));
		board.set(0, 3, TokenFactory.King(black));
		board.set(0, 4, TokenFactory.Queen(black));
		board.set(0, 5, TokenFactory.Bishop(black));
		board.set(0, 6, TokenFactory.Knight(black));
		board.set(0, 7, TokenFactory.Rook(black));
		
		board.set(1, 0, TokenFactory.Pawn(black));
		board.set(1, 1, TokenFactory.Pawn(black));
		board.set(1, 2, TokenFactory.Pawn(black));
		board.set(1, 3, TokenFactory.Pawn(black));
		board.set(1, 4, TokenFactory.Pawn(black));
		board.set(1, 5, TokenFactory.Pawn(black));
		board.set(1, 6, TokenFactory.Pawn(black));
		board.set(1, 7, TokenFactory.Pawn(black));
		
		// white
		board.set(7, 0, TokenFactory.Rook(white));
		board.set(7, 1, TokenFactory.Knight(white));
		board.set(7, 2, TokenFactory.Bishop(white));
		board.set(7, 3, TokenFactory.King(white));
		board.set(7, 4, TokenFactory.Queen(white));
		board.set(7, 5, TokenFactory.Bishop(white));
		board.set(7, 6, TokenFactory.Knight(white));
		board.set(7, 7, TokenFactory.Rook(white));
		
		board.set(6, 0, TokenFactory.Pawn(white));
		board.set(6, 1, TokenFactory.Pawn(white));
		board.set(6, 2, TokenFactory.Pawn(white));
		board.set(6, 3, TokenFactory.Pawn(white));
		board.set(6, 4, TokenFactory.Pawn(white));
		board.set(6, 5, TokenFactory.Pawn(white));
		board.set(6, 6, TokenFactory.Pawn(white));
		board.set(6, 7, TokenFactory.Pawn(white));
		
		return board;
	}
	
	
	public static GameBoard ChessBoard_Pawn_Promotion(UUID white, UUID black) {
		GameBoard board = BoardFactory.ChessBoard(white, black);
		// move white pawn to back row
		board.move(6, 3, 0, 6);
		// move black pawn to front row
		board.move(1, 3, 7, 6);
		return board;
	}
	
	public static GameBoard EmptyBoard() {
		return EmptyBoard(8);
	}
	
	public static GameBoard EmptyBoard(int size) {
		return new GameBoard(size);
	}
	
	public static GameBoard SingleTokenBoard() {
		GameBoard board = EmptyBoard();
		board.set(4, 4, TokenFactory.Pawn(UUID.randomUUID()));
		return board;
	}
	
	public static GameBoard TwoTokenBoard() {
		int boardSize = 8;
		GameBoard board = new GameBoard(boardSize);
		board.set(5, 4, TokenFactory.Pawn(UUID.randomUUID()));
		board.set(3, 4, TokenFactory.Pawn(UUID.randomUUID()));
		return board;
	}
}
