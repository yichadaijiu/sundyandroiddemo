package sundy.android.demo.datastore;

import java.util.Date;

public class ModelUser {
	//用户表主键ID
	private int m_UserID;
	//用户名称
	private String m_UserName;
	//添加日期
	private Date m_CreateDate = new Date();
	//状态 0失效 1启用
	private int m_State = 1;
	/**
	 * 用户表主键ID
	 */
	public int GetUserID() {
		return m_UserID;
	}
	/**
	 * 用户表主键ID
	 */
	public void SetUserID(int p_UserID) {
		this.m_UserID = p_UserID;
	}
	/**
	 * 用户名称
	 */
	public String GetUserName() {
		return m_UserName;
	}
	/**
	 * 用户名称
	 */
	public void SetUserName(String p_UserName) {
		this.m_UserName = p_UserName;
	}
	/**
	 * 添加日期
	 */
	public Date GetCreateDate() {
		return m_CreateDate;
	}
	/**
	 * 添加日期
	 */
	public void SetCreateDate(Date p_CreateDate) {
		this.m_CreateDate = p_CreateDate;
	}
	/**
	 * 状态 0失效 1启用
	 */
	public int GetState() {
		return m_State;
	}
	/**
	 * 状态 0失效 1启用
	 */
	public void SetState(int p_State) {
		this.m_State = p_State;
	}
}
