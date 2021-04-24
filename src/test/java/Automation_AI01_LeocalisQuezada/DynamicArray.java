package Automation_AI01_LeocalisQuezada;

public class DynamicArray {
    public static void main(String[] args) {

        //declare ZipCode variable
        String[] ZipCode;
        //declare int variable
        int[] StreetNumber;

        //set the length of the array number of data it can store
        ZipCode = new String[4];
        ZipCode[0] = "10701";
        ZipCode[1] = "10702";
        ZipCode[2] = "10703";
        ZipCode[3] = "10704";

        // set the length of the array for all the street number
        StreetNumber = new int[4];
        StreetNumber [0] = 558;
        StreetNumber [1] = 559;
        StreetNumber [2] = 560;
        StreetNumber [3] = 561;

         // set your iteration to loop through all the values from zipcode
        for (int i = 0;i < ZipCode.length; i++) {
            //print out all the values in one print statement
            System.out.println("My Zip Code is " + ZipCode[i] + " and my street number is " + StreetNumber[i]);
        }// end of for loop

    }//end of main
}//end of java class
