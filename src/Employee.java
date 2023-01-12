public class Employee {
    private  String employeeNick;
    // Объявили свойство nick (ФИО)
    private String department;
    // Объявили свойство phone (номер телефона)
    private int salary;
    private int id;




    public Employee(String employeeNick, String department, int salary, int id) {
        this.employeeNick = employeeNick;
        this.department = department;
        this.salary = salary;
        this.id = id;
    }

    public String getNick() {
        return employeeNick;
        // Создали геттер для ФИО
    }

    public String getDepartment() {
        return department;
        // Создали геттер для отдела
    }
    public int getSalary() {
        return salary;
        // Создали геттер для зарплаты
    }
    public void setDepartment(String department) {
        this.department = department;
        // Создали сеттер для отдела
    }
    public void setSalary(int salary) {
        this.salary = salary;
        // Создали сеттер для зарплаты
    }
}