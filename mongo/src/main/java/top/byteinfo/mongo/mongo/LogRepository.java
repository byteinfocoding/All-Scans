package top.byteinfo.mongo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.byteinfo.mongo.log.LogEntity;

@Repository
public interface LogRepository extends MongoRepository<LogEntity, Long> {
}
