/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/27/19
 * Submitted:  02/27/19
 * Comment: Revised
 * @author: Donald DeWitt
 * @version: 2019.02.25
 */

import java.io.*;

public class P1Driver
{
    public static void main(String args[]) throws IOException
    {
        StackSLS<Object> stack = new StackSLS<Object>(); //Creates a stack with no items
        int i = 0; //Integer for controlling the menu
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("1. Push item onto stack.\n"
                           + "2. Pop item from stack.\n"
                           + "3. Display top item from stack.\n"
                           + "4. Display items in stack.\n"
                           + "5. Clear stack.\n"
                           + "6. Exit.\n");

        while(i != 6)
        {
            System.out.println("Select an option: ");
            i = Integer.parseInt(br.readLine().trim());
            System.out.println(i);

            switch(i)
            {
            case 1:
                System.out.println("\t" + "Pushing item onto stack...");
                System.out.println("\t" + "Enter the item to push onto the stack:");
                Object item = br.readLine().trim();
                System.out.println(item);
                stack.push(item);
                break;

            case 2:
                if(!(stack.isEmpty()))
                {
                    System.out.println("\t" + "Item '" + stack.pop() + "' was popped from the stack.");
                }
                else
                {
                    System.out.println("\t" + "stack is empty.");
                }
                break;

            case 3:
                if(!(stack.isEmpty()))
                {
                    System.out.println("\t" + "Item at the top of the stack: " + stack.peek().toString());

                }
                else
                {
                    System.out.println("\t" + "stack is empty.");
                }
                break;

            case 4:
                if(!(stack.isEmpty()))
                {
                    System.out.println(stack.toString());
                }
                else
                {
                    System.out.println("\t" + "stack is empty.");
                }
                break;

            case 5:
                if(!(stack.isEmpty()))
                {
                    stack = new StackSLS<Object>();
                }
                else
                {
                    System.out.println("\t" + "stack is empty.");
                }
                break;

            case 6:
                System.out.println("\t" + "Exiting program...");
                break;

            default:
                System.out.println("\t" + "Please select a valid option 1-6.");
                break;
            }//end switch
        }//end while
    }//end main()
}
