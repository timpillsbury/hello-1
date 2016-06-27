package net.kimleo.inject.context;

import net.kimleo.inject.annotation.Qualified;

import java.lang.reflect.InvocationTargetException;

public interface Context {
    void addComponents(Class[] classes) throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException;

    boolean isComponentClass(Class clz);

    <T> T getInstance(Class<? extends T> aClass);

    Class getRealComponent(Class param);

    boolean isContextComponent(Class param);

    void addComponent(Class component) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    <T> void addQualifiedInstance(Class<? extends T> clz, String qualifier, T instance);

    Object getQualifiedInstance(Class<?> finalType, String qualified);
}