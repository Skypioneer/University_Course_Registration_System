package cwang_hw4.driver;

import cwang_hw4.enums.Building;
import cwang_hw4.enums.FacultyType;
import cwang_hw4.enums.Quarter;
import cwang_hw4.enums.StudentType;
import cwang_hw4.enums.SubjectCode;
import cwang_hw4.enums.StudentProgram;
import cwang_hw4.exception.CourseNotFoundException;
import cwang_hw4.exception.DuplicateCourseException;
import cwang_hw4.exception.DuplicatePersonException;
import cwang_hw4.exception.DuplicateSubjectException;
import cwang_hw4.exception.PersonNotFoundException;
import cwang_hw4.system.RegistrationSystem;
import cwang_hw4.exception.DuplicateSectionException;
import cwang_hw4.exception.SectionNotFoundException;

/**
 * The program implements a simple course registration system for a university
 * by interfaces with RegistrationSystem, and populates Faculty, Students,
 * Courses, Prerequisites, and Sections class, and subjects HashMap.
 *
 * @author Jason Wang
 * @version 23.0
 */
public class Driver {

    /**
     * <p>The <strong>Driver</strong> interfaces with the cwang_hw4.registration
     * cwang_hw4.system and populates faculty, students, subjects, courses,
     * their prerequisites, and course sections.</p>
     *
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();
        populateSystem(system);

        // Print the results of the RegistrationSystem collections
        // this includes all the contents of: faculty, students, subjects,
        // courses (and their prerequisites), and course section;
        // cwang_hw4.additional functions may be added to the System to
        // complete this task.
        printSystem(system);
    }

    /**
     * The populateSystem method calls other methods to populates faculties,
     * students, subjects, courses, prerequisites, and sections.
     *
     * @param system The system that holds information of an university
     */
    private static void populateSystem(RegistrationSystem system) {
        try {
            populateFaculty(system);
            populateStudents(system);
            populateSubjects(system);
            populateCourses(system);
            populatePrerequisites(system);
            populateSections(system);
        } catch (DuplicatePersonException e) {
            System.out.println(e.getMessage());
        } catch (DuplicateSubjectException e) {
            System.out.println(e.getMessage());
        } catch (DuplicateCourseException e) {
            System.out.println(e.getMessage());
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (DuplicateSectionException e) {
            System.out.println(e.getMessage());
        } catch (SectionNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * The populateStudents method populates data of students.
     *
     * @param system The system that holds information of an university
     * @throws DuplicatePersonException The person already exist in the system.
     */
    private static void populateStudents(RegistrationSystem system)
            throws DuplicatePersonException {
        system.addStudent("Michael", "Bluth", StudentType.UNDERGRAD,
                StudentProgram.BSCS, Quarter.FQ, 2018);
        system.addStudent("Gob", "Bluth", StudentType.UNDERGRAD,
                StudentProgram.BACS, Quarter.SQ, 2018);
        system.addStudent("Buster", "Bluth", StudentType.UNDERGRAD,
                StudentProgram.BSCS, Quarter.WQ, 2018);
        system.addStudent("Lucille", "Bluth", StudentType.UNDERGRAD,
                StudentProgram.BSCS, Quarter.WQ, 2017);
        system.addStudent("Lindsay", "Funke", StudentType.UNDERGRAD,
                StudentProgram.BACS, Quarter.FQ, 2018);
        system.addStudent("Tobias", "Funke", StudentType.UNDERGRAD,
                StudentProgram.BACS, Quarter.FQ, 2017);
        system.addStudent("Maeby", "Funke", StudentType.UNDERGRAD,
                StudentProgram.BSCS, Quarter.SQ, 2017);
        system.addStudent("Kitty", "Sanchez", StudentType.UNDERGRAD,
                StudentProgram.UNDECIDED, Quarter.FQ, 2018);
        system.addStudent("Edsger", "Dijkstra", StudentType.GRAD,
                StudentProgram.CERT, Quarter.RQ, 2018);
        system.addStudent("Ada", "Lovelace", StudentType.GRAD,
                StudentProgram.CERT, Quarter.FQ, 2018);
        system.addStudent("Grace", "Hopper", StudentType.GRAD,
                StudentProgram.MSCS, Quarter.WQ, 2017);
        system.addStudent("Marie", "Curie", StudentType.GRAD,
                StudentProgram.CERT, Quarter.FQ, 2017);
        system.addStudent("Alan", "Turing", StudentType.GRAD,
                StudentProgram.CERT, Quarter.RQ, 2017);
        system.addStudent("Katherine", "Johnson", StudentType.GRAD,
                StudentProgram.MSCS, Quarter.FQ, 2018);
    }

    /**
     * The populateFaculty method populates data of faculties.
     *
     * @param system The system that holds information of an university
     * @throws DuplicatePersonException The person already exist in the system.
     */
    private static void populateFaculty(RegistrationSystem system)
            throws DuplicatePersonException {
        system.addFaculty("Adair", "Dingle", FacultyType.PROF, Building.ENGR,
                531, "dingle@seattleu.edu");
        system.addFaculty("Steven", "Hanks", FacultyType.LECTURE, Building.ENGR,
                511, "hankssteven@seattleu.edu");
        system.addFaculty("Pejman", "Khadivi", FacultyType.ASSTPROF,
                Building.ENGR, 521, "khadivip@seattleu.edu");
        system.addFaculty("Michael", "Koenig", FacultyType.LECTURE,
                Building.ENGR, 520, "koenigm@seattleu.edu");
        system.addFaculty("Eric", "Larson", FacultyType.PROF, Building.ENGR,
                528, "elarson@seattleu.edu");
        system.addFaculty("Richard", "LeBlanc", FacultyType.PROF, Building.ENGR,
                527, "leblanc@seattleu.edu");
        system.addFaculty("Lin", "Li", FacultyType.ASSTPROF, Building.ENGR, 529,
                "lil@seattleu.edu");
        system.addFaculty("David", "Lillethun", FacultyType.ASSTPROF,
                Building.ENGR, 506, "lillethd@seattleu.edu");
        system.addFaculty("Kevin", "Lundeen", FacultyType.INSTRUCT,
                Building.ENGR, 519, "lundeenk@seattleu.edu");
        system.addFaculty("Michael", "McKee", FacultyType.LECTURE,
                Building.ENGR, 519, "mckeem@seattleu.edu");
        system.addFaculty("Aditya", "Mishra", FacultyType.ASSTPROF,
                Building.ENGR, 507, "mishraa@seattleu.edu");
        system.addFaculty("James", "Obare", FacultyType.INSTRUCT,
                Building.ENGR, 502, "obarej@seattleu.edu");
        system.addFaculty("Sheila", "Oh", FacultyType.SEN_INSTRUCT,
                Building.ENGR, 504, "ohsh@seattleu.edu");
        system.addFaculty("Susan", "Reeder", FacultyType.SEN_INSTRUCT,
                Building.ENGR, 505, "sreeder@seattleu.edu");
        system.addFaculty("Roshanak", "Roshandel", FacultyType.ASSOCPROF,
                Building.ENGR, 508, "roshanak@seattleu.edu");
        system.addFaculty("Jason", "Wong", FacultyType.INSTRUCT,
                Building.ENGR, 526, "wongja@seattleu.edu");
        system.addFaculty("Yingwu", "Zhu", FacultyType.ASSOCPROF,
                Building.ENGR, 530, "zhuy@seattleu.edu");
    }

    /**
     * The populateSubjects method populates data of subjects
     *
     * @param system The system that holds information of an university
     * @throws DuplicateSubjectException The subjects already exist in the
     * system.
     */
    private static void populateSubjects(RegistrationSystem system)
            throws DuplicateSubjectException {
        system.addSubject(SubjectCode.BIOL, "Biology");
        system.addSubject(SubjectCode.CHEM, "Chemistry");
        system.addSubject(SubjectCode.CPSC, "Computer Science");
        system.addSubject(SubjectCode.MATH, "Mathematics");
    }

    /**
     * The populateCourses method populates data of courses.
     *
     * @param system The system that holds information of an university
     * @throws DuplicateCourseException The course already exist in the system.
     */
    private static void populateCourses(RegistrationSystem system)
            throws DuplicateCourseException {
        system.addCourse(SubjectCode.CPSC, 1420,
                "Programming and Problem Solving I", 5);
        system.addCourse(SubjectCode.CPSC, 1430,
                "Programming and Problem Solving II", 5);
        system.addCourse(SubjectCode.CPSC, 2430,
                "Data Structures", 5);
        system.addCourse(SubjectCode.CPSC, 2500,
                "Computer Organization", 5);
        system.addCourse(SubjectCode.CPSC, 2600,
                "Foundations of Computer Science", 5);
        system.addCourse(SubjectCode.CPSC, 3200,
                "Object-Oriented Development", 5);
        system.addCourse(SubjectCode.CPSC, 3300,
                "Fundamentals of Databases", 5);
        system.addCourse(SubjectCode.CPSC, 3400,
                "Languages and Computation", 5);
        system.addCourse(SubjectCode.CPSC, 3500, "Computing Systems", 5);
        system.addCourse(SubjectCode.CPSC, 4100,
                "Design and Analysis of Algorithms", 5);
        system.addCourse(SubjectCode.CPSC, 5001, "Programming Boot Camp I", 3);
        system.addCourse(SubjectCode.CPSC, 5002, "Programming Boot Camp II", 3);
        system.addCourse(SubjectCode.CPSC, 5003,
                "Programming Boot Camp III", 3);
        system.addCourse(SubjectCode.CPSC, 5011, "Object-Oriented Concepts", 3);
        system.addCourse(SubjectCode.CPSC, 5021, "Database Systems", 3);
        system.addCourse(SubjectCode.CPSC, 5031,
                "Data Structures and Algorithms", 3);
        system.addCourse(SubjectCode.CPSC, 5041,
                "Computing Systems Principles I", 3);
        system.addCourse(SubjectCode.CPSC, 5042,
                "Computing Systems Principles II", 3);
        system.addCourse(SubjectCode.CPSC, 5051,
                "Fundamentals of Software Engineering", 3);
        system.addCourse(SubjectCode.CPSC, 5200,
                "Software Architecture and Design", 5);
        system.addCourse(SubjectCode.CPSC, 5800,
                "Ethics and Professional Issues in Computing", 2);
        system.addCourse(SubjectCode.CPSC, 5600, "Parallel Computing", 5);
        system.addCourse(SubjectCode.CPSC, 5610, "Artificial Intelligence", 5);
        system.addCourse(SubjectCode.CPSC, 5510, "Computer Networks", 5);
        system.addCourse(SubjectCode.CPSC, 5520, "Distributed Systems", 5);
        system.addCourse(SubjectCode.CPSC, 5240, "Software as a Service", 5);
        system.addCourse(SubjectCode.CPSC, 5250,
                "Mobile Software Development", 5);
        system.addCourse(SubjectCode.CPSC, 5300,
                "Physical Database Design & Optimization", 5);
        system.addCourse(SubjectCode.CPSC, 5400,
                "Complier Principles and Techniques", 5);
        system.addCourse(SubjectCode.CPSC, 5700, "Computer Graphics", 5);
    }

    /**
     * The populatePrerequisites method populates data of prerequisites.
     *
     * @param system The system that holds information of an university
     * @throws CourseNotFoundException The course doesn't exist in the system.
     */
    private static void populatePrerequisites(RegistrationSystem system)
            throws CourseNotFoundException {
        system.addPrerequisite(SubjectCode.CPSC, 1430, SubjectCode.CPSC, 1420);
        system.addPrerequisite(SubjectCode.CPSC, 2430, SubjectCode.CPSC, 1430);
        system.addPrerequisite(SubjectCode.CPSC, 2500, SubjectCode.CPSC, 1430);
        system.addPrerequisite(SubjectCode.CPSC, 2600, SubjectCode.CPSC, 1430);
        system.addPrerequisite(SubjectCode.CPSC, 3200, SubjectCode.CPSC, 2430);
        system.addPrerequisite(SubjectCode.CPSC, 3300, SubjectCode.CPSC, 2430);
        system.addPrerequisite(SubjectCode.CPSC, 3400, SubjectCode.CPSC, 2430);
        system.addPrerequisite(SubjectCode.CPSC, 3400, SubjectCode.CPSC, 2600);
        system.addPrerequisite(SubjectCode.CPSC, 3500, SubjectCode.CPSC, 2430);
        system.addPrerequisite(SubjectCode.CPSC, 3500, SubjectCode.CPSC, 2500);
        system.addPrerequisite(SubjectCode.CPSC, 4100, SubjectCode.CPSC, 2430);
        system.addPrerequisite(SubjectCode.CPSC, 4100, SubjectCode.CPSC, 2600);
        system.addPrerequisite(SubjectCode.CPSC, 5002, SubjectCode.CPSC, 5001);
        system.addPrerequisite(SubjectCode.CPSC, 5003, SubjectCode.CPSC, 5002);
        system.addPrerequisite(SubjectCode.CPSC, 5011, SubjectCode.CPSC, 5003);
        system.addPrerequisite(SubjectCode.CPSC, 5021, SubjectCode.CPSC, 5003);
        system.addPrerequisite(SubjectCode.CPSC, 5042, SubjectCode.CPSC, 5041);
        system.addPrerequisite(SubjectCode.CPSC, 5200, SubjectCode.CPSC, 5011);
        system.addPrerequisite(SubjectCode.CPSC, 5200, SubjectCode.CPSC, 5051);
        system.addPrerequisite(SubjectCode.CPSC, 5600, SubjectCode.CPSC, 5031);
        system.addPrerequisite(SubjectCode.CPSC, 5600, SubjectCode.CPSC, 5042);
        system.addPrerequisite(SubjectCode.CPSC, 5610, SubjectCode.CPSC, 5031);
        system.addPrerequisite(SubjectCode.CPSC, 5510, SubjectCode.CPSC, 5042);
        system.addPrerequisite(SubjectCode.CPSC, 5520, SubjectCode.CPSC, 5042);
        system.addPrerequisite(SubjectCode.CPSC, 5240, SubjectCode.CPSC, 5042);
        system.addPrerequisite(SubjectCode.CPSC, 5250, SubjectCode.CPSC, 5011);
        system.addPrerequisite(SubjectCode.CPSC, 5300, SubjectCode.CPSC, 5021);
        system.addPrerequisite(SubjectCode.CPSC, 5700, SubjectCode.CPSC, 5031);
    }

    /**
     * The populateSections method populates data of sections.
     *
     * @param system The system that holds information of an university
     * @throws CourseNotFoundException The course doesn't exist in the system.
     * @throws PersonNotFoundException The person doesn't exist in the system.
     * @throws DuplicateSectionException The section already exist in the
     *                                   system.
     * @throws SectionNotFoundException The section doesn't exist in the system.
     */
    private static void populateSections(RegistrationSystem system)
            throws CourseNotFoundException, PersonNotFoundException,
            DuplicateSectionException, SectionNotFoundException {
        system.addSection(SubjectCode.CPSC, 2430, 1, "Susan", "Reeder",
                Quarter.FQ, 2018, 15, Building.PIGT, 207);
        system.addSection(SubjectCode.CPSC, 2430, 2, "Adair", "Dingle",
                Quarter.FQ, 2018, 30, Building.PIGT, 207);
        system.addSection(SubjectCode.CPSC, 2600, 1, "Sheila", "Oh",
                Quarter.FQ, 2018, 30, Building.LEML, 122);
        system.addSection(SubjectCode.CPSC, 4100, 1, "Yingwu", "Zhu",
                Quarter.FQ, 2018, 34, Building.PIGT, 102);
        system.addSection(SubjectCode.CPSC, 5011, 1, "Steven", "Hanks",
                Quarter.FQ, 2018, 20, Building.ADMN, 203);
        system.addSection(SubjectCode.CPSC, 5011, 2, "Sheila", "Oh",
                Quarter.FQ, 2018, 30, Building.LEML, 122);
        system.addSection(SubjectCode.CPSC, 5021, 1, "Michael", "McKee",
                Quarter.FQ, 2018, 36, Building.BANN, 401);
        system.addSection(SubjectCode.CPSC, 5021, 2, "Michael", "McKee",
                Quarter.FQ, 2018, 30, Building.LEML, 122);
        system.addSection(SubjectCode.CPSC, 5510, 1, "David", "Lillethun",
                Quarter.FQ, 2018, 30, Building.ENGR, 304);
        system.addSection(SubjectCode.CPSC, 5600, 2, "Kevin", "Lundeen",
                Quarter.FQ, 2018, 20, Building.BANN, 402);
    }

    /**
     * The printSystem method print all information out.
     *
     * @param system The system that holds information of an university
     */
    private static void printSystem(RegistrationSystem system) {
        // TODO: implement printSystem method

        System.out.println("-- FACULTY LIST --");
        System.out.println(system.getFacultiesInfo());

        System.out.println("\n-- STUDENT LIST --");
        System.out.println(system.getStudentsInfo());

        System.out.println("\n-- SUBJECT LIST --");
        System.out.println(system.getSubjectsInfo());

        System.out.println("\n-- COURSE LIST --");
        System.out.println(system.getCoursesInfo());

        System.out.println("\n-- SECTION LIST --");
        System.out.println(system.getSectionInfo());
    }
}
