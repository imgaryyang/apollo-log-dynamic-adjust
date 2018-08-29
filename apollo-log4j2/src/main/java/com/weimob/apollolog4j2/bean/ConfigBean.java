package com.weimob.apollolog4j2.bean;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
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
          Configurator.setLevel(key.replace(KEY_PREFIX, ""),
                  Level.toLevel(changeEvent.getChange(key).getNewValue()));
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

}
