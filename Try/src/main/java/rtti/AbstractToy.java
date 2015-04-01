package rtti;

public class AbstractToy implements IToy {
	public String playToy(String player) throws Exception {
		System.out.println(player + " plays abstract toy");
		return "";
	}
}
