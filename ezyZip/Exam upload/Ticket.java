public class Ticket
{
    // Your code goes here.
    int[] acts;
    float price;
    String name;
    String nationalNumber;
    boolean complete;
    int actCounter;
    boolean VIP = false;
    
    public Ticket(String visitorName, String visitorNatNumber)
    {
        name = visitorName;
        nationalNumber = visitorNatNumber;
        acts = new int[10];
        price = 0;
        complete = false;
        actCounter = 0;
    }
    
    public String getNatNumber()
    {
        return nationalNumber;
    }
    public boolean addAct(int actNr)
    {
        if(complete == false)
        {
            if(actCounter < 10)
            {
                acts[actCounter] = actNr;
                actCounter ++;
                calculatePrice();
                if(actCounter == 10)
                {
                    setComplete();
                }
                return true;
            }
        
        }
        return false;
    }
    
    public void calculatePrice()
    {
        if(actCounter == 0)
        {
            price = 0f;
        }
        else if(actCounter != 0 && actCounter <= 3)
        {
            price = 30f;
        }
        else if(4 <= actCounter && actCounter <= 5)
        {
            price += 7.5f;
        }
        else if(5 < actCounter && actCounter <= 10)
        {
            price += 5.0f;
        }
    }
        
    
    public int getActCounter()
    {
        return actCounter;
    }
        
    public int[] getActs()
    {
        return acts;
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
    
    public float getPrice()
    {
        return price;
    }
        
}

