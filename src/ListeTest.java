import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest
{
    Liste liste = new Liste();
    Node n = new Node("hej");
    Node n1 = new Node("med");
    Node n2 = new Node("dig");


    @BeforeEach
    void setUp()
    {
        liste.insertFromhead(n);
        liste.insertFromhead(n1);
        liste.insertFromhead(n2);
    }

    @Test
    void insertFromhead()
    {

        assertEquals("hej",liste.tail.data);
        assertEquals("med",liste.tail.previous.data);
        assertEquals("dig",liste.tail.previous.previous.data);


    }

    @Test
    void printFromHead()
    {

       assertEquals("dig med hej",liste.printFromHead());

    }

    @Test
    void printFromTail()
    {

        assertEquals("hej med dig",liste.printFromTail());
    }
}