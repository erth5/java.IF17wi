public class fakultaet
{

	static long berechneFakultaet( int n )
	{
		if( n < 0 )
			return -1;
		if( n == 1 || n == 0 )
			return 1;
		return berechneFakultaet(n-1) * n;
	}
	
	public static void main(String[] args)
	{
		long result = berechneFakultaet(Integer.valueOf(args[0]));
		if( result < 0 )
			System.out.println("Fehler, negative Eingabe!");
		else
			System.out.println( result );
	}

}
