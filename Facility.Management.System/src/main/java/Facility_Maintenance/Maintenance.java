package Facility_Maintenance;
import Facility.Facility_Interface;
import java.util.ArrayList;

public interface Maintenance {

    public String getId();

    public void setId(String id);

    public String getType();

    public void setType(String type);

    public void setCost(double cost);

    public double getCost();

}
