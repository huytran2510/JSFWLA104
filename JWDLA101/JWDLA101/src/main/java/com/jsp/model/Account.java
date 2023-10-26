package com.jsp.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "dbo", name = "Account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long account_id;
    private String account;
    private String email;
    private String password;
    private int status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    private Employee employee;

    public Account() {
    }

    public Account( String account, String email, String password, int status) {

        this.account = account;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", employee=" + employee +
                '}';
    }
}
