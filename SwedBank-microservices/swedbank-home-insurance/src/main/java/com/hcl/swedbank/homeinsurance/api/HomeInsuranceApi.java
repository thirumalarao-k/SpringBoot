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

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(value = "HomeInsurance", description = "the HomeInsurance API")
public interface HomeInsuranceApi {

    @ApiOperation(value = "Find property address by category", notes = "", response = Category.class, tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Category.class),
        @ApiResponse(code = 400, message = "Invalid Category supplied", response = Category.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/searchByCategory/{category}",
        produces = { "application/json"+";charset=UTF-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<Category> getAddressByCategory(@ApiParam(value = "category of address(Owner/Renter) that needs to be fetched",required=true ) @PathVariable("category") String category, @RequestHeader(name = "language", required = true) String language);


    @ApiOperation(value = "Get all the owner and renter addresses", notes = "Description here", response = Personaldetails.class, responseContainer = "List", tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Personaldetails.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = Personaldetails.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/getAllPersonalDetails",
        produces = { "application/json"+";charset=UTF-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<Personaldetails> getAllAddress();


    @ApiOperation(value = "Get all available Extras", notes = "All the meta data of extra items will be fetched", response = Extra.class, responseContainer = "List", tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Extra.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = Extra.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/getAllExtraItems",
        produces = { "application/json"+";charset=UTF-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Extra>> getAllExtras();


    @ApiOperation(value = "Get all available photos", notes = "Description here", response = Photo.class, responseContainer = "List", tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Photo.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = Photo.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/getAllPhotos/{propertyId}",
        produces = { "application/json"+";charset=UTF-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Photo>> getAllPhotos(@ApiParam(value = "",required=true ) @PathVariable("propertyId") String propertyId);


    @ApiOperation(value = "Get all available plans", notes = "Description here", response = Plan.class, responseContainer = "List", tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Plan.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = Plan.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/getAllPlans",
        produces = { "application/json"+";charset=UTF-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Plan>> getAllPlans(@RequestHeader(name = "language", required = true) String language);


    @ApiOperation(value = "Get all policy documents", notes = "Description here", response = PolicyDocument.class, responseContainer = "List", tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = PolicyDocument.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = PolicyDocument.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/getAllPolicyDocs",
        produces = { "application/json"+";charset=utf-8"}, 
        method = RequestMethod.GET)
    ResponseEntity<List<PolicyDocument>> getAllPolicyDocs();


    @ApiOperation(value = "Get all available Properties", notes = "Description here", response = Void.class, tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = Void.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/getPropertyByAddressId/{addressId}",
        produces = { "application/json"+";charset=utf-8"}, 
        method = RequestMethod.GET)
    ResponseEntity<Property> getAllProperties(@ApiParam(value = "",required=true ) @PathVariable("addressId") String addressId);


    @ApiOperation(value = "Find the monthly/yearly premium", notes = "", response = Premium.class, tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Premium.class),
        @ApiResponse(code = 400, message = "Invalid data", response = Premium.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/calculatePremiumByPlan/{propertyId}/{planType}/{bedrooms}/{livingrooms}/{bathrooms}/{extrasCount}/{premium:.+}",
        produces = { "application/json"+";charset=utf-8"}, 
        method = RequestMethod.GET)
    ResponseEntity<Premium> getPremiumByPlan(@ApiParam(value = "property-id of the address",required=true ) @PathVariable("propertyId") Integer propertyId,
        @ApiParam(value = "property-id of the address",required=true ) @PathVariable("planType") String planType,
        @ApiParam(value = "no of bed rooms",required=true ) @PathVariable("bedrooms") Integer bedrooms,
        @ApiParam(value = "no of living rooms",required=true ) @PathVariable("livingrooms") Integer livingrooms,
        @ApiParam(value = "no of bathrooms",required=true ) @PathVariable("bathrooms") Integer bathrooms,
        @ApiParam(value = "extras Count",required=true ) @PathVariable("extrasCount") Integer extrasCount,
    	@ApiParam(value = "premium to Consider",required=true ) @PathVariable("premium") double premium);


    @ApiOperation(value = "Sign the document", notes = "Description here", response = SignDocument.class, tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = SignDocument.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = SignDocument.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/signDocument",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<SignDocument> signDocument();


    @ApiOperation(value = "uploads a photo", notes = "", response = UploadPhoto.class, tags={ "Home Insurance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UploadPhoto.class) })
    @RequestMapping(value = "/swedbanksvc/insurance/home/{propertyId}/{extraId}/uploadPhoto",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    ResponseEntity<UploadPhoto> uploadPhoto(@ApiParam(value = "Property Id to update",required=true ) @PathVariable("propertyId") Long propertyId,
        @ApiParam(value = "Extra Id of the property to update",required=true ) @PathVariable("extraId") Long extraId,
        @ApiParam(value = "Additional data to pass to server" ) @RequestPart(value="additionalMetadata", required=false)  String additionalMetadata,
        @ApiParam(value = "file detail") @RequestPart("file") MultipartFile file);

}
