/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sarahtrinidad
 */
/**
 * MotorPH Payroll System - Group 8
 * @author sarahtrinidad
 */

public class Group8Motorph {

    // ---------- INNER CLASSES FROM UML ----------

    // 1. Employee
    static class Employee {
        private String id;
        private String name;
        private String position;
        private double salary;
        private String employmentType;
        private LoginSession login;

        public Employee(String id, String name, String position, double salary, String employmentType, LoginSession login) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.salary = salary;
            this.employmentType = employmentType;
            this.login = login;
        }

        public double getNetPay() {
            return salary - calculateDeductions();
        }

        public double calculateDeductions() {
            Deductions deductions = new Deductions();
            return deductions.totalDeduction();
        }

        public double getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }
    }

    // 2. LoginSession
    static class LoginSession {
        private String username;
        private String passwordHash;

        public LoginSession(String username, String passwordHash) {
            this.username = username;
            this.passwordHash = passwordHash;
        }

        public boolean authenticate(String pw) {
            return passwordHash.equals(Integer.toString(pw.hashCode()));
        }
    }

    // 3. Payroll
    static class Payroll {
        private Employee employee;
        private String period;
        private double grossPay;
        private double deductions;
        private double netPay;

        public Payroll(Employee employee, String period, double grossPay) {
            this.employee = employee;
            this.period = period;
            this.grossPay = grossPay;
        }

        public void computePayroll() {
            deductions = employee.calculateDeductions();
            netPay = grossPay - deductions;
        }

        public void printPayroll() {
            System.out.println("Payroll for: " + employee.getName());
            System.out.println("Gross Pay: " + grossPay);
            System.out.println("Deductions: " + deductions);
            System.out.println("Net Pay: " + netPay);
        }
    }

    // 4. Deductions
    static class Deductions {

        public double calculateSSS() {
            return 200.0;
        }

        public double calculatePhilHealth() {
            return 150.0;
        }

        public double calculatePagIbig() {
            return 100.0;
        }

        public double calculateTax() {
            return 300.0;
        }

        public double calculateOtherDeductions() {
            return 50.0;
        }

        public double totalDeduction() {
            return calculateSSS() + calculatePhilHealth() + calculatePagIbig()
                    + calculateTax() + calculateOtherDeductions();
        }
    }

    // 5. Attendance
    static class Attendance {
        private String id;
        private String date;
        private String timeIn;
        private String timeOut;

        public Attendance(String id, String date, String timeIn, String timeOut) {
            this.id = id;
            this.date = date;
            this.timeIn = timeIn;
            this.timeOut = timeOut;
        }

        public double calculateWorkedHours() {
            String[] inParts = timeIn.split(":");
            String[] outParts = timeOut.split(":");
            int inMinutes = Integer.parseInt(inParts[0]) * 60 + Integer.parseInt(inParts[1]);
            int outMinutes = Integer.parseInt(outParts[0]) * 60 + Integer.parseInt(outParts[1]);
            return (outMinutes - inMinutes) / 60.0;
        }
    }

    // ---------- MAIN METHOD FOR DEMO ----------
    public static void main(String[] args) {
        // Setup login
        LoginSession login = new LoginSession("sarahtrinidad", Integer.toString("mypassword".hashCode()));

        // Setup employee
        Employee emp = new Employee("EMP001", "Sarah Trinidad", "Developer", 30000.0, "Full-Time", login);

        // Setup payroll
        Payroll payroll = new Payroll(emp, "May 2025", emp.getSalary());
        payroll.computePayroll();
        payroll.printPayroll();

        // Optional: Test attendance
        Attendance att = new Attendance("A001", "2025-05-18", "08:00", "17:00");
        System.out.println("Worked Hours: " + att.calculateWorkedHours());
    }
}

