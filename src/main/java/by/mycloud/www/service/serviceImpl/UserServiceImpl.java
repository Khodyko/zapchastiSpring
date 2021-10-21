package by.mycloud.www.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.mycloud.www.dao.UserDao;
import by.mycloud.www.entity.User;
import by.mycloud.www.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private PasswordEncoder bcryptBean;

	@Override
	@Transactional
	public void register(User user) {
		user.setPassword(bcryptBean.encode(user.getPassword()));
		userDao.register(user);
	}

}
