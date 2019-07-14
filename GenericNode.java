import java.io.Serializable;

public class GenericNode <T extends Serializable> implements Serializable {
    private T elem;
    private GenericNode <T> next;
    //constructor-------------------------------------------------------------------------------------------------------------------
    public GenericNode(T elem, GenericNode <T> next) {
        this.elem = elem;
        this.next = next;
    }
    //set e get---------------------------------------------------------------------------------------------------------------------
    public void setElem(T elem) {this.elem = elem;}

    public T getElem(){return elem;}

    public void setNext(GenericNode <T> next) {this.next = next;}

    public GenericNode <T> getNext() {return next;}
    //Methods-----------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------------------
}
