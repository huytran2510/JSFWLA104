package com.jsp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(schema = "dbo", name = "Employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;
    private String first_name;
    private String last_name;
    private String full_name;
    private String gender;
    private LocalDate date_of_birth;
    private String phone;
    private String address;
    private String department_name;
    private String remark;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
    private Account account;
    public Employee(){}
    public Employee( String first_name, String last_name, String gender, LocalDate date_of_birth,
                    String phone, String address, String department_name, String remark) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.phone = phone;
        this.address = address;
        this.department_name = department_name;
        this.remark = remark;
        this.full_name = first_name + " " + last_name;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getFull_name() {
        return first_name + " " + last_name;
    }
    public void setFull_name(String full_name) {
        if (full_name == null) {
            this.first_name = "";
            this.last_name = "";
        } else {
            String[] names = full_name.split(" ", 2);
            if (names.length >= 2) {
                this.first_name = names[0];
                this.last_name = names[1];
            } else {
                this.first_name = full_name;
                this.last_name = "";
            }
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "employee_id=" + employee_id +
//                ", first_name='" + first_name + '\'' +
//                ", last_name='" + last_name + '\'' +
//                ", gender='" + gender + '\'' +
//                ", date_of_birth=" + date_of_birth +
//                ", phone='" + phone + '\'' +
//                ", address='" + address + '\'' +
//                ", department_name='" + department_name + '\'' +
//                ", remark='" + remark + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender='" + gender + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", department_name='" + department_name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
