package ro.jademy.HR;

import ro.jademy.HR.repository.EmployeeRepository;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("abc");
//        sb.append("d").append("e");String s =sb.toString();
//        System.out.println(s);
//        System.out.println( Locale.getDefault());
//       ;
//    Locale.setDefault(new Locale("ro","Ro"));
//        System.out.println( Locale.getDefault());}
//        java.text.NumberFormat;
        EmployeeRepository employeeRepository;

        try {
            employeeRepository = new EmployeeRepository();
            showMenu(employeeRepository);
        } catch (SQLException e) {
            System.out.println("ceva nu e in regula" + e);
        }

    }

    public static void showMenu(EmployeeRepository employeeRepository) {

        System.out.println(" -----------------------------------------------");
        System.out.println("|          Welcome to the DataBase HR   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. Add employee");
        System.out.println("2. Show List Employees");
        System.out.println("3. Remove employee");
        System.out.println("4. Show Hystory Employee");
        System.out.println("5. Exit");
        showOptionsMenu(employeeRepository);
    }

    public static void showOptionsMenu(EmployeeRepository employeeRepository) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Select an action from below:");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    employeeRepository.addEmployee(employeeRepository.createEmployee());
                    break;
                case 2:
                    employeeRepository.getAllEmployees();
                    employeeRepository.showListAllEmployee(employeeRepository.getAllEmployees());
                    break;
                case 3:
                    employeeRepository.removeEmployee(employeeRepository.createEmployee());
                    break;
                case 4:
                    employeeRepository.showHistoryEmployee(employeeRepository.createEmployee());
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception pe) {

            pe.printStackTrace();
        }

        showMenu(employeeRepository);
    }

//    public static Employee createEmployee() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter first name");
//        String firstName = sc.nextLine();
//        System.out.println("Enter last name");
//        String lastName = sc.nextLine();
//        System.out.println("Enter last name");
//        String deptName = sc.nextLine();
//        Employee e = new Employee(firstName, lastName, deptName);
//        return e;
//    }
}

