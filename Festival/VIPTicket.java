public class VIPTicket extends Ticket
{
    VIPTicket(String v, String n, boolean t){
        super(v,n);
        VIP = true;
        if(t==true){
            price+=50;
        }
    }
}
