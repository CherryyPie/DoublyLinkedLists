package fop.w5dll;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;

public class IntDoubleList {
    private IntDoubleListElement head;
    private IntDoubleListElement tail;

    public IntDoubleList() {
        head = null;
        tail = null;
    }


    public IntDoubleListElement getLastElement() {

        return tail;
    }

    public IntDoubleListElement getFirstElement() {

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
            tail = elem;
        }
    }

    public int size() {
        IntDoubleListElement elem = head;
        int count = 0;
        while (elem != null) {
            elem = elem.next;
            count++;
        }
        return count;
    }

    public int get(int pos) {
        IntDoubleListElement elem = head;
        if (pos < 0 || pos >= this.size()) {
            System.out.println("Invalid input");
            return 0;
        }
        if (pos == 0) {
            return head.getInfo();
        } else {
            for (int i = 0; i < pos; i++) {
                elem = elem.next;
            }
        }
        return elem.getInfo();
    }

    public void remove(int pos) {
        IntDoubleListElement elem = head;
        if (pos < 0 || pos >= this.size()) {
            System.out.println("Invalid input");
        }
        if (pos == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }

        } else if (pos == this.size() - 1) {
            tail = tail.prev;
            if (tail.prev != null) tail.next = null;
        } else {
            for (int i = 0; i < pos; i++) {
                elem = elem.next;
                elem.prev.next = elem.next;
                elem.next.prev = elem.prev;
            }
        }
    }

    public String toString() {
        if (this.size() == 0) return "";
        StringBuilder str = new StringBuilder();
        IntDoubleListElement elem = head;
        while (elem != null) {
            if (elem.next == null) {
                str.append(elem.getInfo());
                break;
            }
            str.append(elem.getInfo()).append(",");
            elem = elem.next;
        }
        return str.toString();
    }

    boolean isEqual(IntDoubleList other) {
        if (other == null) return false;
        if (this.size() == other.size()) {
            if (this.size() == 0) return true;
        }
        if (this.size() != other.size()) {
            return false;
        }
        IntDoubleListElement elem1 = this.head;
        IntDoubleListElement elem2 = other.head;
        while (elem1 != null && elem2 != null) {
            if (elem1.getInfo() != elem2.getInfo()) {
                return false;
            }
            elem1 = elem1.next;
            elem2 = elem2.next;
        }
        return true;
    }

    public int sum() {
        IntDoubleListElement curr = head;
        int sum = 0;
        for (int i = 0; i < this.size(); i++) {
            sum += curr.getInfo();
            curr = curr.next;
        }
        return sum;
    }

    public IntDoubleList copy() {
        IntDoubleList newList = new IntDoubleList();
        IntDoubleListElement curr = head;
        for (int i = 0; i < this.size(); i++) {
            newList.append(curr.getInfo());
            curr = curr.next;
        }
        return newList;
    }

    public IntDoubleListElement[] search(int intValue) {

        IntDoubleListElement[] searchResults = new IntDoubleListElement[this.size()];
        int index = 0;
        IntDoubleListElement currentElement = head;
        while (currentElement != null) {
            if (currentElement.getInfo() == intValue) {
                searchResults[index] = currentElement;
                index++;
            }
            currentElement = currentElement.next;
        }
        IntDoubleListElement[] finalResults = new IntDoubleListElement[index];
        for (int i = 0; i < index; i++) finalResults[i] = searchResults[i];
        return finalResults;
    }
}
