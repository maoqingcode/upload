package com.mao.BeanWrapperTest;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;

public class BeanTest {
    public static void main(String[] args) {
        User user = new User();

        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(user);
        wrapper.setPropertyValue("username", "jack");
        System.out.println(user.getUsername());
        PropertyValue prop = new PropertyValue("msg", "hello");
        wrapper.setPropertyValue(prop);
        System.out.println(user.getMsg());
    }
}
