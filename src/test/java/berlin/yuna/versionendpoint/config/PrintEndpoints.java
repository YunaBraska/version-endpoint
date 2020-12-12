package berlin.yuna.versionendpoint.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class PrintEndpoints implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods()
                .forEach((requestMappingInfo, handlerMethod) -> {
                    if (!requestMappingInfo.getMethodsCondition().isEmpty()) {
                        System.out.println("Endpoint: " + requestMappingInfo.getMethodsCondition().toString() + " " + requestMappingInfo.getPatternValues().toString());
                    }
                });
    }
}
