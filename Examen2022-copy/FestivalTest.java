import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FestivalTest
{
    /**
     * Default constructor for test class FestivalTest
     */
    public FestivalTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void test0(){
        Festival festival = new Festival(10);
        assertEquals(10, festival.getNrOfActs());
    }
    
    @Test
    public void test1(){
        Ticket ticket = new Ticket("Tony", "19891011-36");
        assertEquals("Tony", ticket.getName());
        assertEquals("19891011-36", ticket.getNatNumber());
        assertEquals(0, ticket.getPrice(),0.1f);
        assertEquals(false, ticket.getComplete());
    }
    
    @Test
    public void test2(){
        Ticket ticket = new Ticket("Tony", "19891011-36");
        assertEquals(true, ticket.addAct(5));
        assertEquals(45.0f, ticket.getPrice());
        //assertEquals("Tony", ticket.getName());
        //assertEquals("19891011-36", ticket.getNatNumber());
        //assertEquals(0, ticket.getPrice(),0.1f);
        //assertEquals(false, ticket.getComplete());
    }
    
    @Test
    public void test3(){
        Festival festival = new Festival(10);
        assertEquals(10, festival.getNrOfActs());
    }
    
    @Test
    public void test4(){
        boolean addedTicket = false;
        Festival festival = new Festival(10);
        Ticket ticket = new Ticket("Tony","19891011-36");
        try{
            addedTicket = festival.addTicket(ticket);
        }catch(Exception e){
            System.out.println("Error. The ticket was not added");
        }
        assertEquals(true, addedTicket);
    }
    
    /*@Test
    public void test5(){}
    
    @Test
    public void test6(){}
    
    @Test
    public void test7(){}
    
    @Test
    public void test8(){}
    
    @Test
    public void test9(){}
    
    @Test
    public void test10(){}*/
}
