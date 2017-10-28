package token;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

public class TestToken {
	
	@Test
	public void testDefaultToken() {
		UUID player = UUID.randomUUID();
		Token token = new Token(player);
		assertTrue("Invalid type: "+token.getType()+". Expected \"\"", token.getType().equals(""));
	}
	@Test
	public void testTokenConstruction() {
		UUID player = UUID.randomUUID();
		String type = "King";
		Token token = new Token(player, type);
		assertTrue("Invalid type: "+token.getType()+". Expected \"\"", token.getType().equals(type));
	}
	@Test
	public void testEquals() {
		UUID player = UUID.randomUUID();
		String type = "Queen";
		Token token = new Token(player, type);
		Token token2 = new Token(player, type);
		
		assertTrue("Expected token == token", token.equals(token));
		assertTrue("Expected token == token2", token.equals(token2));
		assertTrue("Expected token2 == token", token2.equals(token));
		token2 = null;
		assertFalse("Expected token == null to be false", token.equals(token2));
	}
	
	@Test
	public void testClone() {
		UUID player = UUID.randomUUID();
		String type = "Queen";
		Token token = new Token(player, type);
		Token token2 = token.clone();
		
		assertTrue("Expected token.equals(token) == true", token.equals(token));
		assertTrue("Expected token.equals(token) == true2", token.equals(token2));
		assertTrue("Expected token2.equals(token) == true", token2.equals(token));
		assertFalse("Expected token2 != token", token == token2);
		assertTrue("Expected token == token", token == token);
	}

}
