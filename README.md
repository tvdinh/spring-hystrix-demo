# spring-hystrix-demo
Spring hystric demo

## Reproduce

```
mvn clean install
```

Error trace:

```java
....
2019-05-07 21:21:03.832  WARN 10421 --- [           main] o.s.w.c.s.GenericWebApplicationContext   : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'hystrixCommandAspect' defined in class path resource [org/springframework/cloud/netflix/hystrix/HystrixCircuitBreakerConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect]: Factory method 'hystrixCommandAspect' threw exception; nested exception is java.lang.NoClassDefFoundError: org/aspectj/lang/JoinPoint
2019-05-07 21:21:03.837  INFO 10421 --- [           main] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2019-05-07 21:21:03.842 ERROR 10421 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'hystrixCommandAspect' defined in class path resource [org/springframework/cloud/netflix/hystrix/HystrixCircuitBreakerConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect]: Factory method 'hystrixCommandAspect' threw exception; nested exception is java.lang.NoClassDefFoundError: org/aspectj/lang/JoinPoint
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:627) ~[spring-beans-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:456) ~[spring-beans-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1321) ~[spring-beans-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1160) ~[spring-beans-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:555) ~[spring-beans-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFact
...

```

To make it work, simply uncomment the below in pom.xml

```
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>1.9.3</version>
		</dependency>
```


