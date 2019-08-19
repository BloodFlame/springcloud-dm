package cn.dm.interceptor;
import cn.dm.common.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 *file: CustomWebMvcConfigurerAdapter.java
 * Created by jiaobuchong on 12/23/15.
 */
@Configuration   //标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Value("${moduleName}")
    private String moduleName;

    @Autowired
    private LogUtils logUtils;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ValidateInterceptor(moduleName,logUtils)).addPathPatterns("/api/**");
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public LogUtils getLogUtils() {
        return logUtils;
    }

    public void setLogUtils(LogUtils logUtils) {
        this.logUtils = logUtils;
    }
}