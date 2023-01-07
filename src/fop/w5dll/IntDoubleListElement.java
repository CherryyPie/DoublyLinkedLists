package fop.w5dll;

public class IntDoubleListElement {
	private int info;
    public IntDoubleListElement next;
    public IntDoubleListElement prev;

    public IntDoubleListElement(int info) {
        this.info = info;
        next = null;
        prev = null;
    }

    public int getInfo() {
        return info;
    }
}
