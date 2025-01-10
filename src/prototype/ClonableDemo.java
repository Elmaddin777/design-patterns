package prototype;

import java.util.Arrays;

class User implements Cloneable {
    public String [] names;
    public Address address;

    public User(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new User(this.names.clone(), (Address) address.clone());
    }
}

class Address implements Cloneable {
    public String city;
    public String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(this.city, this.street);
    }
}

public class ClonableDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User(new String[] {"Bob", "Marley"},
                new Address("Baku", "Azadliq st."));

        User user2 = (User) user1.clone();
        user2.names[0] = "another name";
        user2.address = new Address("Ganja", "some st.");


        System.out.println("user1: " + user1);
        System.out.println("user2: " + user2);
    }

}
