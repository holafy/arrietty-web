package ivy.web.entry.context.comp;

import ivy.web.entry.context.data.IUserContextData;

public interface IUserInfoComp {

	/**
	 * 根据用户ID查询用户信息
	 * 
	 * @param id
	 *            -userid
	 * @return
	 */
	public abstract IUserContextData queryUserById(String id);

	/**
	 * 根据用户[username]查询用户信息
	 * 
	 * @param un
	 *            -username
	 * @return
	 */
	public abstract IUserContextData queryUserByUn(String un);

	/**
	 * 根据用户身份证号查询用户信息
	 * 
	 * @param idno
	 *            身份证号
	 * @return
	 */
	public abstract IUserContextData queryUserByIdNo(String idno);

}