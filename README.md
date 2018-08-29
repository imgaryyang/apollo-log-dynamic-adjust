# apollo-log-dynamic-adjust

## 简介
- apollo 动态调整调整日志级别，支持spring + logback, spring + log4j2, spring + log4j
- spring boot的实现官方已经有实例，具体可参考： [例子](https://github.com/ctripcorp/apollo-use-cases)

## 接入方要求
- apollo client版本 0.9.2+
- 代码中log声明要求
   - `Logger logger = LoggerFactory.getLogger(XXX.class);`
   - `@Slf4j` lombok的声明方式
   
## 主要实现逻辑
   - 在apollo portal上配置key，key分为两部分，用.分隔，前半部分是固定的，log.level主要是为了区分与其他配置项冲突，后半部分是项目中要改变日志级别具体的包路径（要全路径）， value就是具体的日志级别，不区分大小写
   - apollo client监听配置改变，改变时解析出具体的包路径，对具体的包设置日志级别
