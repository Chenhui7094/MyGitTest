/**
 * 文件名：UserService.java<br>
 * 创建时间：2017年9月1日 上午8:50:01<br>
 * 创建者：zhanglei<br>
 * 修改者：暂无<br>
 * 修改简述：暂无<br>
 * 修改详述：
 * <p>
 * 暂无<br>
 * </p>
 * 修改时间：暂无<br>
 */
package com.chen.user.service;

import java.util.List;
import java.util.Map;

import com.chen.user.bean.Man;
import com.chen.user.bean.UserBean;

/**
 * TODO 一句话描述类的主要作用<br>
 * <p>
 * TODO 该类的详细描述<br>
 * </p>
 * Time：2017年9月1日 上午8:50:01<br>
 * 
 * @author zhanglei
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UserService {

	public int insertUser(UserBean user);

	public void insertBatchUser(List<UserBean> user);

	public int deleteUserById(int id);

	public int updateUser(UserBean user);

	public List<UserBean> selectUserList();

	/**
	 * @return
	 */
	public List<Man> selectManList();

	/**
	 * @return
	 */
	public List<Map<String, String>> selectDicList();

}
