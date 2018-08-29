package com.weimob.apollolog4j;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author maxiaolong
 * @create 2018-08-28 15:02
 **/
@Slf4j
public class XmlLombokApplication {


  public static void main(String[] args) {
    new ClassPathXmlApplicationContext("spring.xml");
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    while (true) {
      log.debug("debug msg");
      log.info("info msg");
      log.warn("warn msg");
      log.error("error msg");
      try {
        Thread.sleep(1000 * 10);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

//    Configurator.setLevel("com.weimob.apollologtest.apollologtest", Level.toLevel("error"));
//    logger.debug("debug msg");
//    logger.info("info msg");
//    logger.warn("warn msg");
//    logger.error("error msg");
//        WccPropertyPlaceholderConfigurer wccConfigurer = (WccPropertyPlaceholderConfigurer)context.getBean("wccConfigurer");
//        String value = wccConfigurer.getPropertyByKey("redis.ip");
  }





}
