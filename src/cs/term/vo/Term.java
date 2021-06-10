package cs.term.vo;

public class Term {
	private String termmem;
	private String term;
	private String termcon;
	private String termcate;
	private String termdate;
	private int termhits;
	
	public Term() {
		super();
	}
	
	public String getTermmem() {
		return termmem;
	}
	public void setTermmem(String termmem) {
		this.termmem = termmem;
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

	public int getTermhits() {
		return termhits;
	}
	public void setTermhits(int termhits) {
		this.termhits = termhits;
	}
	
	
}
