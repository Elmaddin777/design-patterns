package singleton.DependencyInjection;

class TaskService {

    public void performTask() {
        System.out.println("Task performed");
    }

}

class TaskClient {

    private final TaskService service;

    public TaskClient(TaskService service) {
        this.service = service;
    }

    public void execute() {
        service.performTask();
    }

}

public class ConstructorInjection {

    public static void main(String[] args) {
        TaskClient client = new TaskClient(new TaskService());
        client.execute();
    }

}
