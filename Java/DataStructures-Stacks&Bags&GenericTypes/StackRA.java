/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/27/19
 * Submitted:  02/27/19
 * Comment: Revised
 * @author: Donald DeWitt
 * @version: 2019.02.27
 */

public class StackRA<T> implements StackInterface<T>
{
    private T[] items;
    private int numItems;

    public StackRA()
    {
        items = (T[]) new Object[3];
        numItems = 0;
    }

    public boolean isEmpty()
    {
        return numItems==0;
    }

    public void popAll()
    {
        items = (T[]) new Object[3];
        numItems = 0;
    }

    public void push(T newItem) throws StackException
    {
        //Resize stack if stack is at capacity
        if(numItems == items.length)
        {
            T[] newStack = (T[]) new Object[items.length + items.length];
            for(int i = 0; i < numItems; i++)
            {
                newStack[i] = items[i];
            }
            items = newStack;
        }
        items[numItems++] = newItem;
    }

    public T pop() throws StackException
    {
        T result;
        if(numItems == 0)
        {
            throw new StackException("Stack is empty");
        }
        else
        {
            result = items[numItems-1];
            items[numItems-1] = null;
        }
        numItems--;
        return result;
    }

    public T peek() throws StackException
    {
        T result;
        if(numItems==0)
        {
            throw new StackException("Stack is empty");
        }
        else
        {
            result = items[numItems-1];
        }
        return result;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("");
        for (int pos = numItems-1; pos > -1; pos--)
        {
            sb.append(items[pos] + " ");
        }
        return sb.toString();
    }
}
