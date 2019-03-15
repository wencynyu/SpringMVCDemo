package com.yuwenxin.repository;

import com.yuwenxin.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**在JpaRepository中，定义了几个简化的操作数据库的方法：

 （1） findAll()：查找表中所有记录；

 （2）findOne(Integer id)：按id来查找某一条记录；

 （3）findByXXX(Object xxx)：在这里XXX是一个字段名，根据该字段的值开查找所有记录；

 （4）save()和delete()：添加一条记录以及删除一条记录。*/
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Modifying
    @Transactional
    // 定义查询
    // @Param注解用于提取参数
    @Query("update UserEntity us set us.nickname=:qNickname, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
    public void updateUser(@Param("qNickname") String nickname, @Param("qFirstName") String firstName,
                           @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);
}
