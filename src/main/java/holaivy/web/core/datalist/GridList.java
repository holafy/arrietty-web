package holaivy.web.core.datalist;

import java.util.List;

public class GridList<T> implements IGridList<T> {
	private int p;// 页号
	private int s;// 面容量
	private int t;// 总数
	private boolean end;// 是否已至页尾
	private List<T> data;

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.core.datalist.IGridList#isEnd()
	 */
	@Override
	public boolean isEnd() {
		return end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.core.datalist.IGridList#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return data == null || data.size() == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.core.datalist.IGridList#getP()
	 */
	@Override
	public int getP() {
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.core.datalist.IGridList#setP(int)
	 */
	@Override
	public void setP(int p) {
		this.p = p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.core.datalist.IGridList#getS()
	 */
	@Override
	public int getS() {
		return s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.core.datalist.IGridList#setS(int)
	 */
	@Override
	public void setS(int s) {
		this.s = s;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.core.datalist.IGridList#getT()
	 */
	@Override
	public int getT() {
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.core.datalist.IGridList#setT(int)
	 */
	@Override
	public void setT(int t) {
		this.t = t;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

}
