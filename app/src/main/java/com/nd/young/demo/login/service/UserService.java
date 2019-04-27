package com.nd.young.demo.login.service;

import com.nd.young.demo.login.model.UserInfo;

public class UserService {

    /**
     * 登陆操作，判断用户名密码是否正确
     * @param username 用户名
     * @param password 密码
     * @return 返回登陆结果
     */
    public boolean login(String username, String password) {
        UserInfo userInfo = getUserInfo(); // 此处调用一个getUserInfo方法，由于是个简单作业，数据是直接在该类生成
        // 在现实场景中，一般是会调用服务端接口，从远端进行拉取或者从数据库读取
        // Model的意义在于Login的这部分逻辑可复用了，
        // 未来在其他地方也有可能调用该Login方法进行登陆操作
        return username.equals(userInfo.username) && password.equals(userInfo.password);
    }

    private UserInfo getUserInfo() {
        return new UserInfo("1", "password1");
    }

}
