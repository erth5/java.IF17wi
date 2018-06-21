import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class SpeicherLinie implements Serializable
{
	private Point anfang;
	private Point ende;
	private Color farbe;
	
	SpeicherLinie( Point a, Point e, Color f )
	{
		anfang = a;
		ende = e;
		farbe = f;
	}
	
	Point getAnfang() 
	{
		return anfang;
	}
	
	Point getEnde()
	{
		return ende;
	}
	
	Color getFarbe()
	{
		return farbe;
	}
	
}
