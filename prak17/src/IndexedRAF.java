import java.io.RandomAccessFile;

public class IndexedRAF
{
    public static void schreibeIn(String dateiname, String[] strarr)
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(dateiname, "rw");
            RandomAccessFile iraf = new RandomAccessFile(dateiname+".idx", "rw");

            for(String str : strarr)
            {
                iraf.writeLong( raf.getFilePointer() );
                raf.writeUTF( str );
            }

            iraf.close();
            raf.close();
        }
        catch(Exception e)
        {
            System.out.println( e.getMessage() );
        }
    }

    public static String liesAus(String dateiname, int n)
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(dateiname, "r");
            RandomAccessFile iraf = new RandomAccessFile(dateiname+".idx", "r");

            iraf.seek( n*8 );

            long startpos = iraf.readLong();

            raf.seek( startpos );

            String str = raf.readUTF();

            raf.close();
            iraf.close();

            return str;
        }
        catch(Exception e)
        {
            System.out.println( e.getMessage() );
            return null; //muss irgendwas returnen falls es fehler gibt
        }
    }

    public static void main(String[] args)
    {
        String[] namen = { "Angela Merkel", "Horst Seehofer", "Alexander Gauland", "Recep Tayyip Erdogan" };

        schreibeIn("dasboese.txt", namen);

        String daswirdmanjawohlnochsagenduerfen = liesAus("dasboese.txt", 2);

        System.out.println(daswirdmanjawohlnochsagenduerfen);

    }

}
