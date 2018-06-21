import java.util.*;

public class Telefonbuch
{
	private Map<String, Set<String>> speicher;
	
	public Telefonbuch()
	{
		speicher = new HashMap<String, Set<String>>();
		
	}
	
	public boolean einfuegen( String name, String nummer )
	{
		if(!speicher.containsKey(name))
		{
			speicher.put(name, new HashSet<String>());
		}
		return speicher.get(name).add(nummer);
	}
	
	public String hatTelNr(String name)
	{
		if( speicher.containsKey(name) )
			return speicher.get(name).toString();
		return "Existiert nicht du Mongo";
	}
	
	public boolean loeschen(String name, String nummer)
	{
		boolean retval = speicher.get(name).remove(nummer);
		if( speicher.get(name).isEmpty() )
			speicher.remove(name);
		return retval;
	}
	
	public boolean loeschen(String name)
	{
		if( speicher.remove(name) == null)
			return false;
		return true;
	}
	
	
	public static void main(String[] args)
	{
		Telefonbuch tb = new Telefonbuch();
		tb.einfuegen("Ich", "+49 1337/80085");
		tb.einfuegen("Du", "+49 0000/12345");
		tb.einfuegen("Du", "+72 0815/67890");
		
		System.out.println( tb.hatTelNr("Ich") );
		System.out.println( tb.hatTelNr("Du") );
		
		tb.loeschen("Ich");
		tb.loeschen("Du", "+72 0815/67890");
		
		System.out.println( tb.hatTelNr("Ich") );
		System.out.println( tb.hatTelNr("Du") );

		tb.loeschen("Du", "+49 0000/12345");
		
		System.out.println( tb.hatTelNr("Du") );
		
	}

}
