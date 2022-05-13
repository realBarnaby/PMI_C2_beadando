import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Bombs {


    //lists
    List<String> bombName = new ArrayList<>();
    List<String> bombIngredients = new ArrayList<>();
    List<String> bombEffect = new ArrayList<>();


    //constructor
    public Bombs(String bombName, String bombIngredients, String bombEffect) {
        this.bombName.add(bombName);
        this.bombIngredients.add(bombIngredients);
        this.bombEffect.add(bombEffect);
    }


    //getter
    public List<String> getBombName() {
        return bombName;
    }

    public List<String> getBombIngredients() {
        return bombIngredients;
    }

    public List<String> getBombEffect() {
        return bombEffect;
    }


    //setter
    public void setBombName(List<String> bombName) {
        this.bombName = bombName;
    }

    public void setBombIngredients(List<String> bombIngredients) {
        this.bombIngredients = bombIngredients;
    }

    public void setBombEffect(List<String> bombEffect) {
        this.bombEffect = bombEffect;
    }
}


//subclass
class Bomb{


    //instance
    List<Bombs> b = new ArrayList<>();


    //constructor
    /*public Bomb(String name, String ingredients, String effect) {
        super(name, ingredients, effect);
    }*/
    public Bomb() {

        try {
            String filepath = "src/main/resources/bombs.xml";
            File xmldoc = new File(filepath);
            DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbfact.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(xmldoc);
            NodeList nlist = doc.getElementsByTagName("bomb");
            for (int i = 0; i < nlist.getLength(); i++) {

                Node nnode = nlist.item(i);

                if (nnode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eelement = (Element) nnode;
                    addBomb(eelement.getElementsByTagName("name").item(0).getTextContent(), eelement.getElementsByTagName("ingredients").item(0).getTextContent(), eelement.getElementsByTagName("effect").item(0).getTextContent());

                }
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    //methods
    //add bomb method
    public void addBomb(String name, String ingredient, String effect) {
        Bombs tmp = new Bombs(name, ingredient, effect);
        b.add(tmp);
    }

    //print method
    public void bombOut() {

        int bdb = 0;

        for(Bombs elem: b) {
            System.out.println("name: " + elem.bombName + " ingredients: " + elem.bombIngredients + " effect: " + elem.bombEffect);
            bdb++;
        }

        System.out.println(bdb);

    }
}
