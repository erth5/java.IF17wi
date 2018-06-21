public class Binary
{
	//für GEORDNETE arrays!!!
	public static int searchRecursive( int[] arr, int zahl, int von, int bis )
	{
		int idx = -1;
		
		if( von <= bis )
		{
			int mitte = (von+bis)/2;
			if( zahl > arr[mitte] )
			{
				idx = searchRecursive( arr, zahl, mitte+1, bis );
			}
			else if( zahl < arr[mitte] )
			{
				idx = searchRecursive(arr, zahl, von, mitte-1);
			}
			else
			{
				return mitte;
			}
		}
		
		return idx;
	}
	
	public static int searchIterative( int[] arr, int zahl, int von, int bis )
	{
		int idx = -1;
		
		while( von <= bis )
		{
			int mitte = (von+bis)/2;
			if( zahl > arr[mitte] )
			{
				von = mitte+1;
			}
			else if( zahl < arr[mitte] )
			{
				bis = mitte-1;
			}
			else
			{
				return mitte;
			}
		}
		
		return idx;
	}
}
