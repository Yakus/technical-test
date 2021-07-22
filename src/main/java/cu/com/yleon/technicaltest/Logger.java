package cu.com.yleon.technicaltest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Logger {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    private String code;
}
