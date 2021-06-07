package cs.term.vo;

public class Term {
	private String term;
	private String termcon;
	private String termcate;
	private String termdate;
	
	public Term() {
		super();
	}
	public Term(String term, String termcon) {
		this.term = term;
		this.termcon = termcon;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTermcon() {
		return termcon;
	}

	public void setTermcon(String termcon) {
		this.termcon = termcon;
	}

	public String getTermcate() {
		return termcate;
	}

	public void setTermcate(String termcate) {
		this.termcate = termcate;
	}

	public String getTermdate() {
		return termdate;
	}

	public void setTermdate(String termdate) {
		this.termdate = termdate;
	}
	
	
}
