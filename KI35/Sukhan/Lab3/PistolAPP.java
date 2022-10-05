package KI35.Sukhan.Lab3;
import java.io.*;
import java.util.Scanner;
/**
* Клас Pistol реалізує програму-драйвер до пістолета
*
* @author Denys Sukhan
* @version 1.0
* @since version 1.0
*
*/
public class PistolAPP 
{
  public static void main(String[] args) throws FileNotFoundException
   {
    String model,company;
    double caliber,shoot_range;
    boolean laser,sight,flashlight;
    Scanner in = new Scanner(System.in);

    System.out.print(" Enter the model of pistol:");
    model = in.nextLine();
    System.out.print(" Enter the name of the company that manufactured the gun:");
    company = in.nextLine();

    System.out.print(" Enter the caliber of the gun: ");
    caliber = in.nextDouble();
    System.out.print(" Enter the firing range of the gun: ");
    shoot_range = in.nextDouble();
 
    System.out.print(" You want to add an accessory to your gun?  Chouse the true or false : ");
    laser= in.nextBoolean();
    sight = laser ; flashlight = sight; 

  Pistol pistol = new Pistol(model,company,caliber,shoot_range,laser,sight,flashlight);
   pistol.change_fuse_state();
   pistol.change_push_state();
   pistol.shoot();
   pistol.get_info();
   pistol.change_push_state();
   pistol.shoot();
   pistol.change_push_state();
   pistol.shoot();
   pistol.get_info();
   pistol.change_cartridge_capacity(25);
   pistol.change_push_state();
   pistol.shoot();
   pistol.get_info();
   pistol.reload();
   pistol.get_info();
   }
}


