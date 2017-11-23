package by.tc.parser_task.dao.action;

import by.tc.parser_task.entity.Gem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class SaxParser extends DefaultHandler {
    private List<Gem> gems = new ArrayList<>();
    private Gem gem;
    private StringBuilder text;

    public SaxParser(){}

    public  List<Gem> getGems(){
        return gems;
    }
    @Override
    public void startDocument(){
        System.out.println("Parsing started");
    }

    @Override
    public void endDocument(){
        System.out.println("Parsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        System.out.println("start element->" +  "uri: " + uri + ", local name: " +
                localName + ", qName:" + qName);
        text = new StringBuilder();
        if(qName.equals("gem")){
            gem = new Gem();
            gem.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length){
        text.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)throws SAXException{
        switch (qName){
            case "name":
                gem.setName(text.toString()); break;
            case "preciousness":
                gem.setPreciousness(text.toString()); break;
            case "color":
                gem.setColor(text.toString()); break;
            case "shine":
                gem.setShine(text.toString()); break;
            case "transparency":
                gem.setTransparency(text.toString()); break;
            case "value":
                gem.setValue(Float.parseFloat(text.toString())); break;
            case "gem":
                gems.add(gem);
                gem = null;
                break;
        }
    }
}
