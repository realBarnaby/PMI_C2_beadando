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

    Potion vm = new Potion();

    //terminal
    public void herbalist() {

        System.out.println("Hello there!");
        System.out.println("Take a look at my wares");

        //options
        System.out.println("\n1. List of potions");
        System.out.println("2. List of bombs");
        System.out.println("3. List of oils");
        System.out.println("4. Buy potions");
        System.out.println("5. Modify potions in cart");
        System.out.println("6. Delete potions from cart");
        System.out.println("9. Print contents of shopping cart");
        System.out.println("7. Farewell");
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

                //List of bombs
                case 2:
                    System.out.println("\nListing bombs..\n");
                    bombs();
                    break;

                //List of oils
                case 3:
                    System.out.println("\nListing oils..\n");
                    oils();
                    break;

                //Buy potions
                case 4:
                    vm.buyPotion();
                    break;

                //Modify potions
                case 5:
                    //modifyPotion();
                    break;

                //Delete potions
                case 6:
                    vm.deletePotion();
                    break;

                //Print contents of shopping cart
                case 7:
                    //printCart();
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
            System.out.println("2. List of bombs");
            System.out.println("3. List of oils");
            System.out.println("4. Buy potions");
            System.out.println("5. Modify potions in cart");
            System.out.println("6. Delete potions from cart");
            System.out.println("9. Print contents of shopping cart");
            System.out.println("8. Farewell");
            System.out.print("Choose from the services above: ");
            strAnswer = button.nextLine();
        }
    }

}
