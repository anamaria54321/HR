package ro.jademy.HR;


import java.util.Date;
import java.util.Objects;

public class Employee {
    private Integer emplNo;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthDate;
    private Date hireDate;
    private Integer phoneNumber;
    private String emailAdress;

    private Department dept;
    private Salary salary;

    public Employee(Integer emplNo, String firstName, String lastName, String gender,Date birthDate,
                    Date hireDate, Integer phoneNumber, String emailAdress, Department dept, Salary salary) {
        this.emplNo = emplNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
        this.dept = dept;
        this.salary = salary;
    }

    public Employee(Integer emplNo, String firstName, String lastName, String gender, Date birthDate, Date hireDate) {
        this.emplNo = emplNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }

    public Employee(Integer emplNo, String firstName, String lastName, String gender, Date birthDate, Date hireDate,
                    Integer phoneNumber, String emailAdress) {
        this.emplNo = emplNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
    }

    public Integer getEmplNo() {
        return emplNo;
    }

    public void setEmplNo(Integer emplNo) {
        this.emplNo = emplNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(emplNo, employee.emplNo) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(hireDate, employee.hireDate) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(emailAdress, employee.emailAdress) &&
                Objects.equals(dept, employee.dept) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {

        return Objects.hash(emplNo, firstName, lastName, gender, birthDate, hireDate, phoneNumber, emailAdress, dept, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emplNo=" + emplNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", phoneNumber=" + phoneNumber +
                ", emailAdress='" + emailAdress + '\'' +
                ", dept=" + dept +
                ", salary=" + salary +
                '}';
    }
}