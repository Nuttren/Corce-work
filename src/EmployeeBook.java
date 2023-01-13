import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees;
    // Объявили массив Employee, реализуемый в классе Employee
    private int size;
    // Объявили свойство size (размер)

    public EmployeeBook() {
        this.employees = new Employee[10];
        // Задали массиву Employee длину — 10
    }

    // Реализуем метод addContact (создать сотрудника):
    public void addEmployee(String contactNick, String department, int salary, int id) {
        if (size >= employees.length) {
            System.out.println("Нельзя добавить сотрудника, закончилось место");
        }
        Employee newEmployee = new Employee(contactNick, department, salary, id);
        employees[size++] = newEmployee;
    }

    // Реализуем метод removeEmployee (удалить контакт)
    // Метод сдвигает массив влево на ячейку, удаляя ячейку под номером i
    public void removeEmployee(String employeeNick) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getNick().equals(employeeNick)) {
                System.out.println(employees[i].getNick() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }

    // Реализуем метод findEmployee (найти контакт)
    public void findContact(String employeeNick) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getNick().equals(employeeNick)) {
                System.out.println(employee.getNick() + ": " + employee.getDepartment() + ": " + employee.getSalary());
                return;
            }
        }
        System.out.println(employeeNick + " не найден");
    }

    // Реализуем метод printAllEmployees (распечатать все контакты со всеми параметрами)
    public void printAllEmployee() {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
        }
        System.out.println(Arrays.toString(employees));
    }

    // Реализуем метод getCurrentSize (получить текущий размер)
    public int getCurrentSize() {
        return size;
    }

    public void totalMonthlySalary() {
        int sum = 0;
        int sumAverage = 0;

        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            sum += employee.getSalary();
        }
        System.out.println("Общая месячная зарплата: " + sum);
        sumAverage = sum / employees.length;
        System.out.println("Средняя месячная зарплата: " + sumAverage);
        System.out.println();
    }

    // Реализуем метод printAllEmployeeNick (распечатать все контакты только с именем)
    public void printAllEmployeeNick() {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getNick());
            System.out.println();
        }
    }

    // // Реализуем метод printMaxSalary (распечатать контакт с максимальной зп)
    public void printMaxSalary() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();

                    System.out.println(employee.getNick() + ": " + employee.getDepartment() + ": " + employee.getSalary() + ": " + employee.getId());
                    System.out.println();
                }
            }
        }


    public void printMinSalary() {
        int min = 100000;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                System.out.println(employee.getNick() + ": " + employee.getDepartment() + ": " + employee.getSalary() + ": " + employee.getId());
                System.out.println();
            }
        }
    }
}






