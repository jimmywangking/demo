package com.baron.demo.control;

import com.baron.demo.VO.UserVO;
import com.baron.demo.dataObject.PublicUsers;
import com.baron.demo.exception.UserException;
import com.baron.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 @package com.baron.demo
 @author Baron
 @create 2020-09-04-4:25 PM
 */

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserControl {

    @Autowired
    private IUserService userService;


//### GET /api/v1/users
//    返回所有用户

    @GetMapping("/users")
    public List<UserVO> getUsers(){
        log.info("start UserControl");
        try {
            return userService.getUsers();
        } catch (UserException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/test")
    public String test(){
        return "Hello world!";
    }

//### POST /api/v1/users
//    创建新用户
    @PostMapping("/users")
    public PublicUsers createUser(@RequestBody UserVO userVO){

        try {
            return userService.createUser(userVO);
        } catch (UserException e) {
            e.printStackTrace();
            return null;
        }
    }
//### GET /api/v1/users/{id}
//    读取指定用户信息
    @GetMapping("/users/{id}")
    public UserVO getUser(@PathVariable Integer id){
        try {
            return userService.getUser(id);
        } catch (UserException e) {
            e.printStackTrace();
            return null;
        }
    }
//### PUT /api/v1/users/{id}
//    更新指定用户信息
    @PutMapping("/users/{id}")
    public PublicUsers updateUser(@RequestBody PublicUsers user){
        try {
            return userService.updateUser(user);
        } catch (UserException e) {
            e.printStackTrace();
            return null;
        }
    }
//### DELETE /api/vi/users/{id}
//    删除指定用户
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        try {
            userService.deleteUser(id);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

}
