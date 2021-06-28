/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/27/19
 * Submitted:  02/27/19
 * Comment: Revised
 * @author: Donald DeWitt
 * @version: 2019.02.27
 */

public class StackSLS<T> implements StackInterface<T>
{
    private Node<T> head;

    public StackSLS()
    {
        head = null;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("");
        if(head != null)
        {
            for(Node<T> curr = head; curr != null; curr = curr.getNext())
            {
                sb.append(curr.getItem() + " ");
            }
        }
        String s = sb.toString();
        return s;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void popAll()
    {
        head = null;
    }

    public void push(T newItem) throws StackException
    {
        head = new Node<T>(newItem,head);
    }

    public T pop() throws StackException
    {
        T result;
        if(head == null)
        {
            throw new StackException("Stack is empty");
        }
        else
        {
            result = (T)head.getItem();
            head = head.getNext();
        }
        return result;
    }

    public T peek() throws StackException
    {
        T result;
        if(head == null)
        {
            throw new StackException("Stack is empty");
        }
        else
        {
            result = (T)head.getItem();
        }
        return result;
    }
}
