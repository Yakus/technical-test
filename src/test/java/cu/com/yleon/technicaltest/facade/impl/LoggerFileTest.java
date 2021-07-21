package cu.com.yleon.technicaltest.facade.impl;

import cu.com.yleon.technicaltest.config.LoggerType;
import cu.com.yleon.technicaltest.config.MessageType;
import cu.com.yleon.technicaltest.exception.EmptyMessageException;
import cu.com.yleon.technicaltest.facade.LoggerFacade;
import cu.com.yleon.technicaltest.factory.LoggerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerFileTest {

    @Test
    void addMessageEmpty() {
        Exception exception = assertThrows(EmptyMessageException.class, () -> {
            LoggerFacade logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
            logger.addMessage("", MessageType.MESSAGE.getCode());
        });
        String expectedMessage = "Message must not be empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void addMessageInfo() throws EmptyMessageException {
        LoggerFacade logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
        logger.addMessage("Test File - Message Info!", MessageType.MESSAGE.getCode());
        assertEquals(true, logger instanceof LoggerFile);
    }

    @Test
    void addMessageWarning() throws EmptyMessageException {
        LoggerFacade logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
        logger.addMessage("Test Console - Message Warning!", MessageType.WARNING.getCode());
        assertEquals(true, logger instanceof LoggerFile);
    }

    @Test
    void addMessageWarningError() throws EmptyMessageException {
        LoggerFacade logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
        logger.addMessage("Test Console - Message Error!", MessageType.ERROR.getCode());
        assertEquals(true, logger instanceof LoggerFile);
    }
}