package holaivy.web.core.datalist;

public interface IGridList<T> {

	public abstract boolean isEnd();

	public abstract boolean isEmpty();

	public abstract int getP();

	public abstract void setP(int p);

	public abstract int getS();

	public abstract void setS(int s);

	public abstract int getT();

	public abstract void setT(int t);

}