package com.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 用于获取spring容器的bean对象 〈功能详细描述〉
 * 
 * @author suwy
 * @version 2017年10月30日
 * @see SpringContextUtil
 * @since
 */
@Component
public class SpringContextUtil implements ApplicationContextAware
{

    private static ApplicationContext applicationContext; // Spring应用上下文环境

    private static void setApplicationContextValue(ApplicationContext applicationContext)
    {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException
    {
        // SpringContextUtil.applicationContext = applicationContext;
        setApplicationContextValue(applicationContext);

    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    /**
     * 获取对象
     * 
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws org.springframework.beans.BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name)
        throws BeansException
    {
        return (T)applicationContext.getBean(name);
    }

    /**
     * 获取类型为requiredType的对象
     * 
     * @param clz
     * @return
     * @throws org.springframework.beans.BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clz)
        throws BeansException
    {
        T result = (T)applicationContext.getBean(clz);
        return result;
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     * 
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name)
    {
        return applicationContext.containsBean(name);
    }

}
