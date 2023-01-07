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

    public IntDoubleListElement getLastElement() {
        return tail;
    }

    public IntDoubleListElement getFirstElement() {
        return head;
    }

    public IntDoubleListElement getFirst() {
        return head;
    }

    public IntDoubleListElement LastElement() {
        return tail;
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
}
