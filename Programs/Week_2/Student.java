import java.util.Scanner;

class StudentInfo {
    String usn;
    String name;
    int numSubjects;
    int[] credits;
    int[] marks;
    
    // Method to accept student details
    void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        
        System.out.print("Enter number of subjects: ");
        numSubjects = sc.nextInt();
        
        credits = new int[numSubjects];
        marks = new int[numSubjects];
        
        System.out.println("Enter the credits for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();
        }
        
        System.out.println("Enter the marks for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }
    
    // Method to display student details
    void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Credits and Marks for each subject:");
        
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }
        
        System.out.println("SGPA: " + calculateSGPA());
    }
    
    // Method to calculate SGPA
    double calculateSGPA() {
        int totalCredits = 0;
        double totalGradePoints = 0.0;
        
        for (int i = 0; i < numSubjects; i++) {
            int gradePoint = getGradePoint(marks[i]);
            totalGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }
        
        return totalGradePoints / totalCredits;
    }
    
    // Method to convert marks to grade points
    int getGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0;  // Fail
    }
}

public class Student {
    public static void main(String[] args) {
        StudentInfo student = new StudentInfo();
        
        student.acceptDetails();
        
        student.displayDetails();

        System.out.println("Abhay NY");
        System.out.println("24BECS404");
    }
}
