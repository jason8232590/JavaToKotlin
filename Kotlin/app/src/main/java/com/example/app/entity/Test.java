package com.example.app.entity;

public class Test {

    public static void main(String[] args){

//        BaseApplication.Companion.getCurrentApplication()
        //加了@jvmstatic
//        BaseApplication.getCurrentApplication();
        //然后kotlin文件中就变成B
        // aseApplication.Companion.getCurrentApplication() -》BaseApplication.CurrentApplication()

        //需要加@JvmStatic 只加@get:JVM("currentAppplication")，两者需配合使用
//        BaseApplication.currentApplication()




        //utils没加@file:JVMName("kotlinUtils")
//        UtilsKt.dp2px(6);
        //加了JVMName("kotlinUtils")
//        kotlinUtils.dp2px(6);


        //如果是object
//        CacheUtils.INSTANCE
    }
}
