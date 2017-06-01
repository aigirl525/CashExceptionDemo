/**
 * Copyright (c) 2013 An Yaming,  All Rights Reserved
 */
package app.properties.custom.imooc.com.cashexceptiondemo;

import android.app.Application;

/**
 * @ClassName: MyApplication
 * @Description: TODO(全局)
 * @author tanghuan
 * @date 2014年12月3日 下午7:44:05
 * 
 */
public class MyApplication extends Application {

	@Override
	public void onCreate() {
			/*
			 * 捕获全局异常模块
			 */
			MyCrashHandler handler = MyCrashHandler.getInstance();
			handler.init(getApplicationContext());
			Thread.setDefaultUncaughtExceptionHandler(handler);
	}


}
