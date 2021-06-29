/*
 * Purpose: Lab 8 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 04/01/19
 * Submitted:  04/01/19
 * @author: Donald DeWitt
 * @version: 2019.04.01
 */
import java.io.*;

public class Problem2
{

    public static void main(String args[]) throws IOException
    {
        int i = 0;
        String item;
        ListRA<String> list = new ListRA<String>();

        System.out.println("1. Insert item into ordered list.\n" +
                           "2. Remove item from list.\n" +
                           "3. Get item from list.\n" +
                           "4. Search for a specified item in the list.\n" +
                           "5. Clear list.\n" +
                           "6. Print size and content of list.\n" +
                           "7. Exit program.");

        while(i != 7)
        {
            System.out.println("Choose an option: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            i = Integer.parseInt(br.readLine());

            switch(i)
            {
            case 1:
                System.out.println("Enter the item: ");
                item = br.readLine().trim();
                boolean added = false;
                if(list.isEmpty())
                {
                    added = true;
                    list.addRA(0, item);
                }
                else
                {
                    int place = search(item, list);
                    if(place < list.size())
                    {
                        if(!(list.get(place).equals(item)))//Make sure item is unique
                        {
                            added = true;
                            list.addRA(place, item);
                        }
                    }
                    else//Item at the end of the list
                    {
                        added = true;
                        list.addRA(place, item);
                    }
                }
                if(added)
                {
                    System.out.println("Item added to the list.");
                }
                else
                {
                    System.out.println("Item not added to the list, not unique.");
                }

                break;
            case 2:
                if(!(list.isEmpty()))
                {
                    System.out.println("Enter the index of the item to remove: ");
                    int removeNum = Integer.parseInt(br.readLine().trim());
                    if(removeNum > -1 && removeNum < list.size())
                    {
                        item = list.get(removeNum);
                        list.remove(removeNum);
                        System.out.println(item + " was removed from the list.");
                    }
                    else
                    {
                        System.out.println("Item not removed. Enter a number greater than -1 and less than less than the size of the list(" + list.size() + ").");
                    }
                }
                else
                {
                    System.out.println("List is empty.");
                }
                break;
            case 3:
                if(!(list.isEmpty()))
                {
                    System.out.println("Enter the index of the item to get: ");
                    int getNum = Integer.parseInt(br.readLine().trim());
                    if(getNum > -1 && getNum < list.size())
                    {
                        System.out.println(list.get(getNum) + " was gotten from the list");
                    }
                    else
                    {
                        System.out.println("Item not gotten. Enter a number greater than -1 and less than less than the size of the list(" + list.size() + ").");
                    }
                }
                else
                {
                    System.out.println("List is empty.");
                }
                break;

            case 4:
                if(!(list.isEmpty()))
                {
                    System.out.println("Enter the item to search: ");
                    item = br.readLine().trim();
                    int index = search(item, list);
                    if(index != list.size())
                    {
                        System.out.println("Successful search. Item " + item + " located in position " + index);
                    }
                    else
                    {
                        System.out.println("Unsuccessful search. Item not found in the list.");
                    }
                }
                else
                {
                    System.out.println("List is empty.");
                }
                break;

            case 5:
                if(!(list.isEmpty()))
                {
                    list.removeAll();
                    System.out.println("List was cleared of all items.");
                }
                else
                {
                    System.out.println("List is empty.");
                }
                break;
            case 6:
                if(!(list.isEmpty()))
                {
                    System.out.println("List size: " + list.size() + "\n"
                                       + "Contents: " + list.toString());
                }
                else
                {
                    System.out.println("List is empty.");
                }
                break;
            case 7:
                System.out.println("Exiting program.");
                break;
            }
        }
    }

    private static int search(String item, ListRA<String> list)//ModifiedSequentialSearch III
    {
        boolean found = false;
        int pos = 0;

        for(int index = 0; index <= list.size() && !found; index++)
        {
            if(index == list.size())
            {
                pos = index;
                found = true;
            }
            else
            {
                if(item.compareTo(list.get(index)) > 0)
                {
                    if(index+1 < list.size())
                    {
                        if(item.compareTo(list.get(index+1)) < 0)
                        {
                            pos = index+1;
                            found = true;
                        }
                    }
                }
                else if(item.compareTo(list.get(index)) == 0)
                {
                    pos = index;
                    found = true;
                }
            }
        }
        return pos;
    }
}
