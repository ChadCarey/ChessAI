package moves;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import chess_boards.BoardFactory;
import chess_boards.GameBoard;
import token.Token;
import token.TokenFactory;

public class TestMoves {

	@Test
	public void testMoveGenerator() {
		System.out.println("Testing MoveGenerator");
		
		// test the move selection abilities of the generator
		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		UUID player2 = UUID.randomUUID();
		Token t1 = TokenFactory.Pawn(player1);
		Token t2 = TokenFactory.Pawn(player2);
		
		int p1Row = 4;
		int p1Col = 3;
		int p2Row = 4;
		int p2Col = 5;
		board.set(p1Row, p1Col, t1);
		board.set(p2Row, p2Col, t2);
		
		System.out.println("Created board");
		System.out.println(board);
		
		MoveGenerator generator = new MoveGenerator();
		generator.register(t1, new NorthMoveAbility(2));
		generator.register(t2, new SouthMoveAbility(1));
		
		List<GameBoard> player1Moves = generator.generate(board, player1);
		List<GameBoard> player2Moves = generator.generate(board, player2);
		assertTrue("Player 1 should have 2 moves", player1Moves.size() == 2);
		assertTrue("Player 2 should have 1 moves", player2Moves.size() == 1);
		
		// checking board contents
		System.out.println("checking player1Moves");
		for(GameBoard b : player1Moves) {
			System.out.println(b);
			p1Row--;
			Token t = b.get(p1Row, p1Col);
			assertNotNull("Found token should not be null", t);
			assertTrue("Found token should be t1", t == t1);
		}
		
		System.out.println("checking player2Moves");
		for(GameBoard b : player2Moves) {
			System.out.println(b);
			p2Row++;
			Token t = b.get(p2Row, p2Col);
			assertNotNull("Found token should not be null", t);
			assertTrue("Found token should be t2", t == t2);
		}
		
	}
	
