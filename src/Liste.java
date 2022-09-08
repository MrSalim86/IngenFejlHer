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
}
