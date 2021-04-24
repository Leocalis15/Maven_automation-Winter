package ActionItems;

public class Assignment3 {
    public static void main(String[] args) {
        String[] Cities = new String[4];

        Cities [0] = "Brooklyn";
        Cities [1] = "Queens";
        Cities [2] = "Manhattan";
        Cities [3] = "Staten Island";

        // using for loop print with conditional statements only when city is Brooklyn or Manhattan
        for (int i = 0; i < Cities.length; i++) {
            if (Cities[i] == "Brooklyn") {
                System.out.println("City is " + Cities[i]);
            } else if (Cities[i] == "Manhattan") {
                System.out.println("City is " + Cities[i]);

        }// end of cases statements
        }// end of for loop
    }// end of main method
}// end of java class

