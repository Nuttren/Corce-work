public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Иван Иванов", "0",1000,0);
        employeeBook.addEmployee("Сергей Сергеев", "0",2000,1);
        employeeBook.addEmployee("Роман Романов", "0",3000,2);
        employeeBook.addEmployee("Петр Петров", "0",4000,3);
        employeeBook.addEmployee("Семен Семенов", "0",5000,4);
        employeeBook.addEmployee("Павел Павлов", "0",6000,5);
        employeeBook.addEmployee("Фома Фоминский", "0",7000,6);
        employeeBook.addEmployee("Антон Антонов", "0",8000,7);
        employeeBook.addEmployee("Илья Ильин", "0",9000, 8);
        employeeBook.printAllEmployee();
        System.out.println();
        employeeBook.totalMonthlySalary();
        employeeBook.getCurrentSize();
    }
}
