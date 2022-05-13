import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ingredients {

    List<String> ingredientsName = new ArrayList<>();
    List<Integer> ingredientsPrice = new ArrayList<>();
    List<Integer> ingredientsQuantity = new ArrayList<>();


    public Ingredients(String ingredientsName, Integer ingredientsPrice, Integer ingredientsQuantity) {
        this.ingredientsName.add(ingredientsName);
        this.ingredientsPrice.add(ingredientsPrice);
        this.ingredientsQuantity.add(ingredientsQuantity);
    }

}

class Ingredient {

    List<Ingredients> ing = new ArrayList<>();

    public Ingredient() {

        try {
            String filepath = "src/main/resources/ingredients.xml";
            File xmldoc = new File(filepath);
            DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbfact.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(xmldoc);
            NodeList nlist = doc.getElementsByTagName("ingredient");
            for (int i = 0; i < nlist.getLength(); i++) {

                Node nnode = nlist.item(i);

                if (nnode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eelement = (Element) nnode;
                    String iName = eelement.getElementsByTagName("name").item(0).getTextContent();
                    Integer iPrice = Integer.parseInt(eelement.getElementsByTagName("price").item(0).getTextContent());
                    Integer iQuantity = Integer.parseInt(eelement.getElementsByTagName("quantity").item(0).getTextContent());
                    addIngredients(iName, iPrice, iQuantity);

                }
            }
        }
            catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addIngredients(String name, Integer price, Integer quantity) {
        Ingredients tmp = new Ingredients(name, price, quantity);
        ing.add(tmp);
    }

    public void ingredientsOut() {

        int idb = 0;

        for (Ingredients ingr: ing) {
            System.out.println("name: " + ingr.ingredientsName + " price: " + ingr.ingredientsPrice + " quantity: " + ingr.ingredientsQuantity) ;
            idb++;
        }
        System.out.println(idb);

    }

    public void potionsPrice(String line) {

        Integer finalPrice = 0;
        String[] array = line.split(",");

        for (String s: array) {
            String element = s.trim().substring(1);
            Integer elementQuantity = Integer.parseInt(s.trim().substring(0, 1));

            for (int i=0; i<ing.size(); i++) {
                if (ing.get(i).ingredientsName.equals(element)) {
                    System.out.println(ing.get(i).ingredientsPrice.toString());
                }
            }
        }

        //return finalPrice;
    }

}
