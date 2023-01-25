
/**
 * Write a description of class Festival here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Festival
{
    // instance variables - replace the example below with your own
    private int[] currentVisitorsPerAct;

    /**
     * Constructor for objects of class Festival
     */
    public Festival(int nrOfActs){
        int[] currentVisitorsPerAct = new int[nrOfActs];
        // initialise instance variables
        for(int i = 0; i < nrOfActs; i++){
            System.out.println(i);
            currentVisitorsPerAct[i] = 0;
            System.out.println(currentVisitorsPerAct[i]);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
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
    
    public boolean addTicket(Ticket ticket){return false;}
    
    public float removeTicket(Ticket ticket){return 1f;}
    
    public int mostPopular(){return 0;}
    
    public boolean doWeHaveABirthday(String date){return false;}
    
    //public ArrayList<Ticket> importBackup(String filename){}
    
    
    
    
}
