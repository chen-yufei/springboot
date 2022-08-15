package com.chenyuhui.springboot.config;

import ch.qos.logback.core.db.DBHelper;
import com.chenyuhui.springboot.bean.Car;
import com.chenyuhui.springboot.bean.Pet;
import com.chenyuhui.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 容器功能
 组件添加
 Configuration
 ● 基本使用
 ● Full模式与Lite模式
 ■ 配置 类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断
 ■ 配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式

 @Bean、@Component、@Controller、@Service、@Repository

 @Import({User.class, DBHelper.class})
 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名

 @Conditional
 条件装配：满足Conditional指定的条件，则进行组件注入

 原生配置文件引入
 @ImportResource

 配置绑定
 使用Java读取到properties文件中的内容，并且把它封装到JavaBean中，以供随时使用

 @EnableConfigurationProperties
 如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，
 那么在IOC容器中是获取不到properties 配置文件转化的bean。
 说白了 @EnableConfigurationProperties 相当于把使用 @ConfigurationProperties 的类进行了一次注入


 自动配置总结：
 ● SpringBoot先加载所有的自动配置类  xxxxxAutoConfiguration
 ● 每个自动配置类按照条件进行生效，默认都会绑定配置文件指定的值。xxxxProperties里面拿。xxxProperties和配置文件进行了绑定
 ● 生效的配置类就会给容器中装配很多组件
 ● 只要容器中有这些组件，相当于这些功能就有了
 ● 定制化配置
 ○ 用户直接自己@Bean替换底层的组件
 ○ 用户去看这个组件是获取的配置文件什么值就去修改。
 xxxxxAutoConfiguration ---> 组件  ---> xxxxProperties里面拿值  ----> application.properties


**/



/*
1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
2、配置类本身也是组件
3、proxyBeanMethods：代理bean的方法
    Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
    Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
    组件依赖必须使用Full模式默认。其他默认是否Lite模式
*/

@Import({DBHelper.class})
@Configuration(proxyBeanMethods = false)    //告诉SpringBoot这是一个配置类 == 配置文件
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties({Car.class})
//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
public class MyConfig {

    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //user组件依赖了Pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }




}
