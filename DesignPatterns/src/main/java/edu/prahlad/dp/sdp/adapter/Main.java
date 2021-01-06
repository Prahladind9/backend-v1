package edu.prahlad.dp.sdp.adapter;

public class Main {

    public static void main(String[] args) {
        /** Using Class/Two-way adapter **/
        EmployeeClassAdapter classAdapter = new EmployeeClassAdapter();
        populateEmployeeData(classAdapter);
        BusinessCardDesigner classDesigner = new BusinessCardDesigner();
        String classCard = classDesigner.designCard(classAdapter);
        System.out.println(classCard);

        System.out.println("*********************************");

        /** Using Object Adapter **/
        Employee employee = new Employee();
        populateEmployeeData(employee);
        EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee);
        BusinessCardDesigner objectDesigner = new BusinessCardDesigner();
        String objectCard = objectDesigner.designCard(classAdapter);
        System.out.println(objectCard);

    }

    private static void populateEmployeeData(Employee employee) {
        employee.setFullName("Elliot Alderson");
        employee.setJobTitle("Security Engineer");
        employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
    }
}