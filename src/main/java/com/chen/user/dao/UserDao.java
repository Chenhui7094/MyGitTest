package com.chen.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.chen.user.bean.Goddess;
import com.chen.user.bean.Man;
import com.chen.user.bean.UserBean;

public interface UserDao {

	@Insert("INSERT INTO t_user (id, name, username, password, sex, comment,status) VALUES (#{id}, #{name}, #{username}, #{password}, #{sex}, #{comment},#{status})")
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = { "SELECT LAST_INSERT_ID()" })
	public int insertUser(UserBean user);

	@Delete("DELETE FROM  t_user WHERE id =#{id}")
	public int deleteUserById(int id);

	@Update("UPDATE t_user SET name = #{name}, username = #{username}, password = #{password}, sex = #{sex}, comment = #{comment},status = #{status} WHERE id = #{id}")
	public int updateUser(UserBean user);

	@Select("SELECT id, name, username, password, sex, comment, create_time createTime, update_time updateTime, status FROM  t_user")
	public List<UserBean> selectUserList();

	@Select("SELECT id, name, username, password, sex, comment, create_time, update_time, status FROM  t_man")
	@Results({
			@Result(property = "goddessList", column = "id", many = @Many(select = "com.birdsh.user.dao.UserDao.selectGoddessList")) })
	public List<Man> selectManList();

	@Select("SELECT id, name, comment, create_time, update_time, status FROM  t_goddess where id in (select goddess_id from t_man_goddess where man_id =#{manid})")
	public List<Goddess> selectGoddessList(Long manid);
	
	@Select("SELECT code, `value` from t_dic")
	public List<Map<String,String>> selectDicList();

}
