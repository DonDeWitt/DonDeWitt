// ********************************************************
// Hash table implementation.
// Assumption: A table contains unique items(at most one
//             item with a given search key at any time)
// *********************************************************

public class HashTable<K, V> implements HashTableInterface<K,V> {
    private ChainNode<K,V>[] table;     // hash table
    private int size = 0;          // size of table, i.e. number of entries ((key,value) associations)

    public HashTable() {
        table = new ChainNode[3];
    }  // end default constructor

// table operations
    public boolean tableIsEmpty() {
        return size==0;
    }  // end tableIsEmpty

    public int tableLength() {
        return size;
    }  // end tableLength


//implement the following 5 methods

    public boolean tableInsert(K key, V value) //inserts  association (key,value) only if key is not already in HashTable and returns true; returns false if the key already has an associated value in HashTable and does not insert
    {
        boolean succ = false;
        boolean found = false;
        int index = hashIndex(key)%table.length;
        ChainNode<K,V> curr = table[index];
        if(curr != null)
        {
            for(; curr != null && !succ && !found; curr = curr.getNext())
            {
                if(curr.getKey().equals(key))
                {
                    found = true;
                }
                else if(curr.getNext() == null)
                {
                    curr.setNext(new ChainNode<K,V>(key, value, null));
                    succ = true;
                    size++;
                }
            }
        }
        else
        {
            table[index] = new ChainNode<K,V>(key, value, null);
            succ = true;
            size++;
        }
        return succ;
    }

    public boolean tableDelete(K searchKey) //deletes the key and its association from the HashTable if it is in the table and returns true; returns false if key is not in the HashTable
    {
        boolean succ = false;
        int index = hashIndex(searchKey)%table.length;
        ChainNode<K,V> head = table[index];
        for(ChainNode<K,V> curr = head; curr != null && !succ; curr = curr.getNext())
        {
            ChainNode<K,V> next = curr.getNext();
            if(curr == head && curr.getKey().equals(searchKey))
            {
                if(next != null)
                {
                    table[index] = next;
                }
                else
                {
                    head = null;
                }
                succ = true;
                size--;
            }
            else if(next != null)
            {
                if(next.getKey().equals(searchKey))
                {
                    curr.setNext(next.getNext());
                    succ = true;
                    size--;
                }
            }
        }
        return succ;
    }

    public V tableRetrieve(K searchKey) //returns the value associated with searchkey in HashTable or null if there is no association
    {
        ChainNode<K,V> head = table[hashIndex(searchKey)%table.length];
        V result = null;
        boolean succ = false;
        if(head != null)
        {
            for(ChainNode<K, V> curr = head;
                    curr != null && !succ;
                    curr = curr.getNext())
            {
                if(curr.getKey().equals(searchKey))
                {
                    result = curr.getValue();
                    succ = true;
                }
            }
        }
        return result;
    }

    public int hashIndex(K key)
    {
        String sKey = (String)key;//Convert from K to String
        sKey = sKey.trim().toUpperCase();
        int result = 0;
        int ref = (int)'A';

        for(int i = 0, limit = sKey.length(), exponent = limit-1, mult = 1; i < limit; i++, exponent--, mult = 1)
        {
            if(exponent > 0)
            {
                mult = 32;
                for(int j = 1; j < exponent; j++)
                {
                    mult = mult << 5;
                }
            }
            result += (((int)sKey.charAt(i) - ref)+1) * mult;
        }
        return result;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("Contents:\n");
        if(size > 0)
        {
            for(int i = 0; i < table.length; i++)
            {
                if(table[i] != null)
                {
                    for(ChainNode<K, V> curr = table[i]; curr != null; curr = curr.getNext())
                    {
                        sb.append("Key: " + curr.getKey() + " - Value: " + curr.getValue() + " .\n");
                    }
                }
            }
        }
        else
        {
            sb.append("No contents to display.");
        }
        return sb.toString();
    }
}  // end HashTable
