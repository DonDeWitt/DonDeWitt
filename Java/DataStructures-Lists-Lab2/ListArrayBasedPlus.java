
public class ListArrayBasedPlus extends ListArrayBased {

    public ListArrayBasedPlus()
    {
        super();
    }  // end default constructor

    public void addResize(int index, Object item)
    {
        if(index > MAX_LIST || numItems+1 > MAX_LIST)
        {
            MAX_LIST += 1;
            resize();
            add(index, item);
        }
        else
        {
            add(index, item);
        }
    }

    public void resize()
    {
        Object []bufferList = makeBuffer();
        items = new Object[MAX_LIST];
        for(int index = 0; index < numItems; index++)
        {
            items[index] = bufferList[index];
        }
    }

    public void reverse()
    {
        Object []bufferList = makeBuffer();
        items = new Object[MAX_LIST];
        for(int index = 0, lastIndex = numItems-1; index < numItems; index++, lastIndex--)
        {
            items[index] = bufferList[lastIndex];
        }
    }

    public Object[] makeBuffer()
    {
        Object []bufferList = new Object[numItems];
        for(int index = 0; index < numItems; index++)
        {
            bufferList[index] = items[index];
        }
        return bufferList;
    }


    public String toString()
    {
        StringBuilder info = new StringBuilder();
        for(int index = 0; index < numItems; index++)
        {
            info.append(get(index));
            if(index < numItems - 1)
            {
                info.append(", ");
            }
            else
            {
                info.append(".");
            }
        }
        return info.toString();
    }
}
