package KI35.Sukhan.Lab3;
import java.io.*;

/**
* Клас Pistol реалізує пістолет
*
* @author Denys Sukhan
* @version 1.0
* @since version 1.0
*
*/   
    public class Pistol{
        private Trigger trigger;
        private Equipment equipment;
        private Cartridge cartridge;
        private PrintWriter fout;
        private boolean fuse;
        private String model,company;
        private double caliber,shoot_range;
    
    
        public Pistol() throws FileNotFoundException {
            model ="Desert Eagle";
            company="American weapons.inc";
            caliber=7.62;
            shoot_range=2.2;
            fuse=true;
            trigger = new Trigger();
            equipment = new Equipment();
            cartridge = new Cartridge();
            fout = new PrintWriter(new File("KI35/Sukhan/Lab3/MyFile.txt"));
        }
    
        public Pistol(String model,String company,double caliber,double shoot_range,boolean laser,boolean sight, boolean flashlight) throws FileNotFoundException {
            this.model =model;
            this.company=company;
            this.caliber=caliber;
            this.shoot_range=shoot_range;
            fuse=true;
            trigger = new Trigger();
            equipment = new Equipment(laser,sight,flashlight);
            cartridge = new Cartridge();
            fout = new PrintWriter(new File("KI35/Sukhan/Lab3/MyFile.txt"));
        }

        public void change_fuse_state(){
         fuse = fuse==false? true:false;
         if(fuse){
                System.out.println("Fuse is changed to [turn on state]\nPlease [turn off] fuse state to make shot.");
                fout.println("Fuse is changed to [turn on state]\nPlease [turn off] fuse state to make shot.");
                fout.flush();
            }
            else{
                System.out.println("Fuse is changed to [turn off state]");
                fout.println("Fuse is changed to [turn off state]");
                fout.flush();
            }
        }

        public void change_push_state(){
           boolean push = trigger.get_push();
           trigger.set_push(!push);
            if(!push){
                   System.out.println("Push is changed to [turn on state]");
                   fout.println("Push is changed to [turn on state]");
                   fout.flush();
               }
               else{
                   System.out.println("Push is changed to [turn off state]\nPlease [turn on] push state to make shot.");
                   fout.println("Push is changed to [turn off state]\nPlease [turn on] push state to make shot.");
                   fout.flush();
               }
             
           }
        
        public void shoot(){
            boolean push = trigger.get_push();
            int cur_bullets = cartridge.get_cur_bullets();
            if (push == true && cur_bullets > 0 && fuse == false){
                cartridge.set_cur_bullets(cur_bullets-1);
                trigger.set_push(false);
                System.out.println("Shot");
                fout.println("Shot");
                fout.flush();
            }
            else{
                System.out.println("Pistol can't shoot!");
                fout.println("Pistol can't shoot!");
                fout.flush();
            }
        }
        
        public void reload(){
            int cur_bullets = cartridge.get_cur_bullets();
            int max_bullets = cartridge.get_max_bullets();
            if (cur_bullets == max_bullets){
                System.out.println("Pistol doesn't require reloading!");
                fout.println("Pistol doesn't require reloading!");
                fout.flush();
            }
            else{
               cartridge.set_cur_bullets(max_bullets);
               System.out.println("The gun is reloaded !");
               fout.println("The gun is reloaded !");
               fout.flush();
            }
        }
        public void switch_laser(){
            boolean laser = equipment.get_laser();
            System.out.println(laser==false? "Laser is [turned on] ": "Laser is [turned on]");
            fout.println(laser==false? "Laser is [turned on] ": "Laser is [turned on]");
            fout.flush();
            equipment.set_laser(!laser);
        }

        public void switch_sight(){
            boolean sight = equipment.get_sight();
            System.out.println(sight==false? "Sight is [turned on] ": "Sight is [turned on]");
            fout.println(sight==false? "Sight is [turned on] ": "Sight is [turned on]");
            fout.flush();
            equipment.set_sight(!sight);
        }

        public void switch_flashlight(){
            boolean flashlight = equipment.get_flashlight();
            System.out.println(flashlight==false? "Flashlight is [turned on] ": "Flashlight is [turned on]");
            fout.println(flashlight==false? "Flashlight is [turned on] ": "Flashlight is [turned on]");
            fout.flush();
            equipment.set_flashlight(!flashlight);
        }

        public void change_cartridge_capacity(int capacity){
            cartridge.set_max_bullets(capacity);
            cartridge.set_cur_bullets(capacity);
            System.out.println("Cartridge capacity was changed to :" + capacity);
            fout.println("Cartridge capacity was changed to :" + capacity);
            fout.flush();
        }
        
        public void get_info(){
            System.out.println("Pistol model (" + model+")\nMade in company (" + company+")\nCaliber(" + caliber+")\nShoot range(" + shoot_range+")\nCurrent bullets(" + cartridge.get_cur_bullets()+")\nCatrige capacity(" + cartridge.get_max_bullets()+")\n");
            fout.println("Pistol model (" + model+")\nMade in company (" + company+")\nCaliber(" + caliber+")\nShoot range(" + shoot_range+")\nCurrent bullets(" + cartridge.get_cur_bullets()+")\nCatrige capacity(" + cartridge.get_max_bullets()+")\n");
            fout.flush();
        }
        

    }

    class Trigger{
        private boolean push;
        public Trigger(){
            push = false;
        } 
        public void set_push(boolean push){
            this.push = push;
         }
    
         public boolean get_push(){
            return push;
         }

    }

    class Equipment{
          private boolean laser,sight,flashlight;
          public Equipment(){
            laser=false;
            sight=false;
           flashlight=false;
          }

          public Equipment(boolean laser,boolean sight, boolean flashlight){
            this.laser=laser;
            this.sight=sight;
            this.flashlight=flashlight;
          }

          public void set_laser(boolean laser){
            this.laser = laser;
         }
         public void set_sight(boolean sight){
            this.sight = sight;
         }
         public void set_flashlight(boolean flashlight){
            this.flashlight = flashlight;
         }
         public boolean get_laser(){
            return laser;
         }
         public boolean get_sight(){
            return sight;
         }
         public boolean get_flashlight(){
            return flashlight;
         }

    }

    class Cartridge {
        private int max_bullets;
        private int cur_bullets;
        public Cartridge(){
          max_bullets = 15;
          cur_bullets= max_bullets;
       }   
     public void  set_max_bullets(int max_bullets){
        this.max_bullets = max_bullets;
     }

     public void set_cur_bullets(int cur_bullets){
        this.cur_bullets = cur_bullets;
     }

     public int get_max_bullets(){
        return max_bullets;
     }

     public int get_cur_bullets(){
        return cur_bullets;
     }
    
    } 


