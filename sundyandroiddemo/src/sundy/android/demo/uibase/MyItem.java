package sundy.android.demo.uibase;

public class MyItem {

	public MyItem(String mName, String mCompany) {
		super();
		this.mName = mName;
		this.mCompany = mCompany;
	}
	private String mName  ;
	private String mCompany  ;
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public String getCompany() {
		return mCompany;
	}
	public void setCompany(String mCompany) {
		this.mCompany = mCompany;
	}
	
}
