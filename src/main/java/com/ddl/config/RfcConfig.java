package com.ddl.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring boot 解决Tomcat 报 The valid characters are defined in RFC 7230 and RFC 3986 的问题
 *
 * @author wangwx
 */
@Configuration
public class RfcConfig {

    /**
     *  * 解决异常信息：
     *  *  java.lang.IllegalArgumentException:
     *  *      Invalid character found in the request target. The valid characters are defined in RFC 7230 and RFC 3986
     *  * @return
     *  
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("relaxedQueryChars", "|{}[]");
            }
        });
        return factory;
    }
}