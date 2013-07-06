package ivy.web.entry.context.data;

import ivy.core.tool.Str;

import java.io.Serializable;

/**
 * @author holaivy@gmail.com
 * 
 */
public class UserContextData implements Serializable, IUserContextData {
	private static final long serialVersionUID = 6930409545104495992L;
	private String uid;
	private String un;
	private String up;
	private String tel;
	private boolean adm;
	private String idno;
	private String cid;
	private String rid;
	private String name;
	private boolean act;
	private String sino;
	private String stat;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#getUid()
	 */
	@Override
	public String getUid() {
		return uid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#setUid(java.lang.String)
	 */
	@Override
	public void setUid(String uid) {
		this.uid = uid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#getUn()
	 */
	@Override
	public String getUn() {
		return un;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#setUn(java.lang.String)
	 */
	@Override
	public void setUn(String un) {
		this.un = un;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#getUp()
	 */
	@Override
	public String getUp() {
		return up;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#setUp(java.lang.String)
	 */
	@Override
	public void setUp(String up) {
		this.up = up;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#getTel()
	 */
	@Override
	public String getTel() {
		return tel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#setTel(java.lang.String)
	 */
	@Override
	public void setTel(String tel) {
		this.tel = tel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#isAdm()
	 */
	@Override
	public boolean isAdm() {
		return adm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#setAdm(boolean)
	 */
	@Override
	public void setAdm(boolean adm) {
		this.adm = adm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#getIdno()
	 */
	@Override
	public String getIdno() {
		return idno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ivy.web.entry.context.data.IUserContextData#setIdno(java.lang.String)
	 */
	@Override
	public void setIdno(String idno) {
		this.idno = idno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#getCid()
	 */
	@Override
	public String getCid() {
		return cid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#setCid(java.lang.String)
	 */
	@Override
	public void setCid(String cid) {
		this.cid = cid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#getRid()
	 */
	@Override
	public String getRid() {
		return rid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#setRid(java.lang.String)
	 */
	@Override
	public void setRid(String rid) {
		this.rid = rid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ivy.web.entry.context.data.IUserContextData#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#isAct()
	 */
	@Override
	public boolean isAct() {
		return act;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#setAct(boolean)
	 */
	@Override
	public void setAct(boolean act) {
		this.act = act;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ivy.web.entry.context.data.IUserContextData#getSino()
	 */
	@Override
	public String getSino() {
		return sino;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ivy.web.entry.context.data.IUserContextData#setSino(java.lang.String)
	 */
	@Override
	public void setSino(String sino) {
		this.sino = sino;
	}

	@Override
	public boolean userActive() {
		return Str.isNotEmpty(un) && act;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}


}
