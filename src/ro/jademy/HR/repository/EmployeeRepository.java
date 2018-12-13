package ro.jademy.HR.repository;

import ro.jademy.HR.BuildTable;
import ro.jademy.HR.DBConection;
import ro.jademy.HR.Employee;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepository {
    BuildTable table = new BuildTable();
    private Connection conn = DBConection.getConnection();
    private Statement stm = conn.createStatement();
    private PreparedStatement insertEmplStm = conn.prepareStatement(
            "INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date,phone_number,email_adress)" +
                    "VALUES(?,?,?,?,?,?,?,?)");
//    private PreparedStatement insertEmplStm = conn.prepareStatement(
//            "DELETE FROM employees WHERE emp_no = " + e.getEmplNo()INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date,phone_number,email_adress)" +
//                    "VALUES(?,?,?,?,?,?,?,?)");


    public EmployeeRepository() throws SQLException {

    }

    public Employee createEmployee() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = sc.nextLine();

        System.out.println("Enter last name");
        String lastName = sc.nextLine();

        System.out.println("Enter the gender");
        String gender = sc.nextLine();
        System.out.println("Enter birth date");
        Date birthDate = getDate();
        System.out.println("Enter hire date");
        Date hireDate = getDate();
        System.out.println("Enter employee number");
        int empNo = sc.nextInt();
        System.out.println("Enter employee phone number");
        int phoneNumber = sc.nextInt();
        System.out.println("Enter employee email adress");
        String emailAdress = sc.nextLine();
        Employee e = new Employee(empNo, firstName, lastName, gender, birthDate, hireDate, phoneNumber,emailAdress);
        return e;
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        System.out.println("Example: 2018-12-10");
        String str = sc.nextLine();
        Date date = sdf.parse(str);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        return date;
    }

    public void addEmployee(Employee e) throws Exception {
        String firstName = e.getFirstName();
        String lastName = e.getLastName();
        String gender = e.getGender();
        Date birthDate = e.getBirthDate();
        Date hireDate = e.getHireDate();
        int empNo = e.getEmplNo();
        int phoneNumber =e.getPhoneNumber();
        String emailAdress =e.getEmailAdress();

        // substitutie variabile
        insertEmplStm.setInt(1, empNo);
        insertEmplStm.setDate(2, new java.sql.Date(birthDate.getTime()));
        insertEmplStm.setString(3, firstName);
        insertEmplStm.setString(4, lastName);
        insertEmplStm.setString(5, gender);
        insertEmplStm.setDate(6, new java.sql.Date(hireDate.getTime()));

        insertEmplStm.setInt(7, phoneNumber);
        insertEmplStm.setString(8, emailAdress);

        insertEmplStm.execute();
    }

    public void removeEmployee(Employee e) throws SQLException {
        ResultSet rs = stm.executeQuery("DELETE FROM employees WHERE emp_no = " + e.getEmplNo() );
    }

    public void showHistoryEmployee(Employee e) {

    }


    public List<Employee> getAllEmployees() throws SQLException {
        ResultSet rs = stm.executeQuery("SELECT *from employees ");
        List<Employee> employeeList = new ArrayList<>();
        while (rs.next()) {
            Employee empl = new Employee(rs.getInt("emp_no"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("gender"),
                    rs.getDate("birth_date"), rs.getDate("hire_date"),
                    rs.getInt("phone_number"),rs.getString("email_adress"));
            employeeList.add(empl);
        }
        return employeeList;
    }

    public void showListAllEmployee(List<Employee> employeeList) throws SQLException {
        employeeList = getAllEmployees();
        System.out.println();
        for (Employee e : getAllEmployees()) {
            System.out.print("|");
            System.out.print((table.getNameWithTraillingSpaces(e.getEmplNo().toString(), table.getEmplNoLargestName(employeeList))) + "|");
            System.out.print((table.getNameWithTraillingSpaces(e.getFirstName(), table.getFirstLargestName(employeeList))) + "|");
            System.out.print((table.getNameWithTraillingSpaces(e.getLastName(), table.getLastLargestName(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getSalary().getSalary().toString(), table.getSalaryLargest(employeeList))) + "|");
            System.out.print((table.getNameWithTraillingSpaces(e.getGender(), table.getGenderLargestName(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getDeptName(), table.getDepartmentLargestName(employeeList))) + "|");
           System.out.print((table.getNameWithTraillingSpaces(e.getBirthDate().toString(), table.getBirthDateLargest(employeeList))) + "|");
            System.out.print((table.getNameWithTraillingSpaces(e.getHireDate().toString(), table.getHireDateLargest(employeeList))) + "|");
            System.out.print((table.getNameWithTraillingSpaces(e.getPhoneNumber().toString(), table.getPhoneNumberLargestName(employeeList))) + "|");
            System.out.print((table.getNameWithTraillingSpaces(e.getEmailAdress().toString(), table.getEmailAdressLargestName(employeeList))) + "|");

////            Syste m.out.print((table.getNameWithTraillingSpaces(e.getSalary().getFromData().toString(), table.getfromDataLargest(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getSalary().getToData().toString(), table.getToDataLargest(employeeList))) + "|");
            System.out.println("");
        }
    }

    public void showTable() throws SQLException {

        List<Employee> employeeList = getAllEmployees();

        for (Employee e : employeeList) {

//        if((e.getMake().length()<=table.getMakeLargestName(es))&&(e.getModel().length()<=table.getModelLargestName(es))
//        &&(e.getTransmissionType().length()<=table.getTransmissionTypeLargestName(es))&&
//                (e.getColor().length()<=table.getColorLargestName(es)))
            System.out.print("|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getEmplNo().toString(), table.getEmplNoLargestName(employeeList))) + "|");
            System.out.print((table.getNameWithTraillingSpaces(e.getFirstName(), table.getFirstLargestName(employeeList))) + "|");
            System.out.print((table.getNameWithTraillingSpaces(e.getLastName(), table.getLastLargestName(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getDeptName(), table.getDepartmentLargestName(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getGender(), table.getGenderLargestName(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getBirthData().toString(), table.getBirthDataLargest(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getHireData().toString(), table.getHireDataLargest(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getSalary().toString(), table.getSalaryLargest(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getSalary().getFromData().toString(), table.getfromDataLargest(employeeList))) + "|");
//            System.out.print((table.getNameWithTraillingSpaces(e.getSalary().getToData().toString(), table.getToDataLargest(employeeList))) + "|");

            System.out.println("");
        }
    }

    public void showHeader() {

    }
}
