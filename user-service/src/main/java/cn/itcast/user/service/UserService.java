package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户id查询用户
     *
     * @param id
     * @return
     */
    public User queryById(Long id) {

        return userMapper.findById(id);
    }



}