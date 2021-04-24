package Day3_03132021;

public class Multiplecondition {
    public static void main(String[] args) {

        //using multiple conditional statements
        int a,b,c;
        a = 2;
        b = 3;
        c = 4;

        //verify either a+b >c, a+b < c, a+b = c
        if (a+b >c){
            System.out.println("a & b is greater than c");
        }else if (a+b < c) {
            System.out.println("a & b is less than c");
        }else { //if previous two conditions didn't match then you can just ended with else statement
            System.out.println("a & b is equal than c");
        }//end of multiple condition

    }//end of main method
}//end of java class
