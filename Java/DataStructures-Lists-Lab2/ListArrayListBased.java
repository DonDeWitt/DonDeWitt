import java.util.ArrayList;

public class ListArrayListBased implements ListInterface {

    ArrayList<Object> items;

    public ListArrayListBased(int size)
    {
        items = new ArrayList<Object>(size);
    }

    public boolean isEmpty() {
        if(items.size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int size() {
        return items.size();
    }

    public void add(int index, Object item) throws ListIndexOutOfBoundsException {
        if(index >= items.size() && index < -1)
        {
            if(items.get(index) != null)
            {
                for(int pos = items.size() +1; pos >= index; pos--)
                {
                    items.add(pos, items.get(pos-1));
                }
                items.add(index, item);
                //numItems ++;
            }
        }
        else
        {
            throw  new ListIndexOutOfBoundsException("Index out of bounds.");
        }

    }

    public Object get(int index) throws ListIndexOutOfBoundsException {
        if(index > items.size() && index < -1)
        {
            return items.get(index);
        }
        else
        {
            throw new ListIndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void remove(int index) throws ListIndexOutOfBoundsException {
        if(index > items.size() && index < -1)
        {
            int size = items.size();
            for(int pos = index; pos < size; pos++)
            {
                items.add(pos, items.get(pos+1));
            }
            //numItems--;
        }
        else
        {
            throw new ListIndexOutOfBoundsException("Index out of bounds");
        }

    }

    public void removeAll() {
        items = new ArrayList<Object>();
    }
}
