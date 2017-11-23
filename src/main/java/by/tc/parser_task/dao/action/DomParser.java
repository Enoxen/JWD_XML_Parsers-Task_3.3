package by.tc.parser_task.dao.action;

import by.tc.parser_task.entity.Gem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class DomParser {
    private List<Gem> gems;
    private DocumentBuilder docBuilder;

    public DomParser(){
        this.gems = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            docBuilder = factory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e){
            e.printStackTrace();
        }
    }

    public List<Gem> getGems(){
        return gems;
    }

    public void buildListOfGems(String filename){
        Document doc = null;
        try{
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();

            NodeList gemsList = root.getElementsByTagName("gem");
            for(int i = 0; i < gemsList.getLength(); i++){
                Element gemElem = (Element)gemsList.item(i);
                Gem gem = buildGem(gemElem);
                gems.add(gem);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (SAXException e){
            e.printStackTrace();
        }
    }
    private Gem buildGem(Element gemElement){
        Gem gem = new Gem();
        gem.setId(Integer.parseInt(gemElement.getAttribute("id")));
        gem.setName(getElementTextContent(gemElement,"name"));
        gem.setPreciousness(getElementTextContent(gemElement,"preciousness"));
        gem.setColor(getElementTextContent(gemElement,"color"));
        gem.setShine(getElementTextContent(gemElement,"shine"));
        gem.setTransparency(getElementTextContent(gemElement,"transparency"));
        gem.setValue(Float.parseFloat(getElementTextContent(gemElement,"value")));
        return gem;
    }
    private String getElementTextContent(Element element, String elementName ){
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
