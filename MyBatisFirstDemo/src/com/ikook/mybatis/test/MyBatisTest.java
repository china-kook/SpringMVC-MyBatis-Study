package com.ikook.mybatis.test;

import com.ikook.mybatis.datasource.DataConnention;
import com.ikook.mybatis.mapper.CustomerMapper;
import com.ikook.mybatis.po.Batch;
import com.ikook.mybatis.po.BatchCustomer;
import com.ikook.mybatis.po.BatchDetail;
import com.ikook.mybatis.po.BatchItem;
import com.ikook.mybatis.po.Customer;
import com.ikook.mybatis.po.FinacialProduct;
import com.ikook.mybatis.po.User;
import com.ikook.mybatis.po.UserInstance;
import com.ikook.mybatis.po.UserQueryInfo;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class MyBatisTest {

    public DataConnention dataConnention = new DataConnention();

    @Test
    public void TestSelect() throws IOException {

        SqlSession sqlSession = dataConnention.getSqlSession();

        // sqlSession.selectOne 最终结果是映射文件中所匹配的 resultType 类型
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public void TestFuzzySearch() throws IOException {
        SqlSession sqlSession = dataConnention.getSqlSession();

        List<User> userList = sqlSession.selectList("test.findUserByUsername", "丽");

        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            System.out.println(u);
        }

        sqlSession.close();
    }

    @Test
    public void TestInsert() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        User user = new User();
        user.setUsername("孙佳佳");
        user.setGender("男");
        user.setPassword("5555");
        user.setEmail("5555@126.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long date = sdf.parse("1991-02-16").getTime();
        user.setBirthday(new Date(date));
        user.setProvince("湖北省");
        user.setCity("武汉市");

        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();

        System.out.println("用户'孙佳佳'的 ID 为：" + user.getId()); // 获取新增用户在数据表中的 ID
        sqlSession.close();
    }

    @Test
    public void TestDelete() throws Exception {
        SqlSession sqlSession = dataConnention.getSqlSession();

        sqlSession.delete("test.deleteUser", 7);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void TestUpdate() throws Exception {
        SqlSession sqlSession = dataConnention.getSqlSession();

        User user = new User();
        user.setId(4);
        user.setUsername("孙丽");

        sqlSession.update("test.updateUserName", user);
        sqlSession.commit();

        sqlSession.close();
    }

    //用户信息综合查询
    @Test
    public void testFindUserList() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        // 创建包装对象，设置查询条件
        UserQueryInfo userQueryInfo = new UserQueryInfo();

        UserInstance userInstance = new UserInstance();

        userInstance.setGender("男");
        userInstance.setUsername("张三");
        userQueryInfo.setUserInstance(userInstance);

        //调用 userMapper 的方法
        List<UserInstance> userList = sqlSession.selectList("test.findUserList", userQueryInfo);

        for (int i = 0; i < userList.size(); i++) {
            UserInstance user = (UserInstance) userList.get(i);
            System.out.println(user.getId() + ":" + user.getUsername());
        }
        sqlSession.close();
    }


    @Test
    public void testBatchCustomer() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        //调用 userMapper 的方法
        List<BatchCustomer> bcList = sqlSession.selectList("test.findBatchCustomer");

        for (BatchCustomer batchCustomer : bcList) {
            System.out.println("卡号为" + batchCustomer.getAcno() + "的名为"
                    + batchCustomer.getUsername() + "的客户:\n于"
                    + batchCustomer.getCreatetime() + "采购了批次号为"
                    + batchCustomer.getNumber() + "的一批理财产品");
        }

        sqlSession.close();
    }

    @Test
    public void testBatchCustomerToMap() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        //调用userMapper的方法
        List<BatchItem> bcList = sqlSession.selectList("test.findBatchCustomerToMap");


        for (BatchItem batchItem : bcList) {

            System.out.println("卡号为" + batchItem.getCustomer().getAcno() + "的名为"  // 取出该批次的用户的卡号
                    + batchItem.getCustomer().getUsername() + "的客户:\n于"   // 取出该批次的用户的用户名
                    + batchItem.getCreatetime() + "采购了批次号为"
                    + batchItem.getNumber() + "的一批理财产品");
        }

        sqlSession.close();
    }

    @Test
    public void testFindBatchAndBatchDetail() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        //调用 userMapper 的方法
        List<BatchItem> batchItemList = sqlSession.selectList("test.findBatchAndBatchDetail");

        for (BatchItem batchItem : batchItemList) {

            //取出该批次订购的理财产品信息
            List<BatchDetail> batchDetails = batchItem.getBatchDetails();

            System.out.println("卡号为 " + batchItem.getCustomer().getAcno() + " 的名为 "
                    + batchItem.getCustomer().getUsername() + " 的客户:\n于 "
                    + batchItem.getCreatetime() + " 采购了批次号为 "
                    + batchItem.getNumber() + " 的一批理财产品，详情如下：");

            for (BatchDetail batchDetail : batchDetails) {

                System.out.println("id为 " + batchDetail.getProduct_id()
                        + " 的理财产品 " + batchDetail.getProduct_num() + " 份");

            }

        }
        sqlSession.close();
    }


    @Test
    public void testfindCustomerAndProducts() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        //调用userMapper的方法，获取所有用户信息(以及从属批次信息)
        List<Customer> customerList = sqlSession.selectList("findUserAndProducts");

        for (Customer customer : customerList) {

            //1.获取用户基本信息
            System.out.println("卡号为 " + customer.getAcno() + " 的名为 "
                    + customer.getUsername() + " 的客户:");

            //2.获取用户下的所有批次订单信息
            List<Batch> batchList = customer.getBatchList();
            for (Batch batch : batchList) {
                System.out.println("于 "
                        + batch.getCreatetime() + " 采购了批次号为 "
                        + batch.getNumber() + " 的一批理财产品，详情如下：");

                //3.获取一个批次的明细
                List<BatchDetail> batchDetails = batch.getBatchDetials();

                FinacialProduct finacialProduct;

                for (BatchDetail batchDetail : batchDetails) {

                    System.out.println("id为 " + batchDetail.getProduct_id()
                            + " 的理财产品 " + batchDetail.getProduct_num() + " 份。");

                    //4.获取每个批次明细中的理财产品详细信息
                    finacialProduct = batchDetail.getFinacialProduct();
                    System.out.println("该理财产品的详细信息为：\n"
                            + "产品名称: " + finacialProduct.getName()
                            + "|产品价格: " + finacialProduct.getPrice()
                            + "|产品简介: " + finacialProduct.getDetail());
                }
            }
            System.out.println("**************************************");
        }


        sqlSession.close();
    }

    @Test
    public void testFindBatchCustomerLazyLoading() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        //调用 userMapper 的方法，获取所有订单信息(未加载关联的用户信息)
        List<BatchItem> batchItemList = sqlSession.selectList("findBatchUserLazyLoading");

        for (BatchItem batchItem : batchItemList) {

            System.out.println("订单编号：" + batchItem.getNumber());

            //执行 getCustomer 时才会去查询用户信息，这里实现了延迟加载
            System.out.println("订购用户姓名:" + batchItem.getCustomer().getUsername());
        }

        sqlSession.close();
    }

    @Test
    public void testFindCustomerOnMapper() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        //获取Mapper代理
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        //执行Mapper代理对象的查询方法
        Customer customer = customerMapper.findCustomerById(1);

        System.out.println("用户姓名：" + customer.getUsername() + "|"
                + "卡号：" + customer.getAcno());
        sqlSession.close();

    }

    @Test
    public void testFindCustomerCache1() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        //调用 userMapper 的方法
        Customer customer1 = customerMapper.findCustomerById(1);
        System.out.println("用户姓名：" + customer1.getUsername());

        Customer customer2 = customerMapper.findCustomerById(1);
        System.out.println("用户姓名：" + customer2.getUsername());
        sqlSession.close();
    }

    @Test
    public void testFindCustomerCache2() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        //调用userMapper的方法
        Customer customer1 = customerMapper.findCustomerById(1);
        System.out.println("用户姓名：" + customer1.getUsername() + "|"
                + "卡号：" + customer1.getAcno());

        String AcNo = "6228289999999";
        customer1.setAcno(AcNo);
        System.out.println("修改用户卡号为：" + AcNo);

        customerMapper.updateCustomerAcNo(customer1);
        sqlSession.commit();

        Customer customer2 = customerMapper.findCustomerById(1);
        System.out.println("用户姓名：" + customer2.getUsername() + "|"
                + "卡号：" + customer2.getAcno());

        sqlSession.close();
    }

    /**
     * 验证二级缓存的存在
     * @throws Exception
     */
    @Test
    public void testFindCustomerOnMapper2() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        //获取Mapper代理
        CustomerMapper customerMapper1 = sqlSession.getMapper(CustomerMapper.class);

        //执行Mapper代理对象的查询方法
        Customer customer1 = customerMapper1.findCustomerById(1);
        System.out.println("用户姓名：" + customer1.getUsername() + "|"
                + "卡号：" + customer1.getAcno());

        //获取Mapper代理
        CustomerMapper customerMapper2 = sqlSession.getMapper(CustomerMapper.class);
        Customer customer2 = customerMapper2.findCustomerById(1);
        System.out.println("用户姓名：" + customer2.getUsername() + "|"
                + "卡号：" + customer2.getAcno());

        sqlSession.close();
    }

    /**
     * 验证二级缓存清空
     * @throws Exception
     */
    @Test
    public void testFindCustomerOnMapper3() throws Exception {

        SqlSession sqlSession = dataConnention.getSqlSession();

        //获取Mapper代理
        CustomerMapper customerMapper1 = sqlSession.getMapper(CustomerMapper.class);

        //执行Mapper代理对象的查询方法
        Customer customer1 = customerMapper1.findCustomerById(1);
        System.out.println("用户姓名：" + customer1.getUsername() + "|"
                + "卡号：" + customer1.getAcno());

        //获取Mapper代理
        CustomerMapper customerMapper2 = sqlSession.getMapper(CustomerMapper.class);

        String AcNo = "6228286666666";
        customer1.setAcno(AcNo);
        //执行Mapper代理对象的修改方法
        customerMapper2.updateCustomerAcNo(customer1);
        System.out.println("修改用户姓名：" + customer1.getUsername() + "|"
                + "的卡号为：" + customer1.getAcno());
        sqlSession.commit();

        //获取Mapper代理
        CustomerMapper customerMapper3 = sqlSession.getMapper(CustomerMapper.class);
        //执行Mapper代理对象的查询方法
        Customer customer3 = customerMapper3.findCustomerById(1);
        System.out.println("用户姓名：" + customer3.getUsername() + "|"
                + "卡号：" + customer3.getAcno());

        sqlSession.close();
    }




}
