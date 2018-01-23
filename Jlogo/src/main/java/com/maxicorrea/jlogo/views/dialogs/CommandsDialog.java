package com.maxicorrea.jlogo.views.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLDocument;
import com.maxicorrea.jlogo.views.extras.DeckerFont;

public class CommandsDialog extends Dialog {

  private static final long serialVersionUID = 1L;
      
  public CommandsDialog(JFrame owner) {
    super(owner);
    contentPane.setPreferredSize(new Dimension(410, 400));
    infoLabel.setText("Comandos JLogo");
    okButton.setBounds(129, 340, 150, 40);
    okButton.setText("Lei Todo");
    centerPane.add(getInfoArea());
    pack();
    setLocationRelativeTo(owner);
  }

  private JScrollPane getInfoArea() {
    JEditorPane edit = new JEditorPane();
    edit.setEditable(false);
    edit.setContentType("text/html");
    StringBuilder info = new StringBuilder();
    info.append("<h3><center>insensibles a las mayúsculas <br/> y minúsculas</h3></center><br/>");
    info.append("<b>ubicar x,y </b>: Posiciona la tortuga en la posicion indicada. <br/>");
    info.append("<b>avanzar q </b>: La tortuga avanzar q pasos.<br/>");
    info.append("<b>retroceder q </b>: La tortuga retrocede q pasos.<br/>");
    info.append("<b>girarder x </b>: Gira a la derecha x grados.<br/>");
    info.append("<b>girarizq x </b>: Gira a la izquierda x grados.<br/>");
    info.append("<b>pincel x </b>: Modifica el tamaño del pincel. <br/>");
    info.append("<b>color r,g,b </b> : Modifica el color del pincel. <br/>");
    info.append("<b>borrar q </b>: La tortuga avanza borrando el dibujo actual. <br/>");
    info.append("<b>pintar</b>: Pinta la región en la que se encuentra la tortuga.<br/>");
    info.append("<b>fondo</b>: Permite cargar una image BMP como fondo.<br/>");
    info.append("<b>nuevo</b>: Genera un nuevo dibujo con fondo blanco.<br/>");
    info.append("<b>dibujar</b>: Genera una imagen BMP con el dibujo resultado.<br/>");
    info.append("<b>guardar</b>: Guarda el dibujo en un archivo \".logo\".<br/>");
    info.append("<b>abrir</b>: Abre el dibujo realizado en una sesion anterior.<br/>");
    info.append("<b>insertar x,y</b>: Inserta un archivo \".logo\" en la posicion x,y.<br/>");
    info.append("<b>circulo r</b>: Genera un circulo de radio r.<br/>");
    info.append("<b>ocultar</b>: Oculta la tortuga.<br/>");
    info.append("<b>mostrar</b>: Muestra la tortuga.<br/>");
    info.append("<b>pincelabajo</b>: Baja el pincel para dibujar.<br/>");
    info.append("<b>pincelarriba</b>: Sube el pincel para no dibujar.<br/>");
    info.append("<b>repetir n</b>: Permite repetir n veces otros comandos.<br/>");
    info.append(" <br/> <br/>");
    edit.setText(info.toString());
    edit.setCaretPosition(0);
    
    Font font = DeckerFont.INSTANCE.getFont().deriveFont(13f);
    String bodyRule = "body { font-family: " + font.getFamily() + "; " +
        "font-size: " + font.getSize() + "pt; }";
    ((HTMLDocument)edit.getDocument()).getStyleSheet().addRule(bodyRule);
    
    JScrollPane pane = new JScrollPane(edit);
    pane.setBackground(Color.WHITE);
    pane.setBorder(null);
    pane.setPreferredSize( new Dimension(365, 300));
    return pane;
  }
  
}