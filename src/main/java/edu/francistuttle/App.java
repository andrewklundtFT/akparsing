package edu.francistuttle;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Document lab = readXMLDocumentFromFile("C:/Users/ak1036178/Desktop/Hitgub/akparsing/src/main/java/edu/francistuttle/lab.xml");
        displayComputers(lab);
    }

    public static Document readXMLDocumentFromFile(String fileNameWithPath) throws Exception {

        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
    
        //Build Document
        Document document = builder.parse(new File(fileNameWithPath));
    
        return document;
    }

    public static void displayComputers(Document doc) {
        NodeList computerList = doc.getElementsByTagName("computer");
        for (int i = 0; i < computerList.getLength(); i++) {
            Element computer = (Element) computerList.item(i);
            System.out.println("computer id: " + computer.getAttribute("id"));
            System.out.println("\tmanufacturer: " + computer.getElementsByTagName("manufacturer").item(0).getTextContent());
            System.out.println("\tprocessor: " + computer.getElementsByTagName("processor").item(0).getTextContent());
            displayMonitors(computer);
        }
    }

    public static void displayMonitors(Element computer) {
        NodeList monitorList = computer.getElementsByTagName("monitor");
        for (int i = 0; i < monitorList.getLength(); i++) {
            Element monitor = (Element) monitorList.item(i);
            System.out.println("\tmonitor id: " + monitor.getAttribute("id"));
            System.out.println("\t\tmonitor manufacturer: " + monitor.getElementsByTagName("manufacturer").item(0).getTextContent());
            System.out.println("\t\tmonitor resolution: " + monitor.getElementsByTagName("resolution").item(0).getTextContent());
        }
    }
}
