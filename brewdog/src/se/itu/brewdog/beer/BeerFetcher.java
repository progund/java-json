package se.itu.brewdog.beer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.stream.*;

import org.json.*;


public class BeerFetcher {

  private static final String url = "https://api.punkapi.com/v2/beers?page=1&per_page=10";
  
  private String json() {
    StringBuilder response = new StringBuilder();
    try {
          BufferedReader reader =
            new BufferedReader(new InputStreamReader
                               (new URL(url).openStream()));
          for(String line : reader.lines().collect(Collectors.toList())) {
            response.append(line);
          }
    } catch (IOException e) {
      System.err.println("Error reading config: " +
                         e.getMessage());
    }
    return response.toString();
  }
  
  public List<Beer> fetchAll() {
    String json = json();
    JSONArray jsonArray = new JSONArray(json);
    
    List<Beer> beers = new ArrayList<>();
    for(int i = 0; i < jsonArray.length(); i++){
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      String name = jsonObject.getString("name");
      String description = jsonObject.getString("description");
      double alcohol = jsonObject.getDouble("abv");
      JSONArray foodsJson = (JSONArray)jsonObject.get("food_pairing");
      ArrayList<String> foodStrings = new ArrayList<>();
      for(int j = 0; j < foodsJson.length(); j++) {
        foodStrings.add(foodsJson.getString(j));
      }
      beers.add(new Beer(name,
                         description,
                         alcohol,
                         foodStrings)
                );
      /*
      beers.add(new Beer("Buzz",
                         "A light, crisp and bitter IPA brewed with English" +
                         " and American hops. A small batch brewed only once.",
                         4.5,
                         Arrays.asList(new String[] {"Spicy chicken tikka masala",
                                                     "Grilled chicken quesadilla",
                                                     "Caramel toffee cake"})
                         )
                );
      */
    }
    return beers;
  }
}
