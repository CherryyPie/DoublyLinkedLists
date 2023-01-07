package fop.w5dll;

public class IntDoubleList {
    private IntDoubleListElement head;
    private IntDoubleListElement tail;

    public IntDoubleList() {
        head = null;
        tail = null;
    }

    public IntDoubleListElement getFirstElement() {
        return head;
    }

    public IntDoubleListElement getLastElement() {
        return tail;
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

    public void append(int info) {
        IntDoubleListElement elem = new IntDoubleListElement(info);
        if (head == null && tail == null) {
            head = elem;
            tail = elem;
        } else {
            tail.next = elem;
            elem.prev = tail;
            elem = tail;
        }
    }
	public int size(){
        int count = 0;
        while (head != null){
            head = head.next;
            count++;
        }return count;
    }
}
