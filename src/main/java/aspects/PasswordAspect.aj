package aspects;


import com.sun.org.apache.xpath.internal.operations.Bool;
import main.LogsManager;
import main.Order;
import main.Account;
import main.Restaurant;
import org.apache.commons.logging.Log;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public aspect PasswordAspect {
    void around(String password) : execution(* main.Account.setPassword(String)) && args(password) {
        final Boolean isPasswordValid = password.matches("^(?=.*[0-9])(?=.*[A-Za-z]).{6,20}$");
        LogsManager.info(password);
        if(!isPasswordValid) {
            LogsManager.exception("Password: {" + password + "} is not valid");
        } else {
            proceed(password);
        }
    }

    void around(String password) : execution(* main.Account.setPassword(String)) && args(password) {
        LogsManager.info("Encrypting password...");
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        LogsManager.info("initial password: {" + password + "}; encrypted: {" + hash + "}");
        proceed(hash);
    }
}
