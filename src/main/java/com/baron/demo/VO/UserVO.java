package com.baron.demo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/***
 @package com.baron.demo
 @author Baron
 @create 2020-09-04-3:07 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String name;
    private String email;
    private Integer managerId;
}
