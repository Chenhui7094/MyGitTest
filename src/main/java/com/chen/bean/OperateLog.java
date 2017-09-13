package com.chen.bean;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @ClassName: OperateLog.java 
 * @Description:操作日志表
 * @author chenhuihui
 * @time 2017年9月13日下午2:20:47
 */
@Data
public class OperateLog {

	/**日志表实体类*/
	@ApiModelProperty(value = "主键ID")
	private Integer id;

	@ApiModelProperty(value = "账号ID")
	private Integer accountId;

	@ApiModelProperty(value = "地址IP")
	private String ip;

	@ApiModelProperty(value = "操作内容")
	private String content;

	@ApiModelProperty(value = "操作时间")
	private Date otime;

	@ApiModelProperty(value = "备注")
	private String memo;

}
