
public class TicTacToe
{
	public static void main(String[] args)
	{
		User u1 = new User();
		u1.setId(0);
		u1.setName("Harry");
		u1.setSymbol("H");
		
		User u2 = new User();
		u2.setId(1);
		u2.setName("Sherry");
		u2.setSymbol("S");
		
		User[] user = new User[] {u1,u2};
		
		Game g = new Game(3,user);
		
		try
		{
			g.start_game();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
