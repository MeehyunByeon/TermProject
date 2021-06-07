package cs.term.vo;

public class Request {
	private String reqid;
	private String reqmem;
	private String reqterm;
	private String reqdate;
	
	public Request() {
		super();
	}

	public String getReqid() {
		return reqid;
	}

	public void setReqid(String reqid) {
		this.reqid = reqid;
	}

	public String getReqmem() {
		return reqmem;
	}

	public void setReqmem(String reqmem) {
		this.reqmem = reqmem;
	}

	public String getReqterm() {
		return reqterm;
	}

	public void setReqterm(String reqterm) {
		this.reqterm = reqterm;
	}

	public String getReqdate() {
		return reqdate;
	}

	public void setReqdate(String reqdate) {
		this.reqdate = reqdate;
	}
	
	
}
