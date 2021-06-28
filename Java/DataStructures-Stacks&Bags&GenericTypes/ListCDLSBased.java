/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 02/25/19
 * Submitted:  02/25/19
 * Comment:
 * @author: Donald DeWitt
 * @version: 2019.02.25
 */

public class ListCDLSBased<T> implements ListInterface {

    private DNode<T> head;
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

    private DNode<T> find(int index)
    {
        // --------------------------------------------------
        // Locates a specified DNode<T> in a linked list.
        // Precondition: index is the number of the desired
        // DNode. Assumes that 0 <= index <= numItems
        // Postcondition: Returns a reference to the desired
        // DNode.
        // --------------------------------------------------
        DNode<T> curr = head;

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

    public DNode<T> getHead()
    {
        return head;
    }

    public void setHead(DNode<T> head)
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
                    head = new DNode<T>((T)item);
                }
                else if(size() == 1)
                {
                    DNode<T> newHead = new DNode<T>((T)item);
                    head.setNext(newHead);
                    head.setBack(newHead);
                    newHead.setNext(head);
                    newHead.setBack(head);
                    head = newHead;
                }
                else
                {
                    DNode<T> lastNode = head.getBack();
                    DNode<T> newHead = new DNode<T>((T)item, head, lastNode);
                    lastNode.setNext(newHead);
                    head.setBack(newHead);
                    head = newHead;
                }
            }
            else
            {

                // insert the new node containing item after
                // the node that prev references
                DNode<T> curr = find(index);
                DNode<T> newNode = new DNode<T>((T)item, curr, curr.getBack());
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
                DNode<T> curr = find(index);
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
                DNode<T> prev = find(index-1);
                // delete the node after the node that prev
                // references, save reference to node
                DNode<T> curr = prev.getNext();
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
            DNode<T> curr = head;
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
}
