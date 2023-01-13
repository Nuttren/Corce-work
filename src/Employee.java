import java.util.Objects;

public class Employee {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && id == employee.id && employeeNick.equals(employee.employeeNick) && department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNick, department, salary, id);
    }

    @Override
    public String toString() {
        return "Сотрудник (" +
                "Фамилия и имя: " + employeeNick + '\'' +
                ", Отдел: " + department + '\'' +
                ", Зарплата=" + salary +
                ", id=" + id +
                ')';
    }

    private  String employeeNick;
    // Объявили свойство nick (ФИО)
    private String department;
    // Объявили свойство phone (номер телефона)
    private int salary;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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