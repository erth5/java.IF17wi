package prak27;

public class  ObjectStack
{
    SimpleList stacklist;

    public ObjectStack()
    {
        stacklist = new SimpleList();
    }

    public void push( Object e )
    {
        stacklist.insertFirst(e);
    }

    public Object pop()
    {
        return stacklist.deleteFirst();
    }

    public boolean isEmpty()
    {
        return stacklist.isEmpty();
    }

    public String toString()
    {
        //das war bestimmt anders gedacht ; aber es ist eine toString() Methode ¯\_(ツ)_/¯
        return stacklist.toString();
    }

}
