package KI35.Sukhan.Lab6;

import java.io.*;
import java.util.*;

/**
* Клас CalcWFio реалізує обчислення виразу і читання/запис у файл
*/
public class CalcWFio {
    private double  result ,sin_rad ,tg_rad;	
	
     /** 
     * Method writeResTxt реалізує запис у текстовий файл
     * @param fName
     */
	public void writeResTxt(String fName) throws FileNotFoundException
    {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f ",result);
        f.close();
    }

    /** 
     * Method readResTxt реалізує читання текстового файлу
     * @param fName
     */
    public void readResTxt(String fName)
    {
        try
        {
            File f = new File (fName);
            if (f.exists())
            {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            }
            else
                throw new FileNotFoundException("File " + fName + "not found");
        }
        catch (FileNotFoundException ex)
        {
            System.out.print(ex.getMessage());
        }
    }

     /** 
     * Method writeResBin реалізує запис у бінарний файл
     * @param fName
     */
    public void writeResBin(String fName) throws FileNotFoundException, IOException
    {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();

    }

     /** 
     * Method readResBin реалізує читання бінарного файлу
     * @param fName
     */
    public void readResBin(String fName) throws FileNotFoundException, IOException
    {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    /** 
     * Method calculate реалізує обчислення виразу
     * @param x
     */
    public double calculate(double x) throws CalcException{

		sin_rad = Math.toRadians(3*x - 5);
		tg_rad = Math.toRadians(2*x);

		try {
			result = Math.sin(sin_rad)*( Math.tan(tg_rad)); 
            if (result==Double.NaN || result==Double.NEGATIVE_INFINITY || result==Double.POSITIVE_INFINITY || 2*x == 90 || 2*x == -90 )
                throw new ArithmeticException();
		}
		catch(ArithmeticException ex){
			if (tg_rad == Math.PI/2.0 || tg_rad == -Math.PI/2.0)
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else
                throw new CalcException("Unknown reason of the exception during exception calculation");
		}

		System.out.println(result);
		return result;
	}


    /** 
     * Method getResult повертає результат 
     * @return result
     */
    public double getResult()
    {
        return result;
    }
}
