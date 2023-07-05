package org.example.objects;

public class Account {
    private String name, lastName, userName, directNumber, titleDK, titleENG, department, userMail, company;

    public Account(String name, String lastName, String userName, String directNumber, String titleDK, String titleENG, String department, String userMail, String company) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.directNumber = directNumber;
        this.titleDK = titleDK;
        this.titleENG = titleENG;
        this.department = department;
        this.userMail = userMail;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDirectNumber() {
        return directNumber;
    }

    public void setDirectNumber(String directNumber) {
        this.directNumber = directNumber;
    }

    public String getTitleDK() {
        return titleDK;
    }

    public void setTitleDK(String titleDK) {
        this.titleDK = titleDK;
    }

    public String getTitleENG() {
        return titleENG;
    }

    public void setTitleENG(String titleENG) {
        this.titleENG = titleENG;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
