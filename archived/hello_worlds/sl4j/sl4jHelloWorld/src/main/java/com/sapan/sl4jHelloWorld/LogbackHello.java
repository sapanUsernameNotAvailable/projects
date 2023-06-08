package com.sapan.sl4jHelloWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class LogbackHello {

   private static final Logger slf4jLogger = LoggerFactory.getLogger(LogbackHello.class);
 
    public static void main(String[] args) {
        slf4jLogger.trace("Hello World!");
        slf4jLogger.debug("Hi, {}", "Sapan >:D");
        slf4jLogger.info("Welcome to the HelloWorld example of Logback.");
        slf4jLogger.warn("Dummy warning message.");
        slf4jLogger.error("Dummy error message.");
    }
}