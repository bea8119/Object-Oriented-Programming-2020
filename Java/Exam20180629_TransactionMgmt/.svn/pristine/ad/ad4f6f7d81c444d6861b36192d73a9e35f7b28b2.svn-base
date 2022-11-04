package transactions;

public class Transaction {
	
	private String transId;
	private String carrier;
	private String requestId;
	private String requestRegion;
	private String offerId;
	private String productId;
	private int score;
	public Transaction(String transId, String carrier, String requestId, String offerId) {
		this.transId = transId;
		this.carrier = carrier;
		this.requestId = requestId;
		this.offerId = offerId;
		this.score=0;
	}
	public String getTransId() {
		return transId;
	}
	public String getCarrier() {
		return carrier;
	}
	public String getRequestId() {
		return requestId;
	}
	public String getOfferId() {
		return offerId;
	}
	public int getScore() {
		return score;
	}
	public boolean setScore(int score) {
		this.score = score;
		if(score>=1 && score<=10)
			return true;
		
		else return false;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getRegion() {
		return requestRegion;
	}
	public void setRequestRegion(String requestRegion) {
		this.requestRegion = requestRegion;
	}
	
	
	

}
