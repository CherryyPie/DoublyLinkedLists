package fop.w5dll;

public class IntDoubleListElement {
    private int info;
    public IntDoubleListElement next;
    public IntDoubleListElement prev;


    public void setInfo(int info) {

        this.info = info;
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
        if(other == null) return false;
        if(this.getInfo() == other.getInfo()){
            return true;
        }else return false;
    }
}
