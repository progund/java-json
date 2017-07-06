package se.itu.brewdog.beer;

import java.util.List;
import java.util.Collections;

public class Beer {
  private String name;
  private double alcoholByVolume;
  private String description;
  private List<String> foods;

  public Beer(String name,
              String description,
              double alcoholByVolume,
              List<String> foods) {
    this.name = name;
    this.description = description;
    this.alcoholByVolume = alcoholByVolume;
    this.foods = foods;
  }

  public String name() {
    return name;
  }

  public String description() {
    return description;
  }

  public double alcoholByVolume() {
    return alcoholByVolume;
  }

  public List<String> foods() {
    return Collections.unmodifiableList(foods);
  }

  @Override
  public String toString() {
    return new StringBuilder(name)
      .append("\n\"")
      .append(description)
      .append("\"\n")
      .append(String.format("%.2f", alcoholByVolume))
      .append("% abv\nSuitable to drink with:\n* ")
      .append(foods.toString().replace(", ", "\n* ")
              .replace("[", "")
              .replace("]", ""))
      .toString();
  }
}
