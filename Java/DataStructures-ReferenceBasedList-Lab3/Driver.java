/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/26/19
 * Submitted:  02/26/19
 * Comment: test suite and sample run attached, revised
 * @author: Donald DeWitt
 * @version: 2019.02.26
 */
import java.io.*;

public class Driver {

    private static MyListReferenceBased list = new MyListReferenceBased();
    public static void main(String args[]) throws IOException
    {
        int i = 0; //Integer for controlling the menu
        String item;
        int pos;
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("1. Insert item to list.\n"
                           + "2. Remove item from list.\n"
                           + "3. Get item from list.\n"
                           + "4. Clear list.\n"
                           + "5. Display size and content of list.\n"
                           + "6. Delete largest item in the list.\n"
                           + "7. Reverse the list.\n"
                           + "8. Exit program.\n");

        while(i != 8)
        {
            System.out.println("Select an option: ");
            i = Integer.parseInt(bReader.readLine().trim());
            System.out.println(i);

            switch(i)
            {
            case 1:
                System.out.println("\t You are now inserting an item into the list.");
                System.out.println("\t Enter item: ");
                item = bReader.readLine().trim();
                System.out.println(item);
                System.out.println("\t Enter position to insert item in: ");
                pos = Integer.parseInt(bReader.readLine().trim());
                System.out.println(pos);

                if(pos > -1 && pos <= list.size())
                {
                    list.add(pos, item);
                    System.out.println("\t Item " + item + " inserted in position " + pos + " in the list.");
                }
                else
                {
                    System.out.println("Please enter a number greater than -1 and less than " + (list.size() + 1));;
                }
                break;

            case 2:
                if(!(list.isEmpty()))
                {
                    System.out.println("\t You are now removing an item from the list.");
                    System.out.println("\t Enter position to remove item from: ");
                    pos = Integer.parseInt(bReader.readLine().trim());
                    System.out.println(pos);


                    if(pos > -1 && pos <= list.size())
                    {
                        list.remove(pos);
                    }
                    else
                    {
                        System.out.println("Please enter a number greater than -1 and less than " + (list.size() + 1));;
                    }
                }//end if
                else
                {
                    System.out.println("List is empty");
                }
                break;

            case 3:
                if(!(list.isEmpty()))
                {
                    System.out.println("\t 	Enter position to retrieve item from: ");
                    pos = Integer.parseInt(bReader.readLine().trim());
                    System.out.println(pos);
                    if(pos > -1 && pos <= list.size())
                    {
                        list.get(pos);
                    }
                    else
                    {
                        System.out.println("Please enter a number greater than -1 and less than " + (list.size() + 1));;
                    }
                }

                else
                {
                    System.out.println("List is empty");
                }

                break;

            case 4:
                if(!(list.isEmpty()))
                {
                    list.removeAll();
                    System.out.println("\t The list was cleared of all items.");
                }
                else
                {
                    System.out.println("List is empty");
                }
                break;

            case 5:
                if(!(list.isEmpty()))
                {
                    System.out.println("\t List of size " + list.size() + " has the following items: " + list.toString());
                }
                else
                {
                    System.out.println("List is empty");
                }
                break;

            case 6:
                if(!(list.isEmpty()))
                {
                    String largestItem = list.get(0).toString();
                    int size = list.size();
                    pos = 0;
                    Node curr = list.head;

                    for (int index = 0; index < size - 1; index++)
                    {
                        if((largestItem.compareTo(curr.getNext().getItem().toString())) < 0)
                        {
                            largestItem = curr.getNext().getItem().toString();
                            pos = index + 1;
                        }
                        curr = curr.getNext();
                    } // end for
                    list.remove(pos);
                    System.out.println("\t Largest item " + largestItem + " deleted.");
                }//end if
                else
                {
                    System.out.println("List is empty");
                }
                break;

            case 7:
                if(!(list.isEmpty()))
                {
                    MyListReferenceBased bufferList = new MyListReferenceBased();
                    int size = list.size();
                    Node curr = list.head;
                    for(int index = 0; index < size; index++)//Populate bufferList
                    {
                        bufferList.add(index, list.get(index));
                        curr.setItem(null);
                        curr = curr.getNext();
                    }
                    curr = list.head;
                    for(int lastIndex = size-1; lastIndex > -1; lastIndex--)
                    {
                        curr.setItem(bufferList.get(lastIndex));
                        curr = curr.getNext();
                    }
                }
                else
                {
                    System.out.println("List is empty");
                }
                break;

            case 8:
                System.out.println("Exiting program.");
                break;

            default:
                System.out.println("Please select a valid option 1-8.");
            }//end switch
        }//end while
    }//end main()
}
