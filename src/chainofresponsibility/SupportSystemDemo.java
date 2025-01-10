package chainofresponsibility;

// Handler
abstract class SupportRequest {

    public SupportRequest nextRequest;

    protected void setNextRequest(SupportRequest nextRequest) {
        this.nextRequest = nextRequest;
    }

    protected abstract void handleRequest(String handleRequest);

}

// Concrete handler 1
class LevelOneSupport extends SupportRequest {

    @Override
    public void handleRequest(String handleRequest) {
        if (handleRequest.equalsIgnoreCase("Password change")) {
            System.out.println("Level One support team on it ...");
        } else if (nextRequest != null) {
            System.out.println("Support can not be handled by level 1 support team");
            nextRequest.handleRequest(handleRequest);
        } else {
            System.out.println("Request can not be handled");
        }
    }

}

// Concrete handler 2
class LevelTwoSupport extends SupportRequest {

    @Override
    public void handleRequest(String handleRequest) {
        if (handleRequest.equalsIgnoreCase("Hardware support")) {
            System.out.println("Level Two support team on it ...");
        } else if (nextRequest != null) {
            System.out.println("Support can not be handled by level 2 support team");
            nextRequest.handleRequest(handleRequest);
        } else {
            System.out.println("Request can not be handled");
        }
    }

}

// Concrete handler 3
class TechLeadSupport extends SupportRequest {

    @Override
    public void handleRequest(String handleRequest) {
        System.out.println("Problem passed to TechLead for support");
    }

}

public class SupportSystemDemo {

    public static void main(String[] args) {
        SupportRequest l1Support = new LevelOneSupport();
        SupportRequest l2Support = new LevelTwoSupport();
        SupportRequest techLead = new TechLeadSupport();

        l1Support.setNextRequest(l2Support);
        l2Support.setNextRequest(techLead);

        l1Support.handleRequest("Hardware support");
        System.out.println("==========================================");
        l2Support.handleRequest("Unknown support request");

    }

}
