/**
 * 文件名：UserService.java<br>
 * 创建时间：2017年9月1日 上午8:49:38<br>
 * 创建者：zhanglei<br>
 * 修改者：暂无<br>
 * 修改简述：暂无<br>
 * 修改详述：
 * <p>
 * 暂无<br>
 * </p>
 * 修改时间：暂无<br>
 */
package com.chen.test1.user.service.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chen.test1.user.bean.Man;
import com.chen.test1.user.bean.UserBean;
import com.chen.test1.user.dao.UserDao;
import com.chen.test1.user.service.UserService;
import com.github.pagehelper.PageHelper;

/**
 * TODO 一句话描述类的主要作用<br>
 * <p>
 * TODO 该类的详细描述<br>
 * </p>
 * Time：2017年9月1日 上午8:49:38<br>
 * 
 * @author zhanglei
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public int insertUser(UserBean user) {
		return userDao.insertUser(user);
	}

	@Override
	public int deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}

	@Override
	public int updateUser(UserBean user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<UserBean> selectUserList() {
		PageHelper.startPage(2, 2);
		return userDao.selectUserList();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.chen.test1.user.service.UserService#selectManList()
	 */
	@Override
	public List<Man> selectManList() {
		return userDao.selectManList();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.chen.test1.user.service.UserService#selectDicList()
	 */
	@Override
	public List<Map<String, String>> selectDicList() {
		return userDao.selectDicList();
	}

	public void insertBatchUser(List<UserBean> list) {
		UserDao mapper = sqlSessionTemplate.getMapper(UserDao.class);
		list.forEach(user -> {
			mapper.insertUser(user);
		});
	}
}
