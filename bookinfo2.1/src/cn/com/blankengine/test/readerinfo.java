package cn.com.blankengine.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="T_reader")
	public class readerinfo {
		@Id
		@Column(name="uuid")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int uuid;
		@Column(name="bid",nullable=false)
		private String bid;	
		
		@Column(name="uid",nullable=false)
		private String uid;
		
		@Column(name="bname",nullable=false)
		private String bname;
		
		@Column(name="bleaddate",nullable=false)
		private Date leaddate;
		
		@Column(name="stuname",nullable=false)
		private String stuname;
		
		@Column(name="breturndate",nullable=false)
		private Date returndate;
		
		private String Str_leaddate;
		
		
		
		public int getUuid() {
			return uuid;
		}

		public void setUuid(int uuid) {
			this.uuid = uuid;
		}

		public Date getReturndate() {
			return returndate;
		}

		public void setReturndate(Date returndate) {
			this.returndate = returndate;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public String getBid() {
			return bid;
		}

		public void setBid(String bid) {
			this.bid = bid;
		}

		public String getBname() {
			return bname;
		}
		
		public void setBname(String bname) {
			this.bname = bname;
		}
		
		public Date getLeaddate() {
			return leaddate;
		}
		
		public void setLeaddate(Date leaddate) {
			this.leaddate = leaddate;
		}
		
		public String getStuname() {
			return stuname;
		}
		
		public void setStuname(String stuname) {
			this.stuname = stuname;
		}
//		public readerinfo(int uid,int bid,String bname,Date leaddate,String stuname)
//		{
//			this.setUid(uid);
//			this.setBid(bid);
//			this.setBname(bname);
//			this.setLeaddate(leaddate);
//			this.setStuname(stuname);
//		}

}
