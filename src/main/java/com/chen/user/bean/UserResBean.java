/**
 * 文件名：UserResBean.java<br>
 * 创建时间：2017年9月1日 上午10:42:38<br>
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
import java.util.Map;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * TODO 一句话描述类的主要作用<br>
 * <p>
 * TODO 该类的详细描述<br>
 * </p>
 * Time：2017年9月1日 上午10:42:38<br>
 * 
 * @author zhanglei
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@Accessors(chain=true)
public class UserResBean implements Serializable {

	private static final long serialVersionUID = 5855698671762073879L;

	private int code;
	private String message;
	private List<UserBean> users;
	private List<Man> mans;
	private List<Map<String, String>> dics;

}
