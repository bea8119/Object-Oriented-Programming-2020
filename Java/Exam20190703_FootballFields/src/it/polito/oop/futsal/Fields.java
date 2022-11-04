package it.polito.oop.futsal;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Comparator;

/**
 * Represents a infrastructure with a set of playgrounds, it allows teams
 * to book, use, and  leave fields.
 *
 */
public class Fields {
    
    public static class Features {
        public final boolean indoor; // otherwise outdoor
        public final boolean heating;
        public final boolean ac;
        public Features(boolean i, boolean h, boolean a) {
            this.indoor=i; this.heating=h; this.ac = a;
        }
    }
    public class Booking {
    	protected int idfield;
    	protected int idAssoc;
    	protected String Time;
		public Booking(int idfield, int idAssoc, String time) {
			this.idfield = idfield;
			this.idAssoc = idAssoc;
			Time = time;
		}
		    	
    }
    
    public class Field implements FieldOption {
    	private int id;
    	private Features features;
    	private List<String> times = new LinkedList<String>();
    	
    	
    	public Field(int id, Features features) {
			this.id = id;
			this.features = features;
		}

		public void addTime(String time){
    		times.add(time);
    	}

		@Override
		public int getField() {
			// TODO Auto-generated method stub
			return id;
		}

		@Override
		public int getOccupation() {
			// TODO Auto-generated method stub
			return times.size();
		}

		

		public Features getFeatures() {
			return features;
		}

		public List<String> getTimes() {
			return times;
		}
		
		
    	
    }
    
    private String OpeningTime;
    private String ClosingTime="00:00";
    
    private Map<Integer, Field> fields= new LinkedHashMap<Integer, Field>();
    private Map<Integer, Associate> associates= new LinkedHashMap<Integer, Associate>();
    private int fid=0;
    private int aid=0;
    
    private List<Booking> bookings= new LinkedList<Booking>();
    
    public void defineFields(Features... features) throws FutsalException {
    	
       for(Features f: features) {    	   
    	   if(!f.indoor && (f.heating || f.ac))
    		   throw new FutsalException();
    	   
    	   fid++;
    	   Field field= new Field(fid, f);
    	   fields.put(fid, field);
    	   
       }
    	
    }
    
    public long countFields() {
    	
        return fid;
    }

    public long countIndoor() {    	
        return fields.values().stream().filter(f-> f.getFeatures().indoor).count();
    }
    
    public String getOpeningTime() {
    	
        return OpeningTime;
    }
    
    public void setOpeningTime(String time) {
    	
    	this.OpeningTime = time;

    }
    
    public String getClosingTime() {
    	
    	
    	return ClosingTime;
    }
    
    public void setClosingTime(String time) {

    	this.ClosingTime=time;
    }
    
    public int getBlocks() {
    	int n;
    	
    	String[] op= OpeningTime.split(":");
    	String[] cl=ClosingTime.split(":");
    	
    	if(ClosingTime.equals("00:00")) {
    		if(Integer.parseInt(op[1])==0)
    			n=24-Integer.parseInt(op[0]);    		
    		else
    			n=24-Integer.parseInt(op[0])-1;
    	}
    	else {
    		if(Integer.parseInt(op[1])<=Integer.parseInt(cl[1]))
    			n=Integer.parseInt(cl[0])-Integer.parseInt(op[0]);    		
    		else
    			n=Integer.parseInt(cl[0])-Integer.parseInt(op[0])-1;
    	}
    			
    	
    	return n;
    }

    public int newAssociate(String first, String last, String mobile) {
    	
    	aid++;
    	Associate a= new Associate(aid, first, last, mobile);
    	associates.put(aid, a);
        return aid;
    }
    
    public String getFirst(int partyId) throws FutsalException {
    	if(!associates.containsKey(partyId))
    		throw new FutsalException();
    	
        return associates.get(partyId).getFirst();
    }
    
    public String getLast(int associate) throws FutsalException {
    	if(!associates.containsKey(associate))
    		throw new FutsalException();
    	
        return associates.get(associate).getLast();
    }
    
    public String getPhone(int associate) throws FutsalException {
    	if(!associates.containsKey(associate))
    		throw new FutsalException();
    	
        return associates.get(associate).getMobile();
        
    }
    
    public int countAssociates() {
        return aid;
    }
    
    public void bookField(int field, int associate, String time) throws FutsalException {
    	
    	String[] cl=ClosingTime.split(":");
    	String[] op= OpeningTime.split(":");
    	
    	
    	String[] t= time.split(":");
    	
    	if(Integer.parseInt(op[1])!=Integer.parseInt(t[1]) || Integer.parseInt(op[0])>Integer.parseInt(t[0])
    			|| (!ClosingTime.equals("00:00") && Integer.parseInt(cl[0])<Integer.parseInt(t[0])))
    		throw new FutsalException("Time is not accepted");
    	if( this.isBooked(field, time) )
    		throw new FutsalException("field is already booked at that time");
    	
    	if(!fields.containsKey(field) || !associates.containsKey(associate))
    		throw new FutsalException("Time is not accepted");
    	
    	Booking b= new Booking(field, associate, time);
    	fields.get(field).addTime(time);
    	
    	bookings.add(b);
    	
    }

    public boolean isBooked(int field, String time) {
    	Long present=bookings.stream().filter(b-> b.idfield==field).map(b-> b.Time)
    			.filter(b-> b.equals(time)).count();
    	
    	if(present==0)
    		return false;
    	else    			
    		return true;
    }
    

    public int getOccupation(int field) {
    	Long num=bookings.stream().filter(b-> b.idfield==field).count();
    	String n= ""+num;
    	
        return Integer.parseInt(n);
    }
    
    
    public List<FieldOption> findOptions(String time, Features required){ 	
        return fields.values().stream().filter(x-> x.getFeatures().indoor==required.indoor && x.getFeatures().ac==required.ac
				&& x.getFeatures().heating==required.heating)
		.filter(x-> !x.getTimes().contains(time))
		.sorted(Comparator.comparingInt(Field::getOccupation).reversed().thenComparing(Field::getField))
		.collect(Collectors.toList())
		;
    }
    
    public long countServedAssociates() {
    	
        return bookings.stream().map(x-> x.idAssoc).distinct().count();
    }
    
   
    
    public double occupation() {
    	double res= (double) bookings.size()/this.getBlocks();
    	
        return res;
    }
    
    public Map<Integer,Long> fieldTurnover() {
    	
    			
        return bookings.stream().collect(Collectors.groupingBy(x-> x.idfield, ()-> new TreeMap<Integer, Long>(), Collectors.counting()))
            	;
    }
    
}
