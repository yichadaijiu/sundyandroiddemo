package sundy.android.demo.uibase;

public class User {
	private String mUserName  ;
	private String mUserAddress  ;
	
	public User(String userName,String userAddress)
	{
		mUserAddress = userAddress ;
		mUserName = userName ;
	}
	
	public String getUserName() {
		return mUserName;
	}
	public void setUserName(String mUserName) {
		this.mUserName = mUserName;
	}
	public String getUserAddress() {
		return mUserAddress;
	}
	public void setUserAddress(String mUserAddress) {
		this.mUserAddress = mUserAddress;
	}
	
}
