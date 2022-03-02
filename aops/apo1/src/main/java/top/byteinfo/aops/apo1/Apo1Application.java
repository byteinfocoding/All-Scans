package top.byteinfo.aops.apo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Apo1Application {

    /**
     *
     * 后台日志需要打印整个对象来看一下所有的属性，
     * 大多数人会利用IDE去实现toString方法来打印，
     * 所有的JavaBean都要覆盖toString实现，如果觉得麻烦，
     * 可以利用反射技术遍历JavaBean的所有参数名称及值即可。
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Apo1Application.class, args);
    }

}
