package aspects;

import main.Account;
import main.LogsManager;


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

public aspect EmailAspect {
    private List<String> emails = new ArrayList<>();

    void around(Account account, String newEmail) : call(* main.Account.setEmail(String)) && target(account) && args(newEmail) {
        final String email = account.getEmail();
        final Boolean isEmailAlreadyUsed =  emails.stream().filter(el -> el == newEmail).findFirst().isPresent();

        if(isEmailAlreadyUsed) {
            LogsManager.exception("Email: {" + newEmail + "} is already used");
        } else {
            emails.add(newEmail);
            emails.remove(email);
            proceed(account, newEmail);
        }
    }

    void around(String email) : execution(* main.Account.setEmail(String)) && args(email) {
        final Boolean isEmailValid = email.matches("^(.+)@(.+)$");
        if(!isEmailValid) {
            LogsManager.exception("Email: {" + email + "} is not valid");
        } else {
            proceed(email);
        }
    }
}
