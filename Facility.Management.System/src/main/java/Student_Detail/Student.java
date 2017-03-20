package Student_Detail;

import Facility.Facility_Interface;

import java.util.ArrayList;

public interface Student {
    public String getId();
    public void setId(String id);
    public String getFirstName();
    public void setFirstName(String FirstName);
    public String getLastName();
    public void setLastName(String LastName);
    public String getFullName();
    public ArrayList<Address> getAddress();
    public void addAddress(Address address);
    public boolean removeAddress(Address address);
    public String getDateOfBirth();
    public void setDateOfBirth(String DateOfBirth);
    public void listPersonFacilities();
    public ArrayList<Facility_Interface> usesFacility = new ArrayList<Facility_Interface> ();
}


