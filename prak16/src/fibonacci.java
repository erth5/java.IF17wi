public class fibonacci
{
	static long fib(int n)
	{
		if(n == 1 || n == 2 )
			return 1;
		return fib(n-1) + fib(n-2);
	}
	
	static long binkoeff(int n, int k)
	{
		if( k == 0 || k == n )
			return 1;
		return binkoeff(n-1, k-1) + binkoeff(n-1, k);
	}
	
	static long hof(long n)
	{
		if( n == 1 || n == 2 )
			return 1;
		return hof(n - hof(n-1)) + hof(n - hof(n-2));
	}
	
	static void ulam( int a )
	{
		while ( a != 1 )
		{
			System.out.print(a+", ");
			if( a % 2 == 1 )
				a = a*3+1;
			else
				a = a/2;
		}
		System.out.println(1);
	}
	
	static long ack( long m, long n )
	{
		if( m == 0 )
			return n + 1;
		if( n == 0 )
			return ack( m-1, 1 );
		return ack( m-1, ack(m, n-1) );
	}
	
	public static void main(String[] args)
	{
		System.out.println( "fib(5)="+fib(5) );
		System.out.println( "binkoeff(16, 4)="+binkoeff(16,4) );
		System.out.println( "hof(4)="+hof(4) );
		System.out.println( "ack(3,2)="+ack(3,2) );

		System.out.println( "Ulam(7)=" );
		ulam( 7 );
	}
}
