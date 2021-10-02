public class StackOverflowException extends RuntimeException {
    
    /**
     * @param string 
     */
    public StackOverflowException(String string) {
        super("The empty is full");
    }
}