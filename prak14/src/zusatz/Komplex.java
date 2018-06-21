package zusatz;

public class Komplex
{
    double radius;
    double winkel;

    public Komplex ( double r, double w ) throws IllegalArgumentException
    {
        if(r < 0){
            throw new IllegalArgumentException("radius must be > 0");
        }

        radius = r;
        winkel = w;
    }


    public static Komplex erzeugeKomplex(double real, double imag)
    {
        double r = Math.sqrt( real*real + imag*imag );
        double w = Math.toDegrees(Math.atan( imag / real ));

        return new Komplex(r, w);
    }

    public double realteil()
    {
        return Math.cos( Math.toRadians(winkel) ) * radius;
    }

    public double imagteil()
    {
        return Math.sin( Math.toRadians(winkel) ) * radius;
    }

    public String toString()
    {
        return realteil() + " + i * " + imagteil();
    }

    public Komplex plus(Komplex z)
    {
        //(x,y)+(x',y')=(x+x', y+y')
        return erzeugeKomplex(
                this.realteil()+z.realteil(),
                this.imagteil()+z.imagteil()
        );
    }

    public Komplex minus(Komplex z)
    {
        //(x,y)+(x',y')=(x-x', y-y')
        return erzeugeKomplex(
                this.realteil()-z.realteil(),
                this.imagteil()-z.imagteil()
        );
    }

    public Komplex mal(Komplex z)
    {
        //(x,y)*(x',y')=(xx'-yy', xy'+yx')
        return erzeugeKomplex(
                this.realteil()*z.realteil() - this.imagteil()*z.imagteil(),
                this.realteil()*z.imagteil() + this.imagteil()*z.realteil()
        );
    }

    public Komplex durch(Komplex z)
    {
        double a = this.realteil();
        double b = this.imagteil();
        double c = z.realteil();
        double d = z.imagteil();

        if( (c*c + d*d) == 0 )
        {
            throw new IllegalArgumentException("Cannot divide by 0");
        }

        //(a,b)/(c,d) = ( (ac+bc)/(c²+d²), (bc-ad)/(c²+d²) )
        return erzeugeKomplex(
                (a*c + b*c)/(c*c+d*d),
                (b*c - a*d)/(c*c+d*d)
        );
    }

    public static void main(String[] args)
    {
        /* functions test
        Komplex myK = new Komplex( 1, 45 );
        System.out.println( "myK: " + myK.toString() );

        Komplex myK2 = erzeugeKomplex(1,1);
        System.out.println( "myK2: " + myK2.toString() );

        System.out.println( "myK2+myK2: " + myK2.plus(myK2).toString() );
        System.out.println( "myK2-myK2: " + myK2.minus(myK2).toString() );
        System.out.println( "myK2*myK: " + myK2.mal(myK).toString() );
        System.out.println( "myK2/myK: " + myK2.durch(myK).toString() );
        */



        Komplex[] karr = new Komplex[10];

        for( int i = 0; i < 10; i++ )
        {
            karr[i] = erzeugeKomplex( Math.random(), Math.random() );
        }

        Komplex k = karr[0];

        for( int i = 1; i < 10; i++ )
        {
            k = k.plus( karr[i] );
        }

        System.out.println( k.toString() );
    }

}
