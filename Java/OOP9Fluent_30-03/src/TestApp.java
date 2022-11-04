import it.polito.oop.games.Game;

public class TestApp {

	public static void main(String[] args) {
		Game pandemic = Game.named("Pandemic").ofType(Game.Type.COOPERATIVE).withMaxPlayers(4);
		Game p2 = Game.named("Pandemic").withMaxPlayers(4).ofType(Game.Type.COOPERATIVE);

		System.out.println("Pandemic: " + pandemic);
		System.out.println("Pandemic: " + p2);
		pandemic = null;
		System.gc();
		System.out.println("Pandemic: " + pandemic);
		System.out.println("Pandemic: " + p2);

		System.out.println("... that's all folks.");
	}
	
}