
public class DNode<T> extends Node<T>
{
    private DNode<T> next;
    private DNode<T> back;

    public DNode(T item)
    {
        super(item);
        next = this;
        back = this;
    }

    public DNode(T item, DNode<T> next, DNode<T> back)
    {
        super(item);
        this.next = next;
        this.back = back;
    }

    public void setNext(DNode<T> nextNode)
    {
        next = nextNode;
    } // end setNext

    public void setBack(DNode<T> backNode)
    {
        back = backNode;
    } // end setNext

    public DNode<T> getNext()
    {
        return next;
    } // end getNext

    public DNode<T> getBack()
    {
        return back;
    }
} // end class DNode
