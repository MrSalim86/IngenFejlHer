public class Liste {


    Node head = null;
    Node tail = null;

    public Liste() {
    }

    public Liste(String s) {
        String[] strings = s.split(" ");

        for (String string : strings) {

            insertFromhead(new Node(string));

        }

    }

    public boolean isEmpty() {

        return head == null && tail == null;
    }

    public boolean onlyOne() {
        return head == tail && head != null;
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

    public String printFromHead() {
        Node n = head;
        StringBuilder stringBuilder = new StringBuilder();

        while (n != null) {

            stringBuilder.append(n.data + " ");
            n = n.next;
        }
        return stringBuilder.toString().trim();
    }

    public String printFromTail() {
        Node n = tail;

        StringBuilder stringBuilder = new StringBuilder();

        while (n != null) {

            stringBuilder.append(n.data + " ");

            n = n.previous;
        }
        return stringBuilder.toString().trim();
    }

    public Node insetFromTail(Node n) {
        if (isEmpty()) {

            tail = n;
            head = n;
            return tail;
        }

        n.previous = tail;
        tail.next = n;
        tail = n;
        return tail;

    }

    public Node insertFromhead(String s) {
        return insertFromhead(new Node(s));
    }

    public Node insertFromTail(String s) {
        return insetFromTail(new Node(s));
    }

    public Node findeNode(String s) {
        Node n = head;
        while (n != null) {

            if (n.data.equalsIgnoreCase(s)) {
                return n;
            }
            n = n.next;
        }

        return null;
    }


    public Node removeFromHead() {
        if (isEmpty()) {
            return null;
        }
        if (onlyOne()) {

            Node res = head;
            head = null;
            tail = null;
            return res;
        }

        // der flere elemter en et i listen

        Node res = head;

        head = head.next;
        head.previous.next = null; // her slette jeg ref fra min gamle head til nye.
        head.previous = null;  // det er min gamle head

        return res;

    }

    public Node removeFromTail() {
        if (isEmpty()) {
            return null;
        }


        if (onlyOne()) {

            Node res = head;

            head = null;
            tail = null;

            return res;
        }
        Node res = tail;

        tail = tail.previous; // flytter tail frem i listen til næste sidte knude
        tail.next.previous = null; //fjerne ref fra gammel tail til nu;
        tail.next = null;      // fjerne ref fra ny tail til gammel tail.
        return res;
    }
}
