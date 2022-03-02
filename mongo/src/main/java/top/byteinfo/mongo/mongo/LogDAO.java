package top.byteinfo.mongo.mongo;

import org.springframework.stereotype.Repository;
import top.byteinfo.mongo.log.LogEntity;

@Repository
public class LogDAO {
    private final LogRepository repository;

    public LogDAO(LogRepository repository) {
        this.repository = repository;
    }

    public void insert(LogEntity entity) {
        repository.insert(entity);
    }
}
