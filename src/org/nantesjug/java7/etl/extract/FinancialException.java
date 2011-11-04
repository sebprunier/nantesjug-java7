package org.nantesjug.java7.etl.extract;

public class FinancialException extends Exception implements
		IFinancialException {

	private static final long serialVersionUID = -4811879531832584336L;

	// Custom attribute
	private String myCode;

	public FinancialException() {
		super();
	}

	public FinancialException(String message, Throwable cause) {
		super(message, cause);
	}

	public FinancialException(String message) {
		super(message);
	}

	public FinancialException(Throwable cause) {
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
