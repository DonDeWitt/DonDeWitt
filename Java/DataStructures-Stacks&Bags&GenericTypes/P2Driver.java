/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/27/19
 * Submitted:  02/27/19
 * Comment: Revised
 * @author: Donald DeWitt
 * @version: 2019.02.27
 */

import java.io.*;

public class P2Driver
{
    public static void main(String args[]) throws IOException
    {
        Bag<Package> deliveryBag = new Bag<Package>();
        Bag<Item> sampleBag = new Bag<Item>();
        int i = -1; //Integer for controlling the menu
        //Object item;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("0. Exit.\n"
                           + "1. Pick up an order.\n"
                           + "2. Drop off an order.\n"
                           + "3. Display number of packages and weight of bag.\n"
                           + "4. Display number of items and weight of the bag of samples.\n"
                           + "5. Enjoy an item from the bag of samples.\n"
                           + "6. Enjoy all the samples in the bag of samples.");

        while(i != 0)
        {
            System.out.println("Select an option: ");
            i = Integer.parseInt(br.readLine().trim());
            System.out.println(i);

            switch(i)
            {
            case 0:
                System.out.println("Exiting...");
                break;
            case 1:
                System.out.println("Please specify package info:");
                System.out.println("item name:");
                String name = br.readLine().trim();
                System.out.println(name);

                System.out.println("item weight:");
                Double weight = Double.parseDouble(br.readLine().trim());
                System.out.println(weight);

                System.out.println("number of items:");
                int numItems = Integer.parseInt(br.readLine().trim());
                System.out.println(numItems);

                System.out.println("sender:");
                String sender = br.readLine().trim();
                System.out.println(sender);

                System.out.println("recepient:");
                String recepient = br.readLine().trim();
                System.out.println(recepient);

                deliveryBag.addItem(new Package(name, weight, sender, recepient, numItems));
                System.out.println("A package of " + name + " each weighing " + weight + " lbs are now in the bag.");
                break;

            case 2:
                if(deliveryBag.isEmpty())
                {
                    System.out.println("No deliveries to process!");
                }
                else
                {
                    Package curr = (Package)deliveryBag.removeItem();
                    System.out.println("Here is your package " + curr.getRecepient() + ". May I please, please keep a sample(Y/N)?");
                    String ans = br.readLine().trim().toUpperCase();//Y/N answer

                    System.out.println("Your package contains: " + curr.getNumItems() + " "
                                       + curr.getName() + "s each weighing " + curr.getWeight() + " from " + curr.getSender() +" to " + curr.getRecepient());

                    if(ans.equals("Y"))
                    {
                        sampleBag.addItem(new Item(curr.getName(), curr.getWeight()));
                        System.out.println("Thank you for letting me keep a " + curr.getName() +"!");
                    }
                    else
                    {
                        System.out.println("Thanks anyway.");
                    }
                }
                break;

            case 3:
                System.out.println("Bag has " + deliveryBag.getSize()
                                   + " packages and weighs " + deliveryBag.getTotalWeight() + " lbs.");
                break;

            case 4:
                System.out.println("Bag has " + sampleBag.getSize()
                                   + " packages and weighs " + sampleBag.getTotalWeight() + " lbs.");
                break;

            case 5:
                if(sampleBag.isEmpty())
                {
                    System.out.println("No samples to enjoy!");
                }
                else
                {
                    Item curr = sampleBag.removeItem();
                    System.out.println("This " + curr.getName() + " is amazing!"
                                       + " I love free stuff!");
                }
                break;

            case 6:
                if(sampleBag.isEmpty())
                {
                    System.out.println("Sample bag is already empty.");
                }
                else
                {
                    sampleBag = new Bag<Item>();
                    System.out.println("Sample bag has been emptied.");
                }
                break;

            default:
                break;
            }//end switch(i)
        }//end while(i !=6)
    }//end main()
}//end class
