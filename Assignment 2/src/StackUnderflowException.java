
public class StackUnderflowException extends RuntimeException {
    
    /**
     * @param string 
     */
    public StackUnderflowException(String string) {
        super("The stack is empty");
    }
}