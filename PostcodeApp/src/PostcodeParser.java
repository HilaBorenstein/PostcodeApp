import java.io.IOException;
import java.io.*;
import java.net.*;


import com.google.gson.*;

public class PostcodeParser {
	
	private Validate v;
	private String postcode_id;
	private Result my_postcode_information;
	private NearestPostcodes my_postcode_nearest_postcodes_information;
	
	public PostcodeParser(String id) throws IOException
	{
		this.postcode_id=id;
		ValidatePostcode();
	}
	
	
	/*******************************************************
	 * ValidatePostcode-will validate the postcode
	 * @param postcode_id
	 * @return
	 * @throws IOException
	 ********************************************************/
	
	public boolean ValidatePostcode  () throws IOException
	{
		boolean validate_success=false;
		URL url = new URL("http://api.postcodes.io/postcodes/"+postcode_id+"/validate");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        try(BufferedReader br = new BufferedReader(  new InputStreamReader(con.getInputStream(), "utf-8"))) {         	
      		    StringBuilder response = new StringBuilder();
      		    String responseLine = null;
      		    //reading the data
      		    while ((responseLine = br.readLine()) != null) {
      		        response.append(responseLine.trim());
      		    }
      		    //Gson paring
      		    String json=response.toString();
        		Gson gson = new Gson();
        		v= gson.fromJson(json, Validate.class);
        		//checking validation
        		if(v.validation())
        		{
        			validate_success= true;
        			}
      		 br.close(); 
      		 con.disconnect();
      		}
        catch(IOException ex){
            System.out.println("ERROR in validate procedure....  " );            
        }
        return validate_success;   
	}
	
	/************************************************************
	 * 
	 * The below  2 methods handles the Json postcode information
	 * @param postcode_id
	 * @throws IOException
	 *****************************************************************/
	
	
	
	public void GetPostcodeJsonData  () throws IOException
	{
		//if(!v.validation()) return;
		
		URL url = new URL("http://api.postcodes.io/postcodes/"+postcode_id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        try(BufferedReader br = new BufferedReader(  new InputStreamReader(con.getInputStream(), "utf-8"))) {         	
      		    StringBuilder response = new StringBuilder();
      		    String responseLine = null;
      		    while ((responseLine = br.readLine()) != null) {
      		        response.append(responseLine.trim());
      		    }
      		    String json=response.toString();
      		   // System.out.println("json:"+json+"");
      		    parseGson(json);     		    
      		 br.close(); 
      		 con.disconnect();
      		}
        catch(IOException ex){
            System.out.println("ERROR!!- "+v.GetErrorMessage() );
        }
	}
	
	
	
	
	public void parseGson(String json) throws IOException
	{ 
		Gson gson = new Gson();
		PostcodeObject p= gson.fromJson(json, PostcodeObject.class);
		if (p.GetStatus()!=200)
			throw new IOException("Error with postcode id");
		p.GetResult().updateRegion();
		//System.out.println(p.GetResult());
		my_postcode_information=p.GetResult();
		findNearestPostcodes();
		
		/*
		if(p.GetStatus()==200)//400 failure
		{
			p.GetResult().updateRegion();
			System.out.println(p.GetResult());
			findNearestPostcodes(p.GetResult().getPostcode() );
		}
		else 
			System.out.println("Error!! status code "+p.GetStatus());
			
			*/
	}
	
	/*****************************************************
	 * The below 2 methos will handle the nearest postcodes 
	 * 
	 * @param postcode_id
	 * @throws IOException
	 */
	public void findNearestPostcodes() throws  IOException
	{ 
		
		URL url = new URL("http://api.postcodes.io/postcodes/"+postcode_id+"/nearest");
       HttpURLConnection con = (HttpURLConnection) url.openConnection();
       con.setDoOutput(true);
       con.setRequestMethod("GET");
       con.setRequestProperty("Content-Type", "application/json");
       //reading the data
       try(BufferedReader br = new BufferedReader(  new InputStreamReader(con.getInputStream(), "utf-8"))) {         	
     		    StringBuilder response = new StringBuilder();
     		    String responseLine = null;
     		    while ((responseLine = br.readLine()) != null) {
     		        response.append(responseLine.trim());
     		    }
     		    //parsing with Gson
     		    String json=response.toString();
     		    //System.out.println("json:"+json+"");
     		    parseNearestPostCodesGson(json);     		    
     		 br.close(); 
     		}
       catch(IOException ex){
           System.out.println("WARNING!! Cannot find nearest postcodes data for postcode id "+ postcode_id);
       }
	}
		
		
		
	public void parseNearestPostCodesGson(String json) throws IOException
	{ 
		Gson gson = new Gson();
		my_postcode_nearest_postcodes_information= gson.fromJson(json, NearestPostcodes.class);
		//System.out.println(my_postcode_nearest_postcodes_information);
		if(my_postcode_nearest_postcodes_information.GetStatus()!=200)//400 failure
			throw new IOException("Error with postcode id");
		my_postcode_nearest_postcodes_information.UpdateNullRegion();
		//System.out.println(my_postcode_nearest_postcodes_information);

	}	
	
	public String toString()
	{
		
		StringBuilder sb=new StringBuilder();
		if(this.my_postcode_information==null) 
			sb.append ("");
		else
			sb.append("\n"+this.my_postcode_information+"\n");
		if(this.my_postcode_nearest_postcodes_information==null) 
			sb.append ("");
		else
			sb.append(my_postcode_nearest_postcodes_information+"\n");
		return(sb.toString());
	}
		


	
	
	
	
}
