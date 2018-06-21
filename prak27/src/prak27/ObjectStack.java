package prak27;

public class ObjectStack
{
    SimpleList stacklist;

    public Stapel()
    {
        first = null;
    }

    public void push( ListElement e )
    {
        e.next = first;
        first = e;
    }

    public ListElement pop()
    {
        ListElement retval = first;
        first = first.next;
        return retval;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public String toString()
    {

    }

}
