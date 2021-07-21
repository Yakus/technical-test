package cu.com.yleon.technicaltest.facade.impl;

import cu.com.yleon.technicaltest.exception.EmptyMessageException;
import cu.com.yleon.technicaltest.facade.LoggerFacade;
import cu.com.yleon.technicaltest.manager.FileManager;

import java.util.logging.Level;

public class LoggerFile implements LoggerFacade {

    private FileManager manager;

    public LoggerFile() {
        this.manager = new FileManager();
        logger.addHandler(this.manager.getFileHandler());
    }

    public void addMessage(String message, String type) throws EmptyMessageException {
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
