import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Driver<K,V>
{
    public static void main(String args[]) throws IOException
    {
        System.out.println("0. Display the content of the symbol table\n" +
                           "1. Insert a symbol key with an associated value in the table\n" +
                           "2. Delete a symbol from the table\r\n" +
                           "3. Retrieve and display the value associated with a symbol key in the table\r\n" +
                           "4. Display the hash index of a symbol key\r\n" +
                           "5. Exit program");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashTable<String, Integer> hT = new HashTable<>();

        boolean on = true;
        while(on)
        {
            System.out.println("\n" + "Enter a number: ");
            int i = Integer.parseInt(br.readLine().trim());
            System.out.println(i);
            switch(i) {
            case 0:
                System.out.println(hT.toString());
                break;
            case 1:
                System.out.println("Enter a symbol: ");
                String symbol = br.readLine().trim().toUpperCase();
                System.out.println(symbol);
                System.out.println("Enter an Integer value: ");
                int value = Integer.parseInt((br.readLine().trim()));
                System.out.println(value);
                if(hT.tableInsert(symbol, value))
                {
                    System.out.println("Added.");
                }
                else
                {
                    System.out.println("Key is already in the table.");
                }
                break;
            case 2:
                System.out.println("Enter entry to be deleted: ");
                String delete = br.readLine().trim().toUpperCase();
                System.out.println(delete);
                if(hT.tableDelete(delete))
                {
                    System.out.println("Deleted.");
                }
                else
                {
                    System.out.println("Unable to find entry '" + delete + "'.");
                }
                break;
            case 3:
                System.out.println("Enter a search key: ");
                String searchKey = br.readLine().trim().toUpperCase();
                System.out.println(searchKey);
                Integer result = hT.tableRetrieve(searchKey);
                if(result != null)
                {
                    System.out.println("Value: " + result);
                }
                else
                {
                    System.out.println("Key not found.");
                }
                break;
            case 4:
                System.out.println("Enter a symbol: ");
                String hK = br.readLine().trim().toUpperCase();
                System.out.println(hK);
                System.out.println("Hash index:" + hT.hashIndex(hK));
                break;
            case 5:
                System.out.println("Closing program...");
                on = false;
                break;
            default:
                System.out.println("Please enter a valid input number 1-5.");
                break;
            }
        }
    }

}
