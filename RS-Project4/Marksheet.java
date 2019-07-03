import java.util.*;

/**
 * computes operation on grades of students
 */
class GradesOperations {
    private int noOfStudents;

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    /**
     * calculate average grade of each student
     * 
     * @param gradesOfStudents[][] stores grades of students, averageGradeList[] stores average grades
     */
    public void averageOfStudent(float gradesOfStudents[][], float averageGradeList[]) {
        float sumOfGrade;
        for (int i = 0; i < noOfStudents; i++) {
            sumOfGrade = 0;
            for (int j = 0; j < 5; j++) {
                sumOfGrade += gradesOfStudents[i][j];
            }
            averageGradeList[i] = sumOfGrade / 5;
            System.out.printf("\n The average Grade of " + (i + 1) + "student is:" + "%.2f", (sumOfGrade / 5));
        }
    }

    /**
     * calculate maximum grade of each student
     * 
     * @param gradesOfStudents[][] stores grades of students
     */
    public void maximumGrade(float gradesOfStudents[][]) {
        float maximumGrade = 0;
        for (int i = 0; i < noOfStudents; i++) {
            maximumGrade = 0;
            for (int j = 0; j < 5; j++) {
                if (gradesOfStudents[i][j] > maximumGrade) {
                    maximumGrade = gradesOfStudents[i][j];
                }
            }
            System.out.printf("\n The maximum Grade of " + (i + 1) + "student is:" + "%.2f", maximumGrade);
        }
    }

    /**
     * calculate minimum grade of each student
     * 
     * @param gradesOfStudents[][] stores grades of students
     */
    public void minimumGrade(float gradesOfStudents[][]) {
        float minimumGrade = 0;
        for (int i = 0; i < noOfStudents; i++) {
            minimumGrade = 0;
            for (int j = 0; j < 5; j++) {
                if (gradesOfStudents[i][j] < minimumGrade) {
                    minimumGrade = gradesOfStudents[i][j];
                }
            }
            System.out.printf("\n The minimum Grade of " + (i + 1) + "student is:" + "%.2f", minimumGrade);
        }
    }

    /**
     * calculate student grades for pass or fail
     * 
     * @param gradesOfStudents[][] stores grades of students, averageGradeList[] stores
     *            average grades
     */
    public void passStudents(float gradesOfStudents[][], float averageGradeList[]) {
        for (int i = 0; i < noOfStudents; i++) {
            if (averageGradeList[i] >= 40) {
                System.out.println("\n The " + (i + 1) + "student is pass");
            } else {
                System.out.println("\n The " + (i + 1) + "student is fail");
            }
        }
    }
}

public class Marksheet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students");
        int noOfStudents = sc.nextInt();
        float[][] gradesOfStudents = new float[noOfStudents][5];
        float[] averageGradeList = new float[noOfStudents];
        try {
            for (int i = 0; i < noOfStudents; i++) {
                System.out.println("Enter grades of " + (i + 1) + " student Of Hindi, English, Maths, Science, SSt: ");
                for (int j = 0; j < 5; j++) {
                    gradesOfStudents[i][j] = sc.nextFloat();
                    if (gradesOfStudents[i][j] < 0.00 || gradesOfStudents[i][j] > 100.00) {
                        throw new ArithmeticException();
                    }
                }
            }
        } catch (ArithmeticException e) {
            System.out.println("Input grade is invalid");
            System.exit(0);
        }
        GradesOperations studentMarksheet = new GradesOperations();
        studentMarksheet.setNoOfStudents(noOfStudents);
        studentMarksheet.averageOfStudent(gradesOfStudents, averageGradeList);
        studentMarksheet.maximumGrade(gradesOfStudents);
        studentMarksheet.minimumGrade(gradesOfStudents);
        studentMarksheet.passStudents(gradesOfStudents, averageGradeList);
    }
}
