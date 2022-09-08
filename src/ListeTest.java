import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest
{
    Liste liste = new Liste();
    Node n = new Node("hej");
    Node n1 = new Node("med");
    Node n2 = new Node("dig");


    @Test
    void insertFromhead()
    {
        liste.insertFromhead(n);
        assertEquals("hej", liste.insertFromhead(n).data);
        assertEquals("med", liste.insertFromhead(n1).data);
        assertEquals("dig", liste.insertFromhead(n2).data);

        assertEquals("hej",liste.tail.data);
        assertEquals("med",liste.tail.previous.data);
        assertEquals("dig",liste.tail.previous.previous.data);


    }

    @Test
    void printFromHead()
    {
        liste.insertFromhead(n);
        liste.insertFromhead(n1);
        liste.insertFromhead(n2);

       assertEquals("dig med hej",liste.printFromHead());

    }
}