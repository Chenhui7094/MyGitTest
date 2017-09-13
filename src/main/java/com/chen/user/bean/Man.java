/**
 * 文件名：Man.java<br>
 * 创建时间：2017年9月1日 上午11:11:22<br>
 * 创建者：zhanglei<br>
 * 修改者：暂无<br>
 * 修改简述：暂无<br>
 * 修改详述：
 * <p>
 * 暂无<br>
 * </p>
 * 修改时间：暂无<br>
 */
package com.chen.user.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * TODO 一句话描述类的主要作用<br>
 * <p>
 * TODO 该类的详细描述<br>
 * </p>
 * Time：2017年9月1日 上午11:11:22<br>
 * 
 * @author zhanglei
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class Man implements Serializable {
	private static final long serialVersionUID = 3970098403729465544L;
	private List<Goddess> goddessList;
	private Goddess goddess;
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