	@Test
	public void testNorthMoveAbility() {
		System.out.println("Testing NorthMoveAbility");
		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		
		Token t1 = TokenFactory.Pawn(player1);
		
		// start at the farthest row
		int row = board.getSize()-1;
		int col = 4;
		board.set(row, col, t1);
		
		MoveGenerator generator = new MoveGenerator();
		// give the token the ability to move MORE than the entire length of the board 
		generator.register(t1, new NorthMoveAbility(board.getSize()+10));
		List<GameBoard> moves = generator.generate(board, row, col);
		assertTrue("Should contain 7 moves", moves.size() == 7);
		for(GameBoard b : moves) {
			row--;
			Token t = b.get(row, col);
			assertNotNull("The token found at this location should not be null", t);
			assertTrue("This should be our token", t==t1);
		}
		
		// print the results
		System.out.println(board);
		moves.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testSouthMoveAbility() {
		System.out.println("Testing SouthMoveAbility");

		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		Token t1 = TokenFactory.Pawn(player1);
		
		// start at the farthest row
		int row = 0;
		int col = 4;
		board.set(row, col, t1);
		
		MoveGenerator generator = new MoveGenerator();
		// give the token the ability to move MORE than the entire length of the board 
		generator.register(t1, new SouthMoveAbility(board.getSize()+10));
		List<GameBoard> moves = generator.generate(board, row, col);
		assertTrue("Should contain 7 moves", moves.size() == 7);
		for(GameBoard b : moves) {
			row++;
			Token t = b.get(row, col);
			assertNotNull("The token found at this location should not be null", t);
			assertTrue("This should be our token", t==t1);
		}
		
		// print the results
		System.out.println(board);
		moves.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testEastMoveAbility() {
		System.out.println("Testing EastMoveAbility");

		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		Token t1 = TokenFactory.Pawn(player1);
		
		// start at the farthest row
		int row = 4;
		int col = 0;
		board.set(row, col, t1);

		System.out.println("Created board");
		System.out.println(board);
		
		
		MoveGenerator generator = new MoveGenerator();
		// give the token the ability to move MORE than the entire length of the board 
		generator.register(t1, new EastMoveAbility(board.getSize()+10));
		List<GameBoard> moves = generator.generate(board, row, col);
		System.out.println(moves.size());
		assertTrue("Should contain 7 moves", moves.size() == 7);
		for(GameBoard b : moves) {
			col++;
			Token t = b.get(row, col);
			assertNotNull("The token found at this location should not be null", t);
			assertTrue("This should be our token", t==t1);
			assertTrue("This should be our token", t.equals(t1));
		}
		
		// print the results
		moves.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testWestMoveAbility() {
		System.out.println("Testing WestMoveAbility");

		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		Token t1 = TokenFactory.Pawn(player1);
		
		// start at the farthest row
		int row = 4;
		int col = board.getSize()-1;
		board.set(row, col, t1);

		System.out.println("Created board");
		System.out.println(board);
		
		
		MoveGenerator generator = new MoveGenerator();
		// give the token the ability to move MORE than the entire length of the board 
		generator.register(t1, new WestMoveAbility(board.getSize()+10));
		List<GameBoard> moves = generator.generate(board, row, col);
		System.out.println(moves.size());
		assertTrue("Should contain 7 moves", moves.size() == 7);
		for(GameBoard b : moves) {
			col--;
			Token t = b.get(row, col);
			assertNotNull("The token found at this location should not be null", t);
			assertTrue("This should be our token", t==t1);
			assertTrue("This should be our token", t.equals(t1));
		}
		
		// print the results
		moves.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testNorthEastMoveAbility() {
		System.out.println("Testing NorthEastMoveAbility");

		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		Token t1 = TokenFactory.Pawn(player1);
		
		// start at the farthest row
		int row = board.getSize()-1;
		int col = 0;
		board.set(row, col, t1);

		System.out.println("Created board");
		System.out.println(board);
		
		
		MoveGenerator generator = new MoveGenerator();
		// give the token the ability to move MORE than the entire length of the board
		int diagonalLength = (int) Math.sqrt( board.getSize()*board.getSize() + board.getSize()+board.getSize() );
		System.out.println("Expected diagonal length == "+diagonalLength);
		generator.register(t1, new NorthEastMoveAbility(diagonalLength+10));
		List<GameBoard> moves = generator.generate(board, row, col);
		
		// print the results
		moves.forEach(b -> System.out.println(b));
		
		System.out.println("Number of moves generated: "+moves.size());
		assertTrue("Should contain "+(diagonalLength-1)+" moves", moves.size() == diagonalLength-1);
		for(GameBoard b : moves) {
			col++;
			row--;
			Token t = b.get(row, col);
			assertNotNull("The token found at this location should not be null", t);
			assertTrue("This should be our token", t==t1);
			assertTrue("This should be our token", t.equals(t1));
		}
		
	}
	
	@Test
	public void testSouthEastMoveAbility() {
		System.out.println("Testing SouthEastMoveAbility");

		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		Token t1 = TokenFactory.Pawn(player1);
		
		// start at the farthest row
		int row = 0;
		int col = 0;
		board.set(row, col, t1);

		System.out.println("Created board");
		System.out.println(board);
		
		
		MoveGenerator generator = new MoveGenerator();
		// give the token the ability to move MORE than the entire length of the board
		int diagonalLength = (int) Math.sqrt( board.getSize()*board.getSize() + board.getSize()+board.getSize() );
		System.out.println("Expected diagonal length == "+diagonalLength);
		
		generator.register(t1, new SouthEastMoveAbility(diagonalLength+10));
		List<GameBoard> moves = generator.generate(board, row, col);
		
		// print the results
		moves.forEach(b -> System.out.println(b));
		
		System.out.println("Number of moves generated: "+moves.size());
		assertTrue("Should contain "+(diagonalLength-1)+" moves", moves.size() == diagonalLength-1);
		for(GameBoard b : moves) {
			col++;
			row++;
			Token t = b.get(row, col);
			assertNotNull("The token found at this location should not be null", t);
			assertTrue("This should be our token", t==t1);
			assertTrue("This should be our token", t.equals(t1));
		}
		
	}
	
	@Test
	public void testNorthWestMoveAbility() {
		System.out.println("Testing NorthWestMoveAbility");

		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		Token t1 = TokenFactory.Pawn(player1);
		
		// start at the farthest row
		int row = board.getSize()-1;
		int col = board.getSize()-1;
		board.set(row, col, t1);

		System.out.println("Created board");
		System.out.println(board);
		
		
		MoveGenerator generator = new MoveGenerator();
		// give the token the ability to move MORE than the entire length of the board
		int diagonalLength = (int) Math.sqrt( board.getSize()*board.getSize() + board.getSize()+board.getSize() );
		System.out.println("Expected diagonal length == "+diagonalLength);
		generator.register(t1, new NorthWestMoveAbility(diagonalLength+10));
		List<GameBoard> moves = generator.generate(board, row, col);
		
		// print the results
		moves.forEach(b -> System.out.println(b));
		
		System.out.println("Number of moves generated: "+moves.size());
		assertTrue("Should contain "+(diagonalLength-1)+" moves", moves.size() == diagonalLength-1);
		for(GameBoard b : moves) {
			col--;
			row--;
			Token t = b.get(row, col);
			assertNotNull("The token found at this location should not be null", t);
			assertTrue("This should be our token", t==t1);
			assertTrue("This should be our token", t.equals(t1));
		}
	}
	
	@Test
	public void testSouthWestMoveAbility() {
		System.out.println("Testing SouthWestMoveAbility");

		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		Token t1 = TokenFactory.Pawn(player1);
		
		// start at the farthest row
		int row = 0;
		int col = board.getSize()-1;
		board.set(row, col, t1);

		System.out.println("Created board");
		System.out.println(board);
		
		
		MoveGenerator generator = new MoveGenerator();
		// give the token the ability to move MORE than the entire length of the board
		int diagonalLength = (int) Math.sqrt( board.getSize()*board.getSize() + board.getSize()+board.getSize() );
		System.out.println("Expected diagonal length == "+diagonalLength);
		
		generator.register(t1, new SouthWestMoveAbility(diagonalLength+10));
		List<GameBoard> moves = generator.generate(board, row, col);
		
		// print the results
		moves.forEach(b -> System.out.println(b));
		
		System.out.println("Number of moves generated: "+moves.size());
		assertTrue("Should contain "+(diagonalLength-1)+" moves", moves.size() == diagonalLength-1);
		for(GameBoard b : moves) {
			col--;
			row++;
			Token t = b.get(row, col);
			assertNotNull("The token found at this location should not be null", t);
			assertTrue("This should be our token", t==t1);
			assertTrue("This should be our token", t.equals(t1));
		}
		
	}
	
	@Test
	public void testEnpasantMoveAbility() {
		fail();
	}
	
	@Test
	public void testDiagonalCaptureMoveAbility() {
		fail();
	}
	
	@Test
	public void testCastlingMoveAbility() {
		fail();
	}
	
	@Test
	public void testLShapedMoveAbility() {
		System.out.println("Testing LShapedMoveAbility");

		GameBoard board = BoardFactory.EmptyBoard();
		UUID player1 = UUID.randomUUID();
		Token t1 = TokenFactory.Pawn(player1);
		
		// start at the farthest row
		int row = 5;
		int col = 5;
		board.set(row, col, t1);

		System.out.println("Created board");
		System.out.println(board);
		
		MoveGenerator generator = new MoveGenerator();
		generator.register(t1, new LShapedMoveAbility());
		
		List<GameBoard> moves = generator.generate(board, row, col);
		
		// check the results
		assertTrue("There should be a total of 8 moves", moves.size() == 8);
		
		// print the results
		moves.forEach(b -> System.out.println(b));
		
		fail("Not fully tested");
	}

	@Test
	public void testTemporaryMoveAbility() {
		fail();
	}
}
