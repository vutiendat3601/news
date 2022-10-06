package com.dv.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {

    @SuppressWarnings("unchecked")
    public static <T> T toModel(HttpServletRequest req, Class<T> clazz) {
        T model = null;
        try {
            Constructor<T> constructor = clazz.getConstructor();
            model = constructor.newInstance();
            BeanUtils.populate(model, req.getParameterMap());
        } catch (NoSuchMethodException e) {
            System.err.println(e.getMessage());
        } catch (SecurityException e) {
            System.err.println(e.getMessage());
        } catch (InstantiationException e) {
            System.err.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (InvocationTargetException e) {
            System.err.println(e.getMessage());
        }
        return model;
    }
}
