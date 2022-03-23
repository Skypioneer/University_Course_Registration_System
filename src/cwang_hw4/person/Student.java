package cwang_hw4.person;

import cwang_hw4.enums.PersonStatus;
import cwang_hw4.enums.Quarter;
import cwang_hw4.enums.StudentProgram;
import cwang_hw4.enums.StudentType;

/**
 * <p>The <strong>Student</strong> class holds information about a student.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the student</li>
 * <li><strong>last name:</strong> last name of the student</li>
 * <li><strong>suid:</strong> Seattle U identification number</li>
 * <li><strong>status:</strong> the status of the student (see PersonStatus
 * enum)</li>
 * <li><strong>student type:</strong> a student can only be assigned a single
 *   student type (see StudentType enum)</li>
 * <li><strong>student program:</strong> a student can only be assigned to a
 *   single program at a point of time, but can switch from one program to
 *   another (i.e. when they've graduated from a program (see StudentProgram
 *   enum)</li>
 * <li><strong>student year:</strong> only relevant for undergraduates (see
 * StudentYear enum)</li>
 * <li><strong>start term:</strong> associated with the quarter and year a
 * student starts a
 *   particular program; for example, a single student may start the CERT in 
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)</li>
 * <li><strong>faculty advisor:</strong> students are assigned a faculty
 *   advisor, but may switch
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, student <strong>Ada Lovelace</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Ada</li>
 * <li><strong>last name:</strong> Lovelace</li>
 * <li><strong>suid:</strong> 100027</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> GRAD</li>
 * <li><strong>student program:</strong> CERT</li>
 * <li><strong>student year:</strong> </li>
 * <li><strong>start term:</strong> FQ 2018</li>
 * <li><strong>faculty advisor:</strong> Lin Li</li>
 * <li><strong>email:</strong> adalovelace@seattleu.edu</li>
 * </ul>
 * <p>And student <strong>Buster Bluth</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Buster</li>
 * <li><strong>last name:</strong> Bluth</li>
 * <li><strong>suid:</strong> 100020</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> UNDERGRAD</li>
 * <li><strong>student program:</strong> BSCS</li>
 * <li><strong>student year:</strong> SOPHOMORE</li>
 * <li><strong>start term:</strong> WQ 2018</li>
 * <li><strong>faculty advisor:</strong> Roshanak Roshandel</li>
 * <li><strong>email:</strong> busterbluth@seattleu.edu</li>
 * </ul>
 * 
 * @author Jason Wang
 * CPSC 5011 01, Seattle University
 */
public class Student {

    /**
     * Constructor.
     * @param firstName   The first name of the student
     * @param lastName    The last name of the student
     */
    public Student(String firstName, String lastName) {
        
        // TODO: implement Student constructor
        this.firstName = firstName;
        this.lastName = lastName;
    
    }

    /**
     * The setSUID method sets the student's SUID.
     *
     * @param SUID The student's SUID
     */
    public void setSUID(int SUID){
        this.SUID = SUID;
    }


    /**
     * The setStatus method sets the student's status.
     *
     * @param status The student's status
     */
    public void setStatus(PersonStatus status){
        this.status = status;
    }

    /**
     * The setType method sets the student's type.
     *
     * @param type The student's type
     */
    public void setType(StudentType type){
        this.type = type;
    }

    /**
     * The setProgram method sets the student's program.
     *
     * @param program The student's program
     */
    public void setProgram(StudentProgram program){
        this.program = program;
    }

    /**
     * The setYear method sets the student's year.
     *
     * @param year The student's year
     */
    public void setYear(String year){

        this.year = year;
    }

    /**
     * The setTerm method sets the student's term.
     *
     * @param quarter The student's begin quarter
     * @param year The student's begin year
     */
    public void setTerm(Quarter quarter, int year){
        this.term = quarter.toString() + " " + year;
    }

    /**
     * The setAdvisor method sets the student's advisor.
     *
     * @param advisor The student's advisor
     */
    public void setAdvisor(String advisor){
        this.advisor = advisor;
    }

    /**
     * The setEmail method sets the student's email.
     *
     * @param email The student's email
     */
    public void setEmail(String email){
        this.email = email.toLowerCase() + "@seattleu.edu";
    }

    /**
     * The getFirstName method returns the student's firstName.
     *
     * @return The student's firstName
     */
    public String getFirstName (){
        return firstName;
    }

    /**
     * The getLastName method returns the student's lastName.
     *
     * @return The student's lastName
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * The getSUID method returns the student's SUID.
     *
     * @return The student's SUID
     */
    public int getSUID(){
        return SUID;
    }

    /**
     * The getStatus method returns the student's status.
     *
     * @return The student's status
     */
    public String getStatus(){
        return status.toString();
    }

    /**
     * The getType method returns the student's type.
     *
     * @return The student's type
     */
    public String getType(){
        return type.toString();
    }

    /**
     * The getProgram method returns the student's program.
     *
     * @return the student's program
     */
    public String getProgram(){
        return program.toString();
    }

    /**
     * The getYear method returns the student's year.
     *
     * @return The student's year
     */
    public String getYear(){
        return year;
    }

    /**
     * The getTerm method returns the student's term.
     *
     * @return The student's term
     */
    public String getTerm(){
        return term;
    }

    /**
     * The getEmail method returns the student's email.
     *
     * @return The student's email
     */
    public String getEmail(){
        return email;
    }

    /**
     * The getAdvisor method returns the student's getAdvisor.
     *
     * @return The student's getAdvisor
     */
    public String getAdvisor(){
        return advisor;
    }

    // TODO: add Student fields
    // - first name
    // - last name
    // - SUID
    // - status (see PersonStatus)
    // - student type (see StudentType)
    // - student program (see StudentProgram)
    // - student year (see StudentYear; only if undergrad––default to freshman)
    // - start term (see Quarter)
    // - faculty advisor
    // - email

    StudentProgram program;
    PersonStatus status;
    StudentType type;
    String year = "";
    String term = "";
    String advisor = "";
    String email = "";
    String firstName = "";
    String lastName = "";
    int SUID;
}
