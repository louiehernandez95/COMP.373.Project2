package Usage;

import Facility.Facility_Interface;
import Facility.Inspection;
import Student_Detail.StudentImpl;

public interface Use_Interface {
    void assignFacilityToUse(StudentImpl student, Facility_Interface facility);
    boolean vacateFacility(StudentImpl student, Facility_Interface facility);
    void listInspection(Facility_Interface facility);
    void listActualUsage(Facility_Interface facility);
    void addInspection(Facility_Interface facility, Inspection inspection);

}