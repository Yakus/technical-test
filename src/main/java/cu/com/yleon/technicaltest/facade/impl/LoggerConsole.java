package cu.com.yleon.technicaltest.facade.impl;

import cu.com.yleon.technicaltest.exception.EmptyMessageException;
import cu.com.yleon.technicaltest.facade.LoggerFacade;
import org.apache.logging.log4j.util.Strings;

import java.util.logging.Level;

public class LoggerConsole implements LoggerFacade {

    public void addMessage(String message, String type) throws EmptyMessageException {
        if (Strings.isBlank(message)) {
            throw new EmptyMessageException("Message must not be empty");
        }
        switch (type) {
            case "INFO":
                logger.log(Level.INFO, message);
                break;
            case "WARNING":
                logger.log(Level.WARNING, message);
                break;
            case "ERROR":
                logger.log(Level.SEVERE, message);
                break;
        }
    }
}