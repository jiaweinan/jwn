package com.shiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
public class TestShiro1 {
	
	@Test
	public void shiroLogin() {
		
		//1������ȫ������
		Factory<org.apache.shiro.mgt.SecurityManager> factory = 
				new IniSecurityManagerFactory("classpath:shiro.ini");
		
		//2ͨ�������õ�һ����ȫ����ʵ��
		org.apache.shiro.mgt.SecurityManager securityManager = 
				factory.getInstance();
		
		//3��ʵ�����ø���ȫ����
		SecurityUtils.setSecurityManager(securityManager);
		
		//4ͨ����ȫ���ߴ���һ���û�
		Subject subject = SecurityUtils.getSubject();
		
		//5����һ���û������������
		UsernamePasswordToken token = 
				new UsernamePasswordToken("jiaweinan","123456");
		
		//6��¼
		try {
			subject.login(token);
			System.out.println("��¼�ɹ�");
			
			//7�����¼�ɹ���ע��
			subject.logout();
		} catch (AuthenticationException e) {
			System.out.println("��¼ʧ��");
		}
	}
}
