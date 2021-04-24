package Day2_03072021;

public class LinearArray {


    public static void main(String[] args) {
    //declare the variable
        String[] cities, countries, Locations;
        int[] streetNumber, houseNumber;

        cities = new String[]{"Brooklyn" , "Queens" , "Manhattan" , "Bronx" , "Staten Island"};
        streetNumber = new int[]{222,3345,567,888,1000};
        houseNumber = new int[]{222,4,4,4,4};
        // I want to print queens and street number as 222;
        System.out.println("My city is " + cities[1] + " and street number is " + streetNumber[0]);


    } //end of main method

} // end of java class
