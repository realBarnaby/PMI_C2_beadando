import java.util.Scanner;

public class Alaa {


    Scanner button = new Scanner(System.in);

    //methods
    //examine if it's a digit method
    public Boolean isDigit(String strDigit) {
        if (strDigit == null) {
            return false;
        }
        try {
            double tmp = Double.parseDouble(strDigit);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //string to digit converter method
    public Integer response(String strDigit) {
        while (!isDigit(strDigit)) {
            System.out.println("Choose a number, please: ");
            strDigit = button.nextLine();
        }
        return Integer.parseInt(strDigit);
    }


    //print methods
    public void potions() {

        Potion lol = new Potion();
        lol.potionOut();

    }

    public void bombs() {

        Bomb kek = new Bomb();
        kek.bombOut();

    }

    public void oils() {

        Oil pog = new Oil();
        pog.oilOut();

    }

    public void ingredients() {

        Ingredient xd = new Ingredient();
        xd.ingredientsOut();

    }


    //terminal
    public void herbalist() {

        System.out.println("Hello there!");
        System.out.println("Take a look at my wares");

        //options
        System.out.println("\n1. List of potions");
        System.out.println("2. Potion brewing");
        System.out.println("3. List of bombs");
        System.out.println("4. Bomb crafting");
        System.out.println("5. List of oils");
        System.out.println("6. Oil crafting");
        System.out.println("7. Buy ingredients");
        System.out.println("8. Farewell");
        System.out.print("Choose from the services above: ");
        String strAnswer = button.nextLine();


        Boolean check = false;
        while (!check) {
            switch(response(strAnswer)) {

                //List of potions
                case 1:
                    System.out.println("\nListing potions..\n");
                    potions();
                    break;

                //Potion brewing
                case 2:
                    System.out.println("\nHere you can brew potions");
                    System.out.println("For a modest fee of course");
                    System.out.println("Which potion would you like to brew?");
                    brewPotion();
                    break;

                //List of bombs
                case 3:
                    System.out.println("\nListing bombs..\n");
                    bombs();
                    break;

                //Bomb crafting
                case 4:
                    System.out.println("\nYou like throwing bombs and watch them break havoc?");
                    System.out.println("Hah! You have a fine taste mate");
                    System.out.println("If you're interested I can surely make you some fresh toy");
                    System.out.println("I even give you a discount as a token of my appreciation!");
                    System.out.println("So which bomb do we start with?");
                    craftBomb();
                    break;

                //List of oils
                case 5:
                    System.out.println("\nListing oils..\n");
                    oils();
                    break;

                //Oil crafting
                case 6:
                    System.out.println("\nOh yes, oils to enhance your blade with");
                    System.out.println("Sure I can help you with that");
                    System.out.println("Show your coin and we can get to it");
                    System.out.println("Good. Now tell me which one do you want");
                    craftOil();
                    break;

                //Buy ingredients
                case 7:
                    System.out.println("\nYou need ingredients?");
                    System.out.println("As I thought! It's your lucky day then I tell you");
                    System.out.println("I have everything you would ever need");
                    System.out.println("But first make your choice");
                    buy();
                    break;

                //Farewell
                case 8:
                    System.out.println("\nCome again");
                    System.out.println("Farewell");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nWhat? Sorry I can't help you with that");
                    break;

            }

            //options
            System.out.println("\n1. List of potions");
            System.out.println("2. Potion brewing");
            System.out.println("3. List of bombs");
            System.out.println("4. Bomb crafting");
            System.out.println("5. List of oils");
            System.out.println("6. Oil crafting");
            System.out.println("7. Buy ingredients");
            System.out.println("8. Farewell");
            System.out.print("Choose from the services above: ");
            strAnswer = button.nextLine();
        }
    }


    public void brewPotion() {
        System.out.println("b");
    }

    public void craftBomb() {
        System.out.println("c");
    }

    public void craftOil() {
        System.out.println("d");
    }

    public void buy() {
        System.out.println("a");
    }

}
