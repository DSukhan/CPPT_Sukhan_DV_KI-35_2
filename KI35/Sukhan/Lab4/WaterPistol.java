package KI35.Sukhan.Lab4;
import java.io.*;

interface ShootMode {
   void setShootMode(int mode);
   int  getShootMode(); 
}

interface ShootWithMode extends ShootMode {
    void shootWithMode();
}

/**
* Клас WaterPistol реалізує Водяний пістолет
* @author Denys Sukhan
* @version 1.0
* @since version 1.0
*/

public class WaterPistol  extends Pistol implements ShootMode { 
  private int mode;
  int curWaterCapacity;   // Capacity value of water pistol cartrige
  int maxWaterCapacity;  //  in range ( 0 to 100) percent

  /* Constructor
   * @throws FileNotFoundException
 */ 

  public WaterPistol() throws FileNotFoundException{
    super();
    mode = 0;
  }
 
   /**
     * Method Виконує вистріл водою різними способами
   */

  public void shoot(){
    boolean push = trigger.get_push();
    int curWaterCapacity = get_curWaterCapacity(); 
    if (push == true && curWaterCapacity > 0){
        if(mode==1){
            set_curWaterCapacity(curWaterCapacity=0);
        }else if(mode==0){
            set_curWaterCapacity(curWaterCapacity-20);
        }
        else{
            System.out.println("Wrong input mode of type Water Shoot!");
        }
        trigger.set_push(false);
        System.out.println("Water pistol fired, cartrige capacity ("+curWaterCapacity+"%)");
        fout.println("Water pistol fired, cartrige capacity ("+curWaterCapacity+"%)");
        fout.flush();
    }
    else{
        System.out.println("Water pistol can't shoot!");
        fout.println("Water pistol can't shoot!");
        fout.flush();
    }
  }
    

   /** 
     * @return shootMode
     */
    public int getShootMode() {
        System.out.println(mode);
        return mode;
    }

     /**
     * Method змінює чутливість мікрофону
     * @param mode - спосіб
     */
    public void setShootMode(int mode) {
        this. mode =  mode;
        System.out.println("Set shooting mode a water pistol to: " +  mode);
        fout.println("Set shooting mode a water pistol to: " +  mode);
        fout.flush();
    }

    /**
    * Method встанослює максимальний рівень води
    * */
    public void set_maxWaterCapacity(int maxWaterCapacity){
        this.maxWaterCapacity = maxWaterCapacity;
     }
    
     /**
       * Method встанослює наявний рівень води
    * */
     public void set_curWaterCapacity(int curWaterCapacity){
        this.curWaterCapacity =curWaterCapacity;
     }
    
      /**
        * Method повертає максимальний рівень води
     * */
     public int get_maxWaterCapacity(){
        return maxWaterCapacity;
     }
    
     /**
       * Method повертає наявний рівень води
     * */
     public int get_curWaterCapacity(){
        return curWaterCapacity;
     }
    
}
