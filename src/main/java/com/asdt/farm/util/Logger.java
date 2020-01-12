package com.asdt.farm.util;

public class Logger {

    private static boolean inString = false;

    /**
     * StringBuffer is threadSafe but requires a bit more resources for that
     * StringBuilder is not threadSafe so its the correct approach here.
     * Those two are exactly the same apart the thread safety.
     */
    private static StringBuilder sb = new StringBuilder();
    // private static StringBuffer sb = new StringBuffer();

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
        // sb = new StringBuffer();
        sb = new StringBuilder();
    }
}
