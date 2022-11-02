package KI35.Sukhan.Lab6;

import java.io.*;
import java.util.*;

/**
* Клас FioApp реалізує програму-драйвер
*
* @author Sukhan Denys
* @version 1.0
* @since version 1.0
*
*/

public class FioApp {
    /** 
     * @param args
     * @throws FileNotFoundException
     * @throws  IOException
     */
    public static void main(String[] args) throws IOException {
        boolean IsCatched = true; 
         CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter data: ");
        double data = s.nextDouble();

        try
        {
            obj.calculate(data);
        }
        catch (CalcException ex)
        {
            IsCatched = false;																							                
            System.out.println(ex.getMessage());
        }
      
        if(IsCatched) {


            System.out.println("Result is: " + obj.getResult());
            obj.writeResTxt("KI35/Sukhan/Lab6/textRes.txt");
            obj.writeResBin("KI35/Sukhan/Lab6/BinRes.bin");

            obj.readResBin("KI35/Sukhan/Lab6/BinRes.bin");
            System.out.println("Result is: " + obj.getResult());
            obj.readResTxt("KI35/Sukhan/Lab6/textRes.txt");
            System.out.println("Result is: " + obj.getResult());

            RandomAccessFile file = new RandomAccessFile("Res.txt", "rw");
            file.write("Sukhan info".getBytes());
            file.close();
        }
 }
}
