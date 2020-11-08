import java.util.HashMap;

public class Backend {

    private static final HashMap<Long, BankAccount> accountMapper = new HashMap<>();

    public static boolean checkExistingHash(long hash) {
        return accountMapper.containsKey(hash);
    }

    public static void createAccount(long hash, BankAccount account){
        if (hash != 0L && account != null){
            accountMapper.put(hash, account);
        }
    }

    public static BankAccount access(long hash){
        return accountMapper.get(hash);
    }

}