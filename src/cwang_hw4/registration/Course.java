package cwang_hw4.registration;

import cwang_hw4.enums.SubjectCode;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>The <strong>Course</strong> class holds information about a course.</p>
 * <ul>
 * <li><strong>subject code:</strong> subject code of the course (see
 *   SubjectCode enum)</li>
 * <li><strong>course number:</strong> course number</li>
 * <li><strong>course name:</strong> course name</li>
 * <li><strong>credit number:</strong> number of credits associated with the
 *   course</li>
 * <li><strong>prerequisites:</strong> courses that are prerequisites of this
 *   course; may
 *   have multiple or none</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011: Object-Oriented Concepts</strong></p>
 * <ul>
 * <li><strong>subject code:</strong> CPSC</li>
 * <li><strong>course number:</strong> 5011</li>
 * <li><strong>course name:</strong> Object-Oriented Concepts</li>
 * <li><strong>credit number:</strong> 3</li>
 * <li><strong>prerequisite(s):</strong> CPSC 5003</li>
 * </ul>
 * 
 * @author Jason Wang
 * CPSC 5011 01, Seattle University
 */
public class Course {
    
    /**
     * Constructor.
     *
     * @param code      The subject code of the course
     * @param courseNum The course number of the course
     * @param name      The course name
     * @param creditNum The number of the credits of the course
     */
    public Course(SubjectCode code, int courseNum, String name, 
                    int creditNum) {
        
        // TODO: implement Course constructor
        this.code = code;
        this.courseNum = courseNum;
        this.name = name;
        this.creditNum = creditNum;
    }

    /**
     * Copy Constructor.
     *
     * @param course thee original course
     */
    public Course (Course course) {
        this.code = course.code;
        this.name = course.name;
        this.courseNum = course.courseNum;
        this.creditNum = course.creditNum;

        // populate the local coursePrereq with the original one
        for(int i = 0; i < course.coursePrereq.size(); i++){
            coursePrereq.add(new Course(course.coursePrereq.get(i)));
        }
    }

    /**
     * The setPrerequisite method sets data of prerequisites to the coursePrereq
     * list.
     *
     * @param prereqCode The subject code of the prerequisite to add to the
     *                   course
     * @param prereqNum The course number of the prerequisite to add to the
     *                  course
     * @param prereqName The name of the prerequisite course
     * @param prereqCreditNum The credit of the prerequisite course
     */
    public void setPrerequisite( SubjectCode prereqCode, int prereqNum,
                                String prereqName, int prereqCreditNum){
        coursePrereq.add(new Course(prereqCode, prereqNum, prereqName,
                prereqCreditNum));
    }

    /**
     * The getCode method returns the course's code.
     *
     * @return The course's code
     */
    public SubjectCode getCode(){
        return code;
    }

    /**
     * The getName method returns the course's name.
     *
     * @return The course's name
     */
    public String getName(){
        return name;
    }

    /**
     * The getCreditNum method returns the course's creditNum.
     *
     * @return The course's creditNum
     */
    public int getCreditNum(){
        return creditNum;
    }

    /**
     * The getCourseNum method returns the course's courseNum.
     *
     * @return The course's courseNum
     */
    public int getCourseNum(){
        return courseNum;
    }

    /**
     * The getPrerequisite method returns the course's prerequisite.
     *
     * @return The course's prerequisite
     */
    public String getPrerequisite(){
        StringBuilder builder = new StringBuilder();

        // append all courrsePrereq information to the builder
        for (int i = 0; i < coursePrereq.size(); i++) {
            builder.append("Name=").append(coursePrereq.get(i).
                    getCode()).append("-").append(coursePrereq.
                    get(i).getCourseNum()).append(": ").append(coursePrereq.
                    get(i).getName());
            if (i + 1 != coursePrereq.size())
                builder.append(", ");
        }

        return builder.toString();
    }
    
    // TODO: add Course fields 
    // - subject code (see SubjectCode)
    // - course number
    // - course name
    // - credit number
    // - a collection of prerequisite course(s)

    private SubjectCode code;
    private String name;
    private int courseNum;
    private int creditNum;
    private List<Course> coursePrereq = new ArrayList<>();

}

