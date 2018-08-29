package com.weimob.apollologback.bean;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author maxiaolong
 * @create 2018-08-28 15:31
 **/
@Configuration
@EnableApolloConfig
public class ConfigBean {

  private static final String KEY_PREFIX = "log.level.";

  public ConfigBean() {
  }

  @ApolloConfigChangeListener
  private void onChange(ConfigChangeEvent changeEvent) {
    LoggerContext loggerContext= (LoggerContext) LoggerFactory.getILoggerFactory();

    for (String key : changeEvent.changedKeys()) {
      if (key.startsWith(KEY_PREFIX)) {
        try {
          //设置全局日志级别
          ch.qos.logback.classic.Logger logger = loggerContext.getLogger(key.replace(KEY_PREFIX, ""));
          logger.setLevel(Level.toLevel(changeEvent.getChange(key).getNewValue()));
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

}
