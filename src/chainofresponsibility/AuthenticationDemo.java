package chainofresponsibility;

// Handler
interface Authentication {

    void authenticate(String username, String password);
    void setNext(Authentication auth);

}

// Concrete handler for basic auth
class BasicAuthentication implements Authentication {

    private Authentication nextAuth;

    @Override
    public void authenticate(String username, String password) {
        if (username.equals("basicUsername") && password.equals("basicPassword")) {
            System.out.println("User is being basic authenticated");
        } else if (nextAuth != null) {
            System.out.println("Passing through basic authentication");
            nextAuth.authenticate(username, password);
        } else {
            System.out.println("Authentication failed");
        }
    }

    @Override
    public void setNext(Authentication auth) {
       this.nextAuth = auth;
    }

}

// Concrete handler for oAuth2
class Oauth2Authentication implements Authentication {

    private Authentication nextAuth;

    @Override
    public void authenticate(String username, String password) {
        if (username.equals("oauth2Username") && password.equals("oauth2Password")) {
            System.out.println("User is being oAuth2 authenticated");
        } else if (nextAuth != null) {
            System.out.println("Passing through oAuth2 authentication");
            nextAuth.authenticate(username, password);
        } else {
            System.out.println("Authentication failed");
        }
    }

    @Override
    public void setNext(Authentication auth) {
      this.nextAuth = auth;
    }

}

// Concrete handler for SSO
class SsoAuthentication implements Authentication {

    private Authentication nextAuth;

    @Override
    public void authenticate(String username, String password) {
        if (username.equals("ssoUsername") && password.equals("ssoPassword")) {
            System.out.println("User is being SSO authenticated");
        } else if (nextAuth != null) {
            System.out.println("Passing through SSO authentication");
            nextAuth.authenticate(username, password);
        } else {
            System.out.println("Authentication failed");
        }
    }

    @Override
    public void setNext(Authentication auth) {
        this.nextAuth = auth;
    }

}

public class AuthenticationDemo {

    public static void main(String[] args) {
        Authentication basicAuthentication = new BasicAuthentication();
        Authentication oauth2Authentication = new Oauth2Authentication();
        Authentication ssoAuthentication = new SsoAuthentication();

        basicAuthentication.setNext(oauth2Authentication);
        oauth2Authentication.setNext(ssoAuthentication);

        System.out.println("First auth attempt ...");
        basicAuthentication.authenticate("basicUsername", "basicPassword");

        System.out.println("Second auth attempt ...");
        basicAuthentication.authenticate("ssoUsername", "ssoPassword");
    }

}
