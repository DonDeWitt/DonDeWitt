import java.util.ArrayList;

public class ListArrayListBasedPlus extends ListArrayListBased
{

    public ListArrayListBasedPlus(int size)
    {
        super(size);
    }

    public void reverse()
    {
        ArrayList<Object> bufferList = makeBuffer();
        for(int index = 0, lastIndex = size()-1; index < size(); index++, lastIndex--)
        {
            items.add(bufferList.get(lastIndex));
        }
    }

    private ArrayList<Object> makeBuffer()
    {
        ArrayList<Object> bufferList = new ArrayList<Object>();
        int size = items.size();
        for(int index = 0; index < size; index++)
        {
            bufferList.add(items.get(index));
        }
        return bufferList;
    }
}
