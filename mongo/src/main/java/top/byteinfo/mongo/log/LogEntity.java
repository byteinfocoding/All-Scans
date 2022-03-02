package top.byteinfo.mongo.log;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("rc_log")
@Data
@Builder
public class LogEntity {
    private Integer userId;
    private Integer userType;
    private String requestUrl;
    private String businessTarget;
    private String message;
    private Object exception;
    private Integer resultCode;
    private Long executeTime;
    private Date datetime = new Date();

}
