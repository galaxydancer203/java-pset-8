import java.math.BigDecimal;
import java.text.NumberFormat;

public class BankAccount {
    AccountOwner accountOwner;
    double balance;
    long accountNumber;

    public BankAccount(AccountOwner accountOwner, double balance){
        this.accountOwner = accountOwner;
        this.balance = balance;
        long accountNumber = 0;
        boolean hashFound = false;
        do {
            accountNumber = generateHash();
            if (!(Backend.checkExistingHash(accountNumber))){
                hashFound = true;
            }
        } while (!hashFound);
        this.accountNumber = accountNumber;
        Backend.createAccount(accountNumber, this);
    }

    public int deposit(double amount){
        if (amount > 0){
            this.balance += amount;
            return 1;
        } else return 2;
    }

    public int withdraw(double amount){
        if (amount < 0){
            return 2;
        } else if (amount > this.balance){
            return 3;
        } else {
            this.balance -= amount;
            return 1;
        }
    }

    public int transfer(long account, double amount){
        if(Backend.checkExistingHash(account) && amount < this.balance && amount > 0){
            withdraw(amount);
            Backend.access(account).deposit(amount);
            return 1;
        } else if(!Backend.checkExistingHash(account)) return 4;
        else if (amount > this.balance) return 3;
        else return 2;
    }

    public String getMaskedAccountNumber(){
        String toMask = String.valueOf(this.accountNumber);
        String lastHalf = toMask.substring(toMask.length() - 4);
        return "****" + lastHalf;
    }

    public String getFormattedBalance(){
        return NumberFormat.getCurrencyInstance().format(this.balance);
    }

    public BigDecimal validateBalance(double balance){
        if (balance <= 0){
            return BigDecimal.ZERO;
        } else return BigDecimal.valueOf(balance);
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }

    public AccountOwner getAccountOwner(){
        return this.accountOwner;
    }

    public void setAccountOwner(AccountOwner accountOwner){
        if (accountOwner != null){
            this.accountOwner = accountOwner;
        }
    }

    public BigDecimal getBalance(){
        return BigDecimal.valueOf(this.balance);
    }

    private long generateHash(){
        String keyGen = "";
        for(int i=0;i<8;i++){
            int tmp = (int) (Math.random() * (9 - 0 + 1) + 0);
            keyGen += tmp;
        }
        long returnMe = Long.parseLong(keyGen);
        return returnMe;
    }
}
