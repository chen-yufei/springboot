package com.chenyuhui.springboot;


import ch.qos.logback.core.db.DBHelper;
import com.chenyuhui.springboot.bean.Car;
import com.chenyuhui.springboot.bean.Pet;
import com.chenyuhui.springboot.bean.User;
import com.chenyuhui.springboot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;



//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.chenyuhui.springboot")
public class MainApplication {


    public static void main(String[] args) {
        //返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //查看容器里面的组件
        /*String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }*/

        //查看容器里面的组件数量
        /*int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);*/

        //从容器中获取组件
        /*String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println("======"+beanNamesForType.length);


        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("======"+beanNamesForType1.length);*/


        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println("组件："+(tom01 == tom02));


        /*
        * 当@Configuration(proxyBeanMethods = false)时，获取的是正常的MyConfig对象
        *       com.chenyuhui.springboot.config.MyConfig@74e8cbc1
        * 当@Configuration(proxyBeanMethods = true)时，获取的是代理的MyConfig对象
        *       com.chenyuhui.springboot.config.MyConfig$$EnhancerBySpringCGLIB$$f5e9b886@3247fe96
        * */
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);


        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println("用户的宠物："+(user01.getPet() == tom));



        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("======");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        //测试@Import
        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);

        //测试@ConditionalOnBean
        boolean tomExits = run.containsBean("tom");
        System.out.println("容器中Tom组件："+tomExits);

        boolean user01Exits = run.containsBean("user01");
        System.out.println("容器中user01组件："+user01Exits);


        //测试@ImportResource("classpath:beans.xml")
        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha："+haha);
        System.out.println("hehe："+hehe);

        //测试@ConfigurationProperties
        Car car = run.getBean(Car.class);
        System.out.println(car);
    }
}
