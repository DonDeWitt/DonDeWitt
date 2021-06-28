/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/27/19
 * Submitted:  02/27/19
 * Comment: Revised
 * @author: Donald DeWitt
 * @version: 2019.07.25
 */
public class Bag<T>
{
    private StackSLS<T> items;
    private double totalWeight;
    private int size;

    public Bag()
    {
        items = new StackSLS<T>();
        totalWeight = 0;
        size = 0;
    }

    public boolean isEmpty()
    {
        return items.isEmpty();
    }

    public int getSize()
    {
        return size;
    }

    public double getTotalWeight()
    {
        return totalWeight;
    }

    public void addItem(Item item)
    {
        if(item instanceof Package)
        {
            Package pItem = (Package)item;
            totalWeight += (pItem.getWeight() * pItem.getNumItems());
        }
        else
        {
            totalWeight += item.getWeight();
        }
        items.push((T)item);
        size++;
    }

    public Item removeItem()
    {
        Item item = (Item)items.pop();
        if(item instanceof Package)
        {
            Package pItem = (Package)item;
            totalWeight -= (pItem.getWeight() * pItem.getNumItems());
        }
        else
        {
            totalWeight += item.getWeight();
        }
        size--;
        return item;
    }
}//end class
