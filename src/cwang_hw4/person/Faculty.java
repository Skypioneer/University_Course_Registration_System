package cwang_hw4.person;

import cwang_hw4.enums.Building;
import cwang_hw4.enums.FacultyType;
import cwang_hw4.enums.PersonStatus;

/**
 * <p>The <strong>Faculty</strong> class holds information about a faculty
 * member.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the faculty</li>
 * <li><strong>last name:</strong> last name of the faculty</li>
 * <li><strong>suid:</strong> SeattleU identification number</li>
 * <li><strong>status:</strong> the status of the faculty (see PersonStatus
 * enum)</li>
 * <li><strong>faculty type:</strong> the type of faculty (see FacultyType enum)
 * </li>
 * <li><strong>office:</strong> includes building (i.e. ENGR) and room number
 * (i.e 504)</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, faculty <strong>Sheila Oh</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Sheila</li>
 * <li><strong>last name:</strong> Oh</li>
 * <li><strong>suid:</strong> 100013</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>faculty type:</strong> SEN_INSTRUCT</li>
 * <li><strong>office (building/room):</strong> ENGR 504</li>
 * <li><strong>email:</strong> ohsh@seattleu.edu</li>
 * </ul>
 * 
 * @author Jason Wang
 * CPSC 5011 01, Seattle University
 */
public class Faculty {

    /**
     * Constructor.
     *
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     */
    public Faculty(String firstName, String lastName) {
        
        // TODO: implement Faculty constructor
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Copy Constructor.
     *
     * @param faculty The original constructor
     */
    public Faculty (Faculty faculty){
        this.firstName = faculty.firstName;
        this.lastName = faculty.lastName;
        this.status = faculty.status;
        this.facultyType = faculty.facultyType;
        this.office = faculty.office;
        this.email = faculty.email;
        this.SUID = faculty.SUID;
    }

    /**
     * The setStatus method returns the faculty's status.
     *
     * @param status The faculty's status
     */
    public void setStatus(PersonStatus status){
        this.status = status;
    }

    /**
     * The setFacultyType method sets the faculty's type.
     *
     * @param facultyType The faculty's type
     */
    public void setFacultyType(FacultyType facultyType){
        this.facultyType = facultyType;
    }

    /**
     * The setOffice method sets the faculty's office.
     *
     * @param office The faculty's building
     * @param room The faculty's room number
     */
    public void setOffice(Building office, int room){
        this.office = office.toString() + " " + room;
    }

    /**
     * The setEmail method sets the faculty's email.
     *
     * @param email The faculty's email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * The setSUID method sets the faculty's ID.
     *
     * @param SUID The faculty's ID
     */
    public void setSUID(int SUID){
        this.SUID = SUID;
    }

    /**
     * The getFirstName returns the faculty's first name.
     *
     * @return The faculty's first name
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * The getLastName method returns the faculty's last name.
     *
     * @return The faculty's last name
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * The getStatus methods returns the faculty's status.
     *
     * @return The faculty's status
     */
    public String getStatus(){
        return status.toString();
    }

    /**
     * The getOffice methods returns the faculty's office.
     *
     * @return The faculty's office
     */
    public String getOffice(){
        return office;
    }

    /**
     * The getEmail methods returns the faculty's email.
     *
     * @return The faculty's email
     */
    public String getEmail(){
        return email;
    }

    /**
     * The getSUID methods returns the faculty's SUID.
     *
     * @return The faculty's SUID
     */
    public int getSUID(){
        return SUID;
    }

    /**
     * The getFacultyType methods returns the faculty's type.
     *
     * @return The faculty's type
     */
    public String getFacultyType(){
        return facultyType.toString();
    }

    /**
     * The getAdvisor methods returns the faculty's advisor.
     *
     * @return The faculty's advisor.
     */
    public String getAdvisor(){
        return firstName + " " + lastName;
    }
    
    // TODO: add Faculty fields
    // - first name
    // - last name
    // - SUID
    // - status (see PersonStatus)
    // - faculty type (see FacultyType)
    // - office (see Building)
    // - email

    String firstName = "";
    String lastName = "";
    PersonStatus status;
    FacultyType facultyType;
    String office = "";
    String email = "";
    int SUID;
}
