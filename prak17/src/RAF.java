import java.io.RandomAccessFile;

public class RAF
{
    public static void main(String[] args)
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
            for(int i = 1; i <= 100; i++)
            {
                raf.writeInt( i*i );
            }

            raf.seek(0);

            for(int i = 0; i < 100; i++)
            {
                System.out.println( raf.readInt() );
            }

            raf.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
