import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Oils {


    //lists
    List<String> oilName = new ArrayList<>();
    List<String> oilIngredients = new ArrayList<>();
    List<String> oilEffect = new ArrayList<>();


    //constructor
    public Oils(String oilName, String oilIngredients, String oilEffect) {
        this.oilName.add(oilName);
        this.oilIngredients.add(oilIngredients);
        this.oilEffect.add(oilEffect);
    }


    //getter
    public List<String> getOilName() {
        return oilName;
    }

    public List<String> getOilIngredients() {
        return oilIngredients;
    }

    public List<String> getOilEffect() {
        return oilEffect;
    }


    //setter
    public void setOilName(List<String> oilName) {
        this.oilName = oilName;
    }

    public void setOilIngredients(List<String> oilIngredients) {
        this.oilIngredients = oilIngredients;
    }

    public void setOilEffect(List<String> oilEffect) {
        this.oilEffect = oilEffect;
    }
}


//subclass
class Oil{


    //instance
    List<Oils> o = new ArrayList<>();


    //constructor
    /*public Oil(String oilName, String oilIngredients, String oilEffect) {
        super(oilName, oilIngredients, oilEffect);
    }*/
    public Oil() {
        try {
            String filepath = "src/main/resources/oils.xml";
            File xmldoc = new File(filepath);
            DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbfact.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(xmldoc);
            NodeList nlist = doc.getElementsByTagName("oil");
            for (int i = 0; i < nlist.getLength(); i++) {

                Node nnode = nlist.item(i);

                if (nnode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eelement = (Element) nnode;
                    addOil(eelement.getElementsByTagName("name").item(0).getTextContent(), eelement.getElementsByTagName("ingredients").item(0).getTextContent(), eelement.getElementsByTagName("effect").item(0).getTextContent());

                }
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    //methods
    //add oil method
    public void addOil(String oilName, String oilIngredients, String oilEffect) {
        Oils tmp = new Oils(oilName, oilIngredients, oilEffect);
        o.add(tmp);
    }

    //print method
    public void oilOut() {

        int odb = 0;

        for (Oils elem: o) {
            System.out.println("name: " + elem.oilName + " ingredients: " + elem.oilIngredients + " effect: " + elem.oilEffect);
            odb++;
        }

        System.out.println(odb);

    }

}