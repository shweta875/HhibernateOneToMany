package com.velocity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Policy policy1=new Policy();
		policy1.setPolicy_status("active");
		policy1.setPolicy_type("childEducation");
		
		Policy policy2=new Policy();
		policy2.setPolicy_status("inActive");
        policy2.setPolicy_type("LifeInsurance");
        
        Policy policy3=new Policy();
        policy3.setPolicy_status("active");
        policy3.setPolicy_type("medical");
        
        List<Policy> policy=new ArrayList<Policy>();
        policy.add(policy1);
        policy.add(policy2);
        policy.add(policy3);
        
        User user=new User();
        user.setName("yuvraj");
        user.setEmail("shweta@gmail.com");
        user.setPolicy(policy);
        
        session.save(user);
        session.save(policy1);
        session.save(policy2); 
        session.save(policy3);
        
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		

	}

}
