package moves;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import chess_boards.GameBoard;
import token.Token;

public class EnpasantMoveAbility implements IMoveAbility {

	private String partner;
	private UUID playerID;
	final private static int SWAP_DISTANCE = 2; 
	
	public EnpasantMoveAbility(String movePartnerType, UUID playerID) {
		assert(movePartnerType != null);
		assert(!movePartnerType.equals(""));
		assert(playerID != null);
		this.partner = movePartnerType;
		this.playerID = playerID;
	}
	
	@Override
	public List<GameBoard> getMoves(int row, int col, GameBoard board) {
		List<GameBoard> out = new LinkedList<>();
		int maxBoardSize = board.getSize();
		
		// check to the east
		int posCol = row+SWAP_DISTANCE;
		if( posCol < maxBoardSize && posCol >= 0) {
			Token posPartner = board.get(row, posCol);
			if( this.isPartner(posPartner) ) {
				GameBoard b = board.clone();
				b.swap(row, col, row, posCol);
				out.add(b);
			}
		}
		
		// check to the west
		posCol = row-SWAP_DISTANCE;
		if( posCol < maxBoardSize && posCol >= 0) {
			Token posPartner = board.get(row, posCol);
			if( this.isPartner(posPartner) ) {
				GameBoard b = board.clone();
				b.swap(row, col, row, posCol);
				out.add(b);
			}
		}
		
		return out;
	}
	
	private boolean isPartner(Token posPartner) {
		if(posPartner == null) {
			return false;
		} else {			
			return posPartner.getType().equals(this.partner) && posPartner.getPlayerID().equals(this.playerID);
		}
	}

}
