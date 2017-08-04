package se.itu.brewdog.main;

import se.itu.brewdog.beer.BeerFetcher;
import se.itu.brewdog.gui.MainFrame;

/**
 * <p>
 * This application creates a BeerFetcher instance, and uses it
 * when creating the MainFrame GUI object.
 * </p>
 * <p>
 * The {@link MainFrame} has a button for fetching JSON data
 * from <a href="https://api.punkapi.com">PunkAPI</a> with
 * data about a few beers from Brewdog's back-catalog.
 * </p>
 * <p>
 * The beer data is presented in a text area in the MainFrame.
 * </p>
 * <p>
 * To compile and run (GNU/Linux or Mac OS):<br>
 * <code>$ ./build.sh &amp;&amp; ./run.sh</code>
 * </p>
 * <p>
 * Or manually (from the directory above src/):<br>
 * <code>
 * $ javac -cp .:lib/* -d bin/ src/se/itu/brewdog&#47;*&#47;*.java &amp;&amp; java -cp bin:lib&#47;* se.itu.brewdog.main.Main
 * </code>
 * </p>
 * <p>
 * To compile and run (Windows):<br>
 * <code>
 * $ javac -cp ".;lib/*" -d bin/ src/se/itu/brewdog&#47;*&#47;*.java &amp;&amp; java -cp "bin;lib&#47;*" se.itu.brewdog.main.Main
 * </code>
 * </p>
 */

public class Main {
  /**
   * The starting point of the Brewdog application. Requires no arguments to run, so the
   * args argument here is not documented.
   */
  public static void main(String[] args) {
    BeerFetcher bf = new BeerFetcher();
    MainFrame mf = new MainFrame(bf);
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {          
          mf.show();
        }
      });
  }

  // Prevent instantiation
  private Main() { }
}
