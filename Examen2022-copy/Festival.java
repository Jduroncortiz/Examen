import java.util.ArrayList;

public class Festival
{
    // instance variables - replace the example below with your own
    //private int[] currentVisitorsPerAct = new int[1];
    private static int[] currentVisitorsPerAct;
    private static int[][] currentVisitorsPerAct2;
    private ArrayList<Ticket> ticketList = new ArrayList();
    
    public Festival(int nrOfActs){
        currentVisitorsPerAct = new int[nrOfActs];
        currentVisitorsPerAct2 = new int[nrOfActs][2];
        //int[] newArray = new int[nrOfActs];
        // initialise instance variables
        /*for(int i = 0; i < nrOfActs; i++){
            System.out.println(i);
            newArray[i] = 0;
            System.out.println(currentVisitorsPerAct[i]);
        }*/
        
        //currentVisitorsPerAct = newArray;
    }

    public int nrOfTickets(){
        int outputNumber = 0;
        for(int i = 0; i < currentVisitorsPerAct.length; i++){
            outputNumber += currentVisitorsPerAct[i];
        }
        return outputNumber;
    }
    
    public int getNrOfActs(){
        return currentVisitorsPerAct.length;
    }
    
    public int[] getCurrentVisitorsPerAct(){
        System.out.println(currentVisitorsPerAct);
        return currentVisitorsPerAct;}
    
    public boolean addTicket(Ticket ticket){
        try{
            ticketList.add(ticket);
            return true;
        }catch(Exception e){
            return false;   
        }
    }
    
    public float removeTicket(Ticket ticket){return 1f;}
    
    public int mostPopular(){return 0;}
    
    public boolean doWeHaveABirthday(String date){return false;}
    
    //public ArrayList<Ticket> importBackup(String filename){}
    
    
    
    
}
