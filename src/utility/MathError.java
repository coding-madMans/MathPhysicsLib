
/*
 * written by Vasu.Subbannavar
 * data : 14/06/2021
 */

package utility;

public class MathError extends Exception{

    public static final String DIVISION_BY_ZERO_ERROR = "{ERROR} : division by zero is not possible";
    public static final String NULL_POINTER_EXCEPTION = "{ERROR} : null pointer exception";
    public static final String NON_INTRACTABLE_INTERACTION = "{ERROR} : The give objects can not interact each other";
    public static final String INCORRECT_ARGUMENTS = "{ERROR} : incorrect arguments...";
    public static final String INDEX_OUT_OF_BOUND = "{ERROR} : the given Index is out of bound...";
    public static final String WRONG_PARAMETERS = "{ERROR} : the given parameters are wrong...";
    public static final String INCORRECT_ARGUMENT_SIZE = "{ERROR} : the given argument size in incorrect...";

    public MathError(){
        super();
    }

    public MathError(String error){
        super(error);
    }

}
