import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Festival
{
    private int[] currentVisitorsPerAct;
    private ArrayList<Ticket> ticketList;
    
    public Festival(int nrOfActs)
    {
        currentVisitorsPerAct = new int[nrOfActs];
        ticketList = new ArrayList<Ticket>();
    }
    
    public boolean addTicket(Ticket ticket)
    {
        int[] acts = ticket.getActs();
        for(Ticket ticket1 : ticketList)
        {
            String nationalNumInList = ticket1.getNatNum();
            if(nationalNumInList.equals(ticket.getNatNum()))
            {
                return false;
            }
        }
        if(ticket.getComplete()==true)
        {
            ticketList.add(ticket);
            for(int i = 0; i<ticket.getActCounter();i++)
            {
                int id = acts[i];
                currentVisitorsPerAct[id] += 1;
            }
            return true;
        }
        return false;
    }
    
    public float removeTicket(Ticket ticket)
    {
        if(ticketList.contains(ticket))
        {
            ticketList.remove(ticket);
            int[] acts = ticket.getActs();
            for(int i = 0; i<ticket.getActCounter();i++)
            {
                int id = acts[i];
                currentVisitorsPerAct[id] -= 1;
            }
            return 20.0f;
        }
        return 0.0f;
    }
    
    public int mostPopularAct()
    {
        int visitorsFirstAct = currentVisitorsPerAct[0];
        int maxVisitors = visitorsFirstAct;
        if(nrOfTickets() == 0)
        {
            return -1;
        }
        int mostPopularAct = 0;
        for(int i = 0; i<currentVisitorsPerAct.length;i++)
        {
            if(currentVisitorsPerAct[i] > maxVisitors)
            {
                maxVisitors = currentVisitorsPerAct[i];
                mostPopularAct = i;
            }
        }
        return mostPopularAct;
    }

    public ArrayList<Ticket> importBackup(String fileName)
    {
        try
        {
            Scanner sc = new Scanner(new File(fileName)).useLocale(Locale.ENGLISH);
            ArrayList<Ticket> ticketsNew = new ArrayList<Ticket>();
            while (sc.hasNext()) 
            {
                ArrayList<String> ticketData = new ArrayList<String>();
                String nextLine = sc.next();
                while(nextLine.equals("-1")==false)
                {
                    ticketData.add(nextLine);
                    nextLine = sc.next();
                }
                Ticket newTicket = new Ticket(ticketData.get(0),ticketData.get(1));
                for(int i = 2;i<ticketData.size();i++)
                {
                    int actId = Integer.parseInt(ticketData.get(i));
                    newTicket.addAct(actId);
                }
                ticketsNew.add(newTicket);
            }
            sc.close();
            return ticketsNew;
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File " + fileName + " not found");
            return null;
        }
    }
    
    public int nrOfTickets()
    {
        return ticketList.size();
    }
    
    public int[] getCurrentVisitorsPerAct()
    {
        return currentVisitorsPerAct;
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