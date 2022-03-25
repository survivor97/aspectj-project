package aspects;

import main.LogsManager;
import org.mindrot.jbcrypt.BCrypt;

public aspect AccountAspect {

    void around(String firstName, String lastName, String email, String username, String password) : execution(public main.Account.new(String, String, String, String, String)) && args(firstName, lastName, email, username, password) {
        LogsManager.info("New Account - Encrypting password...");
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        LogsManager.info("Account with username {" + username + "} has an initial password: {" + password + "}; encrypted: {" + hash + "}");
        proceed(firstName, lastName, email, username, hash);
    }

}