import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import java.util.ArrayList;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FestivalTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    /*
     * Test 1: Constructor and getters and setters of Ticket.
     */
    
    
    @Test
    public void test01()
    {
        Ticket e1 = new Ticket("Bob", "19960523-123");
        assertEquals("Bob", e1.getName());
        assertFalse(e1.getComplete());
        assertEquals(0, e1.getActCounter());
    }
    // */

    /*
     * Test 2: Methods addAct() and calculatePrice()
     **/
     
     
    @Test
    public void test02()
    {
        Ticket e1 = new Ticket("Bob", "19960523-123");
        assertEquals(0.0f, e1.getPrice(), 0.1f);
        assertTrue(e1.addAct(5));
        assertTrue(e1.addAct(9));
        assertEquals(30.0f, e1.getPrice(), 0.1f);
        assertTrue(e1.addAct(4));
        assertTrue(e1.addAct(7));
        assertEquals(37.5f, e1.getPrice(), 0.1f);
        assertTrue(e1.addAct(12));
        assertTrue(e1.addAct(8));
        assertEquals(50.0f, e1.getPrice(), 0.1f);
        assertTrue(e1.addAct(1));
        assertTrue(e1.addAct(6));
        assertEquals(60.0f, e1.getPrice(), 0.1f);
        assertTrue(e1.addAct(2));
        assertTrue(e1.addAct(11));
        assertEquals(70.0f, e1.getPrice(), 0.1f);
        assertFalse(e1.addAct(3));
        assertTrue(e1.getComplete());
        assertEquals(5, e1.getActs()[0]);
        assertEquals(7, e1.getActs()[3]);
    }
    // */

    /*
     * Test 3: Constructor of Festival.
     */
    
    
    @Test
    public void test03()
    {
        Festival summer = new Festival(15);
        assertEquals(0, summer.nrOfTickets());
        assertEquals(15, summer.getCurrentVisitorsPerAct().length);
        Festival dour = new Festival(156);
        assertEquals(156, dour.getCurrentVisitorsPerAct().length);
    }  
    // */
   
    /*
     * Test 4: Adding acts without restrictions.
     **/
     
     
    @Test
    public void test04()
    {
        Ticket e1 = new Ticket("Bob", "19960523-123");
        assertTrue(e1.addAct(5));
        assertTrue(e1.addAct(9));
        assertTrue(e1.addAct(4));
        assertTrue(e1.addAct(7));
        assertTrue(e1.addAct(12));
        assertTrue(e1.addAct(8));
        assertTrue(e1.addAct(1));
        assertTrue(e1.addAct(6));
        assertTrue(e1.addAct(2));
        assertTrue(e1.addAct(11));
        Festival summer = new Festival(15);
        assertEquals(0, summer.getCurrentVisitorsPerAct()[5]);
        assertTrue(summer.addTicket(e1));
        assertEquals(1, summer.getCurrentVisitorsPerAct()[5]);
        assertEquals(1, summer.nrOfTickets());
        Ticket e2 = new Ticket("Liz", "19970303-103");
        assertTrue(e2.addAct(5));
        assertTrue(e2.addAct(9));
        assertTrue(e2.addAct(4));
        e2.setComplete();
        assertTrue(summer.addTicket(e2));
        assertEquals(2, summer.nrOfTickets());
        assertEquals(2, summer.getCurrentVisitorsPerAct()[5]);
    }
    // */

    /*
     * Test 5: Rejection of incomplete tickets.
     **/
     
     
    @Test
    public void test05()
    {
        Ticket e1 = new Ticket("Bob", "19960523-123");
        assertTrue(e1.addAct(5));
        assertTrue(e1.addAct(9));
        assertTrue(e1.addAct(4));
        assertTrue(e1.addAct(7));
        assertTrue(e1.addAct(12));
        assertTrue(e1.addAct(8));
        assertTrue(e1.addAct(1));
        assertTrue(e1.addAct(6));
        assertTrue(e1.addAct(2));
        assertTrue(e1.addAct(11));
        Festival summer = new Festival(15);
        assertTrue(summer.addTicket(e1));
        assertEquals(1, summer.nrOfTickets());
        Ticket e2 = new Ticket("Liz", "19970303-103");
        assertTrue(e2.addAct(5));
        assertTrue(e2.addAct(9));
        assertTrue(e2.addAct(4));
        assertFalse(summer.addTicket(e2));
        assertEquals(1, summer.nrOfTickets());    
    }
    // */

    /*
     * Test 6: Rejection of double bookings.
     **/
     
     
    @Test
    public void test06()
    {
        Ticket e1 = new Ticket("Bob", "19960523-123");
        assertTrue(e1.addAct(5));
        assertTrue(e1.addAct(9));
        assertTrue(e1.addAct(4));
        assertTrue(e1.addAct(7));
        assertTrue(e1.addAct(12));
        assertTrue(e1.addAct(8));
        assertTrue(e1.addAct(1));
        assertTrue(e1.addAct(6));
        assertTrue(e1.addAct(2));
        assertTrue(e1.addAct(11));
        Festival summer = new Festival(15);
        assertTrue(summer.addTicket(e1));
        assertEquals(1, summer.nrOfTickets());
        Ticket e2 = new Ticket("Liz", "19970303-103");
        assertTrue(e2.addAct(5));
        assertTrue(e2.addAct(9));
        assertTrue(e2.addAct(4));
        e2.setComplete();
        assertTrue(summer.addTicket(e2));
        assertEquals(2, summer.nrOfTickets());    
        Ticket e3 = new Ticket("Sue", "19920309-003");
        assertTrue(e3.addAct(5));
        assertTrue(e3.addAct(8));
        assertTrue(e3.addAct(3));
        e3.setComplete();
        assertTrue(summer.addTicket(e3));
        assertEquals(3, summer.nrOfTickets());    
        Ticket e4 = new Ticket("Lizzy", "19970303-103");
        assertTrue(e4.addAct(5));
        e4.setComplete();
        assertFalse(summer.addTicket(e4));
        assertEquals(3, summer.nrOfTickets());    
    }
    // */

    /*
     * Test 7: Removal of tickets.
     */
    
    
    @Test
    public void test07()
    {
        Ticket e1 = new Ticket("Bob", "19960523-123");
        assertTrue(e1.addAct(5));
        assertTrue(e1.addAct(9));
        assertTrue(e1.addAct(4));
        assertTrue(e1.addAct(7));
        assertTrue(e1.addAct(12));
        assertTrue(e1.addAct(8));
        assertTrue(e1.addAct(1));
        assertTrue(e1.addAct(6));
        assertTrue(e1.addAct(2));
        assertTrue(e1.addAct(11));
        Festival summer = new Festival(15);
        assertTrue(summer.addTicket(e1));
        assertEquals(1, summer.nrOfTickets());
        Ticket e2 = new Ticket("Liz", "19970303-103");
        assertTrue(e2.addAct(5));
        assertTrue(e2.addAct(9));
        assertTrue(e2.addAct(4));
        e2.setComplete();
        assertTrue(summer.addTicket(e2));
        assertEquals(2, summer.nrOfTickets());    
        Ticket e3 = new Ticket("Sue", "19920309-003");
        assertTrue(e3.addAct(5));
        assertTrue(e3.addAct(8));
        assertTrue(e3.addAct(3));
        e3.setComplete();
        assertTrue(summer.addTicket(e3));
        assertEquals(3, summer.nrOfTickets());    
        Ticket e4 = new Ticket("Lizzy", "19970303-103");
        assertEquals(20.0f, summer.removeTicket(e2), 0.1f);
        assertEquals(2, summer.nrOfTickets());
        assertEquals(2, summer.getCurrentVisitorsPerAct()[5]);
        assertEquals(0.0f, summer.removeTicket(e4), 0.1f);        
        assertEquals(2, summer.nrOfTickets());
    }
    // */
    
    /*
     * Test 8: Checks mostPopularAct().
     */
    
    
    @Test
    public void test08()
    {
        Festival summer = new Festival(15);
        assertEquals(-1, summer.mostPopularAct());
        Ticket e1 = new Ticket("Bob", "19960523-123");
        assertTrue(e1.addAct(5));
        assertTrue(e1.addAct(9));
        assertTrue(e1.addAct(4));
        assertTrue(e1.addAct(7));
        assertTrue(e1.addAct(12));
        assertTrue(e1.addAct(8));
        assertTrue(e1.addAct(1));
        assertTrue(e1.addAct(6));
        assertTrue(e1.addAct(2));
        assertTrue(e1.addAct(11));
        assertTrue(summer.addTicket(e1));
        assertEquals(1, summer.nrOfTickets());
        Ticket e2 = new Ticket("Liz", "19970303-103");
        assertTrue(e2.addAct(5));
        assertTrue(e2.addAct(9));
        assertTrue(e2.addAct(4));
        e2.setComplete();
        assertTrue(summer.addTicket(e2));
        assertEquals(2, summer.nrOfTickets());    
        Ticket e3 = new Ticket("Sue", "19920309-003");
        assertTrue(e3.addAct(5));
        assertTrue(e3.addAct(8));
        assertTrue(e3.addAct(3));
        e3.setComplete();
        assertTrue(summer.addTicket(e3));
        assertEquals(3, summer.nrOfTickets());
        assertEquals(5, summer.mostPopularAct());
    }
    // */
       
    /*
     * Test 9: Importing tickets from file.
     */
    
    
    @Test
    public void test09()
    {
        Festival summer = new Festival(15);
        ArrayList<Ticket> newTickets = new ArrayList<Ticket>();
        newTickets = summer.importBackup("visitors.txt");
        
        assertEquals("Bob", newTickets.get(0).getName());
        assertEquals("Sue", newTickets.get(2).getName());
        assertEquals(10, newTickets.get(1).getActCounter());
        assertEquals(1, newTickets.get(2).getActCounter());
        assertNotEquals("Sarah", newTickets.get(1).getName());
    }
    // */
    
    /*
     * Test 10: checks if a visitor has a birthday.
     */
    
    
    @Test
    public void test10()
    {
        Festival summer = new Festival(15);
        
        Ticket e1 = new Ticket("Bob", "19960523-123");
        assertTrue(e1.addAct(5));
        assertTrue(e1.addAct(9));
        assertTrue(e1.addAct(4));
        assertTrue(e1.addAct(7));
        assertTrue(e1.addAct(12));
        assertTrue(e1.addAct(8));
        assertTrue(e1.addAct(1));
        assertTrue(e1.addAct(6));
        assertTrue(e1.addAct(2));
        assertTrue(e1.addAct(11));
        assertTrue(summer.addTicket(e1));
        assertEquals(1, summer.nrOfTickets());
        
        Ticket e2 = new Ticket("Liz", "19970303-103");
        assertTrue(e2.addAct(5));
        assertTrue(e2.addAct(9));
        assertTrue(e2.addAct(4));
        e2.setComplete();
        assertTrue(summer.addTicket(e2));
        assertEquals(2, summer.nrOfTickets());
        
        assertTrue(summer.doWeHaveABirthday("19970303"));
        assertFalse(summer.doWeHaveABirthday("19920310"));
        assertFalse(summer.doWeHaveABirthday("19920311"));
    }
    // */
   
    /*
     * Test 11: Construction and basic functionality of VIP Ticket.
     */
    
    
    @Test
    public void test11()
    {
        VIPTicket vipOne = new VIPTicket("Donald", "19600325-666", true);
        VIPTicket vipTwo = new VIPTicket("Minnie", "19600325-666", false);
        assertEquals(50.0f, vipOne.getPrice(), 0.1f);
        assertEquals(0.0f, vipTwo.getPrice(),0.1f);
        
        assertThat(vipOne, instanceOf(Ticket.class));
        assertThat(vipTwo, instanceOf(Ticket.class));
    }
// */
}