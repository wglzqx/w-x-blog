package com.wxblog.core.config.shiro;

import com.wxblog.core.bean.User;
import com.wxblog.core.dao.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: NightWish
 * @create: 2018-09-26 16:34
 * @description:
 **/
public class BlogRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authenticationInfo=new SimpleAuthorizationInfo();
        String name=principalCollection.getPrimaryPrincipal().toString();
        //只有管理员角色
        User user=userMapper.checkUserIsExists(name);
        if (user != null){
            authenticationInfo.addRole("admin");
        }
        return authenticationInfo;
    }

    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String loginName=token.getPrincipal().toString();
        User user=userMapper.checkUserIsExists(loginName);
        if (user != null){
            return new SimpleAuthenticationInfo(loginName,token.getPassword(),getName());
        }else{
            throw new UnknownAccountException();
        }
    }
}
