package cu.com.yleon.technicaltest.config;

public enum LoggerType {

    CONSOLE("console"),
    DATABASE("database"),
    FILE("file");

    private String type;

    LoggerType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
