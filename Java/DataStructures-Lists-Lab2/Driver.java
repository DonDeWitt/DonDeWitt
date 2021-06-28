import java.io.*;

public class Driver {


    public static void main(String args[]) throws IOException
    {
        ListArrayBasedPlus list = new ListArrayBasedPlus();
        boolean running = true;
        BufferedReader bReader = new BufferedReader (new InputStreamReader(System.in));
        int selection;
        int position;
        Object item;

        System.out.println("Select from the following menu");
        System.out.println("1. Insert item to list.");
        System.out.println("2. Remove item from list.");
        System.out.println("3. Get item from list.");
        System.out.println("4. Clear list.");
        System.out.println("5. Print size and content of list.");
        System.out.println("6. Reverse list.");
        System.out.println("7. Exit program.");

        while(running)
        {
            System.out.println("Make your menu selection now: ");
            selection = Integer.parseInt(bReader.readLine().trim());

            switch(selection)
            {
            case 1:
                System.out.println("You are now inserting an item into the list.");
                System.out.println("Enter item: ");
                item = bReader.readLine().trim();
                System.out.println("Enter position to enter item in: ");
                position = Integer.parseInt(bReader.readLine().trim());
                if(isValid(list, position))
                {
                    list.addResize(position, item);
                    System.out.println("Item " + item + " inserted in position " + position + " in the list.");
                }
                else
                {
                    outOfRange();
                }
                break;
            case 2:
                System.out.println("Enter position to remove item from: ");
                position = Integer.parseInt(bReader.readLine().trim());
                if(isValid(list, position))
                {
                    item = list.get(position);
                    list.remove(position);
                    System.out.println("Item " + item + " removed from position " + position + " in the list.");
                }
                else
                {
                    outOfRange();
                }
                break;
            case 3:
                System.out.println("Enter position to retrieve item from: ");
                position = Integer.parseInt(bReader.readLine().trim());
                if(isValid(list, position))
                {
                    System.out.println("Item " + list.get(position) + " retrieved from position " + position + " in the list.");
                }
                else
                {
                    outOfRange();
                }
                break;
            case 4:
                list.removeAll();
                break;
            case 5:
                System.out.println("List of size " + list.size() + " has the following items:  " + list.toString());
                break;
            case 6:
                list.reverse();
                System.out.println("List reversed.");
                break;
            case 7:
                running = false;
                break;
            default:
                System.out.println("Please insert a valid option");
                break;
            }
        }
    }

    public static boolean isValid(ListArrayBasedPlus list, int position)
    {
        if(position > list.numItems || position < 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static void outOfRange()
    {
        System.out.println("Position specified is out of range!");
    }

}
