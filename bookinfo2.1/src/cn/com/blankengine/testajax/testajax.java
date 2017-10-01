package cn.com.blankengine.testajax;

public class testajax {
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	public String ajax()
	{
		 result = "{\"login\":\"success\"}"; 
		return "success";
	}
}
