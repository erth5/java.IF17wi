public class Punkt
{
	//Attribute definieren
	double x;	//private ist Standard, muss also nicht explizit angegeben werden!
	double y;

	//Konstruktoren definieren
	public Punkt()
	{
		x = 0;
		y = 0;
	}

	public Punkt(double newx, double newy)
	{
		x = newx;
		y = newy;
	}

	//Methoden (Funktionen) definieren
	public double getx() { return x; };	//java ist es egal, wie wir formatieren.
	public double gety() { return y; };	//man könnte das auch über viele Zeilen schreiben

	public void versetzen(double newx, double newy)
	{
		x = newx;
		y = newy;
	}

	public void verschieben(double dx, double dy)
	{
		x += dx;
		y += dy;
	}

	public String toString()
	{
		//gib "(x|y)" zurück
		return "( " + x + "|" + y + " )";
	}

	public boolean equals( Punkt p )	//boolean ist ein Wahrheitswert
	{
		// == bedeutet "gleich" im Mathematischen Sinne, also vergleichen
		// && bedeutet "UND" ; wie in der Aussagenlogik
		//es gibt keine klare Rangordnung zwischen den Symbolen, anders als bei +-*/ !!
		//deshalb sind Klammern sehr wichtig! Lieber eine zu viel als zu wenig!

		//Hier die elegante schreibweise
		return ( (x == p.getx()) && (y == p.gety()) );

		/*Hier die ausführliche schreibweise
		if( (x == p.getx()) && (y == p.gety()) )	//falls X gleich und Y gleich,
		{
			return true;							//dann gib Wahr zurück
		}
		else										//Ansonsten
		{
			return false;							//gib Falsch zurück
		}*/
	}

}