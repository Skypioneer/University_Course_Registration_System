package cwang_hw4.exception;

/**
 * <p>The class <strong>DuplicateCourseException</strong> and its subclasses are
 * a form of Throwable that indicates conditions that a reasonable application
 * might want to catch. This cwang_hw4.exception is thrown when attempting to
 * add a duplicate course.</p>
 *
 * Jason Wang
 * CPSC 5011 01, Seattle University
 */
@SuppressWarnings("serial")
public class DuplicateCourseException extends Exception {

    /**
     * call default constructor and custom message does not need to be provided
     * @param msg custom your own message
     */
    public DuplicateCourseException(String msg) {
        super(msg);
    }

    /**
     * when throwing exception, call constructor and pass in message provided.
     */
    public DuplicateCourseException() {
        this("Course has already been added.");
    }
    
}
