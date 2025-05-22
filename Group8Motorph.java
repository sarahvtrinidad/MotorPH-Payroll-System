import java.util.Scanner;

public class Group8Motorph {

    // ---------- INNER CLASSES FROM UML ----------

    // 1. Employee
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
            return salary - calculateDeductions();
        }

        public double calculateDeductions() {
            Deductions deductions = new Deductions(salary);
            return deductions.totalDeduction();
        }

        public double getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }

        public LoginSession getLogin() {
            return login;
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

        public String getUsername() {
            return username;
        }
    }

    // 3. Payroll
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
            deductions = deductionsBreakdown.totalDeduction();
            netPay = grossPay - deductions;
        }

        public void printPayroll() {
            System.out.println("Payroll for: " + employee.getName());
            System.out.println("Gross Pay: " + grossPay);
            System.out.println("Deductions Breakdown:");
            System.out.printf("  SSS: %.2f\n", deductionsBreakdown.calculateSSS());
            System.out.printf("  PhilHealth: %.2f\n", deductionsBreakdown.calculatePhilHealth());
            System.out.printf("  Pag-IBIG: %.2f\n", deductionsBreakdown.calculatePagIbig());
            System.out.printf("  Tax: %.2f\n", deductionsBreakdown.calculateTax());
            System.out.printf("  Other Deductions: %.2f\n", deductionsBreakdown.calculateOtherDeductions());
            System.out.printf("Total Deductions: %.2f\n", deductions);
            System.out.printf("Net Pay: %.2f\n", netPay);
        }
    }

    // 4. Deductions
    static class Deductions {
        private double salary;

        public Deductions(double salary) {
            this.salary = salary;
        }

        public double calculateSSS() {
            return salary * 0.045; // 4.5% for example
        }

        public double calculatePhilHealth() {
            return salary * 0.03; // 3%
        }

        public double calculatePagIbig() {
            return salary * 0.02; // 2%
        }

        public double calculateTax() {
            return salary * 0.10; // 10%
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
            String[] inParts = timeIn.split(":");
            String[] outParts = timeOut.split(":");
            int inMinutes = Integer.parseInt(inParts[0]) * 60 + Integer.parseInt(inParts[1]);
            int outMinutes = Integer.parseInt(outParts[0]) * 60 + Integer.parseInt(outParts[1]);
            return (outMinutes - inMinutes) / 60.0;
        }
    }

    // ---------- MAIN METHOD FOR DEMO ----------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setup login and employees
        Employee[] employees = new Employee[] {
            new Employee(1, "Sarah Trinidad", "Developer", 30000.0, "Full-Time", new LoginSession("sarahtrinidad", Integer.toString("mypassword".hashCode()))),
            new Employee(2, "Jett Dagsa", "Developer", 28000.0, "Full-Time", new LoginSession("jet01", Integer.toString("password123".hashCode()))),
            new Employee(3, "Ela Abigail Acal", "Developer", 45000.0, "Full-Time", new LoginSession("ela02", Integer.toString("pass123".hashCode()))),
            new Employee(4, "Franchella Martini micu-Paculan", "Developer", 35000.0, "Full-Time", new LoginSession("fran03", Integer.toString("pass12345".hashCode()))),
            new Employee(5, "Irisha Bea Montaño", "Developer", 32000.0, "Full-Time", new LoginSession("iris04", Integer.toString("pass123456".hashCode())))
        };

        System.out.println("Welcome to Motorph Payroll System");
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        Employee loggedInEmployee = null;
        for (Employee emp : employees) {
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
}
