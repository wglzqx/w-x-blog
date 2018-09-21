package com.wxblog.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxblog.core.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: NightWish
 * @create: 2018-09-21 14:48
 * @description:
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
