package com.nihui.shiro.loginandlogout;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


/**
 * @Classname LoginLogoutTest
 * @Description TODO
 * @Date 2019/10/28 10:59 AM
 * @Created by nihui
 */
public class LoginLogoutTest {
    public static void main(String[] args) {
        //1、获取SecurityManager工厂，
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到一个SecurityManager实例，绑定到SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //得到Subject 以及用户名密码的身份验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("nihui","123");
        // 验证登陆

        try {
            subject.login(token);
        }catch (AuthenticationException e){
            //身份认证失败
        }
        System.out.println(subject.isAuthenticated()); //true表示用户已经登陆

        //退出操作
        subject.logout();

    }
}
