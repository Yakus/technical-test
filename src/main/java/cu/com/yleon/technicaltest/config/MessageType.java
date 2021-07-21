package cu.com.yleon.technicaltest.config;

public enum MessageType {

    MESSAGE("message", "INFO"),
    WARNING("warning", "WARNING"),
    ERROR("error", "ERROR");

    private String name;
    private String code;

    MessageType(final String name, final String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
