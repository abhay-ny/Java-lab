// FinalMarks.java
import CIE.Internals;
import SEE.External;

public class FinalMarks {
    public static void main(String[] args) {
        // Create internal marks for students
        int[] internalMarks1 = {80, 75, 70, 85, 90};
        int[] internalMarks2 = {78, 82, 88, 76, 84};

        // Create external marks for students
        int[] externalMarks1 = {85, 80, 90, 70, 75};
        int[] externalMarks2 = {80, 85, 90, 88, 78};

        // Create Internals and External students
        Internals student1 = new Internals("24BECS404", "Abhay NY", 5, internalMarks1);
        External student2 = new External("24BECS412", " Koala", 5, externalMarks2);

        // Calculate the final marks (sum of internal and external marks)
        int finalMarks1 = student1.calculateInternalMarks() + student2.calculateExternalMarks();
        int finalMarks2 = student1.calculateInternalMarks() + student2.calculateExternalMarks();

        // Displaying the final marks of students
        System.out.println("Student 1 - USN: " + student1.getUsn() + ", Name: " + student1.getName() + ", Final Marks: " + finalMarks1);
        System.out.println("Student 2 - USN: " + student2.getUsn() + ", Name: " + student2.getName() + ", Final Marks: " + finalMarks2);
    }
}
