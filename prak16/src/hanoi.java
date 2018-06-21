package prak16;

public class hanoi
{
	static double versetzeTurm( int n, String von, String nach, String hilf )
	{
		if ( n == 1 )
		{
			System.out.println("Versetze Turm von " + von + " nach " + nach);
			return 1;
		}
		else
		{
			System.out.println("Versetze Turm von " + von + " nach " + hilf);
			return 2*versetzeTurm(n-1, von, hilf, nach)+1;
		}
	}
	
	public static void main(String[] args)
	{
		double schritte = versetzeTurm(64, "1", "3", "2");
		System.out.println( schritte + " Schritte" );
	}
	
}
