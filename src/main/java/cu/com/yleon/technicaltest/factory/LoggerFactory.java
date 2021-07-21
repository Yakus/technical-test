package cu.com.yleon.technicaltest.factory;

import cu.com.yleon.technicaltest.config.LoggerType;
import cu.com.yleon.technicaltest.exception.LoggerTypeException;
import cu.com.yleon.technicaltest.facade.LoggerFacade;
import cu.com.yleon.technicaltest.facade.impl.LoggerConsole;
import cu.com.yleon.technicaltest.facade.impl.LoggerDatabase;
import cu.com.yleon.technicaltest.facade.impl.LoggerFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class LoggerFactory {
	@Autowired
    private static Environment env;


    private LoggerFactory(Environment env) {
        super();
    }

    public static LoggerFacade getLogger(String type) {
        if (LoggerType.FILE.getType().equals(type)) {
            return new LoggerFile();
        } else if (LoggerType.CONSOLE.getType().equals(type)) {
            return new LoggerConsole();
        } else if (LoggerType.DATABASE.getType().equals(type)) {
            return new LoggerDatabase(env);
        } else {
            throw new LoggerTypeException("Invalid configuration | Logger type not valid!");
        }
    }
}
