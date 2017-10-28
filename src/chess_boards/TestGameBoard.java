package chess_boards;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import token.Token;

public class TestGameBoard {

	@Test
	public void testDefaultConstruction() {
		GameBoard board = new GameBoard(8);
		
		// the board should initialize to null values by default.
		for(int i = 0; i < board.getSize(); ++i) {
			for(int j = 0; j < board.getSize(); ++j) {
				Token foundToken = board.get(i,j);
				assertNull(foundToken);
			}
		}
	}
	
	@Test
	public void testCopyConstructor() {
		GameBoard board = generateDummyBoard();
		GameBoard board2 = new GameBoard(board);
		assertTrue("Expected board == board2", board.equals(board2));
	}
	
	@Test
	public void testClone() {
		GameBoard board = generateDummyBoard();
		assertTrue("Should be equal", board.clone().equals(board));
	}
	
	@Test
	public void testEquals() {
		UUID player = UUID.randomUUID();
		GameBoard board = generateDummyBoard();
		GameBoard board2 = new GameBoard(board);
		int row = 0;
		int col = 1;
		String name = "King";
		assertTrue("Expected board == board2", board.equals(board2));
		board2.set(row, col, new Token(player, name));
		assertFalse("Expected board != board2", board.equals(board2));
	}
	
	@Test
	public void testSet() {
		UUID player = UUID.randomUUID();
		GameBoard board = generateDummyBoard();
		GameBoard board2 = new GameBoard(board);
		assertTrue("Expected board == board2", board.equals(board2));
		int row = 0;
		int col = 1;
		String name = "King";
		assertTrue("Expected board == board2", board.equals(board2));
		board2.set(0, 1, new Token(player, name));
		assertFalse("Expected board != board2", board.equals(board2));
		assertTrue("token should be "+name, board2.get(row, col).equals(name));
	}
	
	@Test
	public void testRemove() {
		GameBoard board = generateDummyBoard();
		int row = 1;
		int col = 2;
		Token atLocation = board.get(row, col);
		board.remove(row, col);
		Token atLocation2 = board.get(row, col);
		assertNull("Should be null", atLocation2);
		assertNotNull("Should not be null", atLocation);
		assertFalse("atLocation != atLocation2", atLocation.equals(atLocation2));	
	}
	
	@Test
	public void testMove() {
		GameBoard board = generateDummyBoard();
		int fromRow = 1;
		int fromCol = 2;
		int toRow = 3;
		int toCol = 4;
		Token token = board.get(fromRow, fromCol);
		board.move(fromRow, fromCol, toRow, toCol);
		assertNull("Should be null", board.get(fromRow, fromCol));
		assertFalse("Should != token", token.equals(board.get(fromRow, fromCol)));
	}
	
	// helper methods
	private GameBoard generateDummyBoard() {
		UUID player = UUID.randomUUID();
		GameBoard board = new GameBoard(8);
		for(int i = 0; i < board.getSize(); ++i) {
			for(int j = 0; j < board.getSize(); ++j) {
				String tokenName = "Dummy_["+i+"]["+j+"]";
				board.set(i, j, new Token(player, tokenName));
			}
		}
		return board;
	}
	
}
