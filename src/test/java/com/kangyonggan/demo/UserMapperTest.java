package com.kangyonggan.demo;

import com.kangyonggan.demo.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

/**
 * @author kangyonggan
 * @since 2019-09-20
 */
public class UserMapperTest extends AbstractTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据账号查询
     */
    @Test
    public void testFindByAccount() {
        User user = new User();
        user.setAccount("admin");
        System.out.println(userMapper.selectOne(user));
    }

    /**
     * 根据主键查询
     */
    @Test
    public void testFindByUserId() {
        // 需要在User类中通过@Id指定主键，不然它不知道哪个字段是主键
        System.out.println(userMapper.selectByPrimaryKey(1L));
    }

    /**
     * 查询数量
     */
    @Test
    public void testFindCount() {
        User user = new User();
        user.setAccount("admin");
        System.out.println(userMapper.selectCount(user));
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        System.out.println(userMapper.selectAll());
    }

    /**
     * 查询所有并排序
     */
    @Test
    public void testFindOrder() {
        Example example = new Example(User.class);
        example.orderBy("createdTime").desc();
        System.out.println(userMapper.selectByExample(example));
    }

    /**
     * 查询所有like
     */
    @Test
    public void testFindByLikeAccount() {
        Example example = new Example(User.class);
        example.createCriteria().andLike("account", "%min%");

        System.out.println(userMapper.selectByExample(example));
    }

}
