package com.login.web.vo;

public class LoginUserVO {
   private Integer  luNum;
   private String luName;
   private String luId;
   private String luPwd;
   @Override
   public String toString() {
      return "LoginUserVO [luNum=" + luNum + ", luName=" + luName + ", luId=" + luId + ", luPwd=" + luPwd + "]";
   }
   public Integer getLuNum() {
      return luNum;
   }
   public void setLuNum(Integer luNum) {
      this.luNum = luNum;
   }
   public String getLuName() {
      return luName;
   }
   public void setLuName(String luName) {
      this.luName = luName;
   }
   public String getLuId() {
      return luId;
   }
   public void setLuId(String luId) {
      this.luId = luId;
   }
   public String getLuPwd() {
      return luPwd;
   }
   public void setLuPwd(String luPwd) {
      this.luPwd = luPwd;
   }
}