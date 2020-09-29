package com.baron.demo.dao;

import com.baron.demo.dataObject.PublicUsers;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 @package com.baron.demo
 @author Baron
 @create 2020-09-04-3:02 PM
 */
public interface UserRepository extends JpaRepository<PublicUsers, Integer> {

}
