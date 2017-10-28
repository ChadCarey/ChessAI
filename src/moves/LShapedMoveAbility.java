package moves;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import chess_boards.GameBoard;
import token.Token;

public class LShapedMoveAbility implements IMoveAbility {

	@Override
	public List<GameBoard> getMoves(int row, int col, GameBoard board) {
		List<GameBoard> out = new LinkedList<>();
		
		int max = board.getSize();
		BiFunction<Integer,Integer, Boolean> isValid = (r, c) -> r < max && c < max && r >= 0 && c >= 0; 
		int nRow;
		int nCol;
		
		nRow = row-1;
		nCol = col-2;
		if(isValid.apply(nRow,nCol)) {
			out.add(board.clone().move(row, col, nRow, nCol));
		}
		nRow = row-2;
		nCol = col-1;
		if(isValid.apply(nRow,nCol)) {
			out.add(board.clone().move(row, col, nRow, nCol));
		}
		nRow = row-2;
		nCol = col+1;
		if(isValid.apply(nRow,nCol)) {
			out.add(board.clone().move(row, col, nRow, nCol));
		}
		nRow = row-1;
		nCol = col+2;
		if(isValid.apply(nRow,nCol)) {
			out.add(board.clone().move(row, col, nRow, nCol));
		}
		nRow = row+1;
		nCol = col+2;
		if(isValid.apply(nRow,nCol)) {
			out.add(board.clone().move(row, col, nRow, nCol));
		}
		nRow = row+2;
		nCol = col+1;
		if(isValid.apply(nRow,nCol)) {
			out.add(board.clone().move(row, col, nRow, nCol));
		}
		nRow = row+2;
		nCol = col-1;
		if(isValid.apply(nRow,nCol)) {
			out.add(board.clone().move(row, col, nRow, nCol));
		}
		nRow = row+1;
		nCol = col-2;
		if(isValid.apply(nRow,nCol)) {
			out.add(board.clone().move(row, col, nRow, nCol));
		}
		
		
		return out;
	}
	
}
