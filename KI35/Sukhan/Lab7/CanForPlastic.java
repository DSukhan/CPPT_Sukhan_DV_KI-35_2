package KI35.Sukhan.Lab7;
/**
* Клас CanForPlastic реалізує ріл із пластику
*
* @author Sukhan Denys
* @version 1.0
* @since version 1.0
*
*/
public class CanForPlastic implements Item {
    private String PName;
    private int size;


    /**
    *Constructor
    *@param PName
    *@param size
    */ 
    public CanForPlastic(String PName, int size) {
        this.PName = PName;
        this.size = size;
    }

   
    /**
     * Method повертає назву речі зі пластику
     * @return String
     */
    public String getPName() {
        return PName;
    }

    
    /** 
     * Method встановлює назву речі зі пластику
     * @param buildingName
     */
    public void SetPName(String PName) {
        this.PName= PName;
    }

    
    /** 
     * Method встановлює розмір речі зі пластику
     * @param area
     */
    public void setSize(int size) {
        this.size = size;
    }

    
    /**
     * Method повертає розмір речі зі пластику
     * @return int
     */
    public int getSize() {
        return size;
    }

    
    /** 
     * Method порівнює розімр речі зі пластику з розіміром речі іншого класу
     * @param p
     * @return int
     */
    public int compareTo(Item p) {
        Integer s = size;
        return s.compareTo(p.getSize());
    }

    /** 
     * Method виводить інформацію про річ з пластику
     */
    public void print() {
        System.out.print("Plastic thing name:  - "+ PName + ". Its size : "+ size + " \n");
    }
}