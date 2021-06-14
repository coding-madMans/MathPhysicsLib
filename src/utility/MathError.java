
/*
 * written by Vasu.Subbannavar
 * data : 14/06/2021
 */

package utility;

public class MathError extends Exception{

    public static final String DIVISION_BY_ZERO_ERROR = "{ERROR} : division by zero is not possible";
    public static final String NULL_POINTER_EXCEPTION = "{ERROR} : null pointer exception";

    public static void init(){}

    public MathError(){
        super();
    }

    public MathError(String error){
        super(error);
    }

}
