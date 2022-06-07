package de.pamLights.lakehydrant.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

import de.pamLights.lakehydrant.modals.HydrantModal;
import de.pamLights.lakehydrant.modals.OverpassResponse;

public class JsonService {
  private ObjectMapper mapper;

  public JsonService() {
    mapper = new ObjectMapper();
  }

  public ArrayList<HydrantModal> getAllFireHydrants(String jsonString) {
    ArrayList<HydrantModal> hydrantModals = new ArrayList<>();

    try {
      OverpassResponse overpassResponse = getOverpassResponseObject(jsonString);
      overpassResponse.getElements().forEach(modal ->  hydrantModals.add(
              new HydrantModal(overpassResponse.getElements().get(0))
      ));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return hydrantModals;
  }

  public OverpassResponse getOverpassResponseObject(String jsonString) throws IOException {
    return mapper.readValue(jsonString, OverpassResponse.class);
  }
}
