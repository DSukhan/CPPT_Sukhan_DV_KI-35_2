package KI35.Sukhan.Lab7;
import java.util.*;
/**
* Клас GarbageCan реалізує Бак для сміття
*
* @author Sukhan Denys
* @version 1.0
* @since version 1.0
*
*/
public class GarbageCan<T extends Item> {
    private ArrayList<T> arr;
    /**
    *Constructor
    */ 
    public GarbageCan() {
        arr = new ArrayList<T>();
    }

    /** 
     * Method шукає максимальний розмір 
     * @return T
     */
    public T findMax() {
        if (!arr.isEmpty()) {
            T max = arr.get(0);
                for (int i=1; i< arr.size(); i++) {
                    if ( arr.get(i).compareTo(max) > 0 ) max = arr.get(i);
                }
            return max;
        }
        return null;
    }

    
    /** 
     * Method додає річ до Баку для сміття
     * @param data
     */
    public void addItem(T data) {
        arr.add(data);
        System.out.print("This Item is added to the Garbage can: ");
        data.print();
    }

    
    /**
     * Method видаляє річ від Баку для сміття
     * @param i
     */
    public void deleteItem(int i) {
        System.out.print("This Item is deleted from the Garbage can: ");
        arr.get(i).print();
        arr.remove(i);
    }

    /**
     * Method показує усі речі з  Баку для сміття
     */
    public void showUnits() {
        if (!arr.isEmpty()) {
            System.out.print("Garbage can Items :\n");
            for (int i=0; i< arr.size(); i++) {
                arr.get(i).print();
            }
        }
        else  System.out.print("Garbage can hasn't Items.\n");
    }
}
