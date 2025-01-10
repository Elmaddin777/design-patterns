package proxy;

interface DatabaseConnection {

    void executeQuery(String query);

}

class OracleDatabaseConnection implements DatabaseConnection {

    private final String connectionString;
    private final String userName;
    private final String password;

    public OracleDatabaseConnection(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
        connect();
    }

    private boolean checkCredentials(String userName, String password) {
        return true; // Assuming it is always true
    }

    public void connect() {
        if (checkCredentials(this.userName, this.password)) {
            System.out.println("Connecting to Oracle DB : " + this.connectionString);
            return;
        }
        System.out.println("Wrong username or password");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }

}

class OracleDatabaseProxy implements DatabaseConnection {

    private final String connectionString;
    private final String userName;
    private final String password;
    private OracleDatabaseConnection oracleDatabaseConnection;

    public OracleDatabaseProxy(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
        openOracleDatabaseConnection();
    }

    @Override
    public void executeQuery(String query) {
        oracleDatabaseConnection.executeQuery(query);
    }

    private void openOracleDatabaseConnection() {
        if (oracleDatabaseConnection == null) {
            this.oracleDatabaseConnection = new OracleDatabaseConnection(connectionString, userName, password);
        }
    }

}


class DbConnectionDemo {

    public static void main(String[] args) {
        var oracleConnection = new OracleDatabaseProxy(
                "jdbc:oracle://localhost:3306/mydb", "username", "password");
        oracleConnection.executeQuery("select * from dual");
        oracleConnection.executeQuery("select * from dual");

        var oracleDbConnectionBackup = new OracleDatabaseConnection(
                "jdbc:oracle://localhost:3306/mydb/backup", "username", "password");
        oracleDbConnectionBackup.executeQuery("select * from dual");
    }

}

