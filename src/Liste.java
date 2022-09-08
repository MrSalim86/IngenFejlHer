public class Liste
{

    Node head = null;
    Node tail = null;

    public boolean isEmpty() {

        return head == null && tail == null;
    }

    public Node insertFromhead(Node n) {

        if (isEmpty()) {
            head = n;
            tail = n;
            return head;
        }

        n.next = head;
        head.previous = n;
        head = n;
        return head;

    }
    public String printFromHead()
    {
        Node n = head;
        StringBuilder stringBuilder = new StringBuilder();

        while (n != null) {

            stringBuilder.append(n.data + " ");
            n = n.next;
        }
        return stringBuilder.toString().trim();
    }
    public String printFromTail()
    {
        Node n = tail;

        StringBuilder stringBuilder = new StringBuilder();

        while (n != null) {

            stringBuilder.append(n.data + " ");

            n = n.previous;
        }
        return stringBuilder.toString().trim();
    }
}
