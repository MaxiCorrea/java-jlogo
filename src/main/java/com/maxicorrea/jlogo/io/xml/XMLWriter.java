package com.maxicorrea.jlogo.io.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class XMLWriter {

  private static final String VERSION = "1.0";
  private static final String ROOT_NAME = "historial";
  private static final String LABEL_NAME = "comando";
  private static final String NAME = "nombre";

  private Document document;


  public boolean write(List<String> history, File file) {
    try {
      Node raiz = createRootElement();
      for (String cmd : history) {
        raiz.appendChild(createElement(cmd));
      }
      generateXMLFile(file);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  private Node createRootElement() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    DOMImplementation impl = builder.getDOMImplementation();
    document = impl.createDocument(null, ROOT_NAME, null);
    document.setXmlVersion(VERSION);
    return document.getDocumentElement();
  }

  private Node createElement(String cmd) {
    String[] data = cmd.split("[ ]");
    Element label = document.createElement(LABEL_NAME);
    Element name = document.createElement(NAME);
    Text textName = document.createTextNode(data[0]);
    name.appendChild(textName);
    label.appendChild(name);
   if(data.length > 1) {
     label.appendChild(createParamElement(data[1]));
   }
    return label;
  }

  private Node createParamElement(String parameters) {
    Element etiqueta = document.createElement("parametro");
    etiqueta.appendChild(document.createTextNode(parameters));
    return etiqueta;
  }

  private void generateXMLFile(File file) throws Exception {
    Source source = new DOMSource(document);
    Result result = new StreamResult(new File(file.getAbsolutePath() + ".logo"));
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(source, result);
  }

}
