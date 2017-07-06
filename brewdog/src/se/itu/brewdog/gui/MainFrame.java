package se.itu.brewdog.gui;

import se.itu.brewdog.beer.BeerFetcher;
import se.itu.brewdog.beer.Beer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MainFrame {
  static {
    try {
      // Ignore this - it's a fix for Rikard's computer. Hell Dell!
      UIManager
        .setLookAndFeel((LookAndFeel)Class
                        .forName("com.sun.java.swing.plaf.gtk.GTKLookAndFeel")
                        .newInstance());
    } catch (Exception ignore) {}
  }

  private BeerFetcher beerFetcher;
  private JFrame frame;
  private JTextArea beerTextArea;
  private JScrollPane beerScrollPane;
  private JButton fetchButton;
  
  public MainFrame(BeerFetcher beerFetcher) {
    this.beerFetcher = beerFetcher;
    initComponents();
    addListeners();
    layoutComponents();
  }

  private void initComponents() {
    frame = new JFrame("Brewdog beers");
    beerTextArea = new JTextArea(50, 50);
    beerTextArea.setEditable(false);    
    beerScrollPane = new JScrollPane(beerTextArea);
    beerScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    beerScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    beerTextArea.setLineWrap(true);
    beerTextArea.setWrapStyleWord(true);    
    fetchButton = new JButton("Fetch beers");    
  }

  private void addListeners() {
    fetchButton
      .addActionListener( e ->
                          {
                            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                                public void run() {          
                                  fetchBeers();
                                }
                              });
                          });
  }

  private void fetchBeers() {
    for (Beer beer : beerFetcher.fetchAll()) {
      beerTextArea.append("" + beer);
      beerTextArea.append("\n");
      beerTextArea.append("==============================\n");
    }
    beerTextArea.setCaretPosition(0);
    beerTextArea.repaint();    
  }

  private void layoutComponents() {
    frame.setLayout(new BorderLayout());
    frame.add(fetchButton, BorderLayout.NORTH);
    frame.add(beerScrollPane, BorderLayout.CENTER);
  }
  public void show() {
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
