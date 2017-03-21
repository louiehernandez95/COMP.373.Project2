package Main;

import java.util.ArrayList;
import Facility.Facility_Interface;
import Facility.Floors;
import Facility.Inspection;
import Facility.Unit;
import Facility_Maintenance.Maintenance;
import Student_Detail.Address;
import Student_Detail.Student;
import Usage.Use_Interface;

import Usage.MaintenanceUsage_Interface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        System.out.println("***************** Application Context Instantiated ******************");
        Address address = (Address) context.getBean("address");
        address.setAddress1("1125 W Loyola Ave");
        address.setCity("Chicago");
        address.setCountry("United States");
        address.setId("4");
        address.setState("IL");
        address.setZip("60626");
        //Spring to inject the right object implementation in Floors
        Floors floors = (Floors) context.getBean("floors");
        floors.setID("1");
        floors.setHeight(50.0);
        floors.setWidth(100.0);
        floors.setLength(100.0);
        floors.setNumFacility(1);
        floors.setNumRooms(12);
        //Spring to inject the right object implementation in Facility
        Facility_Interface facility = (Facility_Interface) context.getBean("facility");
        facility.setName("Mertz Hall");
        facility.setFacilityType("Dorm");
        facility.setDimensions("1000*1000*50");
        facility.setCapacity(100);
        facility.setAddress(address);
        facility.setUsage(110.32);
        //Spring to inject the right object implementation in unit
        Unit unit = (Unit) context.getBean("unit");
        unit.setId("1");
        unit.setWidth(10.0);
        unit.setHeight(10.0);
        unit.setLength(10.0);
        unit.setType("Dorm Room");
        //Spring to inject the right object implementation in Student
        Student student = (Student) context.getBean("student");
        student.setId("1");
        student.setFirstName("Louie");
        student.setLastName("Hernandez");
        student.setDateOfBirth("11-01-95");
        student.usesFacility.add(facility);
        //Spring to inject the right object implementation in Inspection
        Inspection inspection = (Inspection) context.getBean("inspection");
        inspection.setId("1");
        inspection.setTime("12:00 pm");
        inspection.setSummary("Surprise Inspection");
        //Spring to inject the right object implementation in Maintenance
        Maintenance maintenance = (Maintenance) context.getBean("maintenance");
        maintenance.setId("1");
        maintenance.setType("Leaky Faucet");
        maintenance.setCost(110.50);
        
        Use_Interface use = (Use_Interface) context.getBean("facilityUse");
        use.assignFacilityToUse(student,facility);
        use.addInspection(facility, inspection);
        System.out.println();
        System.out.println("INSPECTIONS FOR FACILITY " + facility.getFacilityInfo());
        use.listInspection(facility);
        System.out.println();
        System.out.println("FACILITIES USED BY PERSON: " + student.getFullName());
        student.listPersonFacilities();
        System.out.println();
        System.out.println("ACTUAL USAGE FOR FACILITY: " + facility.getFacilityInfo());
        use.listActualUsage(facility);
        System.out.println();
        MaintenanceUsage_Interface maintenance_Usage = (MaintenanceUsage_Interface) context.getBean("maintenanceUsage");
        maintenance_Usage.makeFacilityMaintRequest(maintenance, facility);
        System.out.println();
        System.out.println("LIST OF MAINTENANCE REQUESTS BY FACILITIES: ");
        maintenance_Usage.listMaintenanceRequest();
        System.out.println();
        System.out.println("LIST OF SCHEDULED MAINTENANCE: ");
        ArrayList<Maintenance> temp = new ArrayList<Maintenance>();
        temp.add(maintenance);
        maintenance_Usage.scheduleMaintenance(facility, temp);
        maintenance_Usage.listMaintenance();
        System.out.println();
        System.out.println("MAINTENANCE COST FOR FACILITY: "+facility.getName());
        maintenance_Usage.calcMaintenanceCost(facility);
        maintenance_Usage.calcDownTime(facility);
        System.out.println("PROBLEM RATE FOR MAINTENANCE: ");
        maintenance_Usage.calcProblemRate(facility);
        System.out.println("***************** End Of Program ******************");
    }
}
