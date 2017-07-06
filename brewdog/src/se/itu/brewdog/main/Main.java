package se.itu.brewdog.main;

import se.itu.brewdog.beer.BeerFetcher;
import se.itu.brewdog.gui.MainFrame;

public class Main {
  public static void main(String[] args) {
    BeerFetcher bf = new BeerFetcher();
    MainFrame mf = new MainFrame(bf);
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {          
          mf.show();
        }
      });
  }
}
