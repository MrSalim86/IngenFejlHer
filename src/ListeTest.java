import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest
{
    Liste fyldtListe = new Liste("hold da lige op mand hvor er her meget text");
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
        assertEquals("hej",tomListe.insertFromTail("hej").data);
        assertEquals("med",tomListe.insertFromTail("med").data);
        tomListe.insertFromTail("dig");
        assertEquals("hej med dig", tomListe.printFromHead());
    }

    @Test
    void findeNode()
    {
        assertEquals(null,tomListe.findeNode("palle"));

        assertEquals("op",fyldtListe.findeNode("op").data);


    }

    @Test
    void removeNodeFromhead()
    {
        assertEquals(null,tomListe.removeFromHead());
        tomListe.insertFromTail("hej");
        assertEquals("hej",tomListe.removeFromHead().data);
        assertEquals(true,tomListe.isEmpty());

        //"hold da lige op mand hvor er her meget text"

        assertEquals("text",fyldtListe.removeFromHead().data);
        assertEquals("hold da lige op mand hvor er her meget",fyldtListe.printFromTail());
    }

    @Test
    void removeFromTail()
    {
        assertEquals(null, tomListe.removeFromTail());

        tomListe.insertFromTail("hej");
        assertEquals("hej",tomListe.removeFromTail().data);
        assertEquals(true,tomListe.isEmpty());

        fyldtListe.removeFromTail();
        assertEquals("da lige op mand hvor er her meget text",fyldtListe.printFromTail());
    }

    @Test
    void removeNode()
    {
        assertEquals(null,tomListe.removeNode("op"));

        //hold da lige op mand hvor er her meget text
        assertEquals("mand",fyldtListe.removeNode("mand").data);
        assertEquals("hold da lige op hvor er her meget text",fyldtListe.printFromTail());
        assertEquals("hold",fyldtListe.removeNode("hold").data);
        assertEquals("da lige op hvor er her meget text",fyldtListe.printFromTail());

        assertEquals("text",fyldtListe.removeNode("text").data);
        assertEquals("da lige op hvor er her meget",fyldtListe.printFromTail());




    }

    @Test
    void insetAfterNode()

    {
        // new Liste("hold da lige op mand hvor er her meget text"
        assertEquals(null, tomListe.insetAfter("shit","op"));
        assertEquals("shit",fyldtListe.insetAfter("shit", "op").data);
        assertEquals("hold da lige op shit mand hvor er her meget text",fyldtListe.printFromTail());

        tomListe.insertFromhead("første");
        tomListe.insetAfter("nyKnude", "første");
        assertEquals("nyKnude første",tomListe.printFromTail());
    }
}

