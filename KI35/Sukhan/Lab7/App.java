package KI35.Sukhan.Lab7;
/**
* Клас App реалізує програму-драйвер
*
* @author Sukhan Denys
* @version 1.0
* @since version 1.0
*
*/
public class App {
    /** 
     * @param args
     */
    public static void main(String[] args) {
        GarbageCan <? super Item> garbageCan = new GarbageCan <Item>();

        garbageCan.addItem(new CanForGlass("Plate", 20));
        garbageCan.addItem(new CanForPlastic("Bottle" , 35));
        garbageCan.addItem(new CanForPlastic("Chair" , 68));
        garbageCan.addItem(new CanForGlass("Window", 75));

        Item res = garbageCan.findMax();
        System.out.print("The max size in Garbage can : \n");
        res.print();
    }
}
