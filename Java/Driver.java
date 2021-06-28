/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/26/19
 * Submitted:  02/26/19
 * Comment: test suite and sample run attached
 * @author: Donald DeWitt
 * @version: 2019.26.11
 */

import java.io.*;

public class Driver {
    public static void main(String args[]) throws IOException
    {
        ListCDLSBased list = new ListCDLSBased(); //Creates a list with no items
        int i = 0; //Integer for controlling the menu
        String item;
        int pos;
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("1. Insert item to list.\n"
                           + "2. Remove item from list.\n"
                           + "3. Get item from list.\n"
                           + "4. Clear list.\n"
                           + "5. Display size and content of list.\n"
                           + "6. Reverse the list.\n"
                           + "7. Exit program.\n");

        while(i != 7)
        {
            System.out.println("Select an option: ");
            i = Integer.parseInt(bReader.readLine().trim());
            System.out.println(i);

            switch(i)
            {
            case 1:
                System.out.println("You are now inserting an item into the list.");
                System.out.println("\t Enter item: ");
                item = bReader.readLine().trim();
                System.out.println(item);
                System.out.println("\t Enter position to insert item in: ");
                pos = Integer.parseInt(bReader.readLine().trim());
                System.out.println(pos);

                if(isValid(list, pos))
                {
                    list.add(pos, item);
                    System.out.println("Item " + item + " inserted in position " + pos + " in the list.");
                }
                else
                {
                    printInvalid(list);
                }
                break;

            case 2:
                if(!(list.isEmpty()))
                {
                    System.out.println("You are now removing an item from the list.");
                    System.out.println("\t Enter position to remove item from: ");
                    pos = Integer.parseInt(bReader.readLine().trim());
                    System.out.println(pos);

                    if(pos < list.size() && pos > -1)
                    {
                        list.remove(pos);
                    }
                    else
                    {
                        printInvalid(list);
                    }
                }//end if
                else
                {
                    printIsEmpty();
                }
                break;

            case 3:
                if(!(list.isEmpty()))
                {
                    System.out.println("\t 	Enter position to retrieve item from: ");
                    pos = Integer.parseInt(bReader.readLine().trim());
                    System.out.println(pos);
                    if(pos < list.size() && pos > -1)
                    {
                        System.out.println(list.get(pos));
                    }
                    else
                    {
                        printInvalid(list);
                    }
                }
                else
                {
                    printIsEmpty();
                }
                break;

            case 4:
                if(!(list.isEmpty()))
                {
                    list.removeAll();
                    System.out.println("The list was cleared of all items.");
                }
                else
                {
                    printIsEmpty();
                }
                break;

            case 5:
                if(!(list.isEmpty()))
                {
                    System.out.println("List of size " + list.size() + " has the following items: " + list.toString());
                }
                else
                {
                    printIsEmpty();
                }
                break;

            case 6:
                if(!(list.isEmpty()))
                {
                    for (int x = 0, size = list.size(), y = size-1; x < size && y > 0 && x!= y; x++)
                    {
                        if(list.get(x) != list.get(y))
                        {
                            list.add(x, list.get(y));
                            list.remove(y+1);
                        }
                    }
                }
                else
                {
                    printIsEmpty();
                }
                break;

            case 7:
                System.out.println("Exiting program.");
                break;

            default:
                System.out.println("Please select a valid option 1-8.");
            }//end switch
        }//end while
    }//end main()

    private static boolean isValid(ListCDLSBased list, int pos)
    {
        if(pos > -1 && pos <= list.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static void printInvalid(ListCDLSBased list)
    {
        System.out.println("Please enter a number greater than -1 and less than " + (list.size()));
    }

    private static void printIsEmpty()
    {
        System.out.println("List is empty");
    }
}
