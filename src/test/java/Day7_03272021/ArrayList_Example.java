package Day7_03272021;

import java.util.ArrayList;
import java.util.concurrent.LinkedTransferQueue;

public class ArrayList_Example {
    public static void main(String[] args) {

        ArrayList<String> Cities = new ArrayList<>();
        Cities.add("Brooklyn");
        Cities.add("Queens");
        Cities.add("Manhattan");
        Cities.add("Staten Island");
        Cities.add("Bronx");

        for (int i=0; i<Cities.size();i++){
            if(Cities.get(i) == "Queens"){
                System.out.println("My city is " + Cities.get(i));
            }
        }



    }//end of main
}//end of java class
