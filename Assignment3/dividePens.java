public class dividePens{
    public static void main(String[]args) {
        int totalPens = 14;
        int numberOfStudents = 3;
        // Calculate pens per student and remaining pens
        int pensPerStudent = totalPens / numberOfStudents;
        int remaining_Pens = totalPens % numberOfStudents;
        // Display the result
        System.out.println("The Pen Per Student is " + pensPerStudent +
                          " and the remaining pen not distributed is " + remaining_Pens);
   }
}
