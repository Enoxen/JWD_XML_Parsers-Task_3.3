package by.tc.parser_task.dao.action;

import by.tc.parser_task.dao.constant.TagName;
import by.tc.parser_task.entity.Gem;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class StaxParser {
    private List<Gem> gems = new ArrayList<>();
    private XMLInputFactory inputFactory;

    public StaxParser(){
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Gem> getGems(){
        return gems;
    }
    public void buildListOfGems(String filename){
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try{
            inputStream = new FileInputStream(new File(filename));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()){
                int type = reader.next();
                if(type == XMLStreamConstants.START_ELEMENT){
                    name = reader.getLocalName();
                    if(name.equals(TagName.GEM)){
                        Gem gem = buildGem(reader);
                        gems.add(gem);
                    }
                }
            }
        }
        catch (XMLStreamException e){
            e.printStackTrace();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(inputStream != null){
                    inputStream.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private Gem buildGem(XMLStreamReader reader) throws XMLStreamException{
        Gem gem = new Gem();
        gem.setId(Integer.parseInt(reader.getAttributeValue(null, TagName.ID)));
        String name;
        while(reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name){
                        case TagName.NAME:
                            gem.setName(getXMLText(reader)); break;
                        case TagName.PRECIOUSNESS:
                            gem.setPreciousness(getXMLText(reader)); break;
                        case TagName.COLOR:
                            gem.setColor(getXMLText(reader)); break;
                        case TagName.SHINE:
                            gem.setShine(getXMLText(reader)); break;
                        case TagName.TRANSPARENCY:
                            gem.setTransparency(getXMLText(reader)); break;
                        case TagName.VALUE:
                            gem.setValue(Float.parseFloat(getXMLText(reader))); break;
                    } break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(name.equals(TagName.GEM)){
                        return gem;
                    }
                    break;
            }
        }
        throw new XMLStreamException("unknown elem");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException{
        String text = null;
        if(reader.hasNext()){
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
