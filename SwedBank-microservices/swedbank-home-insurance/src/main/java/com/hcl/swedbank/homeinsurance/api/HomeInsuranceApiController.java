package com.hcl.swedbank.homeinsurance.api;

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
import com.hcl.swedbank.homeinsurance.api.model.conversion.utilities.JSONToJavaConverter;
import io.swagger.annotations.*;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeInsuranceApiController implements HomeInsuranceApi {
	
	@Override
    public ResponseEntity<Category> getAddressByCategory(@ApiParam(value = "category of address(Owner/Renter) that needs to be fetched",required=true ) @PathVariable("category") String category, @RequestHeader("language") String language) {
    	Category cat = new Category();
    	if("en".equalsIgnoreCase(language)) {
    	
	    	if("owner".equalsIgnoreCase(category)) {
	    		cat = (Category) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/Address Search_Response.json");
	    	}
	    	else if("renter".equalsIgnoreCase(category)) {
	    		cat = (Category) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/Address Search_renter_Response.json");
	    	}
    	}
    	else if("sw".equalsIgnoreCase(language)) {
        	
	    	if("owner".equalsIgnoreCase(category)) {
	    		cat = (Category) new JSONToJavaConverter().convertJStoJava("jsonFiles/sw/Address Search_Response.json");
	    	}
	    	else if("renter".equalsIgnoreCase(category)) {
	    		cat = (Category) new JSONToJavaConverter().convertJStoJava("jsonFiles/sw/Address Search_renter_Response.json");
	    	}
    	}
        return new ResponseEntity<>(cat , HttpStatus.OK);
    }
	
	@Override
    public ResponseEntity<Personaldetails> getAllAddress() {
       
        return new ResponseEntity<>((Personaldetails) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/Personal Details_Response.json"), HttpStatus.OK);
    }
	
	@Override
    public ResponseEntity<List<Extra>> getAllExtras() {
       
        return new ResponseEntity<>((List<Extra>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/Extra_Master_Response.json"), HttpStatus.OK);
    }

	@Override
    public ResponseEntity<List<Photo>> getAllPhotos(@ApiParam(value = "",required=true ) @PathVariable("propertyId") String propertyId) {
    	List<Photo> lpropphos = getPropertyPhotos(Integer.parseInt(propertyId), (List<Photo>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/ViewPhotosResponse.json"));
        return new ResponseEntity<>(lpropphos, HttpStatus.OK);
    }
	
	@Override
    public ResponseEntity<List<Plan>> getAllPlans(@RequestHeader(name = "language", required = true) String language) {
    	List<Plan> listPlan = new ArrayList<Plan>();
    	if("en".equalsIgnoreCase(language)){
    		listPlan = (List<Plan>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/Insurance Section.json");
    	}
    	else if("sw".equalsIgnoreCase(language)) {
    		listPlan = (List<Plan>) new JSONToJavaConverter().convertJStoJava("jsonFiles/sw/Insurance Section.json");
    	}
        return new ResponseEntity<>( listPlan, HttpStatus.OK);
    }

	@Override
    public ResponseEntity<List<PolicyDocument>> getAllPolicyDocs() {
       
        return new ResponseEntity<>( (List<PolicyDocument>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/PolicyDocument_Response.json"), HttpStatus.OK);
    }
	
	@Override
    public ResponseEntity<Property> getAllProperties(@ApiParam(value = "",required=true ) @PathVariable("addressId") String addressId) {
        return new ResponseEntity<>(getProperty(addressId, (List<Property>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/Property Details_Response.json")),HttpStatus.OK);
    }

	@Override
    public ResponseEntity<Premium> getPremiumByPlan(@ApiParam(value = "property-id of the address",required=true ) @PathVariable("propertyId") Integer propertyId,
        @ApiParam(value = "property-id of the address",required=true ) @PathVariable("planType") String planType,
        @ApiParam(value = "no of bed rooms",required=true ) @PathVariable("bedrooms") Integer bedrooms,
        @ApiParam(value = "no of living rooms",required=true ) @PathVariable("livingrooms") Integer livingrooms,
        @ApiParam(value = "no of bathrooms",required=true ) @PathVariable("bathrooms") Integer bathrooms,
        @ApiParam(value = "extras Count",required=true ) @PathVariable("extrasCount") Integer extrasCount,
        @ApiParam(value = "premium to Consider",required=true ) @PathVariable("premium") double premium) {
       
        return new ResponseEntity<>((Premium) premiumCalculation(String.valueOf(propertyId), planType, bedrooms, bathrooms, livingrooms, extrasCount,premium),HttpStatus.OK);
    }
	
	@Override
    public ResponseEntity<SignDocument> signDocument() {
       
        return new ResponseEntity<>((SignDocument)new JSONToJavaConverter().convertJStoJava("jsonFiles/en/SignSignatureResponse.json"), HttpStatus.OK);
    }

	@Override
    public ResponseEntity<UploadPhoto> uploadPhoto(@ApiParam(value = "Property Id to update",required=true ) @PathVariable("propertyId") Long propertyId,
        @ApiParam(value = "Extra Id of the property to update",required=true ) @PathVariable("extraId") Long extraId,
        @ApiParam(value = "Additional data to pass to server" ) @RequestPart(value="additionalMetadata", required=false)  String additionalMetadata,
        @ApiParam(value = "file detail") @RequestPart("file") MultipartFile file) {
       
        return new ResponseEntity<>((UploadPhoto) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/UploadPhotoResponse.json"),   HttpStatus.OK);
    }
    
    public List<Photo> getPropertyPhotos(int propertyid , List<Photo> allPhotos){
    	List<Photo> lpps = new ArrayList<>();
    	
    	for(Photo ph:allPhotos) {
    		if(ph.getPropertyId()== propertyid) {
    			lpps.add(ph);
    		}
    	}    	
    	return lpps;
    }
    
    public Property getProperty(String addressId, List<Property> props) {
    	Property prop = null;
    	for(Property property:props) {
    		if(property.getAddressId() == Integer.parseInt(addressId)) {
    			prop=property;
    		}    		
    	}
    	return prop;
    	
    }
    
    public Premium premiumCalculation(String addressId, String planType, int bedrooms, int bathrooms, int livingrooms, int extrascount,double premium) {
    	Premium prm = new Premium();
    	
    	String basePT = "base";
    	String plusPT = "plus";
    	String premiumPT = "premium";
    	
    	double basePrm = 0.0;
    	double bedroomscost = 0.0;
    	double bathroomscost = 0.0;
    	double livingroomscost = 0.0;
    	double extrascost = 0.0;
    	
    	if( basePT.equalsIgnoreCase(planType) || plusPT.equalsIgnoreCase(planType) || premiumPT.equalsIgnoreCase(planType)) {
    		
    		if(! Double.valueOf(premium).equals(Double.valueOf(0))) {
    			basePrm = premium;
    		}
    		else {
    			basePrm = getProperty(addressId, (List<Property>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/Property Details_Response.json")).getBaseMonthlyPremium();
        		
        		if(plusPT.equalsIgnoreCase(planType)){        	    	
            		basePrm = basePrm * 1.5;
        		}
        		else if(premiumPT.equalsIgnoreCase(planType)){        	    	
            		basePrm = basePrm * 1.8;
        		}
        		
    		}
    	}
    	if(basePT.equalsIgnoreCase(planType)) {
    		   		
    		if(bedrooms!=0) {
    			bedroomscost = bedrooms * 1.26;
    		}
    		if(bathrooms!=0) {
    			bathroomscost = bathrooms * 2.52;
    		}
    		if(livingrooms!=0) {
    			livingroomscost = livingrooms * 2.52;
    		}
    		if(extrascount!=0) {
    			extrascost = extrascount * 1.89;
    		}
    		
    	}
    	else if(plusPT.equalsIgnoreCase(planType)){
    		
    		if(bedrooms!=0) {
    			bedroomscost = bedrooms * 1.32;
    		}
    		if(bathrooms!=0) {
    			bathroomscost = bathrooms * 2.64;
    		}
    		if(livingrooms!=0) {
    			livingroomscost = livingrooms * 2.64;
    		}
    		if(extrascount!=0) {
    			extrascost = extrascount * 1.98;
    		}
      	}
    	else if(premiumPT.equalsIgnoreCase(planType)){
    		
    		if(bedrooms!=0) {
    			bedroomscost = bedrooms * 1.52;
    		}
    		if(bathrooms!=0) {
    			bathroomscost = bathrooms * 3.04;
    		}
    		if(livingrooms!=0) {
    			livingroomscost = livingrooms * 3.04;
    		}
    		if(extrascount!=0) {
    			extrascost = extrascount * 2.28;
    		}
    	}
    	double mPrm = (double) Math.round((basePrm + bedroomscost + bathroomscost + livingroomscost + extrascost) * 100.0)/100.0;
    			
		prm.setMonthlyPremium(mPrm);
		prm.setYearlyPremium((double) Math.round(mPrm * 12 * 100.0)/100.0);
    	
		return prm;   	
    }
}
