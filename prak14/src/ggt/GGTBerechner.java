package ggt;

public class GGTBerechner
{
    public static long berechneGGT(long a, long b) throws IllegalArgumentException
    {
        if(a < 0 || b < 0)
        {
            throw new IllegalArgumentException("Enter 2 !POSITIVE NUMBERS!");
        }

        if( a < b )
        {
            long temp = a;
            a = b;
            b = temp;
        }

        long r = a % b;

        while( r > 0 )
        {
            a = b;
            b = r;
            r = a % b;
        }

        return b;
    }

}
