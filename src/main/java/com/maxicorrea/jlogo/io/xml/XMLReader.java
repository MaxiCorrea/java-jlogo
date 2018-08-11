package com.maxicorrea.jlogo.io.xml;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLReader {

  public List<String> read(File file) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = null;
    Document document = null;
    try {
      builder = factory.newDocumentBuilder();
      document = builder.parse(file);
    } catch (Exception e) {
      return null;
    }

    List<String> history = new ArrayList<>();
    Element historialTag = document.getDocumentElement();
    NodeList comando = historialTag.getChildNodes();
    for (int i = 0; i < comando.getLength(); i++) {
      org.w3c.dom.Node n = comando.item(i); 
      if (n.getNodeType() == Node.ELEMENT_NODE) {
        Element e = (Element) n;
        NodeList nombreComandoNodo = e.getElementsByTagName("nombre");
        String nombre = nombreComandoNodo.item(0).getTextContent();
        NodeList parametrosComandoNodo = e.getElementsByTagName("parametro");
        StringBuilder parametros = new StringBuilder();
        for (int j = 0; j < parametrosComandoNodo.getLength(); j++) {
          org.w3c.dom.Node nodoParametro = parametrosComandoNodo.item(j);
          if (nodoParametro.getNodeType() == Node.ELEMENT_NODE) {
            parametros.append(parametrosComandoNodo.item(j).getTextContent());
          }
        }
        history.add(nombre + parametros.toString() );
      }
    }
    return history;
  }

}
