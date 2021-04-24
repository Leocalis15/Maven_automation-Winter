package Day3_03132021;

public class switchcasestatements {
    public static void main(String[] args) {

        /*using switch cases statements print
        if milkType is oat milk, almond milk, organic milk
        else milk type is not recognized
         */

        //declare and define the variable for milkType
        String milkType = "soy milk";
        switch (milkType){
            case "oat milk":
                System.out.println("Milk Type is oat milk");
                break;
            case "almond milk":
                System.out.println("Milk Type is almond milk");
                break;
            case "organic milk":
                System.out.println("Milk Type is organic milk");
                break;
            default:
                System.out.println("Milk Type is not recognized" + milkType);
        }//end of switch statement

    }//end of main method

}// end of java class
