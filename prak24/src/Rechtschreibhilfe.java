import java.io.*;
import java.util.*;

public class Rechtschreibhilfe
{
	private String dictfile;
	private String textfile;
	private Set<String> dict;
	Map<Integer, List<String>> errorsave;
	
	public Rechtschreibhilfe(String dictfile, String textfile)
	{
		this.dictfile = dictfile;
		this.textfile = textfile;
		dict = new HashSet<String>();
		errorsave = new HashMap<Integer, List<String>>();
	}
	
	private void initDict()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dictfile)));
			
			String line = br.readLine();
			while( line != null )
			{
				dict.add( line );
				line = br.readLine();
			}			
		}
		catch(Exception e)
		{
			
		}
	}
	
	private void analyseText()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(textfile)));
			
			String line = br.readLine();
			int linenum = 1;
			while( line != null )
			{
				StringTokenizer tokenizer = new StringTokenizer(line, " \n\t.,;:!?()-");
				
				while( tokenizer.hasMoreTokens() )
				{
					String word = tokenizer.nextToken();
					if( !dict.contains( word ) )
					{
						if(!errorsave.containsKey(linenum))
						{
							errorsave.put(linenum, new LinkedList<String>());
						}
						errorsave.get(linenum).add(word);
					}
				}
				
				line = br.readLine();
				linenum++;
			}
			br.close();
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void genReport()
	{
		initDict();
		analyseText();
		for( int key : errorsave.keySet() )
		{
			System.out.println("Fehler auf Zeile "+key+": "+errorsave.get(key).toString());
		}
	}
	
	public static void main(String[] args)
	{
		Rechtschreibhilfe rsh = new Rechtschreibhilfe("woerter.txt", "text.txt");

		rsh.genReport();
	}
	
}
