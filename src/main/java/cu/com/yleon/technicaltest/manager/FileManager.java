package cu.com.yleon.technicaltest.manager;

import cu.com.yleon.technicaltest.exception.HandlerNotFoundException;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;

public class FileManager implements Serializable {

    private static final long serialVersionUID = 1L;

    @Value("${file.logger.path:D:/test.txt}")
    private String path = "D:/test.txt";

    public FileManager() {
        super();
    }

    public File getLogFile() throws FileNotFoundException {
        File logFile = new File(path);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                throw new FileNotFoundException();
            }
        }
        return logFile;
    }

    public FileHandler getFileHandler() {
        try {
            getLogFile();
            return new FileHandler(path);
        } catch (SecurityException | IOException e) {
            throw new HandlerNotFoundException("Error get file handler.", e);
        }
    }
}
