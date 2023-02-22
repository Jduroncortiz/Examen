public class VIPTicket extends Ticket
{
     // Your code goes here.   
     public VIPTicket(String visitorName, String visitorNumber, boolean wantToMeetAndGreet)
     {
         super(visitorName, visitorNumber);
         if(wantToMeetAndGreet == true)
         {
             price += 50;
         }
     }
}
