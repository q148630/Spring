package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * 該類別是一個配置類，它的作用和 bean.xml 是一樣的
 * spring 中的新註解
 * @Configuration:
 *      作用: 指定當前的類別是一個配置類
 *      細節: 當配置類作為 AnnotationConfigApplicationContext 物件建立的參數時，該註解可以不寫
 * @ComponentScan:
 *      作用: 用於透過註解指定 spring 在建立容器時要掃描的 package
 *      屬性:
 *          value: 它和 basePackages 的作用是一樣的，都是用於指定建立容器時要掃描的 package
 *                  我們使用此註解就等同於在 xml 配置了:
 *                      <context:component-scan base-package="org.example"></context:component-scan>
 * @Bean:
 *      作用: 用於把當前方法的返回值作為 bean 物件存入 spring 的 ioc 容器中
 *      屬性:
 *          name: 用於指定 bean 的 id，當不寫時，默認值是當前方法的名稱
 *      細節:
 *          當我們使用註解配置方法時，如果方法有參數，spring 框架會去容器中查找有沒有可用的 bean 物件，
 *          查找的方式和 @Autowired 註解的作用是一樣的
 * @Import:
 *      作用: 用於導入其他的配置類
 *      屬性:
 *          value: 用於指定其他配置類的字節碼
 *                  當我們使用 @Import 的註解後，有 @Import 註解的類就是父配置類，而導入的都是子配置類
 * @PropertySource:
 *      作用: 用於指定 properties 文件的位置
 *      屬性:
 *          value: 指定文件的名稱和路徑
 *                  關鍵字: classpath，表示類路徑下
 */
//@Configuration
@ComponentScan({"org.example", "config"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
