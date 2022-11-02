package KI35.Sukhan.Lab7;
/**
* Інтерфейс Item реалізує методи , які використовують похідні класи
*
* @author Sukhan Denys
* @version 1.0
* @since version 1.0
*
*/
public interface Item extends Comparable<Item> {
    public int getSize();
    public void print();
}
