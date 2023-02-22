public class Ticket
{
    int[] acts;
    float price;
    String name;
    String nationalNumber;
    boolean complete;
    int actCounter;
    boolean VIP = false;
    Ticket(String v, String n){
        name = v;
        nationalNumber = n;
        acts = new int[10];
        actCounter = 0;
        price = 0;
    }
    
    public boolean addAct(int n){
        if(!complete){
        acts[actCounter] = n;
        actCounter++;
        if (actCounter == acts.length){
            complete = true;
        }
        calculatePrice();
        return true;
        }
        return false;
    }
    
    public void calculatePrice(){
        if(actCounter<=3){
            price = 30;
        }else if(actCounter==4){
            price+=7.5;
        }else if(actCounter == 5){
            price+=7.5;
        }else{
            price+=5;
        }
    }
    
    public int[] getActs(){
        return acts;
    }
    
    public void setComplete(){
        complete = true;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean getComplete(){
        return complete;
    }
    
    public int getActCounter(){
        return actCounter;
    }
    
    public float getPrice(){
        return price;
    }
}

