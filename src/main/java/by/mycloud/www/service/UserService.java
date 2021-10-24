package by.mycloud.www.service;

import javax.validation.Valid;

import by.mycloud.www.entity.User;

public interface UserService {

	public void register(@Valid User user, String password2);

}
