package de.pamLights.lakehydrant.modals;

import java.util.Map;

import de.pamLights.lakehydrant.modals.enums.AwwaClass;
import de.pamLights.lakehydrant.modals.enums.CouplingsType;
import de.pamLights.lakehydrant.modals.enums.HydrantPosition;
import de.pamLights.lakehydrant.modals.enums.HydrantType;
import de.pamLights.lakehydrant.modals.enums.PillarType;
import de.pamLights.lakehydrant.modals.enums.WaterSource;

public class HydrantModal extends OsmNode {
    private String emergencyType;
    private int hydrantDiameter;
    private HydrantType hydrantType;
    private HydrantPosition hydrantPosition;
    private String operator;
    private PillarType pillarType;
    private String surveyDate;
    private WaterSource waterSource;
    private int couplings;
    private String couplingsDiameters;
    private CouplingsType couplingsType;
    private String ref;
    private String name;
    private String pressure;
    private String volume;
    private String flowRate;
    private AwwaClass awwaClass;
    private String description;
    private String fixme;

    public HydrantModal() {

    }

    public HydrantModal(OsmNode osmData) {
        for(Map.Entry<String, String> entry : osmData.getTags().entrySet()) {
            switch (entry.getKey()) {
                case "emergencyType":
                    this.emergencyType = entry.getValue();
                    break;
                case "fire_hydrant:diameter":
                    this.hydrantDiameter = Integer.parseInt(entry.getValue());
                    break;
                case "fire_hydrant:type":
                    this.hydrantType = HydrantType.fromString(entry.getValue());
                    break;
                case "pillar:type":
                    this.pillarType = PillarType.fromString(entry.getValue());
                    break;
                case "couplings:type":
                    this.couplingsType = CouplingsType.fromString(entry.getValue());
                    break;
                case "fire_hydrant:position":
                    this.hydrantPosition = HydrantPosition.fromString(entry.getValue());
                    break;
                case "description":
                    this.description = entry.getValue();
                    break;
                case "water_source":
                    this.waterSource = WaterSource.fromString(entry.getValue());
                    break;
                case "operator":
                    this.operator = entry.getValue();
                    break;
                case "survey:date":
                    this.surveyDate = entry.getValue();
                    break;
                case "ref":
                    this.ref = entry.getValue();
                    break;
                case "pressure":
                    this.pressure = entry.getValue();
                    break;
                case "water_tank:volume":
                    this.volume = entry.getValue();
                    break;
                case "flow_rate":
                    this.flowRate = entry.getValue();
                    break;
                case "fire_hydrant:awwa_class":
                    this.awwaClass = AwwaClass.fromString(entry.getValue());
                    break;
                case "fixme":
                    this.fixme = entry.getValue();
                    break;
                case "couplings":
                    this.couplings = Integer.parseInt(entry.getValue());
                    break;
                case "couplings:diameters":
                    this.couplingsDiameters = entry.getValue();
                    break;
                case "name":
                    this.name = entry.getValue();
                    break;
                default:
                    break;
            }
        }
    }


    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public int getHydrantDiameter() {
        return hydrantDiameter;
    }

    public void setHydrantDiameter(int hydrantDiameter) {
        this.hydrantDiameter = hydrantDiameter;
    }

    public HydrantType getHydrantType() {
        return hydrantType;
    }

    public void setHydrantType(HydrantType hydrantType) {
        this.hydrantType = hydrantType;
    }

    public HydrantPosition getHydrantPosition() {
        return hydrantPosition;
    }

    public void setHydrantPosition(HydrantPosition hydrantPosition) {
        this.hydrantPosition = hydrantPosition;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public PillarType getPillarType() {
        return pillarType;
    }

    public void setPillarType(PillarType pillarType) {
        this.pillarType = pillarType;
    }

    public String getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(String surveyDate) {
        this.surveyDate = surveyDate;
    }

    public WaterSource getWaterSource() {
        return waterSource;
    }

    public void setWaterSource(WaterSource waterSource) {
        this.waterSource = waterSource;
    }

    public int getCouplings() {
        return couplings;
    }

    public void setCouplings(int couplings) {
        this.couplings = couplings;
    }

    public String getCouplingsDiameters() {
        return couplingsDiameters;
    }

    public void setCouplingsDiameters(String couplingsDiameters) {
        this.couplingsDiameters = couplingsDiameters;
    }

    public CouplingsType getCouplingsType() {
        return couplingsType;
    }

    public void setCouplingsType(CouplingsType couplingsType) {
        this.couplingsType = couplingsType;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(String flowRate) {
        this.flowRate = flowRate;
    }

    public AwwaClass getAwwaClass() {
        return awwaClass;
    }

    public void setAwwaClass(AwwaClass awwaClass) {
        this.awwaClass = awwaClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFixme() {
        return fixme;
    }

    public void setFixme(String fixme) {
        this.fixme = fixme;
    }
}
