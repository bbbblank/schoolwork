package cn.com.blankengine.test;



import java.io.Closeable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;

public class Stuaction {
	
	private static SessionFactory sessionFactory;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // ��ȡָ�����������ļ�
		sessionFactory = cfg.buildSessionFactory(); // ��������Session����
	}
	
	private studentinfo stu;
	private bookinfo book;
	private readerinfo reinfo = new readerinfo();
	private List<readerinfo> info;
	private App app;
	

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public bookinfo getBook() {
		return book;
	}

	public void setBook(bookinfo book) {
		this.book = book;
	}

	public List<readerinfo> getInfo() {
		return info;
	}

	public void setInfo(List<readerinfo> info) {
		this.info = info;
	}

	public readerinfo getReinfo() {
		return reinfo;
	}

	public void setReinfo(readerinfo reinfo) {
		this.reinfo = reinfo;
	}

	public studentinfo getStu() {
		return stu;
	}

	public void setStu(studentinfo stu) {
		this.stu = stu;
	}
	
	//��¼
	public String login()
	{
//		String username ="1";
//		String passwd = "123";
		Session se = sessionFactory.openSession();
		Transaction tran = se.beginTransaction();
		Query query=se.createQuery("from studentinfo where uid =:username and stupw =:passwd");
		query.setParameter("username",stu.getUid());
		query.setParameter("passwd", stu.getStupw());
		System.out.println(stu.getUid());
		stu = (studentinfo)query.uniqueResult();
		if(stu !=  null)
		{
			ActionContext actionContext = ActionContext.getContext();   //ȡ��struts����
		    Map<String, Object> session = actionContext.getSession();    //ȡ��session
		    session.put("uid", stu.getUid());       //���û����ݷ���session
		    System.out.println("this is uid"+stu.getUid());
		    if(stu.getRool() == 1) //1Ϊѧ�� 2Ϊ����Ա
		    {
		    	return "student";
		    }
		    else
		    {
		    	return "admin";
		    }
		}
		else
		{
		return "false";
		}
	}
	
	//ʹ���û���¼��UID����ѯ�û������鼮
	public List<readerinfo> serchstubook(String stuid)
	{
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		try {
			Query query=session.createQuery("from readerinfo where uid=:uid");
			query.setParameter("uid", stuid);
			
			return query.list();
		} catch (Exception e) {
			return null;
		}
		finally {
			session.close();
		}
	}
	
	
	//ͨ��UID��bid��ѯ���ĵ�ĳһ���鼮
	
	public readerinfo findreaderinfo(String bid,String uid)
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from readerinfo where bid =:bid and uid=:uid");
		query.setParameter("uid", uid);
		query.setParameter("bid", bid);
		reinfo = (readerinfo) query.uniqueResult();
		session.close();
		
		return reinfo;
	}
	
//����ɾ��
	public void deletebook(String bid,String uid)
	{
//		String bid="H123";
//		String uid="123";
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from readerinfo where bid =:bid and uid=:uid");
		query.setParameter("uid", uid);
		query.setParameter("bid", bid);
		query.executeUpdate();
		tx.commit();
		session.close();
	}
	
	//���鱣��
	public void updatereaderinfo(String bid,String uid)
	{
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		reinfo = new readerinfo();
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String hehe = dateFormat.format( now ); 
		App app = new App();
		System.out.println(hehe);
		Calendar   calendar   =   new   GregorianCalendar(); 
	    calendar.setTime(now); 
	    calendar.add(calendar.DATE,30);//��������������һ��.����������,������ǰ�ƶ�
		book = app.serchbookbyid(bid);
		reinfo.setBid(bid);
		reinfo.setBname(book.getBname());
		reinfo.setLeaddate(now);
		reinfo.setUid(uid);
		reinfo.setReturndate(calendar.getTime());
		reinfo.setStuname("22222");
		session.save(reinfo);
		tx.commit();
		session.close();
	}
	
	//���豣��

	public void updateleadData(String bid,String uid,Date newdata)
	{
//		String bid ="123";
//		String uid="123";
//		Date newdata = new Date();
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(bid);
		System.out.println(uid);
		System.out.println(newdata);
		Query query = session.createQuery("update from readerinfo set returndate =:newdate where bid =:bid and uid=:uid");
		query.setParameter("uid", uid);
		query.setParameter("bid", bid);
		query.setParameter("newdate", newdata);
		
		query.executeUpdate();
	}

	public studentinfo findstubyid(String uid)
	{
//		String uid="123";
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from studentinfo where uid =:uid");
		query.setParameter("uid", uid);
		try {
			return (studentinfo)query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		finally {
			session.close();
		}
	}

	public void updatepasswd(String uid,String passwd)
	{
//		String uid = "123";
//		String passwd="555";
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("�޸�����"+uid);
		Query query = session.createQuery("update from studentinfo set stupw =:passwd where uid =:uid");
		query.setParameter("passwd", passwd);
		query.setParameter("uid", uid);
		query.executeUpdate();
		
		
	}
}
