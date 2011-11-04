package org.nantesjug.java7.etl.extract;

public class FinancialException2 extends Exception implements
		IFinancialException {

	private static final long serialVersionUID = 6378964475167043549L;

	// Custom attribute
	private String myCode;

	public FinancialException2() {
		super();
	}

	public FinancialException2(String message, Throwable cause) {
		super(message, cause);
	}

	public FinancialException2(String message) {
		super(message);
	}

	public FinancialException2(Throwable cause) {
		super(cause);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nantesjug.java7.etl.extract.IFinancialException#getMyCode()
	 */
	@Override
	public String getMyCode() {
		return myCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.nantesjug.java7.etl.extract.IFinancialException#setMyCode(java.lang
	 * .String)
	 */
	@Override
	public void setMyCode(String myCode) {
		this.myCode = myCode;
	}
}
