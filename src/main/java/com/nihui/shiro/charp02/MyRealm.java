package com.nihui.shiro.charp02;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @Classname MyRealm
 * @Description TODO
 * @Date 2019/10/28 2:02 PM
 * @Created by nihui
 */
public class MyRealm implements Realm {

    public String getName() {
        return "myrealm";
    }
    public boolean supports(AuthenticationToken token) {
        //仅仅支持一个UsernamePaasswordToke
        return token instanceof UsernamePasswordToken;
    }
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取到用户名和密码
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if (!"nihui".equals(username)){
            //用户名错误
            throw new UnknownAccountException();
        }
        if (!"123".equals(password)){
            //密码错误
            throw new IncorrectCredentialsException();
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
