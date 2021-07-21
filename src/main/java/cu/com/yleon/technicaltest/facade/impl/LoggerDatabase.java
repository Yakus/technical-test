package cu.com.yleon.technicaltest.facade.impl;

import cu.com.yleon.technicaltest.config.MessageType;
import cu.com.yleon.technicaltest.exception.EmptyMessageException;
import cu.com.yleon.technicaltest.facade.LoggerFacade;
import cu.com.yleon.technicaltest.manager.DatabaseManager;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.env.Environment;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;

public class LoggerDatabase implements LoggerFacade {

    private final DatabaseManager manager;
    private final Environment env;

    public LoggerDatabase(Environment env) {
        this.env = env;
        this.manager = new DatabaseManager(env);
    }

    public void addMessage(String message, String type) throws EmptyMessageException {
        if (Strings.isBlank(message)) {
            throw new EmptyMessageException("Message must not be empty");
        }
        String messageCode = null;
        switch (type) {
            case "INFO":
                logger.log(Level.INFO, message);
                messageCode =  MessageType.MESSAGE.getCode();
                break;
            case "WARNING":
                logger.log(Level.WARNING, message);
                messageCode =  MessageType.WARNING.getCode();
                break;
            case "ERROR":
                logger.log(Level.SEVERE, message);
                messageCode =  MessageType.ERROR.getCode();
                break;
        }
        String errorMessage = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
        this.manager.insertMessageBD(errorMessage, messageCode);
    }
}