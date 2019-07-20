package com.hcl.swedbank.homeinsurance.api.model.conversion.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.swedbank.homeinsurance.api.model.Category;
import com.hcl.swedbank.homeinsurance.api.model.Extra;
import com.hcl.swedbank.homeinsurance.api.model.Personaldetails;
import com.hcl.swedbank.homeinsurance.api.model.Photo;
import com.hcl.swedbank.homeinsurance.api.model.Plan;
import com.hcl.swedbank.homeinsurance.api.model.PolicyDocument;
import com.hcl.swedbank.homeinsurance.api.model.Premium;
import com.hcl.swedbank.homeinsurance.api.model.Property;
import com.hcl.swedbank.homeinsurance.api.model.SignDocument;
import com.hcl.swedbank.homeinsurance.api.model.UploadPhoto;
import java.io.*;

public class JSONToJavaConverter  {
	
	public Object convertJStoJava(String filePath) {
		BufferedReader br = null;
		final Logger LOGGER = Logger.getLogger(this.getClass());
		final String Json = ".json";
		try {
			
			InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
		    InputStreamReader isr = new InputStreamReader(is,System.setProperty("file.encoding", "ISO-8859-1"));
		    br = new BufferedReader(isr);

		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1);
		
		}
		catch (Exception e ) {
			LOGGER.error(e);
		}
		
		ObjectMapper om = new ObjectMapper();
		Object lo = null;

		if("Extra_Master_Response".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {		
			ExtrasList em = new ExtrasList();
			try {
				em = om.readValue(br, ExtrasList.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  em.getExtras();
		}
		else if("Personal Details_Response".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {		
			Personaldetails em = new Personaldetails();
			try {
				em = om.readValue(br, Personaldetails.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  em;
		}
		
		else if("ViewPhotosResponse".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {		
			PhotosList em = new PhotosList();
			try {
				em = om.readValue(br, PhotosList.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  em.getPhotos();
		}
		else if("Insurance Section".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {
			PlansList lp = new PlansList();
			try {
				lp = om.readValue(br, PlansList.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  lp.getPlans();
		}
		
		else if("Property Details_Response".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {
			PropertyList lp = new PropertyList();
			try {
				lp = om.readValue(br, PropertyList.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  lp.getPropertydetails();
		}
		
		else if("Address Search_Response".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json))) ||  "Address Search_renter_Response".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {
			Category ct= new Category(); 
			try {
				ct = om.readValue(br, Category.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  ct;
		}
		
		else if("PolicyDocument_Response".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {
			PolicyDocsList pd= new PolicyDocsList(); 
			try {
				pd = om.readValue(br, PolicyDocsList.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  pd.getPolicydocs();
		}
		
		else if("SignSignatureResponse".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {
			SignDocument sd = new SignDocument();
			
			try {
				sd = om.readValue(br, SignDocument.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  sd;
		}
		
		else if("UploadPhotoResponse".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {
			UploadPhoto up = new UploadPhoto();
			
			try {
				up = om.readValue(br, UploadPhoto.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  up;
		}
		
		else if("PremiumCalculation_Response".equals(filePath.substring(filePath.lastIndexOf('/')+1, filePath.lastIndexOf(Json)))) {
			Premium up = new Premium();
			
			try {
				up = om.readValue(br, Premium.class);
			} catch (IOException e) {
				LOGGER.error(e);
			}
			lo =  up;
		}
		
		return lo;
	}
	
	static class ExtrasList {
		  private List<Extra> extras;

		public List<Extra> getExtras() {
			return extras;
		}

		public void setExtras(List<Extra> extras) {
			this.extras = extras;
		}
	}
	static class PhotosList {
		  private List<Photo> photos;

		public List<Photo> getPhotos() {
			return photos;
		}

		public void setPhotos(List<Photo> photos) {
			this.photos = photos;
		}
	}
	
	static class PlansList {
		  private List<Plan> plans;

		public List<Plan> getPlans() {
			return plans;
		}

		public void setPlans(List<Plan> plans) {
			this.plans = plans;
		}
	}
	
	static class PolicyDocsList {
		  private List<PolicyDocument> policydocs;

		public List<PolicyDocument> getPolicydocs() {
			return policydocs;
		}

		public void setPolicydocs(List<PolicyDocument> policydocs) {
			this.policydocs = policydocs;
		}
	}
	static class PropertyList {
		  private List<Property> propertydetails;

		public List<Property> getPropertydetails() {
			return propertydetails;
		}

		public void setPropertydetails(List<Property> propertydetails) {
			this.propertydetails = propertydetails;
		}
	}
}
