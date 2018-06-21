package ggt;

public class GGTTester
{
    public static void main(String[] args) throws Exception
    {
        if( args.length != 2 )
        {
            throw new Exception("Enter 2 Arguments!");
        }

        System.out.println("GGT = " + GGTBerechner.berechneGGT(Long.valueOf(args[0]), Long.valueOf(args[1])) );

    }
}
