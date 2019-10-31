package com.nihui.shiro.charp02;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @Classname AuthenticatorTest
 * @Description TODO
 * @Date 2019/10/29 9:57 AM
 * @Created by nihui
 */
public class AuthenticatorTest {
    public static void main(String[] args) {
        //测试成功
        testAllSuccessFulStrategyWithSuccess();
    }

    //测试成功
    public static void testAllSuccessFulStrategyWithSuccess(){
        login("classpath:shiro-authenticator-all-success.ini");
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        System.out.println(principalCollection.asList().size());
    }




    private static void login(String configFile){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("test","123");
        subject.login(token);
    }
}
