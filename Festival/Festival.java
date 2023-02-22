import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Festival
{
    int[] currentVisitorsPerAct;
    ArrayList<Ticket> tickets;
    
    Festival(int nrOfActs){
        currentVisitorsPerAct = new int[nrOfActs];
        tickets = new ArrayList<>();
    }
    
    public int nrOfTickets(){
        return tickets.size();
    }
    
    public int[] getCurrentVisitorsPerAct(){
        return currentVisitorsPerAct;
    }
    
    public boolean addTicket(Ticket t){
        boolean present = false;
        for(Ticket j: tickets){
            if(t.nationalNumber == j.nationalNumber){
                present = true;
            }
        }
        if(!tickets.contains(t) && !present){
        if(t.complete){
        tickets.add(t);
        for(int i=0; i<t.actCounter; i++){
            currentVisitorsPerAct[t.acts[i]]++;
        }
        return true;
        }
        return false;
        }
        return false;
    }
    
    public float removeTicket(Ticket t){
        if(tickets.contains(t)){
        for(Ticket r: tickets){
            if(t.equals(r)){
                tickets.remove(t);
                for(int i=0; i<t.actCounter; i++){
            currentVisitorsPerAct[t.acts[i]]--;
            }
            if(!t.VIP){
                return 20;
            }   
            }
        }
        }
        return 0;
    }
    
    public int mostPopularAct(){
        int k=-1;
        for(int i=0; i<currentVisitorsPerAct.length;i++){
            if(currentVisitorsPerAct[i]>0 && currentVisitorsPerAct[i]>k){
                k = currentVisitorsPerAct[i];
            }
        }
        for (int j=0; j<currentVisitorsPerAct.length;j++){
            if(currentVisitorsPerAct[j]==k){
                return j;
            }
        }
        
        return -1;
    }
    
    public boolean doWeHaveABirthday(String date){
        for(Ticket t: tickets){
            String[] s = t.nationalNumber.split("-");
            if(s[0].equals(date)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Ticket> importBackup(String fileName){
        ArrayList<Ticket> newTickets = new ArrayList<>();
        try
        {
            int index = 0;
            Scanner sc = new Scanner(new File(fileName)).useLocale(Locale.ENGLISH);
            while (sc.hasNext()) 
            {
                String name = sc.next();
                String national = sc.next();
                Ticket t = new Ticket(name, national);
                int act=sc.nextInt();
                while(act!=-1){
                t.addAct(act);
                act=sc.nextInt();
                }
                t.setComplete();
                newTickets.add(t);
            }
            sc.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File " + fileName + " not found");
        }
        
        return newTickets;
    }
}



/*
         try
        {
            Scanner sc = new Scanner(new File(fileName)).useLocale(Locale.ENGLISH);
            while (sc.hasNext()) 
            {
                // Your code goes here
            }
            sc.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File " + fileName + " not found");
        }

 */