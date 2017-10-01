package cn.com.blankengine.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookinfo")
public class bookinfo {
	@Id
	@Column(name="bid",nullable=false)
	private String bid;
	
	@Column(name="bname",nullable=false)
	private String bname;
	
	@Column(name="bwriter",nullable=false)
	private String bwriter;
	
	@Column(name="bpublicment",nullable=false)
	private String bpublicment;
	
	@Column(name="bnumcount",nullable=false)
	private int bnumcount;
	
	@Column(name="bnumnow",nullable=false)
	private int bnumnow;
	
	
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
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBpublicment() {
		return bpublicment;
	}
	public void setBpublicment(String bpublicment) {
		this.bpublicment = bpublicment;
	}
	public int getBnumcount() {
		return bnumcount;
	}
	public void setBnumcount(int bnumcount) {
		this.bnumcount = bnumcount;
	}
	public int getBnumnow() {
		return bnumnow;
	}
	public void setBnumnow(int bnumnow) {
		this.bnumnow = bnumnow;
	}
	
//	public bookinfo(String bid,String bname,String bwriter,String bpublicment,int bnumcount,int bnumnow)
//	{
//		this.setBid(bid);
//		this.setBname(bname);
//		this.setBnumcount(bnumcount);
//		this.setBnumnow(bnumnow);
//		this.setBpublicment(bpublicment);
//		this.setBwriter(bwriter);
//	}
}
