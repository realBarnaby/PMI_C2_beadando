import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Potions {


    //lists
    List<String> potionName = new ArrayList<>();
    List<String> potionIngredients = new ArrayList<>();
    List<String> potionEffect = new ArrayList<>();
    List<Double> potionDuration = new ArrayList<>();
    List<Integer> potionToxicity = new ArrayList<>();

    List<Toxication> toxicationTier = new ArrayList<>();

    //constructor
    public Potions(String potionName, String potionIngredients, String potionEffect, Double potionDuration, Toxication toxicationTier) {
        this.potionName.add(potionName);
        this.potionIngredients.add(potionIngredients);
        this.potionEffect.add(potionEffect);
        this.potionDuration.add(potionDuration);
        this.toxicationTier.add(toxicationTier);
    }


    //getter
    public List<String> getPotionName() {
        return potionName;
    }

    public List<String> getPotionIngredients() {
        return potionIngredients;
    }

    public List<String> getPotionEffect() {
        return potionEffect;
    }

    public List<Double> getPotionDuration() {
        return potionDuration;
    }

    public List<Integer> getPotionToxicity() {
        return potionToxicity;
    }


    //setter
    public void setPotionName(List<String> potionName) {
        this.potionName = potionName;
    }

    public void setPotionIngredients(List<String> potionIngredients) {
        this.potionIngredients = potionIngredients;
    }

    public void setPotionEffect(List<String> potionEffect) {
        this.potionEffect = potionEffect;
    }

    public void setPotionDuration(List<Double> potionDuration) {
        this.potionDuration = potionDuration;
    }

    public void setPotionToxicity(List<Integer> potionToxicity) {
        this.potionToxicity = potionToxicity;
    }

}


class Potion{


    //instance
    List<Potions> p = new ArrayList<>();


    //constructor
    public Potion() {

        try {
            String filepath = "src/main/resources/potions.xml";
            File xmldoc = new File(filepath);
            DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbfact.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(xmldoc);
            NodeList nlist = doc.getElementsByTagName("potion");
            for (int i = 0; i < nlist.getLength(); i++) {

                Node nnode = nlist.item(i);

                if (nnode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eelement = (Element) nnode;
                    addPotion(eelement.getElementsByTagName("name").item(0).getTextContent(), eelement.getElementsByTagName("ingredients").item(0).getTextContent(), eelement.getElementsByTagName("effect").item(0).getTextContent(), Double.parseDouble(eelement.getElementsByTagName("duration").item(0).getTextContent()), enumAdd(Integer.parseInt(eelement.getElementsByTagName("toxicity").item(0).getTextContent())));

                }
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    //methods
    //add potion method
    public void addPotion(String name, String ingredients, String effect, Double duration, Toxication toxicationTier) {
        Potions tmp = new Potions(name, ingredients, effect, duration, toxicationTier);
        p.add(tmp);
    }

    //setting the enum to values method
    public Toxication enumAdd(Integer toxicity) {
        switch(toxicity) {

            case 14: return Toxication.low;
            case 20: return Toxication.medium;
            case 25: return Toxication.high;
            case 30: return Toxication.veryHigh;
            default: return Toxication.none;

        }
    }

    //print method
    public void potionOut() {

        int pdb = 0;

        for (Potions elem: p) {
            System.out.println("name: " + elem.potionName + " ingredients: " + elem.potionIngredients + " effect: " + elem.potionEffect + " duration: " + elem.potionDuration + " toxication tier: " + elem.toxicationTier);
            pdb++;
        }

        System.out.println(pdb);
    }

    List<Potions> cart = new ArrayList<>();


    //methods
    //create
    public void buyPotion() {

        Scanner button = new Scanner(System.in);

        System.out.println("Choose a name of a potion you want to buy: ");
        String name = button.nextLine();


        for (int i=0; i<24; i++) {

            if (p.get(i).potionName.equals(name)) {
                cart.add(p.get(i));
            }

        }

    }

    //modify
    public void modifyPotion() {

        Scanner button = new Scanner(System.in);

        System.out.println("Choose a name of a potion you want to modify: ");
        String name = button.nextLine();

        System.out.println("Choose the name of the potion you want to modify the element to: ");
        String newName = button.nextLine();

        for (int i=0; i<24; i++) {

            if (p.get(i).potionName.equals(name)) {

                //cart.get(i) = p.get(newName);

            }

        }

    }


    //delete
    public void deletePotion() {

        Scanner button = new Scanner(System.in);

        System.out.println("Choose a name of a potion you want to delete: ");
        String name = button.nextLine();


        for (int i=0; i<24; i++) {

            if (p.get(i).potionName.equals(name)) {
                cart.remove(p.get(i));
            }

        }

    }

    //print
    public void printCart() {



    }

}
