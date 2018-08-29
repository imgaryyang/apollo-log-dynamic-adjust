package com.weimob.apollolog4j.bean;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    for (String key : changeEvent.changedKeys()) {
      if (key.startsWith(KEY_PREFIX)) {
        try {
          Level level = Level.toLevel(changeEvent.getChange(key).getNewValue());
          Logger logger = LogManager.getLogger(key.replace(KEY_PREFIX, ""));
          logger.setLevel(level);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

}
