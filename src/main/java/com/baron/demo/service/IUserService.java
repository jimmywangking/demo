package com.baron.demo.service;

import com.baron.demo.exception.UserException;
import com.baron.demo.VO.UserVO;
import com.baron.demo.dataObject.PublicUsers;

import java.util.List;

/***
 @package com.baron.demo
 @author Baron
 @create 2020-09-04-3:05 PM
 */
public interface IUserService {

//### GET /api/v1/users
//            返回所有用户
    List<UserVO> getUsers() throws UserException;
//### POST /api/v1/users
//            创建新用户
    PublicUsers createUser(UserVO userVO) throws UserException;
//### GET /api/v1/users/{id}
//    读取指定用户信息
    UserVO getUser(Integer id) throws UserException;
//### PUT /api/v1/users/{id}
//    更新指定用户信息
    PublicUsers updateUser(PublicUsers publicUsers) throws UserException;
//### DELETE /api/vi/users/{id}
//    删除指定用户
    void deleteUser(Integer id) throws UserException;
}
