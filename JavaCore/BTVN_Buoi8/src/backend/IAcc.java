package backend;

import entity.Account;
import java.util.List;

public interface IAcc {
    List<Account> getAllAccounts();
    List<Account> getAccountsByUsername(String username);
}
