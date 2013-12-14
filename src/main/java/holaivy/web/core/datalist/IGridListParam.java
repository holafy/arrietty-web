package holaivy.web.core.datalist;

public interface IGridListParam {

	public abstract int getP();

	public abstract void setP(int p);

	public abstract int getC();

	public abstract void setC(int c);

	public abstract int getS();

	public abstract void setS(int s);

	public boolean isPager();

	public void setPager(boolean pager);
}