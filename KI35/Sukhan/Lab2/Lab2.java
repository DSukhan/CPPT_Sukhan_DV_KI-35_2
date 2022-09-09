package KI35.Sukhan.Lab2;

import java.io.*;
import java.util.*;
/**
* Клас Lab2 реалізує приклад програми до лабораторної роботи №2
*
* @author Denys Sukhan
* @version 1.0
* @since version 1.0
*
*/
public class Lab2 {
       /** 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main (String [] args)throws FileNotFoundException {
        int size;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("KI35/Sukhan/Lab2/MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);
        System.out.print("Enter the size of the square matrix: ");
        size = in.nextInt();
        in.nextLine();
        arr = new char[size][];
        System.out.print("\nEnter a placeholder character: ");
        filler = in.nextLine();
        exit:
            if(filler.length() == 1) {
                int gap = (size % 2 == 0) ? size / 2 : size / 2 + 1;
                for (int i = 0; i < gap  ; i++) {
                    for (int j = 0; j <= i; j++) {
                        arr[i]= new char[i+1];
                        arr[i][j] = (char) filler.codePointAt(0);
                        System.out.print(arr[i][j] + " ");
                        fout.print(arr[i][j] + " ");
                    }
                    System.out.print("\n");
                    fout.print("\n");
                }
                for (int i = gap; i < size; i++) {
                    for (int j = 0; j < size-i; j++) {
                        arr[i]= new char[size-i];
                        arr[i][j] = (char) filler.codePointAt(0);
                        System.out.print(arr[i][j] + " ");
                        fout.print(arr[i][j] + " ");  
                    }
                    System.out.print("\n");
                    fout.print("\n");
                }   
            }   
            else if (filler.length() == 0) {
                System.out.print("\nNo placeholder character entered");
                break exit;
            }
            else {
                System.out.print("\nToo many placeholder characters");
                break exit;
            }
            fout.flush();
            fout.close();
        }    
        }