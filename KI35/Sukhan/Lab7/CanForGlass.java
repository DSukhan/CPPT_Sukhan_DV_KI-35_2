package KI35.Sukhan.Lab7;
/**
* Клас CanForGlass реалізує річ зі скла
*
* @author Sukhan Denys
* @version 1.0
* @since version 1.0
*
*/
public class CanForGlass implements Item {
    private String GName;
    private int size;

    /**
    *Constructor
    *@param GName
    *@param size
    */ 
    public CanForGlass(String GName, int size) {
        this.GName = GName;
        this.size = size;
    }
    
    /** 
     * Method повертає назву речі зі скла
     * @return String
     */
    public String getGName() {
        return GName;
    }

    
    /**
     * Method встановлює назву речі зі скла
     * @param GName
     */
    public void setGName(String GName) {
        this.GName = GName;
    }

    
    /** 
     * Method встановлює розмір для речі зі скла
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    
    /** 
     * Method повертає розмір  речі зі скла
     * @return int
     */
    public int getSize() {
        return size;
    }

    
    /** 
     * Method порівнює розімр речі зі скла з розміром речі  іншого класу
     * @param p
     * @return int
     */
    public int compareTo(Item p) {
        Integer s = size;
        return s.compareTo(p.getSize());
    }


    /** 
     * Method виводить інформацію річ зі скла
     */
    public void print() {
        System.out.print("Glass thing name:  - "+ GName + ". Its size : "+ size + " \n");
    }

}
