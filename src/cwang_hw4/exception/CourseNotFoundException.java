package cwang_hw4.exception;

/**
 * <p>The class <strong>CourseNotFoundException</strong> and its subclasses are
 * a form of Throwable that indicates conditions that a reasonable application
 * might want to catch. This cwang_hw4.exception is thrown when attempting to
 * find a course that does not exist.</p>
 *
 * Jason Wang
 * CPSC 5011 01, Seattle University
 */
@SuppressWarnings("serial")
public class CourseNotFoundException extends Exception {

    /**
     * call default constructor and custom message does not need to be provided.
     * @param msg custom your own message
     */
    public CourseNotFoundException(String msg) {
        super(msg);
    }

    /**
     * when throwing exception, call constructor and pass in message provided.
     */
    public CourseNotFoundException() {
        this("Course was not found.");
    }
    
}
