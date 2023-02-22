public class Ticket
{
    // instance variables 
    private int[] acts;
    private float price = 0;
    private String name;
    private String nationalNumber;
    private boolean complete = false;
    private int actCounter;
    //private static int actsNumber;

    public Ticket(String visitorName, String visitorNatNumber)
    {
        name = visitorName;
        nationalNumber = visitorNatNumber;
        actCounter = 0;
        complete = false;
        price = 0;
    }
    
    public boolean addAct(int actNr){// throws Exception{
        if(!complete){
        int actsNumber = actNr;
        int[] newArray = new int[actNr];
        try{
            if(actNr>10){
                actsNumber = actNr;
                
                //throw new Exception("Max acts is 10");            
            }else if(actNr==10){
                setComplete();
            }
            for(int i = 0; i < actNr; i++){
                newArray[i] = i;
                System.out.println(newArray[i]);
            }
        }catch(Exception e){
            System.out.println("Error. Input number =< 0");
            return false;
        }
        acts = newArray;
        calculatePrice();
        return true;
        }else{
        System.out.println("Ticket is complete. Impossible to add any more acts");
        return false;
        }
    }
    
    public boolean addAct(int actID){
        if(acts.length == null){
            
        }
    }
    
    public void calculatePrice(){
        if(acts.length == 0){
            price = 0;
        }else if((0<acts.length)&(acts.length<4)){
            price = acts.length * 10f;
        }else if((4<acts.length)&(acts.length<6)){
            price = 30+(acts.length-3)*7.5f;
            System.out.println(price);
        }else{
            price = 45+(acts.length-5)*5f;
        }

    }
    
    public int[] getActs(){return acts;}
    
    public int getNrOfActs(){
        return actCounter;    
    }
    
    public void setComplete(){}
    
    public boolean getComplete(){return complete;}
    
    public void setPrice(){}
    
    public void setName(){}
    
    public void setNatNumber(){}
    
    public float getPrice(){return price;}
    
    public String getName(){return name;}
    
    public String getNatNumber(){return nationalNumber;}
    
    
    

}
