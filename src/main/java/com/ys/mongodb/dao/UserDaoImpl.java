package com.ys.mongodb.dao;

import com.ys.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author HD
 * @date 2018/10/22 18:02
 *
 * SpringBoot-data-mongodb实现(对应测试包有单元测试类)
 */
@Component
public class UserDaoImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param user
     */
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        return  mongoTemplate.findOne(query, User.class);
    }

    /**
     * 更新对象
     *
     * @param user
     */
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,User.class);
    }

    /**
     * 删除对象
     *
     * @param id
     */
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }
}
