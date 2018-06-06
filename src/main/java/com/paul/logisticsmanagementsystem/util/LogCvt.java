package com.paul.logisticsmanagementsystem.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogCvt {
    private static final String INFO = "info";
    private static final String ERROR = "error";
    private static final String DEBUG = "debug";
    private static final String TRACE = "trace";

    private static final Logger logger = LoggerFactory.getLogger("com.froad");

    public Logger getLogger() {
        return logger;
    }


    // Log a message at the INFO level.
    public static void info(String msg) {
        printer(INFO, msg, null);
    }

    // Log a message at the INFO level.
    public static void info(String msg, Throwable t) {
        printer(INFO, msg, t);
    }


    // Log a message at the DEBUG level.
    public static void debug(String msg) {
        printer(DEBUG, msg, null);
    }


    // Log a message at the DEBUG level.
    public static void debug(String msg, Throwable t) {
        printer(DEBUG, msg, t);
    }

    // Log a message at the ERROR level.
    public static void error(String msg) {
        printer(ERROR, msg, null);
    }

    // Log a message at the ERROR level.
    public static void error(String msg, Throwable t) {
        printer(ERROR, msg, t);

    }

    // Log a message at the TRACE level.
    public static void trace(String msg) {
        printer(TRACE, msg, null);
    }

    // Log a message at the TRACE level.
    public static void trace(String msg, Throwable t) {
        printer(TRACE, msg, t);
    }


    private static String numberOfLine(String str) {
        return String.valueOf((" " + str).split("\n").length - 1);
    }

    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            try {
                pw.close();
                sw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String checkMsg(String msg) {
        return msg != null ? msg : "";
    }

    private static void printer(String type, String msg, Throwable e) {
        msg = checkMsg(msg);
        StringBuilder sb = new StringBuilder();
        sb.append(msg.replaceAll("\n", "\r\n"));
        sb.append(e != null ? getStackTrace(e) : "");
        MDC.put("LINE", numberOfLine(sb.toString()));
        String msg2 = sb.toString();
        if (INFO.equalsIgnoreCase(type)) {
            logger.info(msg2);
        } else if (ERROR.equalsIgnoreCase(type)) {
            logger.error(msg2);
        } else if (DEBUG.equalsIgnoreCase(type)) {
            logger.debug(msg2);
        } else if (TRACE.equalsIgnoreCase(type)) {
            logger.trace(msg2);
        }
        MDC.remove("LINE");
    }
}
