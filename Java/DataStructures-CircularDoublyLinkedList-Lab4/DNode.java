public class DNode extends Node
{
    private DNode back;

    public DNode(Object item)
    {
        super(item);
        back = this;
    }

    public DNode(Object item, DNode next, DNode back)
    {
        super(item, next);
        this.back = back;
    }

    public DNode getNext()
    {
        return (DNode)next;
    } // end setNext

    public void setBack(DNode backNode)
    {
        back = backNode;
    } // end setNext

    public DNode getBack()
    {
        return back;
    }
} // end class DNode
