public class Sequentiell
{
	//für UNGEORDNETE arrays!
	//2 varianten
	
	public static int suche1(int[] arr, int zahl)
	{
		int i = 0;
		try {
			while( arr[i] != zahl )
			{
				i++;
			}
		}
		catch( ArrayIndexOutOfBoundsException e )
		{
			return -1;
		}
		return i;
	}
	
	public static int suche2( int[] arr, int zahl )
	{
		
		for( int i = 0; i < arr.length; i++ )
			if( arr[i] == zahl )
				return i;
		return -1;
	}
	
	public static int sucheObjekt( Object[] arr, Object obj )
	{
		int i = 0;
		while( i < arr.length )
		{
			if( arr[i] == obj )
				return i;
			i++;
		}
		return -1;
	}
	
	public static <E> int sucheGenerisch( E[] arr, E e )
	{
		for( int i = 0; i < arr.length; i++ )
			if( arr[i] == e )
				return i;
		return -1;
	}
	
}
