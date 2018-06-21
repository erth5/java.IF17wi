public class Tester
{

	public static boolean istGeordnet( int[] arr )
	{		
		for( int i = 0; i < arr.length-1; i++ )
		{
			//sobald ein element größer ist als sein Nachfolger, 
			//ist das array nicht mehr aufsteigend geordnet
			if( arr[i] > arr[i+1] )
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		
		int[] sorted = new int[50000000];
		int[] unsorted = new int [50000000];
		
		for( int i = 0; i < 50000000; i++ )
		{
			sorted[i] = i;
			unsorted[i] = (int) (Math.random() * 100 + 1);
		}

		long start1 = System.nanoTime();
		System.out.println(start1);
		int idx1 = Sequentiell.suche1(unsorted, 16);
		long ende1 = System.nanoTime();
		System.out.println(ende1);
		long diff1 = ende1 - start1;
		System.out.println("Seq.1 needed "+diff1+"ns");
		
		long start2 = System.currentTimeMillis();
		int idx2 = Sequentiell.suche2(unsorted, 16);
		long ende2 = System.currentTimeMillis();
		long diff2 = ende2 - start2;
		System.out.println("Seq.2 needed "+diff2+"ms");
		
		System.out.println( "Sequentiell 1: " + idx1 );
		System.out.println( "Sequentiell 2: " + idx2 );
		
		long startRec = System.currentTimeMillis();
		int idxRec = Binary.searchRecursive(sorted, 27, 0, sorted.length);
		long endeRec = System.currentTimeMillis();
		long diffRec = endeRec - startRec;
		System.out.println("Recursive needed "+diffRec+"ms");
		
		long startItr = System.currentTimeMillis();
		int idxItr = Binary.searchIterative(sorted, 27, 0, sorted.length);
		long endeItr = System.currentTimeMillis();
		long diffItr = endeItr - startItr;
		System.out.println( "Iterative needed "+diffItr+"ms" );
		
		System.out.println( "Recursiv:" + idxRec );
		System.out.println( "Iterativ:" + idxItr );
		
		boolean a1 = istGeordnet( sorted );
		boolean a2 = istGeordnet( unsorted );
		
		System.out.println("Sorted ist geordnet? "+a1);
		System.out.println("Unsorted ist geordnet? "+a2);
	}

}
