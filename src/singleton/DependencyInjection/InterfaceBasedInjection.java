package singleton.DependencyInjection;

// Dependency
class Service {
    public void performTask() {
        System.out.println("Service performing task");
    }
}

// Interface for injecting
interface Client {
    void setService(Service service);
    void execute();
}

// impl
class ClientImpl implements Client {

    private Service service;

    @Override
    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public void execute() {
        if (service != null) {
            service.performTask();
        } else {
            System.out.println("Service is null");
        }
    }

}

/*
*
*  Dependency Injection explicitly
*
* */
public class InterfaceBasedInjection {

    public static void main(String[] args) {
       Client client = new ClientImpl();
       client.setService(new Service());
       client.execute();
    }

}
