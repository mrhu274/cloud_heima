package ct.itcast.feigh.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: hhp
 * Date: 2022/6/3
 * Time: 14:11
 * Description: No Description
 * @author hhp
 */

public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        // 日志级别为BASIC
        return Logger.Level.BASIC;
    }
}
