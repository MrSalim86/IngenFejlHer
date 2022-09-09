public class Liste
{

    Node head = null;
    Node tail = null;

    public Liste()
    {
    }

    public Liste(String s)
    {
        String [] strings = s.split(" ");

        for (String string : strings) {

            insertFromhead(new Node(string));

        }

    }

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

    public Node insetFromTail(Node n)
    {
        if (isEmpty()){

            tail = n;
            head = n;
            return tail;
        }

        n.previous = tail;
        tail.next = n;
        tail = n;
        return tail;

    }

    public Node insertFromhead(String s)
    {
        return insertFromhead(new Node(s));
    }

}
