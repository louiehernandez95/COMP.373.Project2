package Facility;
import Student_Detail.Address;

import java.util.ArrayList;


public interface Facility_Interface {
    void listUnits();
    String getFacilityInfo();
    int getAvailableCapacity();
    boolean addNewUnit(Unit unit);
    void addFacilityDetail(String detail);
    boolean removeUnit(Unit unit);
    ArrayList<Inspection> getInspections();
    void addInspection(Inspection inspection);
    double getUsage();
    public void setUsage(double use);
    public String getName();
    public void setName(String name);
    public String getFacilityType();
    public void setFacilityType(String facilityType);
    public String getDimensions();
    public void setDimensions(String dimensions);
    public Address getAddress();
    public void setAddress(Address address);
    public void setCapacity(int capacity);

}
