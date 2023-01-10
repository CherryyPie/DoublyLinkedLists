package fop.w5dll;

public class IntDoubleList {
    private IntDoubleListElement head;
    private IntDoubleListElement tail;

    public IntDoubleList() {
        head = null;
        tail = null;
    }

    public void setTail(IntDoubleListElement tail) {
        this.tail = tail;
    }

    public void setHead(IntDoubleListElement head) {
        this.head = head;
    }

    public IntDoubleListElement getTail() {
        return tail;
    }

    public IntDoubleListElement getHead() {
        return head;
    }

    public int getLastElement() {
        return tail.getInfo();
    }

    public int getFirstElement() {
        return head.getInfo();
    }


    public void append(int info) {
        IntDoubleListElement elem = new IntDoubleListElement(info);
        if (head == null && tail == null) {
            head = elem;
            tail = elem;
        } else {
            tail.next = elem;
            elem.prev = tail;
            tail = elem;
        }
    }

    public int size() {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public int get(int pos) {
        if (pos == 0) {
            return head.getInfo();
        } else {
            for (int i = 0; i < pos; i++) {
                head = head.next;
            }
        }
        return head.getInfo();
    }

    public void remove(int pos) {
        if (pos == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }

        }else {
            IntDoubleListElement elem = head;
            for (int i = 0; i < pos-1; i++) {
                elem = elem.next;
            }
            elem.next = elem.next.next;
            if (elem.next == null){
                tail = elem;
            }else elem.next.prev = elem;
        }
    }
}
