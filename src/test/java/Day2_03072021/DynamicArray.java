package Day2_03072021;

public class DynamicArray {
    public static void main(String[] args) {
        // declare countries variable
        String[] countries;
        // declare int variable
        int[] streetNumber;

        //set the length of the array for number of data it can store
        countries = new String[4];
        countries[0] = "USA";
        countries[1] = "Spain";
        countries[2] = "Bangladesh";
        countries[3] = "india";

        //set the length of array for street number
        streetNumber = new int[4];
        streetNumber[0] = 222;
        streetNumber[1] = 333;
        streetNumber[2] = 444;

        //print usa frm countries list
        System.out.println("country is " + countries[0] + " on street number " + streetNumber[1]);

    }// end of main method
}//end of java class