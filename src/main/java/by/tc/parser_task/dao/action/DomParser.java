package by.tc.parser_task.dao.action;

import by.tc.parser_task.dao.constant.TagName;
import by.tc.parser_task.entity.Gem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(StaxParser.class);
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
        logger.info("Started DOM parsing");
        Document doc = null;
        try{
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();

            NodeList gemsList = root.getElementsByTagName(TagName.GEM);
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
        gem.setId(Integer.parseInt(gemElement.getAttribute(TagName.ID)));
        gem.setName(getElementTextContent(gemElement,TagName.NAME));
        gem.setPreciousness(getElementTextContent(gemElement,TagName.PRECIOUSNESS));
        gem.setColor(getElementTextContent(gemElement,TagName.COLOR));
        gem.setShine(getElementTextContent(gemElement,TagName.SHINE));
        gem.setTransparency(getElementTextContent(gemElement,TagName.TRANSPARENCY));
        gem.setValue(Float.parseFloat(getElementTextContent(gemElement,TagName.VALUE)));
        return gem;
    }
    private String getElementTextContent(Element element, String elementName ){
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
