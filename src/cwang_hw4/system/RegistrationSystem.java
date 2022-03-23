package cwang_hw4.system;

import cwang_hw4.enums.*;
import cwang_hw4.exception.*;
import cwang_hw4.person.Faculty;
import cwang_hw4.person.Student;
import cwang_hw4.registration.Course;
import cwang_hw4.registration.Section;
import java.time.Year;
import java.util.*;

/**
 * <p>The <strong>RegistrationSystem</strong> class stores information about
 * the school, including the ability to add students, add faculty, add courses,
 * and add prerequisite(s).</p>
 *
 * @author Jason Wang
 * CPSC 5011 01, Seattle University
 */
public class RegistrationSystem {

    /**
     * Constructor.
     */
    public RegistrationSystem() {

        // TODO: implement RegistrationSystem constructor
        facultyList = new ArrayList<>();
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
        sectionList = new ArrayList<>();
        subjects = new HashMap<>();
    }

    /**
     * Add a student to the student list collection.
     *
     * @param firstName  The first name of the student
     * @param lastName   The last name of the student
     * @param type       The student type
     * @param program    The student program
     * @param quarter    The start quarter of the student
     * @param year       The start year of the student
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addStudent(String firstName, String lastName,
                           StudentType type, StudentProgram program,
                           cwang_hw4.enums.Quarter quarter, int year)
                            throws DuplicatePersonException {

        // TODO: implement addStudent method
        // check if the person is duplicated
        if (!studentList.isEmpty()) {
            for(int i = 0; i < studentList.size();i++) {
                if (firstName.equals(studentList.get(i).getFirstName())
                        && lastName.equals(studentList.get(i).getLastName()))
                    throw new DuplicatePersonException();
            }
        }

        // declare Student class
        Student student = new Student(firstName, lastName);
        student.setSUID(SUID);
        student.setStatus(checkStatus(type, year));
        student.setType(type);
        student.setYear(checkStudentGrade(type, year));
        student.setEmail(firstName+lastName);
        student.setTerm(quarter, year);
        student.setProgram(program);
        student.setAdvisor(assignAdvisorToStudent());
        studentList.add(student);
        SUID++;
    }

    /**
     * Add a faculty to the faculty list collection.
     *
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     * @param type        The faculty type
     * @param bldg        The building of the faculty office
     * @param room        The (building) room of the faculty office
     * @param email       The email of the faculty
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addFaculty(String firstName, String lastName,
                            FacultyType type, Building bldg, int room, String
                                   email) throws DuplicatePersonException {
        // TODO: implement addFaculty method

        // check if the person is duplicated
        if (!facultyList.isEmpty()) {
            for(int i = 0; i < facultyList.size();i++) {
                if (firstName.equals(facultyList.get(i).getFirstName())
                        && lastName.equals(facultyList.get(i).getLastName()))
                    throw new DuplicatePersonException();
            }
        }

        // declare Faculty class
        Faculty faculty = new Faculty(firstName, lastName);
        faculty.setFacultyType(type);
        faculty.setOffice(bldg, room);
        faculty.setEmail(email);
        faculty.setSUID(SUID);
        faculty.setStatus(PersonStatus.ACTIVE);
        facultyList.add(faculty);
        SUID++;
    }

    /**
     * Adds a subject to the subject list collection.
     * (hint: use a Map instead of creating a class)
     *
     * @param code    The subject code
     * @param desc    The subject description
     *
     * @throws DuplicateSubjectException The subject is already in the system
     */
    public void addSubject(SubjectCode code, String desc)
                            throws DuplicateSubjectException {

        // TODO: implement addSubject method
        // check if the subject is duplicated
        if(!subjects.isEmpty()){
            if (subjects.containsKey(code))
                throw new DuplicateSubjectException();
        }

        subjects.put(code, desc);
    }

    /**
     * Adds a course to the course list collection.
     *
     * @param code       The subject code of the course
     * @param num        The course number of the course
     * @param name       The course name
     * @param creditNum  The number of the credits of the course
     * @throws DuplicateCourseException    The course is already in the system
     */
    public void addCourse(SubjectCode code, int num, String name,
                            int creditNum) throws DuplicateCourseException {

        // TODO: implement addCourse method

        // check if the course is duplicated
        if (!courseList.isEmpty()){
            for (int i = 0; i < courseList.size(); i++){
                if (courseList.get(i).getCourseNum() == num)
                    throw new DuplicateCourseException();
            }
        }

        courseList.add(new Course(code, num, name, creditNum));
    }

