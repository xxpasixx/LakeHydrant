package de.pamLights.lakehydrant.modals;

import java.util.ArrayList;
import java.util.HashMap;

public class OverpassResponse {
  private double version;
  private String generator;
  private HashMap<String, String> osm3s;
  private ArrayList<OsmNode> elements;


  public OverpassResponse(double version, String generator, HashMap<String, String> osm3s, ArrayList<OsmNode> elements) {
    this.version = version;
    this.generator = generator;
    this.osm3s = osm3s;
    this.elements = elements;
  }

  public OverpassResponse() {
  }

  public double getVersion() {
    return version;
  }

  public void setVersion(double version) {
    this.version = version;
  }

  public String getGenerator() {
    return generator;
  }

  public void setGenerator(String generator) {
    this.generator = generator;
  }

  public HashMap<String, String> getOsm3s() {
    return osm3s;
  }

  public void setOsm3s(HashMap<String, String> osm3s) {
    this.osm3s = osm3s;
  }

  public ArrayList<OsmNode> getElements() {
    return elements;
  }

  public void setElements(ArrayList<OsmNode> elements) {
    this.elements = elements;
  }
}
