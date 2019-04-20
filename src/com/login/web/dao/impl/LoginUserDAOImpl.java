package com.login.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.web.dao.LoginUserDAO;
import com.login.web.db.DBConnector;
import com.login.web.vo.LoginUserVO;

public class LoginUserDAOImpl implements LoginUserDAO {
   private static String selectListSql = "select * from login_user where 1=1";
   private static String selectSql = selectListSql + "and lu_id=? and lu_pwd=?";

   @Override
   public List<LoginUserVO> selectLoginUserList(LoginUserVO lu) {
      try (Connection con = DBConnector.getCon(); 
         PreparedStatement ps = con.prepareStatement(selectListSql);) {
    	  
         ResultSet rs = ps.executeQuery(); //Resultset = 컬럼데이터(메타), 로우데이터
         List<LoginUserVO> luList = new ArrayList<>();
         while(rs.next()) {
            LoginUserVO luv = new LoginUserVO();
            luv.setLuId(rs.getString("lu_id"));
            luv.setLuName(rs.getString("lu_name"));
            luv.setLuNum(rs.getInt("lu_num"));
            luv.setLuPwd(rs.getString("lu_pwd"));
            luList.add(luv);            
         }
         return luList;
      } catch (SQLException e) {

      } finally {
         DBConnector.close();
      }
      return null;
   }

   @Override
   public LoginUserVO selectLoginUser(LoginUserVO lu) {
      try(Connection con = DBConnector.getCon();
            PreparedStatement ps = con.prepareStatement(selectSql);){
    	  ps.setString(1, lu.getLuId());
    	  ps.setString(2, lu.getLuPwd());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	 LoginUserVO luv = new LoginUserVO();
                 luv.setLuId(rs.getString("lu_id"));
                 luv.setLuName(rs.getString("lu_name"));
                 luv.setLuNum(rs.getInt("lu_num"));
                 luv.setLuPwd(rs.getString("lu_pwd"));
                 return luv;
            }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;
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
   public static void main(String[] args) {
      LoginUserDAO ldao = new LoginUserDAOImpl();
      System.out.println(ldao.selectLoginUserList(null));
//      LoginUserVO lu = new LoginUserVO();
//      lu.setLuId("gold");
//      lu.setLuPwd("123");
//      System.out.println(ldao.selectLoginUser(lu));
      
   }

}