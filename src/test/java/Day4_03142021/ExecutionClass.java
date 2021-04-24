package Day4_03142021;

public class ExecutionClass {
    public static void main(String[] args) {
// this is where you can call your reusable method to be executed
        //inside main method
        ReusableMethodExp.addtwonumbers(20,30);
        ReusableMethodExp.addtwonumbers(60,30);

        //call subtract method and store the result
        int c = ReusableMethodExp.subtractTwoNumbers(40,20);
        System.out.println("New result " + (c+5));
    }

    //end of main method
}
