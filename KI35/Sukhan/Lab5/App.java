package KI35.Sukhan.Lab5;

import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;

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
        try
         {
            Scanner in = new Scanner(System.in);
            PrintWriter fout = new PrintWriter(new File("KI35/Sukhan/Lab5/Result.txt"));        
             try
            {
                for(int i = 0;i<6;i++){
                    Realization eq = new Realization();
                    out.print("Enter X: ");
                    fout.print("Result: "+ eq.calculate(in.nextInt())+"\n"); 

                }
             }
             catch (CalcException ex)
              {                                                                                                            
                out.print(ex.getMessage());
                fout.print(ex.getMessage());
              }
             finally
             {                                                                                              
                 fout.flush();
                 fout.close();
             } 
         }
         catch (FileNotFoundException ex)
         {
             out.print("Exception reason: Perhaps wrong file path");
         }
    }
}
