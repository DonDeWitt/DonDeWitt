/*
 * Purpose: Lab 8 Problem 3
 * Status: Incomplete
 * Last update: 04/01/19
 * Submitted:  04/01/19
 * @author: Donald DeWitt
 * @version: 2019.04.01
 */
public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface
{
    protected String []items;  // an array of list items
    protected int numItems;  // number of items in list

    AscendinglyOrderedStringList()
    {
        items = new String[3];
        numItems = 0;
    }

    public boolean isEmpty()
    {
        return(numItems == 0);
    }

    public int size()
    {
        return numItems;
    }

    public void add(String item) throws ListIndexOutOfBoundsException
    {
        //resize
        int place = search(item);
        boolean add = false;
        if(place < numItems)
        {
            if(!(items[place].equals(item)))
            {
                add = true;
            }
        }
        else if(place == numItems)
        {
            add = true;
        }
        if(add)
        {
            if(numItems+1 > items.length)
            {
                String []bufferList = new String[numItems+1];
                for(int pos = 0; pos < numItems; pos++)
                {
                    bufferList[pos] = items[pos];
                }
                items = new String[items.length + items.length];
                for(int pos = 0; pos < numItems; pos++)
                {
                    items[pos] = bufferList[pos];
                }
            }
            //add and sort
            if(numItems>0)
            {
                items[search(item)] = item;
            }
            else
            {
                items[0] = item;
            }
            numItems++;
        }
    }

    public String get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }  // end if
    } // end get

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            for (int pos = index+1; pos < numItems; pos++)
            {
                items[pos-1] = items[pos];
            }  // end for
            numItems--;
            items[numItems] = null;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove

    public void clear()
    {
        items = (String[]) new Object[3];
        numItems = 0;
    }

    public int search(String item)
    {
        boolean found = false;
        int index = 0;//if found
        int low = 0;
        int high = numItems;
        int mid = high/2;
        for(int pos = mid; pos >= low && pos <= high && !found && pos < numItems && pos > 0; pos--)
        {
            if(item.compareTo(items[pos]) == 0)
            {
                found = true;
            }
            else if(item.compareTo(items[pos]) > 0)
            {
                low = mid;
                mid = (low+high)/2;
            }
            else
            {
                high = mid;
                mid = (low+high)/2;
            }
            index = pos;
        }
        return index;
    }



    public String toString()
    {
        StringBuilder info = new StringBuilder();
        for(int index = 0; index < numItems; index++)
        {
            info.append(get(index) + " ");
        }
        return info.toString();
    }
}
