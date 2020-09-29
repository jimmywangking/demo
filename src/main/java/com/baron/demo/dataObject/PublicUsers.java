package com.baron.demo.dataObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/***
 @package com.baron.demo
 @author Baron
 @create 2020-09-04-2:50 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "public_users")
public class PublicUsers {

    @Id
    @GeneratedValue
//    @Column(name = "id", nullable = false)
    private Integer id;

//    @Column(name = "email", nullable = true)
    private String email;
//    @Column(name = "name", nullable = true)
    private String name;
//    @Column(name = "manager_id", nullable = true)
    private Integer managerId;

//    @Column(name = "createdAt", table = "users")
    private String createdAt;
//    @Column(name = "updatedAt", table = "users")
    private String updatedAt;
}
