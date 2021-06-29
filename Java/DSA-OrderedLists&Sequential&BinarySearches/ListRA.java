/*
 * Purpose: Data Structure and Algorithms Midterm
 * Status: Complete and thoroughly tested
 * Last update: 03/05/19
 * Submitted:  03/05/19
 * @author: Donald DeWitt
 * @version: 2019.03.05
 */
public class ListRA<T> extends ListArrayBased<T>
{
    public ListRA()
    {
        super();
    }  // end default constructor

    public void addRA(int index, T item)
    {
        if(numItems+1 > items.length)
        {
            resize();
            add(index, item);
        }
        else
        {
            add(index, item);
        }
    }

    public boolean searchAdd(String item)
    {
        boolean added = false;
        if(!(isEmpty()))
        {
            for(int index = size()-1; index >= 0 && !added; index--)
            {
                if(item.compareTo((String)get(index)) > 0)
                {
                    addRA(index+1, (T)item);
                    added = true;
                }
                else if(item.compareTo((String)get(index)) == 0)
                {
                    addRA(index, (T)item);
                    added = true;
                }
            }
            if(!added)
            {
                addRA(0, (T)item);
            }
        }
        else
        {
            addRA(0, (T)item);
        }
        return added;
    }

    public void resize()
    {
        T []bufferList = (T[]) new Object[numItems];
        for(int index = 0; index < numItems; index++)
        {
            bufferList[index] = items[index];
        }
        items = (T[]) new Object[items.length + items.length];
        for(int index = 0; index < numItems; index++)
        {
            items[index] = bufferList[index];
        }
    }

    public void reverse()
    {
        T []bufferList = (T[]) new Object[numItems];
        for(int index = 0; index < numItems; index++)
        {
            bufferList[index] = items[index];
        }
        items = (T[]) new Object[3];
        for(int index = 0, lastIndex = numItems-1; index < numItems; index++, lastIndex--)
        {
            items[index] = bufferList[lastIndex];
        }
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
