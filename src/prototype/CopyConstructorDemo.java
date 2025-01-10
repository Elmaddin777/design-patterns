package prototype;

class Employee {

    public String name;
    public EmployeeAddress address;

    public Employee(Employee otherObject) {
        name = otherObject.name;
        address = new EmployeeAddress(otherObject.address);
    }

    public Employee(String name, EmployeeAddress address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class EmployeeAddress {

    public String streetName;

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "streetName='" + streetName + '\'' +
                '}';
    }

    public EmployeeAddress(EmployeeAddress otherObject) {
        streetName = otherObject.streetName;
    }

    public EmployeeAddress(String streetName) {
        this.streetName = streetName;
    }
}


public class CopyConstructorDemo {

    public static void main(String[] args) {
        var employee1 = new Employee("firstemployee", new EmployeeAddress("firststreetname"));
        var employee2 = new Employee(employee1);
        employee2.name = "secondemployee";

        System.out.println("First employee: " + employee1);
        System.out.println("Second employee: " + employee2);
    }

}
