public class Zufallstester
{
	public static void main(String[] args)
	{
		ZufallszahlenGenerator z = new ZufallszahlenGenerator(1337);

		for(int i = 0; i < 20; i++)
		{
			System.out.println( z.zufallsInt(100) );
		}

	}
}