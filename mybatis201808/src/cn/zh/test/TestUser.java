package cn.zh.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.zh.pojo.User;

public class TestUser {

	
	@Test
	public void testById() {
		
		//config 资源路径
		String resources = "config.xml";
		
		//类的构造器
		InputStream is = TestUser.class.getClassLoader().getResourceAsStream(resources);
		
		//通过sqlSessionFactoryBuild.build()获取SqlSessionFactory  构建器
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//获取SqlSessionFactory获取sqlSession(封装了执行sql的所有方法)
		SqlSession session = factory.openSession();
		session.commit();

		//根据id查询
		String id ="getUser";
		String id2 ="updateUser";
		String id3 = "deleteUser";
		String id4="inserUser";
		String id5 = "selectAllUser";
		User user = session.selectOne(id, 2);
		User user1 = new User();
		user1.setName("严佳恒");
		user1.setAge(10);
		System.out.println(user);
//		session.delete(id3, 1);
		int insert = session.insert(id4, user1);
		System.out.println(insert);
		List<Object> selectList = session.selectList(id5);
		System.out.println(selectList);
		/*for (Object object : selectList) {
			System.out.println(object);
		}*/
	}
	
	
}
