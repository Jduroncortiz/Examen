public class Ticket
{
    private int[] acts;
    private float price;
    private String name;
    private String nationalNumber;
    private boolean complete;
    private int actCounter;
    
    public Ticket(String visitorName, String visitorNatNumber)
    {
        name = visitorName;
        nationalNumber = visitorNatNumber;
        complete = false;
        actCounter = 0;
        acts = new int[10];
    }
    
    public void calculatePrice()
    {
        if(actCounter < 3)
        {
            price = 30.0f;
        }
        else if(actCounter == 3 || actCounter == 4)
        {
            price += 7.5f;
        }
        else
        {
            price += 5.0f;
        }
    }
    
    public boolean addAct(int actNr)
    {
        if(complete == false)
        {
            if(actCounter < 10)
            {   
                acts[actCounter] = actNr;
                calculatePrice();
                actCounter ++;
                if(actCounter == 10)
                {
                    setComplete();
                }
                return true;
            }
        }
        return false;
    }
    
    public void setComplete()
    {
        complete = true;
    }
    
    public String getName()
    {
        return name;
    }
    
    public boolean getComplete()
    {
        return complete;
    }
    
    public int getActCounter()
    {
        return actCounter;
    }
    
    public float getPrice()
    {
        return price;
    }
    
    public int[] getActs()
    {
        return acts;
    }
    
    public String getNatNum()
    {
        return nationalNumber;
    }
}

