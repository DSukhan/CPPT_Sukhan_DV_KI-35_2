package KI35.Sukhan.Lab5;
/**
 * Class <code>Realization</code> implements method for ( sin(3x-5) * tg(2x) ) expression
 * calculation
 * @author Denys Sukhan
 * @version 1.0
 */ 

//Клас Realization реалізує обчислення виразу ( sin(3x-5) * tg(2x) )

public class Realization {

	/** 
     * @param x
     * @throws CalcException 
     */

    public double calculate(double x) throws CalcException{
		double y, sin_rad ,tg_rad;	

		sin_rad = Math.toRadians(3*x - 5);
		tg_rad = Math.toRadians(2*x);

		try {
			y = Math.sin(sin_rad)*( Math.tan(tg_rad)); 
			     // Якщо результат не є числом, то генеруємо виключення
            if (y==Double.NaN || y==Double.NEGATIVE_INFINITY || y==Double.POSITIVE_INFINITY || 2*x == 90 || 2*x == -90 )
                throw new ArithmeticException();
		}
		catch(ArithmeticException ex){
			// створимо виключення вищого рівня з поясненням причини
			// виникнення помилки 
			if (tg_rad == Math.PI/2.0 || tg_rad == -Math.PI/2.0)
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else
                throw new CalcException("Unknown reason of the exception during exception calculation");
		}

		System.out.println(y);
		return y;
	}
}
