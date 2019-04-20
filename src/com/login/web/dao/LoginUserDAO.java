package com.login.web.dao;

import java.util.List;

import com.login.web.vo.LoginUserVO;

public interface LoginUserDAO {
   public List<LoginUserVO> selectLoginUserList(LoginUserVO lu);
   public LoginUserVO selectLoginUser(LoginUserVO lu);
   public int insertLoginUser(LoginUserVO lu);
   public int updateLoginUser(LoginUserVO lu);
   public int deleteLoginUser(int luNum);
   
}