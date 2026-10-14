public class PersonalBankingLedger {

    // Account details
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Tracking totals for summary
    private double totalDeposits = 0.0;
    private double totalWithdrawals = 0.0;

    // Constructor to initialize account details
    public PersonalBankingLedger(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName.trim().toUpperCase();
        this.accountNumber = accountNumber.trim();
        this.balance = initialBalance;
    }

    // Deposit with custom description
    public void deposit(double amount, String description) {
        this.balance += amount;
        this.totalDeposits += amount;

        System.out.println("Deposit Amount      : Rs. " + String.format("%.2f", amount));
        System.out.println("Transaction Status : Deposit Successful");
        System.out.println("Updated Balance     : Rs. " + String.format("%.2f", this.balance));
        System.out.println();
    }

    // Overloaded deposit with simple amount
    public void deposit(double amount) {
        deposit(amount, "Standard Deposit");
    }

    // Withdrawal with validation
    public void withdraw(double amount, String description) {
        if (amount > this.balance) {
            System.out.println("Withdrawal Amount  : Rs. " + String.format("%.2f", amount));
            System.out.println("Transaction Status : Insufficient Balance");
            System.out.println("Available Balance  : Rs. " + String.format("%.2f", this.balance));
            System.out.println();
        } else {
            this.balance -= amount;
            this.totalWithdrawals += amount;

            System.out.println("Withdrawal Amount  : Rs. " + String.format("%.2f", amount));
            System.out.println("Transaction Status : Withdrawal Successful");
            System.out.println("Updated Balance     : Rs. " + String.format("%.2f", this.balance));
            System.out.println();
        }
    }

    // Overloaded withdrawal with simple amount
    public void withdraw(double amount) {
        withdraw(amount, "Standard Withdrawal");
    }

    // Name verification method (properly closed with a brace)
    public boolean verifyAccountHold(String inputName) {
        if (inputName == null) {
            return false;
        }
        return this.accountHolderName.equals(inputName.trim().toUpperCase());
    } 

    // Print Initial Account Details
    public void displayAccountInfo() {
        System.out.println("=========== PERSONAL BANKING LEDGER ===========");
        System.out.println("Account Holder Name : " + this.accountHolderName);
        System.out.println("Account Number      : " + this.accountNumber);
        System.out.println("Initial Balance     : Rs. " + String.format("%.2f", (this.balance - totalDeposits + totalWithdrawals)));
        System.out.println("\n----------- TRANSACTION DETAILS -----------");
    }

    // Print Summary
    public void displaySummary(String nameToVerify) {
        System.out.println("----------- ACCOUNT SUMMARY -----------");
        System.out.println("Account Holder      : " + this.accountHolderName);
        System.out.println("Account Number      : " + this.accountNumber);
        System.out.println("Total Deposits      : Rs. " + String.format("%.2f", this.totalDeposits));
        System.out.println("Total Withdrawals   : Rs. " + String.format("%.2f", this.totalWithdrawals));
        // Fixed: Use correct lowercase String.format with format specifier
        System.out.println("Final Balance       : Rs. " + String.format("%.2f", this.balance));
        System.out.println();

        boolean isMatch = verifyAccountHold(nameToVerify);
        System.out.println("Account Holder Verification: " + (isMatch ? "Names Match" : "Names Do Not Match"));
        System.out.println("===============================================");
    }

    // Main Method
    public static void main(String[] args) {
        PersonalBankingLedger ledger = new PersonalBankingLedger("Ravi Kumar", "1234567890", 10000.00);

        ledger.displayAccountInfo();
        ledger.deposit(5000.00);
        ledger.withdraw(2000.00);
        ledger.withdraw(20000.00);
        ledger.displaySummary("Ravi Kumar");
    }
}