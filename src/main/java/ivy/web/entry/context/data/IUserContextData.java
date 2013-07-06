package ivy.web.entry.context.data;

public interface IUserContextData {

	public abstract String getUid();

	public abstract void setUid(String uid);

	public abstract String getUn();

	public abstract void setUn(String un);

	public abstract String getUp();

	public abstract void setUp(String up);

	public abstract String getTel();

	public abstract void setTel(String tel);

	public abstract boolean isAdm();

	public abstract void setAdm(boolean adm);

	public abstract String getIdno();

	public abstract void setIdno(String idno);

	public abstract String getCid();

	public abstract void setCid(String cid);

	public abstract String getRid();

	public abstract void setRid(String rid);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract boolean isAct();

	public abstract void setAct(boolean act);

	public abstract String getSino();

	public abstract void setSino(String sino);

	public abstract boolean userActive();
	
	public abstract String getStat();

	public abstract void setStat(String stat) ;

}