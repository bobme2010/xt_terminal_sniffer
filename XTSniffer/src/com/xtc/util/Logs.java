package com.xtc.util;

import com.framework.util.BaseLog;

/**
 * 日志类
 * @author 9995857
 * @version 2.0
 */
public class Logs {
	
	public static void info(String str)
	{	
		BaseLog.isVerboseModel = false;
		BaseLog.info(str);
	}
	
	public static void debug(String str)
	{
		BaseLog.isVerboseModel = false;
			BaseLog.info(str);
	}
}
