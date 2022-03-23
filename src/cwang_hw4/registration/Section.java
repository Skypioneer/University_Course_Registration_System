package cwang_hw4.registration;

import cwang_hw4.enums.Building;
import cwang_hw4.enums.Quarter;
import cwang_hw4.person.Faculty;

/**
 * <p>The <strong>Section</strong> class holds information about a course
 * section.</p> <ul>
 * <li><strong>course:</strong> course associated with the section</li>
 * <li><strong>section:</strong> section number for the course</li>
 * <li><strong>instructor:</strong> instructor for the section (assume single
 * instructor)</li>
 * <li><strong>term:</strong> quarter and year when the section is offered
 * (see Quarter enum)</li>
 * <li><strong>capacity:</strong> capacity for the section</li>
 * <li><strong>location:</strong> building and room where the section is held
 * (see Building enum)</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011-02: Object-Oriented Concepts</strong>
 * <ul>
 * <li><strong>course:</strong> CPSC 5011</li>
 * <li><strong>section:</strong> 02</li>
 * <li><strong>instructor:</strong> Sheila Oh</li>
 * <li><strong>term (quarter/year):</strong> FQ18</li>
 * <li><strong>capacity:</strong> 30</li>
 * <li><strong>location (building/room):</strong> LEML 122</li>
 * </ul>
 * 
 * @author Jason Wang
 * CPSC 5011 01, Seattle University
 */
public class Section {    
    
    /**
     * Constructor.
     * @param course     The course associated with the section
     * @param section    The section number for the course
     * @param instructor The faculty instructor teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     */
    public Section(Course course, int section, Faculty instructor,
                   Quarter quarter, int year, int cap, Building bldg, int room)
    {
        
        // TODO: implement Section constructor

        this.course = new Course(course);
        this.instructor = new Faculty(instructor);
        this.section = "0" + section;
        this.term = quarter;
        this.year = year;
        this.capacity = cap;
        this.location = bldg;
        this.room = room;
    }

    /**
     * The getCourseCode method returns the course's code.
     *
     * @return The course's code
     */
    public String getCourseCode(){
        return course.getCode().toString();
    }

    /**
     * The getCourseNumber method returns the course's number.
     *
     * @return The course's number
     */
    public int getCourseNumber(){
        return course.getCourseNum();
    }

    /**
     * The getSection method returns the course's section.
     *
     * @return The course's section
     */
    public String getSectionNum(){
        return section;
    }

    /**
     * The getCourse method returns the new Course class.
     *
     * @return The new Course class
     */
    public Course getCourse() {
        return new Course(course);
    }

    /**
     * The getFaculty method returns the new Faculty class.
     *
     * @return The new Faculty class
     */
    public Faculty getFaculty() {
        return new Faculty(instructor);
    }

    /**
     * The getTermAndYear method returns the term and year.
     *
     * @return The term and year
     */
    public String getTermAndYear(){
        return term + " " + year;
    }

    /**
     * The getCapacity method returns the course's session capacity.
     *
     * @return The course's session capacity
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * The getBldgAndRoom method returns the course's location.
     *
     * @return The course's location
     */
    public String getBldgAndRoom (){
        return location.toString() + " " + room;
    }

    
    // TODO: add Section fields including:
    // - course
    // - section
    // - instructor
    // - term (see Quarter)
    // - capacity
    // - location (see Building)

    private Course course;
    private Faculty instructor;
    private Quarter term;
    private Building location;
    private String section;
    private int capacity;
    private int year;
    private int room;
}
