import java.io.*;

public class studentDataStream{
    public static void main(String[] args) {
        String fileName = "students.dat";

        // Write student data to a file
        writeStudentData(fileName);

        // Read student data from the file
        readStudentData(fileName);
    }

    private static void writeStudentData(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    private static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
