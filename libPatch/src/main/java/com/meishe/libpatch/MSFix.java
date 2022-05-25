package com.meishe.libpatch;

import android.app.Application;
import android.content.Context;

import java.io.File;
import java.lang.reflect.Field;

public class MSFix {


    public static void install(Application application, File filePatch) {
        //PathClassLoader
        ClassLoader classLoader = application.getClassLoader();
        //反射获取ClassLoader父类
        ClassLoader parent = classLoader.getParent();
        Class<? extends ClassLoader> baseDexClassLoaderClazz = parent.getClass();
        try {
            Field pathListField=baseDexClassLoaderClazz.getDeclaredField("pathList");
            pathListField.setAccessible(true);
            //这个是DexPathList 对象
            Object pathListObject = pathListField.get(parent);

            Class dexPathList=Class.forName("dalvik.system.DexPathList");
            Field dexElements = dexPathList.getDeclaredField("dexElements");
            dexElements.setAccessible(true);
            //旧的dexElements对象
            Object[] dexElementsOld = (Object[]) dexElements.get(pathListObject);





        } catch (Exception e) {
            e.printStackTrace();
        }


    }


//    private static File initHack(Context context) {
//
//    }
}
