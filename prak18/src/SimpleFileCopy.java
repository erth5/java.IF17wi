import java.io.IOException;
import java.net.URL;
import java.nio.file.*;

import java.io.InputStream;

public class SimpleFileCopy
{
	public static void copyFile(String source, String target) throws IOException
	{
		Path src = Paths.get(source);
		Path tgt = Paths.get(target);
		Files.copy(src, tgt, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static void moveFile(String source, String target) throws IOException
	{
		Path src = Paths.get(source);
		Path tgt = Paths.get(target);
		Files.move(src, tgt, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static void copyURL(String source, String target) throws Exception
	{
		URL src = new URL(source);
		Path tgt = Paths.get( target );
		InputStream srcIS = src.openStream();
		Files.copy(src.openStream(), tgt, StandardCopyOption.REPLACE_EXISTING);
		srcIS.close();
	}
	
	public static void main(String[] args)
	{
		try
		{
			Path kopien = Paths.get("/vol/vol_home_student/mx7-3/dwaurens/lx/Kopien");
			if( !Files.exists(kopien) )
				Files.createDirectory(kopien);
			copyFile("/vol/vol_home_student/mx7-3/dwaurens/lx/test.cpp", "/vol/vol_home_student/mx7-3/dwaurens/lx/test.h");
			moveFile("/vol/vol_home_student/mx7-3/dwaurens/lx/test.h", "/vol/vol_home_student/mx7-3/dwaurens/lx/Kopien/test.h");
			copyURL("https://www.google.de/robots.txt", "/vol/vol_home_student/mx7-3/dwaurens/lx/Kopien/MrRobot.txt");
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//throw{}catch(){}
		try 
		{
			throw new Exception("stirb");
		}
		catch( Exception e )
		{
			System.out.println("lol");
		}
		
	}
}
