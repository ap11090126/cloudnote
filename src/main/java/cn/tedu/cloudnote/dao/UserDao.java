package cn.tedu.cloudnote.dao;



import cn.tedu.cloudnote.entity.User;

public interface UserDao {
	public User findByName(String name);
	public void save(User user);
}
