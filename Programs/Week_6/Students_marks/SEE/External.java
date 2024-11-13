// SEE/External.java
package SEE;

import CIE.Student;

public class External extends Student {
    protected int[] externalMarks; // Array to store external marks for 5 courses

    // Constructor
    public External(String usn, String name, int sem, int[] externalMarks) {
        super(usn, name, sem);
        this.externalMarks = externalMarks;
    }

    // Method to get external marks
    public int[] getExternalMarks() {
        return externalMarks;
    }

    // Method to calculate external marks total
    public int calculateExternalMarks() {
        int total = 0;
        for (int marks : externalMarks) {
            total += marks;
        }
        return total;
    }
}
