package cn.com.blankengine.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;

public class App extends HttpServlet{

	private static SessionFactory sessionFactory;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // 读取指定的主配置文件
		sessionFactory = cfg.buildSessionFactory(); // 根据生成Session工厂
	}
	private List<bookinfo> books;
	private bookinfo book = new bookinfo();
	private List<readerinfo> info;
	private readerinfo reinfo;
	private String serchname;
	private String leadid; //bookinfo的图书bid
	private String leaduid;
	private int addnum; //书籍增加或者添加书籍的书籍数量
	private Stuaction stuaction;
	private studentinfo stu;
	private int page;
	private int node;
	
	


	public studentinfo getStu() {
		return stu;
	}


	public void setStu(studentinfo stu) {
		this.stu = stu;
	}


	public readerinfo getReinfo() {
		return reinfo;
	}


	public void setReinfo(readerinfo reinfo) {
		this.reinfo = reinfo;
	}


	public int getNode() {
		return node;
	}


	public void setNode(int node) {
		this.node = node;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public List<readerinfo> getInfo() {
		return info;
	}


	public void setInfo(List<readerinfo> info) {
		this.info = info;
	}


	public void setLeaduid(String leaduid) {
		this.leaduid = leaduid;
	}
	

	public Stuaction getStuaction() {
		return stuaction;
	}



	public void setStuaction(Stuaction stuaction) {
		this.stuaction = stuaction;
	}



	public int getAddnum() {
		return addnum;
	}



	public void setAddnum(int addnum) {
		this.addnum = addnum;
	}



	public String getLeadid() {
		return leadid;
	}



	public void setLeadid(String leadid) {
		this.leadid = leadid;
	}



	
	public List<bookinfo> getBooks() {
		return books;
	}



	public String getSerchname() {
		return serchname;
	}



	public void setSerchname(String serchname) {
		this.serchname = serchname;
	}



	public void setBooks(List<bookinfo> books) {
		this.books = books;
	}

	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void testSave() throws Exception {
//		User user = new User();
//		user.setName("张三");
//
//		// 保存
//		Session session = sessionFactory.openSession(); // 打开一个新的Session
//		Transaction tx = session.beginTransaction(); // 开始事务
//		
//		
//		List<appli> applic = (List<appli>)session.createQuery("select appli from appli where id = '123'").list();
//		for(appli appli :applic)
//			{
//				System.out.println(appli.getId());
//			}
//		
//		
//
//		tx.commit(); // 提交事务
//		session.close(); // 关闭Session，释放资源
//		
//		
//	}


	public bookinfo getBook() {
		return book;
	}



	public void setBook(bookinfo book) {
		this.book = book;
	}



//	@Test
//	public void getid()
//	{
//		Session session = sessionFactory.openSession();
//		String hql ="from appli";
//		Query query = session.createQuery(hql);
//		List<appli> app = query.list();
//		for(appli c: app)
//		{
//			System.out.print(c.getId()+c.getName());
//		}
//		
//	}
//	
	
	
	public String insertbook()				//增加书籍若书籍不存在直接添加书籍，若书籍不存在更新书籍信息
	{
		int numcount,numnow;		
		bookinfo cbook = new bookinfo();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		System.out.print(book.getBid());
		cbook =serchbookbyid(book.getBid());
		if(cbook == null)
		{
			session.save(book);
		}
		else
		{
			System.out.println("总共书籍"+book.getBname());
			updatebookforadmin(book.getBid(),book.getBname(),book.getBpublicment(),book.getBwriter(),book.getBnumcount(),book.getBnumnow());
			return "update";
		}
		tran.commit();
		session.close();
		
		return "success";
	}
	
	public String Changebookinfo()
	{
		book = null;
		book = serchbookbyid(serchname);
		
		return "success";
		
	}
	
	public void findall(int page)
	{
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from bookinfo").setFirstResult(page).setMaxResults(5);
		books= query.list();
		for(bookinfo b:books)
		{
			System.out.println(b.getBid());
		}
		tran.commit();
		session.close();
	}
	
//	
//	public void showallbook()
//	{
//		findall(0);
//		findall(5);
//	}
	public String showallbook()
	{
		
		findall(page);
		return "success";
	}
	
	//用ID查询书籍
	
	public bookinfo serchbookbyid(String id)
	{
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from bookinfo where bid = :id");
		query.setParameter("id", id);
		bookinfo book = (bookinfo)query.uniqueResult();
		tran.commit();
		session.close();
		return book;
		
	}
	
	public List<bookinfo> serchbookbyname(String hql)
	{
		String name  = "%" +serchname+"%";
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("keyvalue", name);
		books = query.list();
		for(bookinfo b:books)
		{
			System.out.print(b.getBid());
		}
		session.close();
		return books;
		
	}
	
	public String serchbook()
	{
		String hql = "from bookinfo where (bname  like :keyvalue) or ( bwriter like :keyvalue)";
		System.out.println("run serchbook"+page);
		books=serchbookbyname(hql);
		System.out.println("模糊查书");
		return "success";
	}
	
	
	
	
	//借书
	public String leadbook() //借书之后需要跳转到当前页面刷新
	{
		stuaction = new Stuaction();
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request =(HttpServletRequest)ac.get(ServletActionContext.HTTP_REQUEST);
		leadid=request.getParameter("leadid");
		leaduid=request.getParameter("leaduid");
		System.out.print(leaduid);
		bookinfo book = serchbookbyid(leadid);
		int booknum = book.getBnumnow();
		if(booknum > 0 && stuaction.findreaderinfo(leadid,leaduid) == null)   //这里有问题
		{
			 //如果readerinfo中不存在该图书
			
				stuaction.updatereaderinfo(leadid, leaduid);
				booknum--;
				updatebookforstu(leadid,booknum);//bookinfo表操作
			
		}
		else
		{
			System.out.println("youshule");
			return "false";
		}
		return "success";
	}
	
	//续借

	public String releadbook()
	{
		stuaction = new Stuaction();
		Date da = new Date();
		reinfo=stuaction.findreaderinfo(leadid,leaduid);
		Calendar   calendar   =   new   GregorianCalendar(); 
	    calendar.setTime(reinfo.getReturndate()); 
	    calendar.add(calendar.DATE,30);//把日期往后增加一天.整数往后推,负数往前移动 
//	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		String hehe = dateFormat.format(); 
//		App app = new App();
//		System.out.println(hehe);
		da = (calendar.getTime());
		stuaction.updateleadData(leadid, leaduid, da);
	    System.out.println(reinfo.getLeaddate());  //这个时间就是日期往后推一天的结果
		return "success";
	}
	
	//还书
	public String returnbook()
	{
		stuaction = new Stuaction();
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request =(HttpServletRequest)ac.get(ServletActionContext.HTTP_REQUEST);
		leadid=request.getParameter("leadid");
		leaduid=request.getParameter("leaduid");
		bookinfo book = serchbookbyid(leadid);
		System.out.print("return book uid"+leaduid);
		int booknum = book.getBnumnow();
		if(booknum < book.getBnumcount())
		{
			//对readerinfo表进行操作
				System.out.println("shanchu");
				stuaction.deletebook(leadid, leaduid);
				booknum++;
				updatebookforstu(leadid,booknum);    //对bookinfo表进行操作
		}
		else
		{
			System.out.println("meiyoushu");
			return "false";
		}
		return "success";
	}
	
	
	//查找学生借阅的总书籍
	
		public String showldbook()
		
		{
			stuaction = new Stuaction();
			System.out.println(leaduid);
			if(stuaction.serchstubook(leaduid) == null)
			{
				return "error";
			}
			info = stuaction.serchstubook(leaduid);
			System.out.print("\n"+leaduid+"\n");
			return "success";
		}
	
	//学生更新书籍方法对图书表进行操作借书图书当前量++ --
	public void updatebookforstu(String id,int num)
	{
		
//		String id="23";
//		int num=55;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "update bookinfo set bnumnow = :bnum where bid =:id";
		Query query = session.createQuery(hql);
		query.setParameter("bnum", num);
		query.setParameter("id", id);
		query.executeUpdate();
		System.out.print("over");
		tran.commit();
		session.close();
	}
	
	//管理员的更新书籍方法
	public void updatebookforadmin(String id,String name,String publiment,String writer,int numnow,int numcount)
	{
		
//		String id="23";
//		int num=55;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "update bookinfo set bnumnow = :bnum,bnumcount =:numcount,bwriter =:writer,bpublicment =:publicment,bname=:name where bid =:id";
		Query query = session.createQuery(hql);
		query.setParameter("bnum", numnow);
		query.setParameter("writer", writer);
		query.setParameter("publicment", publiment);
		query.setParameter("name", name);
		query.setParameter("numcount", numcount);
		query.setParameter("bnum", numnow);
		query.setParameter("id", id);
		query.executeUpdate();
		System.out.print("更新完成");
		tran.commit();
		session.close();
		
	}
	
	@Test
	public String chengestupasswd()
	{
//		String uid="123";
		stuaction = new Stuaction();
		System.out.println("hellow");
		System.out.println(leaduid+"修改密码");
		System.out.println(stu.getStupw());
		stuaction.updatepasswd(leaduid,stu.getStupw());
		return "success";
		
	}

}
