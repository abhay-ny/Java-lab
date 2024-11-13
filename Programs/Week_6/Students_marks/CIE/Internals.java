// CIE/Internals.java
package CIE;

public class Internals extends Student {
    protected int[] internalMarks; // Array to store internal marks for 5 courses

    // Constructor
    public Internals(String usn, String name, int sem, int[] internalMarks) {
        super(usn, name, sem);
        this.internalMarks = internalMarks;
    }

    // Method to get internal marks
    public int[] getInternalMarks() {
        return internalMarks;
    }

    // Method to calculate internal marks total
    public int calculateInternalMarks() {
        int total = 0;
        for (int marks : internalMarks) {
            total += marks;
        }
        return total;
    }
}
