import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest
{

    Liste tomListe = new Liste();
    Liste liste = new Liste();
    Node n = new Node("hej");
    Node n1 = new Node("med");
    Node n2 = new Node("dig");

    Node b = new Node("hej");
    Node b1 = new Node("med");
    Node b2 = new Node("dig");


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

    @Test
    void indsætbagfra()
    {
        liste.insetFromTail(b);
        assertEquals("hej",liste.insetFromTail(b).data);
        assertEquals("med",liste.insetFromTail(b1).data);
        assertEquals("dig",liste.insetFromTail(b2).data);

        assertEquals("dig",liste.tail.data);
        assertEquals("med",liste.tail.previous.data);
        assertEquals("hej",liste.tail.previous.previous.data);


    }

    @Test
    void smartconstructor()
    {
        Liste liste1 = new Liste("det er smart det her");
        Liste liste2 = new Liste("palle");

        assertEquals("det er smart det her", liste1.printFromTail());
        assertEquals("palle", liste2.printFromTail());

    }

    @Test
    void smartindsæt_head()
    {
        assertEquals("hej",tomListe.insertFromhead("hej").data);
        assertEquals("med",tomListe.insertFromhead("med").data);
        tomListe.insertFromhead("dig");
        assertEquals("hej med dig", tomListe.printFromTail());
    }

    @Test
    void smartInsertFromTail()
    {
        assertEquals("hej",tomListe.insetFromTail("hej").data);
        assertEquals("med",tomListe.insetFromTail("med").data);
        tomListe.insetFromTail("dig");
        assertEquals("hej med dig", tomListe.printFromHead());
    }
}