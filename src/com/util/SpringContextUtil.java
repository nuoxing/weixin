package com.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * ���ڻ�ȡspring������bean���� ��������ϸ������
 * 
 * @author suwy
 * @version 2017��10��30��
 * @see SpringContextUtil
 * @since
 */
@Component
public class SpringContextUtil implements ApplicationContextAware
{

    private static ApplicationContext applicationContext; // SpringӦ�������Ļ���

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
     * ��ȡ����
     * 
     * @param name
     * @return Object һ������������ע���bean��ʵ��
     * @throws org.springframework.beans.BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name)
        throws BeansException
    {
        return (T)applicationContext.getBean(name);
    }

    /**
     * ��ȡ����ΪrequiredType�Ķ���
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
     * ���BeanFactory����һ������������ƥ���bean���壬�򷵻�true
     * 
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name)
    {
        return applicationContext.containsBean(name);
    }

}
