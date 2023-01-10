package fop.w5dll;

public class IntDoubleListElement {
    private int info;
    public IntDoubleListElement next;
    public IntDoubleListElement prev;

    public void setPrev(IntDoubleListElement prev) {
        this.prev = prev;
    }

    public void setNext(IntDoubleListElement next) {

        this.next = next;
    }

    public void setInfo(int info) {

        this.info = info;
    }

    public IntDoubleListElement getPrev() {

        return prev;
    }

    public IntDoubleListElement getNext() {

        return next;
    }

    public IntDoubleListElement(int info) {
        this.info = info;
        next = null;
        prev = null;
    }

    public int getInfo() {
        return info;
    }

    boolean isEqual(IntDoubleListElement other){
        if(this.getInfo() == other.getInfo()){
            return true;
        }else return false;
    }
}
