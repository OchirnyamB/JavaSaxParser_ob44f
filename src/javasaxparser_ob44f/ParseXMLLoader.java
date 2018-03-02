/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparser_ob44f;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author ob44f
 */
public class ParseXMLLoader {
    private static String textBody;
    public static void load(File xmlCourseFile) throws Exception{
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){
                @Override
                public void startDocument() throws SAXException {
                    textBody += "\nStart of Document:\n";
                }

                @Override
                public void endDocument() throws SAXException {
                    textBody += "\nEnd of Document.";
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException {
                    textBody += " <Start of Element>: " + qName;
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    textBody += " <End of Element> " + qName;
                }
                @Override
                public void characters(char[] ch, int start, int length) {
                    textBody += " " + new String(ch, start, length);
                }
            };
            saxParser.parse(xmlCourseFile.getAbsoluteFile(), handler);
        } catch(IOException | SAXException ex){
            throw ex;
        }
    }
    public String getTextBody(){
        return this.textBody;
    }
    public void setTextBody(){
        this.textBody = "";
    }
}
