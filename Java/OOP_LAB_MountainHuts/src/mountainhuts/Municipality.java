package mountainhuts;

/**
 * Represents a municipality
 *
 */
public class Municipality {

	/**
	 * Name of the municipality.
	 * 
	 * Within a region the name of a municipality is unique
	 * 
	 * @return name
	 */
	
	private String name;
	private String province;
	private int altitude;
	
	
	
	public Municipality(String name, String province, Integer altitude) {
		
		this.name = name;
		this.province = province;
		this.altitude = altitude;
	}

	public String getName() {
		return name;
	}

	/**
	 * Province of the municipality
	 * 
	 * @return province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Altitude of the municipality
	 * 
	 * @return altitude
	 */
	public Integer getAltitude() {
		return altitude;
	}

}
