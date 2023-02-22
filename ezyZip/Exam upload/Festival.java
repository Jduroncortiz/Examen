import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Festival
{
    int[] currentVisitorsPerAct;
    ArrayList<Ticket> ticketList;
    
    public Festival(int nrOfActs)
    {
        currentVisitorsPerAct = new int[nrOfActs];
        ticketList = new ArrayList<Ticket>();
    }
    
    public int nrOfTickets()
    {
        return ticketList.size();
    }
    
    public int[] getCurrentVisitorsPerAct()
    {
        return currentVisitorsPerAct;
    }
    
    public boolean addTicket(Ticket ticket)
    {
        int[] festivalActs = ticket.getActs();
        // String natNumber = ticket.getNatNumber();
        for (Ticket id : ticketList)
        {
            if(id.getNatNumber() == ticket.getNatNumber())
            {
                return false;
            }
            
        }
        if(ticket.getComplete()==true)
        {
            ticketList.add(ticket);
            for(int i = 0; i < ticket.getActCounter(); i++)
            {
                int act = festivalActs[i];
                currentVisitorsPerAct[act] += 1;
            }
            return true;
        }
        return false;
    }
    
    public float removeTicket(Ticket ticket)
    {
        if(ticketList.contains(ticket) == true)
        {
            if(ticket.getActs().length!=0)
            {
                ticketList.remove(ticket);
                int[] festivalActs = ticket.getActs();
                for(int i = 0; i < ticket.getActCounter(); i++)
                {
                    int act = festivalActs[i];
                    currentVisitorsPerAct[act] -= 1;
                }
                return 20.0f;
            }
            else
            {
                return 0.0f;
            }
        }
        return 0.0f;
    }
    
    public int mostPopularAct()
    {
        int mostPopular = 0;
        int maxVisitors = currentVisitorsPerAct[0];
        if(ticketList.size() == 0)
        {
            return -1;
        }
        else 
        {
            for(int i = 0; i<currentVisitorsPerAct.length; i++)
            {
                if(currentVisitorsPerAct[i] > maxVisitors)
                {
                    maxVisitors = currentVisitorsPerAct[i];
                    mostPopular = i;
                }
            }
            
        }
        return mostPopular;
    }
    
    public boolean doWeHaveABirthday(String date)
    {
        boolean check = false;
        for (Ticket id : ticketList)
        {
            String natNumber = id.getNatNumber();
            char[] dateToCompare = new char[date.length()];
            char[] birthNumber = new char[date.length()];
            for (int i = 0; i< date.length(); i++)
            {
                dateToCompare[i] = date.charAt(i);
                birthNumber[i] = natNumber.charAt(i);
            }
            for (int j = 0; j<dateToCompare.length; j++)
            {
                if(birthNumber[j] == dateToCompare[j])
                {
                    check = true;
                }
                else
                {
                    check = false;
                }
            }
        }
        return check;
    }
    
        
    public ArrayList<Ticket> importBackup(String fileName)
    {
        String name = "";
        String natNumber = "";
        int actNr = 0;
        ArrayList<Ticket> newTicketList = new ArrayList<Ticket>();
        Ticket newTicket;
        try
        {
            Scanner sc = new Scanner(new File(fileName)).useLocale(Locale.ENGLISH);
            while (sc.hasNext()) 
            {
                // Your code goes here
                name = sc.next();
                natNumber = sc.next();
                newTicket = new Ticket(name, natNumber);
                actNr = sc.nextInt();
                while (actNr != -1)
                {
                    newTicket.addAct(actNr);
                    actNr = sc.nextInt();
                }
                newTicket.setComplete();
                newTicketList.add(newTicket);
            }
            sc.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File " + fileName + " not found");
            return null;
        }
        return newTicketList;
    
 
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