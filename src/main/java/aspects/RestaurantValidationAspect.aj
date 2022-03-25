package aspects;

import main.LogsManager;
import main.Restaurant;

import java.util.Scanner;
public aspect RestaurantValidationAspect {

    Restaurant around(String name) : call(public main.Restaurant.new(String)) && args(name) {
        LogsManager.info("Initial restaurant name: " + name);

        if(nameIsValid(name)) {
            LogsManager.infoSuccess("Restaurant name is valid");
            return proceed(name);
        }
        else {
            LogsManager.info("Restaurant name is invalid.");
            Scanner scanner = new Scanner(System.in);
            String newName = "0";
            while (!nameIsValid(newName)) {
                LogsManager.info("Enter new name: ");
                newName = scanner.nextLine();
            }
            LogsManager.info("New restaurant name: " + newName);
            return proceed(newName);
        }
    }

    private boolean nameIsValid(String name) {
        return name.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
    }

}
