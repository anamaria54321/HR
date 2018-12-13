package ro.jademy.HR;

import ro.jademy.HR.Employee;

import java.util.ArrayList;
import java.util.List;

public class BuildTable {
    public List<String> stringList = new ArrayList<>();
    public List<Employee> employees = new ArrayList<>();


    private int largestString(ArrayList<String> stringList) {
        int max = 0;
        for (String s : stringList) {
            if (s.length() >= max) {
                max = s.length();
            }
        }
        return max;
    }

    public String getNameWithTraillingSpaces(String name, int largestNameCount) {
        String spaces = "";
        int nrSpaces = largestNameCount - name.length();
        for (int i = 0; i < nrSpaces + 2; i++) {
            spaces += " ";
        }
        return name + spaces;
    }

    public int getFirstLargestName(List<Employee> employees) {

        ArrayList<String> firstName = new ArrayList<>();
        for (Employee e : employees) {
            firstName.add(e.getFirstName());
        }
        return largestString(firstName);
    }

    public int getLastLargestName(List<Employee> employees) {

        ArrayList<String> lastName = new ArrayList<>();
        for (Employee e : employees) {
            lastName.add(e.getLastName());
        }
        return largestString(lastName);
    }

//    public int getDepartmentLargestName(List<Employee> employees) {
//
//        ArrayList<String> deptName = new ArrayList<>();
//        for (Employee e : employees) {
//            deptName.add(e.getDeptName());
//        }
//        return largestString(deptName);
//    }

    public int getEmplNoLargestName(List<Employee> employees) {

        ArrayList<String> emplNo = new ArrayList<>();
        for (Employee e : employees) {
            emplNo.add(e.getEmplNo().toString());
        }
        return largestString(emplNo);
    }

    public int getGenderLargestName(List<Employee> employees) {

        ArrayList<String> gender = new ArrayList<>();
        for (Employee e : employees) {
            gender.add( e.getGender());
        }
        return largestString( gender);
    }
    public int getBirthDateLargest(List<Employee> employees) {

        ArrayList<String> birthDate = new ArrayList<>();
        for (Employee e : employees) {
            birthDate.add(e.getBirthDate().toString());
        }
        return largestString(birthDate);
    }
    public int getHireDateLargest(List<Employee> employees) {

        ArrayList<String> hireDate = new ArrayList<>();
        for (Employee e : employees) {
            hireDate.add(e.getBirthDate().toString());
        }
        return largestString(hireDate);
    }
    public int getSalaryLargest(List<Employee> employees) {

        ArrayList<String> salary = new ArrayList<>();
        for (Employee e : employees) {
            salary.add(e.getSalary().getSalary().toString());
        }
        return largestString(salary);
    }
    public int getfromDataLargest(List<Employee> employees) {

        ArrayList<String> fromData = new ArrayList<>();
        for (Employee e : employees) {
            fromData.add(e.getSalary().getFromDate().toString());
        }
        return largestString(fromData);
    }
    public int getToDataLargest(List<Employee> employees) {

        ArrayList<String> toData = new ArrayList<>();
        for (Employee e : employees) {
            toData.add(e.getSalary().getFromDate().toString());
        }
        return largestString(toData);
    }
    public int getPhoneNumberLargestName(List<Employee> employees) {

        ArrayList<String> phoneNumber = new ArrayList<>();
        for (Employee e : employees) {
            phoneNumber.add(e.getEmplNo().toString());
        }
        return largestString(phoneNumber);
    }
    public int getEmailAdressLargestName(List<Employee> employees) {

        ArrayList<String> emailAdress = new ArrayList<>();
        for (Employee e : employees) {
            emailAdress.add( e.getGender());
        }
        return largestString( emailAdress);
    }
}


