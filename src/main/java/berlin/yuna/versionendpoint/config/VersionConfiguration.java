package berlin.yuna.versionendpoint.config;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureOrder
@ComponentScan(basePackageClasses = VersionConfiguration.class)
@ConditionalOnWebApplication
public class VersionConfiguration {

}