    /**
     * Adds a prerequisite to an existing course in the course
     * list collection.
     *
     * @param code          The subject code of the course
     * @param num           The course number of the course
     * @param prereqCode    The subject code of the prerequisite
     *                      to add to the course
     * @param prereqNum     The course number of the prerequisite
     *                      to add to the course
     * @throws CourseNotFoundException The course was not found in the system
     */
    public void addPrerequisite(SubjectCode code, int num,
                            SubjectCode prereqCode, int prereqNum)
                            throws CourseNotFoundException {

        // TODO: implement addPrerequisite method

        // check if the course exists
        checkIfCourseExist(num);

        // add prerequisite data to the matched course
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCode().equals(code) &&
                    courseList.get(i).getCourseNum() == num) {
                courseList.get(i).setPrerequisite(prereqCode, prereqNum,
                        findPrereqName(prereqCode, prereqNum),
                        findPrereqCreditNum(prereqCode, prereqNum));
                break;
            }
        }
    }

    /**
     * Adds a section to the section list collection.
     *
     * @param code       The subject code of the course
     * @param courseNum  The course number of the course
     * @param sectionNum The section number for the course
     * @param firstName  The first name for the faculty teaching the course
     * @param lastName   The last name for the faculty teaching the course
     * @param quarter    The quarter that the course section is held
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     * @throws CourseNotFoundException   The course was not found in the system
     * @throws PersonNotFoundException   The person was not found in the system
     * @throws DuplicateSectionException The section is already in the system
     */
    public void addSection(SubjectCode code, int courseNum, int sectionNum,
                            String firstName, String lastName, Quarter quarter,
                           int year, int cap, Building bldg, int room)
                            throws CourseNotFoundException,
                            PersonNotFoundException, DuplicateSectionException {
        // TODO: implement addSection method

        // check if the course exists
        checkIfCourseExist(courseNum);

        // check if the person exists
        if (facultyList.isEmpty()){
            throw new PersonNotFoundException();
        } else {
            boolean findPerson = false;
            for (int i = 0; i < facultyList.size(); i++){
                if (facultyList.get(i).getFirstName().equals(firstName) &&
                        facultyList.get(i).getLastName().equals(lastName)){
                    findPerson = true;
                    break;
                }
            }
            if (!findPerson)
                throw new PersonNotFoundException();
        }

        // check if the section is duplicated
        if (!sectionList.isEmpty()) {
            for(int i = 0; i < sectionList.size(); i++){
                if (courseNum == sectionList.get(i).getCourseNumber() &&
                        sectionNum == Integer.parseInt(sectionList.get(i).
                                getSectionNum()))
                    throw new DuplicateSectionException();
            }
        }

        sectionList.add(new Section(copyCourse(code, courseNum), sectionNum,
                copyFaculty(firstName, lastName), quarter, year, cap, bldg,
                room));

    }

    /**
     * The PersonStatus method return the person's status.
     *
     * @param type The faculty type
     * @param year The start year of the student
     * @return The person's status
     */
    private PersonStatus checkStatus(StudentType type, int year){
        final int THISYEAR = Year.now().getValue();
        int grade = THISYEAR - year;
        PersonStatus status;

        if (type.toString().equals("UNDERGRAD")){
            if (grade > 4)
                status = PersonStatus.INACTIVE;
            else
                status = PersonStatus.ACTIVE;
        }
        else {
            if (grade > 6)
                status = PersonStatus.INACTIVE;
            else
                status = PersonStatus.ACTIVE;
        }

        return status;
    }

    /**
     * The checkStudentGrade method returns the student's grade.
     *
     * @param type The student type
     * @param year The start year of the student
     * @return The student's grade
     */
    public String checkStudentGrade(StudentType type, int year){
        String levelOfGrade;        // grade of student

        // check student's grade
        if (type.toString().equals("UNDERGRAD")){
            final int THISYEAR = Year.now().getValue();
            int grade = THISYEAR - year;
            if (grade <= 1)
                levelOfGrade = StudentYear.FRESHMAN.toString();
            else if (grade <= 2)
                levelOfGrade = StudentYear.SOPHOMORE.toString();
            else if (grade <= 3)
                levelOfGrade = StudentYear.JUNIOR.toString();
            else
                levelOfGrade = StudentYear.SENIOR.toString();
        }else
            levelOfGrade = "";

        return levelOfGrade;
    }

    /**
     * The getCourse method returns the Course class.
     *
     * @param code The course's code
     * @param courseNum The course's number
     * @return  A new Course class
     */
    public Course copyCourse(SubjectCode code, int courseNum){
        int index = 0;      // to store the location in the courses

        // find the aimed Course class
        for (int i = 0; i < courseList.size(); i++) {
            if (code.equals(courseList.get(i).getCode()) &&
                    courseNum == courseList.get(i).getCourseNum()) {
                index = i;
                break;
            }
        }
        return new Course(courseList.get(index));
    }

    /**
     * The getFaculty method returns the Faculty class.
     *
     * @param firstName The faculty's fist name
     * @param lastName The faculty's last name
     * @return A new Faculty class
     */
    public Faculty copyFaculty(String firstName, String lastName){
        int index = 0;      //to store the location in the courses

        // find the aimed Faculty class
        for (int i = 0; i < facultyList.size(); i++) {
            if (firstName.equals(facultyList.get(i).getFirstName()) &&
                    lastName.equals(facultyList.get(i).getLastName())) {
                index = i;
                break;
            }
        }
        return new Faculty(facultyList.get(index));
    }

    /**
     * The assignAdvisorToStudent method return an advisor's name.
     *
     * @return The advisor's name
     */
    public String assignAdvisorToStudent(){
        int assignedAdvisorIndex;           // The advisor index
        Random random = new Random();

        assignedAdvisorIndex = random.nextInt(facultyList.size());

        return facultyList.get(assignedAdvisorIndex).getAdvisor();
    }

    /**
     * The findPrereqName method returns the name of the prerequisite
     * course.
     *
     * @param prereqCode The subject code of the prerequisite to add to the
     *                   course
     * @param prereqNum The course number of the prerequisite to add to the
     *                  course
     * @return The name of the prerequisite course
     */
    public String findPrereqName(SubjectCode prereqCode, int prereqNum){
        String prereqName = "";     // The name of the prerequisite course

        // find the name of the prerequisite course
        for(int i = 0; i < courseList.size(); i++){
            if (courseList.get(i).getCode().equals(prereqCode) &&
                    courseList.get(i).getCourseNum() == prereqNum) {
                prereqName = courseList.get(i).getName();
                break;
            }
        }
        return prereqName;
    }

    public int findPrereqCreditNum(SubjectCode prereqCode, int prereqNum){
        int prereqCreditNum = -1;     // The credit of the prerequisite course

        // find the name of the prerequisite course
        for(int i = 0; i < courseList.size(); i++){
            if (courseList.get(i).getCode().equals(prereqCode) &&
                    courseList.get(i).getCourseNum() == prereqNum) {
                prereqCreditNum = courseList.get(i).getCreditNum();
                break;
            }
        }
        return prereqCreditNum;
    }

    /**
     * The checkIfTheCourseExists method checks if the aimed Course class exists
     *
     * @param number the Course code
     * @throws CourseNotFoundException The course was not found in the system
     */
    public void checkIfCourseExist(int number) throws CourseNotFoundException {

        // check if the course exists
        if (courseList.isEmpty()){
            throw new CourseNotFoundException();
        } else {
            boolean findCourse = false;

            for (int i = 0; i < courseList.size(); i++){
                if (courseList.get(i).getCourseNum() == number){
                    findCourse = true;
                    break;
                }
            }
            if (!findCourse)
                throw new CourseNotFoundException();
        }
    }

    /**
     * The getFacultiesInfo method appends information of faculties together.
     *
     * @return information of faculties
     */
    public String getFacultiesInfo(){
        StringBuilder builder = new StringBuilder();

        // append information of faculties to the builder
        for (int i = 0; i < facultyList.size(); i++){
            builder.append("Faculty: Name=").
                    append(facultyList.get(i).getFirstName()).
                    append(" ").append(facultyList.get(i).getLastName()).
                    append(", SUID=").append(facultyList.get(i).getSUID()).
                    append(", Email=").append(facultyList.get(i).getEmail()).
                    append(", Status=").append(facultyList.get(i).getStatus()).
                    append(", Type=").append(facultyList.get(i).
                    getFacultyType()).append(", Office=").
                    append(facultyList.get(i).getOffice()).append("\n");
        }

        return builder.toString();
    }

    /**
     * The getStudentsInfo method appends information of students together.
     *
     * @return information of students
     */
    public String getStudentsInfo(){
        StringBuilder builder = new StringBuilder();

        // append information of students to the builder
        for (int i = 0; i < studentList.size(); i++){
            builder.append("Student: Name=").
                    append(studentList.get(i).getFirstName()).
                    append(" ").append(studentList.get(i).getLastName()).
                    append(", SUID=").append(studentList.get(i).getSUID()).
                    append(", Email=").append(studentList.get(i).getEmail()).
                    append(", Status=").append(studentList.get(i).getStatus()).
                    append(", Type=").append(studentList.get(i).getType()).
                    append(", Program=").append(studentList.get(i).
                    getProgram()).append(", Term=").append(studentList.get(i).
                    getTerm()).append(", Advisor=").append(studentList.get(i).
                    getAdvisor());
            if (studentList.get(i).getType().equals("UNDERGRAD"))
                builder.append(", Year=").append(studentList.get(i).getYear()).
                        append("\n");
            else
                builder.append("\n");
        }

        return builder.toString();
    }

    /**
     * The getSubjectsInfo method appends information of subjects together.
     *
     * @return information of subjects
     */
    public String getSubjectsInfo(){
        StringBuilder builder = new StringBuilder();

        // append information of subjects to the builder
        for (HashMap.Entry<SubjectCode, String> entry : subjects.entrySet()) {
            builder.append("Subject: ").append(entry.getValue()).append("(").
                    append(entry.getKey()).append(")\n");
        }

        return builder.toString();
    }

    /**
     * The getCoursesInfo method appends information of courses together.
     *
     * @return information of courses
     */
    public String getCoursesInfo(){
        StringBuilder builder = new StringBuilder();

        // append information of courses to the builder
        for (int i = 0; i < courseList.size(); i++){
            builder.append("Course: Name=").append(courseList.get(i).
                    getCode()).append("-").append(courseList.get(i).
                    getCourseNum()).append(": ").append(courseList.get(i).
                    getName()).append(", Credits=").append(courseList.get(i).
                    getCreditNum()).append(", Prerequisites=[").
                    append(courseList.get(i).getPrerequisite()).append("]\n");
        }

        return builder.toString();
    }

    /**
     * The getSectionInfo method appends information of sections together.
     *
     * @return information of sections
     */
    public String getSectionInfo(){
        StringBuilder builder = new StringBuilder();

        // append information of sections to the builder
        for (int i = 0; i < sectionList.size(); i++) {
            builder.append("Section: Course=").append(sectionList.get(i).
                    getCourseCode()).append(" ").append(sectionList.get(i).
                    getCourseNumber()).append("-").append(sectionList.get(i).
                    getSectionNum()).append(": ").append(sectionList.get(i).
                    getCourse().getName()).append(", Faculty=").
                    append(sectionList.get(i).getFaculty().getAdvisor()).
                    append(", Term=").append(sectionList.get(i).
                    getTermAndYear()).append(", Capacity=").
                    append(sectionList.get(i).getCapacity()).append(", Room=").
                    append(sectionList.get(i).getBldgAndRoom()).append("\n");
        }

        return builder.toString();
    }

    // TODO: add RegistrationSystem collections
    // - student list
    // - faculty list
    // - subject list
    // = course list
    // - section list
    //
    // Note -- there is no list for prerequisites - these should be included
    // as part of the course list

    private List<Faculty> facultyList;                  // to store faculties
    private List<Student> studentList;                  // to store students
    private List<Course> courseList;                    // to store courses
    private List<Section> sectionList;                  // to store section
    private HashMap<SubjectCode, String> subjects;      // to store subjects

    private int SUID = 100001;                  // to initialize SUID to 100001
}
