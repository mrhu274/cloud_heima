package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: hhp
 * Date: 2022/6/1
 * Time: 22:49
 * Description: No Description
 * @author hhp
 */
@Data
@Component
@ConfigurationProperties(prefix ="pattern" )
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;


}
