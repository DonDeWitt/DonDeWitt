public class Package extends Item
{
    private String sender;
    private String recepient;
    private int numItems;

    public Package(String name, double weight, String sender, String recepient, int numItems)
    {
        super(name, weight);
        this.sender = sender;
        this.recepient = recepient;
        this.numItems = numItems;
    }

    public String getSender()
    {
        return sender;
    }

    public String getRecepient()
    {
        return recepient;
    }

    public int getNumItems()
    {
        return numItems;
    }
}// end class
