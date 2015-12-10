package com.jxnu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 初始化安装
 * @author puchunwei
 *
 */
@Component
public class Installer {

	@Resource
	private SqlSessionFactory sessionFactory;

	/**
	 * 执行安装
	 */
	@Transactional
	public void install() {
		SqlSession session = sessionFactory.openSession();
		Connection conn = session.getConnection();
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from testbean");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("name : " + rs.getString(1) + " age : "
						+ rs.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(session + "test");

	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"config/spring/spring.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}
}
