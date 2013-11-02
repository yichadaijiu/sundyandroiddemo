package sundy.android.demo.sqlite;

public class User {

	private String userName  ;
	private String userAddress  ;
	private int userAge ;
	private boolean isMale  ;
	private int id  ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 得到用户名称
	 * @return 用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置用户名
	 * @param userName 设置用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 得到用户地址
	 * @return 返回地址
	 */
	public String getUserAddress() {
		return userAddress;
	}
	
	/**
	 * 设置用户地址
	 * @param userAddress 用户地址
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	/**
	 * 得到用户年龄
	 * @return
	 */
	public int getUserAge() {
		return userAge;
	}
	/**
	 * 设置用户年龄
	 * @param userAge
	 */
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	/**
	 * 性别
	 * @return
	 */
	public boolean isMale() {
		return isMale;
	}
	/**
	 * 性别
	 * @param isMale
	 */
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	
}
