package com.chen.test1.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.jdbc.SQL;

import com.chen.test1.bean.OperateLog;

/**
 * @ClassName: OperLogDao.java 
 * @Description:操作日志数据库操作
 * @author chenhuihui
 * @time 2017年9月13日下午2:30:20
 */
public interface OperLogDao {

	@InsertProvider(type = OperLogSqlProvider.class, method = "insertOperLog")
	int insertOperLog(OperateLog operLog);

	static class OperLogSqlProvider {
		public String insertOperLog(OperateLog operLog) {
			return new SQL() {
				{
					INSERT_INTO("operate_log");
					VALUES("account_id", "#{accountId}");
					VALUES("ip", "#{ip}");
					VALUES("content", "#{content}");
					VALUES("otime", "#{otime}");
					VALUES("memo", "#{memo}");
				}
			}.toString();
		}
	}
}
