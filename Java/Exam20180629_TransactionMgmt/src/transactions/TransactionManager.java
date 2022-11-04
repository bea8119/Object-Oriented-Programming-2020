package transactions;
import java.util.*;
import java.util.Comparator.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collections.*;

//import static java.util.stream.Collectors.*;
//import static java.util.Comparator.*;

public class TransactionManager {
	
	public Map<String, Region> regions= new TreeMap<String, Region>();
	public Map<String, String> places= new TreeMap<String, String>();
	public Map<String, List<String>> carriers= new TreeMap<String,List<String>>();
	public Map<String, LocProd> requests = new TreeMap<String, LocProd>();
	public Map<String, LocProd> offers = new TreeMap<String, LocProd>();
	public Map<String, Transaction> transactions = new TreeMap<String, Transaction>();
	
	protected class LocProd{			
		protected String place;
		protected String productId;
		protected String region;
		public LocProd(String place, String productId, String region) {
			this.place = place;
			this.productId = productId;
			this.region=region;
		}
		
	
	}
//R1
	public List<String> addRegion(String regionName, String... placeNames) 
	throws TMException{ 
		
		if(regions.containsKey(regionName))
			throw new TMException();
		
		List<String> orderedp= new ArrayList<String>();
		
		for(String p: placeNames) {
			if(!places.containsKey(p)) {
				orderedp.add(p);
				places.put(p,regionName);
			}
				
			
		}
		orderedp.sort((a, b)-> a.compareTo(b));		
		Region r= new Region(regionName, orderedp);
		regions.put(regionName, r);
		return  orderedp;
	}
	
	public List<String> addCarrier(String carrierName, String... regionNames) throws TMException{
		if(carriers.containsKey(carrierName))
			throw new TMException();
		
		List<String> orderedr= new ArrayList<String>();
		
		for(String r: regionNames) {
			if(regions.containsKey(r) && !orderedr.contains(r)) {
				orderedr.add(r);
				regions.get(r).addCarrier(carrierName);
			}
				
				
			}
	
		orderedr.sort((a, b)-> a.compareTo(b));		
		carriers.put(carrierName, orderedr);
		
		return orderedr;
	}
	
	public List<String> getCarriersForRegion(String regionName) { 
		
		return regions.get(regionName).getCarriers();
	}
	
//R2
	public void addRequest(String requestId, String placeName, String productId) 
			throws TMException {
		if(requests.containsKey(requestId))
			throw new TMException();
		if(!places.containsKey(placeName))
			throw new TMException();
		LocProd lp= new LocProd(placeName, productId, places.get(placeName));
		requests.put(requestId, lp);
		
		
	}
	
	public void addOffer(String offerId, String placeName, String productId) 
			throws TMException {
		
		if(offers.containsKey(offerId))
			throw new TMException();
		if(!places.containsKey(placeName))
			throw new TMException();
		LocProd lp= new LocProd(placeName, productId, places.get(placeName));
		offers.put(offerId, lp);
	}
	

//R3
	public void addTransaction(String transactionId, String carrierName, String requestId, String offerId) 
			throws TMException {
		
		
		for(Transaction t: transactions.values()) 		
			if(t.getRequestId().equals(requestId) && t.getOfferId().equals(offerId))
				throw new TMException();		
		
		if(!requests.get(requestId).productId.equals(offers.get(offerId).productId))
			throw new TMException();	
		
		if(!carriers.get(carrierName).contains(requests.get(requestId).region)
				|| !carriers.get(carrierName).contains(offers.get(offerId).region ))
				throw new TMException();
		
		Transaction transaction= new Transaction(transactionId, carrierName, requestId, offerId );
		transaction.setProductId(requests.get(requestId).productId);
		transaction.setRequestRegion(requests.get(requestId).region);
		transactions.put(transactionId, transaction);
		
	}
	
	public boolean evaluateTransaction(String transactionId, int score) {
		return transactions.get(transactionId).setScore(score);
	}
	
//R4
	public SortedMap<Long, List<String>> deliveryRegionsPerNT() {
		
		return
		 transactions.values().stream().collect(Collectors.groupingBy(Transaction::getRegion, 
				TreeMap::new, Collectors.counting()))
		
		 .entrySet().stream().collect(Collectors.groupingBy(e->e.getValue(), 
				 ()-> new TreeMap<Long, List<String> >(Comparator.reverseOrder()),
				 Collectors.mapping(e-> e.getKey(), Collectors.toList())))
		;
		
		
	}
	
	public SortedMap<String, Integer> scorePerCarrier(int minimumScore) {
		return
		/*transactions.values().stream().filter(x->x.getScore()>=minimumScore)				
				.collect(Collectors.groupingBy(Transaction::getCarrier, 
						()-> new TreeMap<String, Integer>(Comparator.naturalOrder()),
						Collectors.summingInt(Transaction::getScore)))			
		;*/
				
		transactions.values().stream().filter(x->x.getScore()>=minimumScore)	
				.sorted(Comparator.comparing(Transaction::getCarrier))
				.collect(Collectors.groupingBy(Transaction::getCarrier, 
						TreeMap::new,
						Collectors.summingInt(Transaction::getScore)));			
	}
	
	public SortedMap<String, Long> nTPerProduct() {
		return
		transactions.values().stream()	
		.sorted(Comparator.comparing(Transaction::getProductId))
		.collect(Collectors.groupingBy(Transaction::getProductId, 
				TreeMap::new,
				Collectors.counting()))
		;
		
		
	}
	
	
}

