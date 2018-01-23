package com.maxicorrea.jlogo.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import com.maxicorrea.jlogo.models.Logo;
import com.maxicorrea.jlogo.views.extras.DeckerFont;
import AppPackage.AnimationClass;

public class HistoryView extends JPanel {
  private static final long serialVersionUID = 1L;
  private static final Font FONT = DeckerFont.INSTANCE.getFont();

  private JList<String> list;

  public HistoryView() {
    setLayout(new BorderLayout());
    setBackground(Color.WHITE);
    setBounds(0, 490, 150, 300);
    list = new JList<>();
    list.setSelectionBackground(Color.WHITE);
    list.setSelectionForeground(Color.BLACK);
    list.setFont(new Font("Monospace", Font.BOLD, 14));
    add(list);
  }

  public JScrollPane getJScrollPaneAnimation() {
    JScrollPane pane = new JScrollPane(this);
    pane.setBackground(Color.WHITE);
    pane.setBounds(0, 490, 150, 300);
    pane.setBorder(BorderFactory.createTitledBorder(null, "Historial", TitledBorder.TOP,
        TitledBorder.CENTER, FONT.deriveFont(Font.PLAIN, 18), Color.RED));
    pane.getVerticalScrollBar().setForeground(Color.white);
    pane.getVerticalScrollBar().setBackground(Color.white);
    pane.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        new AnimationClass().jTextAreaYUp(490, 220, 10, 5, pane);
        new AnimationClass().jTextAreaYDown(220, 490, 10, 5, pane);
      }
    });
    return pane;
  }

  public void update(Logo logo) {
    List<String> data = logo.history();
    DefaultListModel<String> model = new DefaultListModel<>();
    for( String cmd  : data ) {
      model.addElement(cmd);
    }
    list.setModel(model);
  }

}
