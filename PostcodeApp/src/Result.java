import java.util.Map;

/************************************************
 * 
 * This class holds information of postcode
 * @author Borenstein
 *
 *************************************************/


public class Result {

	private String postcode;
	private int quality;
	private int eastings;
	private int northings;
	private String country;
	private String nhs_ha;
	private double longitude;
	private double latitude;
	private String european_electoral_region;
	private String primary_care_trust;
	private String region;
	private String lsoa;
	private String msoa;
	private String incode;
	private String outcode;
	private String parliamentary_constituency;
	private  String admin_district;
	private  String parish;
	private  String admin_county;
    private  String admin_ward;
    private String ced;
    private  String ccg;
    private  String nuts;
    private  Map<String, String> codes;
    
    public Result()
    {

    }
    
    public void updateRegion()
    {
    	if(this.region==null)
    		this.region= "Region Not Found";
    }

	  public String getCountry() {
	    return this.country;
	  }

	  public String getRegion() {
	    return this.region;
	  }
	 
	  public String getPostcode() {
		    return this.postcode;
		  }

	  public void setCountry(String country) {
	    this.country = country;
	  }

	  public void setRegion(String region) {
	    this.region = region;
	    }
	  

	public String  toString ()
	{
		StringBuilder s=new StringBuilder();
		s.append("Postcode ID: "+this.postcode);
		s.append(", Country: "+this.country);
		s.append(", Region: "+this.region);
		return	(s.toString());
	}

}
