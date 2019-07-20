package com.hcl.swedbank.homeinsurance.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.swedbank.homeinsurance.api.HomeInsuranceApiController;
import com.hcl.swedbank.homeinsurance.api.model.Photo;
import com.hcl.swedbank.homeinsurance.api.model.Property;
import com.hcl.swedbank.homeinsurance.api.model.conversion.utilities.JSONToJavaConverter;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HomeInsuranceApiController.class, secure = false)
public class SwedBankHomeInsurancceApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSearchByOwnerCategory() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/searchByCategory/{category}","owner").accept(
				MediaType.APPLICATION_JSON).header("language", "en");
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/Address Search_Response.json")),"ISO-8859-1");
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearchByRenterCategory() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/searchByCategory/{category}","renter").accept(
				MediaType.APPLICATION_JSON).header("language", "en");
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/Address Search_renter_Response.json")),"ISO-8859-1");
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllPolicyDocs() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/getAllPolicyDocs","").accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/PolicyDocument_Response.json")));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected.substring(expected.indexOf("["), expected.indexOf("]")+1), result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllAddress() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/getAllPersonalDetails","").accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/Personal Details_Response.json")),"ISO-8859-1");
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllExtraItems() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/getAllExtraItems","").accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/Extra_Master_Response.json")));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected.substring(expected.indexOf("["), expected.indexOf("]")+1), result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllPhotos() {
		int propertyId = 7;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/getAllPhotos/{propertyId}",propertyId).accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		
		List<Photo> lps= (List<Photo>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/ViewPhotosResponse.json");
		List<Photo> lppps = new ArrayList<Photo>();
		ObjectMapper om = new ObjectMapper();
		for(Photo lp:lps) {
			if(lp.getPropertyId() == propertyId) {
				lppps.add(lp);					
			}
		}

		try {
			expected = om.writeValueAsString(lppps);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllPlansInEnglish() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/getAllPlans","").accept(
				MediaType.APPLICATION_JSON).header("language", "en");
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/Insurance Section.json")));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected.substring(expected.indexOf("["), expected.indexOf("]")+1), result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllPlansInSwedish() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/getAllPlans","").accept(
				MediaType.APPLICATION_JSON).header("language", "sw");
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/sw/Insurance Section.json")),"ISO-8859-1");
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected.substring(expected.indexOf("["), expected.indexOf("]")+1), result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUploadPhoto() {
		FileInputStream inputFile = null;
		MockMultipartFile file = null;
		try {
			inputFile = new FileInputStream( "src/test/resources/pics/photo-1508138221679-760a23a2285b.jfif");
		} catch (FileNotFoundException e2) {
			
			e2.printStackTrace();
		}
		try {
			file = new MockMultipartFile("file", "photo-1508138221679-760a23a2285b.jfif", "multipart/form-data", inputFile);
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
		
		MvcResult result = null;
		try {
			result = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/swedbanksvc/insurance/home/{propertyId}/{extraId}/uploadPhoto","100","2").file(file).contentType(MediaType.MULTIPART_FORM_DATA)).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/UploadPhotoResponse.json")));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSignDocument() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/swedbanksvc/insurance/home/signDocument","").accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/SignSignatureResponse.json")));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPropertyByAddressId() {
		Integer addressId=100;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/getPropertyByAddressId/{addressId}",addressId).accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			List<Property> lps= (List<Property>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/Property Details_Response.json");

			for(Property lp:lps) {
				if(lp.getAddressId() == addressId) {
					expected = new ObjectMapper().writeValueAsString(lp);					
				}
			}
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetBasePremiumByPlan() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/calculatePremiumByPlan/{propertyId}/{planType}/{bedrooms}/{livingrooms}/{bathrooms}/{extrasCount}/{premium}","100","base","1","2","3","4","0.0").accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/test/resources/jsonFiles/Base_PremiumCalculation_Response.json")));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPlusPremiumByPlan() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/calculatePremiumByPlan/{propertyId}/{planType}/{bedrooms}/{livingrooms}/{bathrooms}/{extrasCount}/{premium}","100","plus","1","2","3","4","0.0").accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/test/resources/jsonFiles/Plus_PremiumCalculation_Response.json")));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAdvancedPremiumByPlan() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/calculatePremiumByPlan/{propertyId}/{planType}/{bedrooms}/{livingrooms}/{bathrooms}/{extrasCount}/{premium}","100","premium","1","2","3","4","0.0").accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/test/resources/jsonFiles/Advanced_PremiumCalculation_Response.json")));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	// Invalid Category i.e neither owner nor renter
	@Test
	public void testSearchByNonOwnerAndRenterCategory() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/searchByCategory/{category}","owners").accept(
				MediaType.APPLICATION_JSON).header("language", "en");
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/Address Search_Response.json")));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		try {
			JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	// Invalid language header i.e neither en nor sw
		@Test
		public void testSearchByCategoryInvlidLanguageHeader() {
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/swedbanksvc/insurance/home/searchByCategory/{category}","owner").accept(
					MediaType.APPLICATION_JSON).header("language", "en-sw");
			

			MvcResult result = null;
			try {
				result = mockMvc.perform(requestBuilder).andReturn();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			String expected = null;
			try {
				expected = new String(Files.readAllBytes(Paths.get("src/main/resources/jsonFiles/en/Address Search_Response.json")));
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			try {
				JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
			} catch (UnsupportedEncodingException | JSONException e) {
				
				e.printStackTrace();
			}
		}
	
	// Invalid URL
	@Test
	public void testGetAllPolicyDocsOnWrongURL() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurances/home/getAllPolicyDocs","").accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		try {
			JSONAssert.assertEquals(String.valueOf(result.getResponse().getStatus()),"404", true);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
	}
	// Invalid addressId
	@Test
	public void testGetPropertyByAddressIdByInvalidAddressId() {
		Integer addressId=1100;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/getPropertyByAddressId/{addressId}",addressId).accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		try {
			List<Property> lps= (List<Property>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/Property Details_Response.json");

			for(Property lp:lps) {
				if(lp.getAddressId() == addressId) {
					expected = new ObjectMapper().writeValueAsString(lp);					
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		assertNull(expected);
		try {
			assertEquals(result.getResponse().getContentAsString(),"");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	// invalid planType
	@Test
	public void testGetPremiumByInvalidPlanType() {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/calculatePremiumByPlan/{propertyId}/{planType}/{bedrooms}/{livingrooms}/{bathrooms}/{extrasCount}/{premium}","100","advanced","1","2","3","4","0.0").accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals("{\"monthly-premium\":0.0,\"yearly-premium\":0.0}", result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	} 
	
	// Invalid photo path and file parameter
	@Test
	public void testUploadInvalidPhoto() {
		FileInputStream inputFile = null;
		MockMultipartFile file = null;
		try {
			file = new MockMultipartFile("notfile", "", "multipart/form-data", inputFile);
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
		
		MvcResult result = null;
		try {
			result = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/swedbanksvc/insurance/home/{propertyId}/{extraId}/uploadPhoto","100","2").file(file).contentType(MediaType.MULTIPART_FORM_DATA)).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		assertEquals(String.valueOf(result.getResponse().getStatus()),"400");
	}

	@Test
	public void testGetAllPhotosWithInvalidPropertyID() {
		int propertyId = 3;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/swedbanksvc/insurance/home/getAllPhotos/{propertyId}",propertyId).accept(
				MediaType.APPLICATION_JSON);
		

		MvcResult result = null;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String expected = null;
		
		List<Photo> lps= (List<Photo>) new JSONToJavaConverter().convertJStoJava("jsonFiles/en/ViewPhotosResponse.json");
		List<Photo> lppps = new ArrayList<Photo>();
		ObjectMapper om = new ObjectMapper();
		for(Photo lp:lps) {
			if(lp.getPropertyId() == propertyId) {
				lppps.add(lp);					
			}
		}

		try {
			expected = om.writeValueAsString(lppps);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
		} catch (UnsupportedEncodingException | JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	// invalid planType
		@Test
		public void testGetPremiumByPremiumPlanTypeAndInitialPremium() {
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/swedbanksvc/insurance/home/calculatePremiumByPlan/{propertyId}/{planType}/{bedrooms}/{livingrooms}/{bathrooms}/{extrasCount}/{premium}","100","premium","1","1","1","1","71.18").accept(
					MediaType.APPLICATION_JSON);
			

			MvcResult result = null;
			try {
				result = mockMvc.perform(requestBuilder).andReturn();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			try {
				JSONAssert.assertEquals("{\"monthly-premium\":138,\"yearly-premium\":1656}", result.getResponse().getContentAsString(), true);
			} catch (UnsupportedEncodingException | JSONException e) {
				
				e.printStackTrace();
			}
		} 
		
		// invalid planType
		@Test
		public void testGetPremiumByBasePlanTypeAndInitialPremium() {
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/swedbanksvc/insurance/home/calculatePremiumByPlan/{propertyId}/{planType}/{bedrooms}/{livingrooms}/{bathrooms}/{extrasCount}/{premium}","100","base","1","1","1","1","71.18").accept(
					MediaType.APPLICATION_JSON);
			

			MvcResult result = null;
			try {
				result = mockMvc.perform(requestBuilder).andReturn();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			try {
				JSONAssert.assertEquals("{\"monthly-premium\":79.37,\"yearly-premium\":952.44}", result.getResponse().getContentAsString(), true);
			} catch (UnsupportedEncodingException | JSONException e) {
				
				e.printStackTrace();
			}
		} 
		
		// invalid planType
		@Test
		public void testGetPremiumByPlusPlanTypeAndInitialPremium() {
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/swedbanksvc/insurance/home/calculatePremiumByPlan/{propertyId}/{planType}/{bedrooms}/{livingrooms}/{bathrooms}/{extrasCount}/{premium}","100","plus","1","1","1","1","71.18").accept(
					MediaType.APPLICATION_JSON);
			

			MvcResult result = null;
			try {
				result = mockMvc.perform(requestBuilder).andReturn();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			try {
				JSONAssert.assertEquals("{\"monthly-premium\": 115.35,\"yearly-premium\":1384.2}", result.getResponse().getContentAsString(), true);
			} catch (UnsupportedEncodingException | JSONException e) {
				
				e.printStackTrace();
			}
		} 
}
