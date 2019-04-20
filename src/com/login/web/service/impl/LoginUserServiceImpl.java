package com.login.web.service.impl;

import java.util.List;

import com.login.web.dao.LoginUserDAO;
import com.login.web.dao.impl.LoginUserDAOImpl;
import com.login.web.service.LoginUserService;
import com.login.web.vo.LoginUserVO;

public class LoginUserServiceImpl implements LoginUserService {
	private LoginUserDAO ludao = new LoginUserDAOImpl();
	@Override
	public List<LoginUserVO> selectLoginUserList(LoginUserVO lu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginUserVO loginUser(LoginUserVO lu) {
		return  ludao.selectLoginUser(lu);
	}

	@Override
	public int insertLoginUser(LoginUserVO lu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLoginUser(LoginUserVO lu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLoginUser(int luNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
