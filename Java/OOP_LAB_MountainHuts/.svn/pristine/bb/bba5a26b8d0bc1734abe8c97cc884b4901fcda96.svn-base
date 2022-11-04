package mountainhuts;

import java.util.Optional;

/**
 * Represents a mountain hut.
 * 
 * It is linked to a {@link Municipality}
 *
 */
public class MountainHut {

	/**
	 * Unique name of the mountain hut
	 * @return name
	 */
	private String name;
	private Optional<Integer> altitude;
	private Integer alt;
	private String category;
	private Integer bedsnumber;
	private Municipality municipality;
	
	
	
	
	
	public MountainHut(String name, Integer altitude, String category, Integer bedsnumber, Municipality municipality) {
		
		this.name = name;
		this.altitude = Optional.ofNullable(altitude);
		if(altitude != null)
			this.alt=altitude;
		this.category = category;
		this.bedsnumber = bedsnumber;
		this.municipality = municipality;
	}

	public String getName() {
		return name;
	}

	/**
	 * Altitude of the mountain hut.
	 * May be absent, in this case an empty {@link java.util.Optional} is returned.
	 * 
	 * @return optional containing the altitude
	 */
	public Optional<Integer> getAltitude() {
		
		return altitude;
	}
	
public Integer getAltitudeint() {
		
		return alt;
	}

	/**
	 * Category of the hut
	 * 
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Number of beds places available in the mountain hut
	 * @return number of beds
	 */
	public Integer getBedsNumber() {
		return bedsnumber;
	}

	/**
	 * Municipality where the hut is located
	 *  
	 * @return municipality
	 */
	public Municipality getMunicipality() {
		return municipality;
	}

}
