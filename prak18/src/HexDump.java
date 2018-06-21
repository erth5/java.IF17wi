import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.InputStream;

public class HexDump
{
	public static String dump(String filename) throws Exception
	{
		int BREITE = 16;
		String dump = "";
		String hexline = "";
		String txtline = "";
		Path file = Paths.get(filename);
		InputStream IS = Files.newInputStream(file);
		int b = IS.read();
		
		int i = 1;
		while( b != -1 )
		{
			if( b <= 15 )
			{
				hexline = hexline + "0";
			}
			hexline = hexline + Integer.toHexString(b);
			
			if( b >= 32 && b <= 127 ) //printable chars
			{
				txtline = txtline + (char)(b);
			}
			else
			{
				txtline = txtline + ".";
			}
			
			if( i == BREITE )
			{
				dump = dump + hexline + "\t" + txtline + "\n";
				i = 0;
				hexline = "";
				txtline = "";
			}
			
			b = IS.read();
			i = i+1;
		}
		
		IS.close();
		if(i < BREITE)
		{
			for( int k = i; k <= BREITE; k++ )
			{
				hexline = hexline + "00";
				txtline = txtline + ".";
			}
			dump = dump + hexline + "\t" + txtline + "\n";
		}
		
		return dump;
	}
	
	public static void main( String [] args ) throws Exception
	{
		if( args.length > 0 )
			System.out.println(dump( args[0] ) );
	}
	
}
