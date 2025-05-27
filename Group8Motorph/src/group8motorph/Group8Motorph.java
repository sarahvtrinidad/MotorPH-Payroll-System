/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package group8motorph;

/**
 *
 * @author sarahtrinidad
 */
import java.util.Scanner;

public class Group8Motorph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[]{new Employee(1, "Sarah Trinidad", "Developer", (double)30000.0F, "Full-Time", new LoginSession("sarahtrinidad", Integer.toString("mypassword".hashCode()))), new Employee(2, "Jett Dagsa", "Developer", (double)28000.0F, "Full-Time", new LoginSession("jet01", Integer.toString("password123".hashCode()))), new Employee(3, "Ela Abigail Acal", "Developer", (double)45000.0F, "Full-Time", new LoginSession("ela02", Integer.toString("pass123".hashCode()))), new Employee(4, "Franchella Martini micu-Paculan", "Developer", (double)35000.0F, "Full-Time", new LoginSession("fran03", Integer.toString("pass12345".hashCode()))), new Employee(5, "Irisha Bea Montaño", "Developer", (double)32000.0F, "Full-Time", new LoginSession("iris04", Integer.toString("pass123456".hashCode())))};
        System.out.println("Welcome to Motorph Payroll System");
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        Employee loggedInEmployee = null;

        for(Employee emp : employees) {
            if (emp.getLogin().getUsername().equals(inputUsername) && emp.getLogin().authenticate(inputPassword)) {
                loggedInEmployee = emp;
                break;
            }
        }

        if (loggedInEmployee != null) {
            System.out.println("\nLogin successful.\n");
            Payroll payroll = new Payroll(loggedInEmployee, "May 2025", loggedInEmployee.getSalary());
            payroll.computePayroll();
            payroll.printPayroll();
        } else {
            System.out.println("\nInvalid credentials. Access denied.");
        }

        scanner.close();
    }

    static class Employee {
        private int id;
        private String name;
        private String position;
        private double salary;
        private String employmentType;
        private LoginSession login;

        public Employee(int id, String name, String position, double salary, String employmentType, LoginSession login) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.salary = salary;
            this.employmentType = employmentType;
            this.login = login;
        }

        public double getNetPay() {
            return this.salary - this.calculateDeductions();
        }

        public double calculateDeductions() {
            Deductions deductions = new Deductions(this.salary);
            return deductions.totalDeduction();
        }

        public double getSalary() {
            return this.salary;
        }

        public String getName() {
            return this.name;
        }

        public LoginSession getLogin() {
            return this.login;
        }
    }

    static class LoginSession {
        private String username;
        private String passwordHash;

        public LoginSession(String username, String passwordHash) {
            this.username = username;
            this.passwordHash = passwordHash;
        }

        public boolean authenticate(String pw) {
            return this.passwordHash.equals(Integer.toString(pw.hashCode()));
        }

        public String getUsername() {
            return this.username;
        }
    }

    static class Payroll {
        private Employee employee;
        private String period;
        private double grossPay;
        private double deductions;
        private double netPay;
        private Deductions deductionsBreakdown;

        public Payroll(Employee employee, String period, double grossPay) {
            this.employee = employee;
            this.period = period;
            this.grossPay = grossPay;
            this.deductionsBreakdown = new Deductions(grossPay);
        }

        public void computePayroll() {
            this.deductions = this.deductionsBreakdown.totalDeduction();
            this.netPay = this.grossPay - this.deductions;
        }

        public void printPayroll() {
            System.out.println("Payroll for: " + this.employee.getName());
            System.out.println("Gross Pay: " + this.grossPay);
            System.out.println("Deductions Breakdown:");
            System.out.printf("  SSS: %.2f\n", this.deductionsBreakdown.calculateSSS());
            System.out.printf("  PhilHealth: %.2f\n", this.deductionsBreakdown.calculatePhilHealth());
            System.out.printf("  Pag-IBIG: %.2f\n", this.deductionsBreakdown.calculatePagIbig());
            System.out.printf("  Tax: %.2f\n", this.deductionsBreakdown.calculateTax());
            System.out.printf("  Other Deductions: %.2f\n", this.deductionsBreakdown.calculateOtherDeductions());
            System.out.printf("Total Deductions: %.2f\n", this.deductions);
            System.out.printf("Net Pay: %.2f\n", this.netPay);
        }
    }

    static class Deductions {
        private double salary;

        public Deductions(double salary) {
            this.salary = salary;
        }

        public double calculateSSS() {
            return this.salary * 0.045;
        }

        public double calculatePhilHealth() {
            return this.salary * 0.03;
        }

        public double calculatePagIbig() {
            return this.salary * 0.02;
        }

        public double calculateTax() {
            return this.salary * 0.1;
        }

        public double calculateOtherDeductions() {
            return (double)50.0F;
        }

        public double totalDeduction() {
            return this.calculateSSS() + this.calculatePhilHealth() + this.calculatePagIbig() + this.calculateTax() + this.calculateOtherDeductions();
        }
    }

    static class Attendance {
        private int id;
        private String date;
        private String timeIn;
        private String timeOut;

        public Attendance(int id, String date, String timeIn, String timeOut) {
            this.id = id;
            this.date = date;
            this.timeIn = timeIn;
            this.timeOut = timeOut;
        }

        public double calculateWorkedHours() {
            String[] inParts = this.timeIn.split(":");
            String[] outParts = this.timeOut.split(":");
            int inMinutes = Integer.parseInt(inParts[0]) * 60 + Integer.parseInt(inParts[1]);
            int outMinutes = Integer.parseInt(outParts[0]) * 60 + Integer.parseInt(outParts[1]);
            return (double)(outMinutes - inMinutes) / (double)60.0F;
        }
    }
}
