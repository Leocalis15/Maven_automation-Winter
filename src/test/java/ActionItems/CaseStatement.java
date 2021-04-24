package ActionItems;

public class CaseStatement {
    public static void main(String[] args) {

   /*using case statement if grade system is A,B, C, D, or F
   else grade system is invalid grade
  */
        //declare and define the variable grade system
        String gradeSystem = "grade is A";

        switch (gradeSystem){

            case "A":
                System.out.println("Excellent Grade");
                break;
            case "B":
                System.out.println("Well Done");
                break;
            case "C":
                System.out.println("Satisfactory");
                break;
            case "D":
                System.out.println("Passed");
                break;
            case "F":
                System.out.println("Fail");
                break;
            default:
                System.out.println("Invalid Grade");

        }// end of case statement
    }// end of main method
}// end of java class
