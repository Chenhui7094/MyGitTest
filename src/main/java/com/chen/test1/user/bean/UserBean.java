package com.chen.test1.user.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserBean implements Serializable {
	private static final long serialVersionUID = 5228531348759661602L;
	private Long id;
	private String name;
	private String username;
	private String password;
	private String sex;
	private String comment;
	private String createTime;
	private String updatetime;
	private Integer status;
}
