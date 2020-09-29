package com.baron.demo.service.impl;

import com.baron.demo.exception.UserException;
import com.baron.demo.VO.UserVO;
import com.baron.demo.dao.UserRepository;
import com.baron.demo.dataObject.PublicUsers;
import com.baron.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/***
 @package com.baron.demo.service.impl
 @author Baron
 @create 2020-09-04-3:19 PM
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserVO> getUsers() throws UserException {
        List<PublicUsers> users = userRepository.findAll();
        List<UserVO> userVOs = new ArrayList<>();
        users.forEach(i -> userVOs.add(new UserVO(i.getName(), i.getEmail(), i.getManagerId())));
        return userVOs;
    }

    @Override
    public PublicUsers createUser(UserVO userVO) throws UserException {
        PublicUsers publicUsers = new PublicUsers();
        BeanUtils.copyProperties(userVO, publicUsers);
        publicUsers.setCreatedAt(new Timestamp(System.currentTimeMillis()).toString());
        publicUsers.setUpdatedAt(publicUsers.getCreatedAt());
        log.info("createUser succeed");
        return userRepository.save(publicUsers);
    }

    @Override
    public UserVO getUser(Integer id) throws UserException {
        UserVO userVO = new UserVO();
        Optional<PublicUsers> userInfoOption = userRepository.findById(id);
        if (userInfoOption.isPresent()){
            BeanUtils.copyProperties(userInfoOption.get(), userVO);
            log.info("getUser succeed");
            return userVO;
        }else {
            throw new UserException("UserServiceImpl, getUser : User "+id+" is not existed!");
        }
    }

    @Override
    public PublicUsers updateUser(PublicUsers publicUsers) throws UserException {
        Optional<PublicUsers> userInfoOption = userRepository.findById(publicUsers.getId());
        if (userInfoOption.isPresent()){
            PublicUsers newUser = userInfoOption.get();
            BeanUtils.copyProperties(publicUsers, newUser);
            newUser.setUpdatedAt(new Timestamp(System.currentTimeMillis()).toString());
            log.info("updateUser succeed");
            return userRepository.save(newUser);
        }else {
            throw new UserException("UserServiceImpl, updateUser : User "+ publicUsers.getId()+" is not existed!");
        }
    }

    @Override
    public void deleteUser(Integer id) throws UserException {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            log.info("deleteUser succeed");
        }else {
            throw new UserException("UserServiceImpl, deleteUser : User "+id+" is not existed!");
        }

    }
}
