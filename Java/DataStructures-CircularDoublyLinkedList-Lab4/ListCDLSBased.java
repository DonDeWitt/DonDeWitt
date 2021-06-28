public class ListCDLSBased implements ListInterface {

    protected DNode head;
    private int numItems;

    public ListCDLSBased()
    {
        head = null;
        numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        return numItems == 0;
    }

    public int size()
    {
        return numItems;
    }

    private DNode find(int index)
    {
        // --------------------------------------------------
        // Locates a specified DNode in a linked list.
        // Precondition: index is the number of the desired
        // DNode. Assumes that 0 <= index <= numItems
        // Postcondition: Returns a reference to the desired
        // DNode.
        // --------------------------------------------------
        DNode curr = head;

        if(index == 0)
        {
            return curr;
        }
        if(index < (numItems/2))
        {
            for (int skip = 0; skip < index; skip++)
            {
                curr = curr.getNext();
            } // end for
        }
        else
        {
            for (int skip = numItems; skip > index; skip--)
            {
                curr = curr.getBack();
            } // end for
        }
        return curr;
    } // end find

    public void setHead(DNode head)
    {
        this.head = head;
    }

    public void add(int index, Object item) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems+1)
        {
            if (index == 0)
            {
                // insert the new node containing item at
                // beginning of list
                if(isEmpty())
                {
                    head = new DNode(item);
                }
                /**
                else
                {
                    DNode newHead = new DNode(item);
                    head.setNext(newHead);
                    head.setBack(newHead);
                    newHead.setNext(head);
                    newHead.setBack(head);
                    head = newHead;
                }
                **/

                else
                {
                    DNode lastNode = head.getBack();
                    DNode newHead = new DNode(item, head, lastNode);
                    lastNode.setNext(newHead);
                    head.setBack(newHead);
                    head = newHead;
                }
            }
            else
            {

                // insert the new node containing item after
                // the node that prev references
                DNode curr = find(index);
                DNode newNode = new DNode(item, curr, curr.getBack());
                curr.getBack().setNext(newNode);
                curr.setBack(newNode);
                curr = newNode;
            } // end else if
            numItems += 1;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on add");
        } // end if
    }  // end add

    public Object get(int index) throws ListIndexOutOfBoundsException
    {
        {
            if (index >= 0 && index < numItems)
            {
                // get reference to node, then data in node
                Node curr = find(index);
                Object dataItem = curr.getItem();
                return dataItem;
            }
            else
            {
                throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on get");
            } // end if
        } // end get
    }

    public void remove(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            if (index == 0)
            {
                if(numItems == 1)
                {
                    head = null;
                }
                else
                {
                    head.getNext().setBack(head.getBack());
                    head.getBack().setNext(head.getNext());
                    head = head.getNext();
                }
            }
            else
            {
                DNode prev = find(index-1);
                // delete the node after the node that prev
                // references, save reference to node
                DNode curr = prev.getNext();
                prev.setNext(curr.getNext());
                curr.getNext().setBack(prev);
            } // end if
            numItems -= 1;
        } // end if
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
        } // end if
    }   // end remove

    public void removeAll()
    {
        head = null;
        numItems = 0;
    }

    public String toString() //uses StringBuilder to return the items in the list as a string
    {
        StringBuilder sb = new StringBuilder();
        if(!(isEmpty()))
        {
            Node curr = head;
            int index = 0;

            while(index < numItems)
            {
                sb.append(curr.getItem() + " ");//throws null pointer exception
                curr = curr.getNext();
                index ++;
            }
        }
        String s = sb.toString();
        return s;
    }
    /***
    public int modIndex(int index) // this code is for handling extended index ranges
    {
    	if(index > 0)
    	{
    		index %= numItems;
    	}
    	else if(index < 0)
    	{
    		index %= (numItems*-1);
    	}

    	return index;
    }
    ***/
}
