package com.asdt.farm;

public class Logger {

    private static boolean inString = false;

    private static StringBuffer sb = new StringBuffer();

    public static void log(String string) {
        if (inString) {
            sb.append(string);
            sb.append("\n");
        } else {
            System.out.println(string);
        }
    }

    public static String getLog() {
        return sb.toString();
    }

    public static void collectInString(boolean b) {
        inString = b;
    }

    public static void reset() {
        sb = new StringBuffer();
    }

}
