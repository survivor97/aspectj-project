package main;

public class LogsManager {
    private static final String ANSI_BLUE = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    public static final String TEXT_RESET = "\u001B[0m";

    public static void info(String text) {
        System.out.println(ANSI_BLUE + "INFO: " + TEXT_RESET + text);
    }

    public static void infoSuccess(String text) {
        System.out.println(ANSI_GREEN + "SUCCESS: " + TEXT_RESET + text);
    }

    public static void exception(Exception exception) {
        System.out.println(ANSI_RED + "EXCEPTION: " + TEXT_RESET + exception.getMessage());
    }

    public static void exception(String message) {
        System.out.println(ANSI_RED + "WARNING: " + TEXT_RESET + message);
    }

    public static void warning(String message) {
        System.out.println(ANSI_YELLOW + "WARNING: " + TEXT_RESET + message);
    }
}
