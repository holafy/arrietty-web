package ivy.web.entry.context.data;

import java.io.Serializable;

/**
 * SessionUser Store in http session
 * 
 * @author holaivy@gmail.com
 * 
 */
public class SessionUser implements Serializable {

	public static final String SESSIONUSER = "SessionUser";

	private static final long serialVersionUID = 5949509141441194324L;

	private String un; // 用户账户
	private String uid; // 用户ID
	private String idno; // 用户身份证号
	private String nam; // 用户姓名
	private String rid; // 用户所属角色ID
	private String role; // 用户所属角色
	private boolean adm; // 是否为管理员
	private String cid; // 卡号
	private String sid; // 通用号

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("[").append(uid).append(",").append(un).append("]");
		return buf.toString();
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public boolean isAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
