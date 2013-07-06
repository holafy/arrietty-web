package holaivy.web.core.datalist;

public class GridListParam implements IGridListParam {
	private int p;
	private int c;
	private int s;

	/* (non-Javadoc)
	 * @see holaivy.web.core.datalist.IGridListParam#getP()
	 */
	@Override
	public int getP() {
		return p;
	}

	/* (non-Javadoc)
	 * @see holaivy.web.core.datalist.IGridListParam#setP(int)
	 */
	@Override
	public void setP(int p) {
		this.p = p;
	}

	/* (non-Javadoc)
	 * @see holaivy.web.core.datalist.IGridListParam#getC()
	 */
	@Override
	public int getC() {
		return c;
	}

	/* (non-Javadoc)
	 * @see holaivy.web.core.datalist.IGridListParam#setC(int)
	 */
	@Override
	public void setC(int c) {
		this.c = c;
	}

	/* (non-Javadoc)
	 * @see holaivy.web.core.datalist.IGridListParam#getS()
	 */
	@Override
	public int getS() {
		return s;
	}

	/* (non-Javadoc)
	 * @see holaivy.web.core.datalist.IGridListParam#setS(int)
	 */
	@Override
	public void setS(int s) {
		this.s = s;
	}

}
