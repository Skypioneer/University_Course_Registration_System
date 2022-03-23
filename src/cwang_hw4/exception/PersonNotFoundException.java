package cwang_hw4.exception;

/**
 * <p>The class <strong>PersonNotFoundException</strong> and its subclasses are
 * a form of Throwable that indicates conditions that a reasonable application
 * might want to catch. This cwang_hw4.exception is thrown when attempting to
 * find a cwang_hw4.person that does not exist.</p>
 *
 * Jason Wang
 * CPSC 5011 01, Seattle University
 */
@SuppressWarnings("serial")
public class PersonNotFoundException extends Exception {

    /**
     * call default constructor and custom message does not need to be provided.
     * @param msg custom your own message
     */
    public PersonNotFoundException(String msg) {
        super(msg);
    }

    /**
     * when throwing exception, call constructor and pass in message provided.
     */
    public PersonNotFoundException() {
        this("Person was not found.");
    }
    
}
