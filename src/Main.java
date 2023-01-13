public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Иван Иванов", "1", 13000, 0);
        employeeBook.addEmployee("Сергей Сергеев", "2", 15000, 1);
        employeeBook.addEmployee("Роман Романов", "3", 3000, 2);
        employeeBook.addEmployee("Петр Петров", "4", 4000, 3);
        employeeBook.addEmployee("Семен Семенов", "5", 5000, 4);
        employeeBook.addEmployee("Павел Павлов", "1", 6000, 5);
        employeeBook.addEmployee("Фома Фоминский", "2", 7000, 6);
        employeeBook.addEmployee("Антон Антонов", "3", 8000, 7);
        employeeBook.addEmployee("Илья Ильин", "4", 9000, 8);
        employeeBook.addEmployee("Максим Максимов", "5", 11100, 9);
        employeeBook.printAllEmployee();
        System.out.println();
        employeeBook.totalMonthlySalary();
        employeeBook.printAllEmployeeNick();
        employeeBook.printMaxSalary();
        employeeBook.printMinSalary ();
        employeeBook.getCurrentSize();
    }

}
