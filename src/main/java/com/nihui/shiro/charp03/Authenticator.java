package com.nihui.shiro.charp03;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @Classname AuthenticatorTest
 * @Description TODO
 * @Date 2019/10/29 9:57 AM
 * @Created by nihui
 */
public class Authenticator {
    public static void main(String[] args) {
        //测试成功
        login("classpath:shiro-permission.ini");
    }
    private static void login(String configFile){
        //获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        //获取SecurityManager实例
        SecurityManager securityManager = factory.getInstance();
        //绑定SecurityManager
        SecurityUtils.setSecurityManager(securityManager);
        //设置主体
        Subject subject = SecurityUtils.getSubject();
        //设置验证登陆token
        UsernamePasswordToken token = new UsernamePasswordToken("test","123");
        //登陆
        subject.login(token);
        System.out.println(subject.isAuthenticated());
        System.out.println("test 是否拥有 role1 "+subject.hasRole("role1"));
        System.out.println("test 是否拥有 role2 "+subject.hasRole("role2"));
        System.out.println("test 是否拥有删除权限"+subject.isPermitted("user:delete"));
        System.out.println("test 是否拥有更新权限"+subject.isPermitted("user:update"));
        subject.logout();
    }
}
