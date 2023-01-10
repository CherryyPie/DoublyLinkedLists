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
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }

        } else {
            for (int i = 0; i < pos - 1; i++) {
                elem = elem.next;
            }
            elem.next = elem.next.next;
            if (elem.next == null) {
                tail = elem;
            } else elem.next.prev = elem;
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

    public boolean isEqual(IntDoubleList other) {
        if (other == null) return false;
        else if (this.size() == other.size()) {
            if (this.size() == 0) return true;
            IntDoubleListElement firstList = this.head;
            IntDoubleListElement secondList = other.head;
            while (firstList != null && secondList != null) {
                if (firstList.getInfo() != secondList.getInfo()) return false;
                firstList = firstList.next;
                secondList = secondList.next;
            }
            return true;
        }
        return false;
//        if (other == null) return false;
//
//        else if (this.size() == other.size()) {
//            if (this.size() == 0) return true;
//
//            IntDoubleListElement elem1 = this.head;
//            IntDoubleListElement elem2 = other.head;
//            while (elem1 != null && elem2 != null) {
//                if (elem1.getInfo() != elem2.getInfo())
//                    return false;
//
//                elem1 = elem1.next;
//                elem2 = elem2.next;
//            }
//            return true;
//        }
//        return false;
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
        IntDoubleListElement elem = head;
        IntDoubleListElement elem2 = head;
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            if (elem.getInfo() == intValue) {
                count++;
            }
            elem = elem.next;
        }
        IntDoubleListElement[] arr = new IntDoubleListElement[count];
        for (int i = 0; i < this.size(); i++) {
            if (elem2.getInfo() == intValue) {
                break;
            }
            elem2 = elem2.next;
        }

        Arrays.fill(arr, elem2);
        return arr;
    }
}
