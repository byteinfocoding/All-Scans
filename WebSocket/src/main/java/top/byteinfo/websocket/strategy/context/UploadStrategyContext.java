package top.byteinfo.websocket.strategy.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.byteinfo.websocket.strategy.UploadStrategy;

import java.util.Map;


/**
 * 上传策略上下文
 *
 * @author yezhiqiu
 * @date 2021/07/28
 */
@Service
public class UploadStrategyContext {
    /**
     * 上传模式
     */
    @Value("${upload.mode}")
    private String uploadMode;

    @Autowired
    private Map<String, UploadStrategy> uploadStrategyMap;

    /**
     * 上传文件
     *
     * @param file 文件
     * @param path 路径
     * @return {@link String} 文件地址
     */
    public String executeUploadStrategy(MultipartFile file, String path) {
//        return uploadStrategyMap.get(getStrategy(uploadMode)).uploadFile(file, path);
        return uploadStrategyMap.get("localUploadStrategyImpl").uploadFile(file, path);
    }


}
