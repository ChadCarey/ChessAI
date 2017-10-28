package token;

import java.util.UUID;

public class TokenFactory {
	public static Token Pawn(UUID player) {
		return new Token(player, "Pawn");
	}
	public static Token Rook(UUID player) {
		return new Token(player, "Rook");
	}
	public static Token Bishop(UUID player) {
		return new Token(player, "Bishop");
	}
	public static Token Knight(UUID player) {
		return new Token(player, "Knight");
	}
	public static Token Queen(UUID player) {
		return new Token(player, "Queen");
	}
	public static Token King(UUID player) {
		return new Token(player, "King");
	}
}
