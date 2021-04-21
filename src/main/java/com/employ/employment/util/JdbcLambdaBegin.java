package com.employ.employment.util;

/**
 * 以lambda表达式开启事务的辅助类
 * @author kong
 *
 */
public interface JdbcLambdaBegin {

	/**
	 * 执行事务的方法
	 */
	public void run();


}
