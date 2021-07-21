package cu.com.yleon.technicaltest.facade;

import cu.com.yleon.technicaltest.exception.EmptyMessageException;

import java.util.logging.Logger;

public interface LoggerFacade {
	
	Logger logger = Logger.getLogger("LoggerFacade");
	
	void addMessage(String message, String type) throws EmptyMessageException;

}
