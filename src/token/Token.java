package token;

import java.util.UUID;

public class Token {

	private String tokenType;
	private UUID playerID;
	
	public Token(UUID playerID) {
		super();
		this.tokenType = "";
		this.playerID = playerID;
	}
	
	public Token(UUID playerID, String tokenType) {
		super();
		this.tokenType = tokenType;
		this.playerID = playerID;
	}
	
	public Token(Token copy) {
		super();
		this.tokenType = copy.getType();
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return this.tokenType;
	}

	public Boolean equals(Token other) {
		if(other != null) {
			return this.equals(other.getType());
		} else {
			return false;
		}
	}

	public Boolean equals(String type) {
		return this.getType().equals(type);
	}
	
	public Token clone() {
		return new Token(this);
	}
	
	@Override
	public String toString() {
		return this.getType();
	}
	
	public UUID getPlayerID() {
		return this.playerID;
	}
	
}
