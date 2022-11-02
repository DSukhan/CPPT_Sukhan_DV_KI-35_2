package KI35.Sukhan.Lab5;

/**
 * Class <code>CalcException</code> more precises ArithmeticException
 * @author Denys Sukhan
 * @version 1.0
 */

 //Клас CalcException реалізує користувацьке виключення

public class CalcException extends ArithmeticException {
    /**
    *Constructor
    */ 
    public CalcException(){}
 
    /**
    *Constructor
    * @param cause
    */ 
    public CalcException(String cause) { 
       super(cause); 
    }
}
