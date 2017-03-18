package Usage;

import Facility.Facility_Interface;
import Facility.Inspection;
import Student_Detail.StudentImpl;



public class FacilityUse implements Use_Interface{

    //Use this method for facility open date

    /*
    public boolean isInUseDuringInterval(int OpenH, int OpenM, int CloseH, int CloseM, int ArrivalH, int ArrivalM) {
        if (OpenH*60+OpenM < ArrivalH*60+ArrivalM < CloseH*60+CloseM)
            System.out.println("Yes, the facility will be open for when you arrive");
            return True;
        else:
            return false;
    }
    */
    public void assignFacilityToUse(StudentImpl student, Facility_Interface facility) {
        student.usesFacility.add(facility);

    }

    public boolean vacateFacility(StudentImpl student, Facility_Interface facility) {
        if (student.usesFacility.contains(facility))
            student.usesFacility.remove(facility);
        return true;
    }

    public void addInspection(Facility_Interface facility, Inspection inspection) {
        facility.addInspection(inspection);
    }

    public void listInspection(Facility_Interface facility) {
        for(Inspection i : facility.getInspections()){
            System.out.println(i.toString());
        }
    }

    public void listActualUsage(Facility_Interface facility) {
        System.out.println(facility.getUsage());
    }
/*
//Calculate usage rate for multiple facilities.
    public double calcUsageRate(Facility_Interface facility,Facility_Interface facility2,Facility_Interface facility3) {
        double calcUsage=0.0;
        calcUsage=facility.getUsage()+facility2.getUsage()+facility3.getUsage()/3;
        return calcUsage;
    }
*/

}
