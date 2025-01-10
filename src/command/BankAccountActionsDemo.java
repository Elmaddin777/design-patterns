package command;

class BankAccount {

    private double balance;
    private final double withdrawLimit = -500;

    protected void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited $" + amount);
    }

    protected void withdraw(double amount) {
        if ((balance - amount) >= withdrawLimit) {
            balance -= withdrawLimit;
        }
        System.out.println("Withdraw $" + amount);
    }

    @Override
    public String toString() {
        return "Balance $" + balance;
    }

}

interface BankOperation {

    void execute();

}

enum BankOperationType {
    DEPOSIT, WITHDRAW
}

class TransferCommand implements BankOperation {

    private final BankAccount bankAccount;
    private final BankOperationType type;
    private final double amount;

    public TransferCommand(BankAccount bankAccount, BankOperationType type, double amount) {
        this.bankAccount = bankAccount;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (this.type == BankOperationType.WITHDRAW) {
            bankAccount.withdraw(this.amount);
        } else if (this.type == BankOperationType.DEPOSIT) {
            bankAccount.deposit(this.amount);
        } else {
            System.out.println("Invalid operation");
        }
    }

}

public class BankAccountActionsDemo {

    public static void main(String[] args) {
        BankAccount edisAccount = new BankAccount();
        BankOperation depositOperation =
                new TransferCommand(edisAccount, BankOperationType.DEPOSIT, 500 );
        depositOperation.execute();

        System.out.println(edisAccount);
    }

}
