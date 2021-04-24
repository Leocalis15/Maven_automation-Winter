package Day2_03072021;

public class ForLoopExample {
    public static void main(String[] args) {
String[] cities;

cities = new String[4];
cities[0] = "Brooklyn";
cities[1] = "Queens";
cities[2] = "Manhattan";
cities[3] = "Bronx";

//set your iteration to loop through all the values to cities
        for (int i = 0;i < cities.length; i++){
            //print out all values in one print statement
            System.out.println(" my city is " + cities[i] + " house address is " );
        }
    }//end of main
}//end of java class
