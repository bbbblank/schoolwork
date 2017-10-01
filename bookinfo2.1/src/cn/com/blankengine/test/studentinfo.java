package cn.com.blankengine.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="stu_info")
public class studentinfo {
	@Id
	@Column(name = "uid")
	private String uid;
	
	@Column(name = "stupw",nullable=false)
	private String stupw;
	
	@Column(name = "e_mail",nullable=false)
	private String mail;
	
	@Column(name = "rool",nullable=false)
	private int rool;
	
	@Column(name = "stuaccount",nullable=false)
	private String acountname;

	

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getStupw() {
		return stupw;
	}

	public void setStupw(String stupw) {
		this.stupw = stupw;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getRool() {
		return rool;
	}

	public void setRool(int rool) {
		this.rool = rool;
	}

	public String getAcountname() {
		return acountname;
	}

	public void setAcountname(String acountname) {
		this.acountname = acountname;
	}
}
