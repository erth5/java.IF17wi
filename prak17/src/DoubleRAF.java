import java.io.RandomAccessFile;

public class DoubleRAF
{
    static void speichere( String datei, double[] zahlen )
    {
        try {
            RandomAccessFile raf = new RandomAccessFile(datei, "rw");

            raf.writeInt( zahlen.length );

            for (double d : zahlen)
                raf.writeDouble(d);

            raf.close();
        }
        catch(Exception e)
        {
            System.out.println( e.getMessage() );
        }
    }

    static double[] lade( String datei )
    {
        try {
            RandomAccessFile raf = new RandomAccessFile(datei, "r");

            int length = raf.readInt();

            double[] d = new double[length];

            for(int i = 0; i < length; i++)
            {
                d[i] = raf.readDouble();
            }

            raf.close();

            return d;
        }
        catch(Exception e)
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    static double lese( String datei, int n )
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(datei, "r");

            //4 = length int ; n*8 = n doubles
            int pos = 4 + n*8;

            raf.seek(pos);

            double d = raf.readDouble();

            return d;
        }
        catch(Exception e)
        {
            System.out.println( e.getMessage() );
            return Double.NaN;
        }
    }


    public static void main( String[] args )
    {
        double[] zahlen = { 1337, 3.1415926, 12e+7, 1.98e-99 };

        speichere("zahlen.txt", zahlen);

        double[] gelesen = lade("zahlen.txt");

        for( double d : gelesen )
            System.out.print( d + ", " );

        double ente = lese("zahlen.txt", 2);

        System.out.println( "n => "+ente );
    }

}
