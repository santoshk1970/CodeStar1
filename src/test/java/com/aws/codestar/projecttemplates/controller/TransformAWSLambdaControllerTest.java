package com.aws.codestar.projecttemplates.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import net.amznsantosh.transform.controller.TransformAWSLambdaController;
import net.amznsantosh.transform.model.DataToBeProtected;

/**
 * Tests for {@link TransformAWSLambdaController}. Modify the tests in order to support your use case as you build your project.
 */
@DisplayName("Tests for TransformAWSLambdaController")
public class TransformAWSLambdaControllerTest {

    private static final String EXPECTED_SITE_NAME = "home";
    private static final String EXPECTED_VIEW_NAME = "index";

    private TransformAWSLambdaController helloWorldController = new TransformAWSLambdaController(EXPECTED_SITE_NAME);

    /**
     * Initializing variables before we run the tests.
     * Use @BeforeAll for initializing static variables at the start of the test class execution.
     * Use @BeforeEach for initializing variables before each test is run.
     */
    @BeforeAll
    static void setup() {
        // Use as needed.
    }

    /**
     * De-initializing variables after we run the tests.
     * Use @AfterAll for de-initializing static variables at the end of the test class execution.
     * Use @AfterEach for de-initializing variables at the end of each test.
     */
    @AfterAll
    static void tearDown() {
        // Use as needed.
    }

    /**
     * Basic test to verify the result obtained when calling {@link TransformAWSLambdaController#helloWorld} successfully.
     */
    @Test
    @DisplayName("Basic test for controller")
    void testHelloWorld() {
        ModelAndView actualModelAndView = helloWorldController.helloWorld();

        // Verify the result obtained matches the values we expect.
        assertEquals(EXPECTED_VIEW_NAME, actualModelAndView.getViewName());
        assertEquals(EXPECTED_SITE_NAME, String.valueOf(actualModelAndView.getModel().get("siteName")));
    }
    @Test
    void testJSonParser (){
    	String returnValue="{\r\n"
    			+ "  \"message\": \"santoshahpla\"\r\n"
    			+ "}";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,String> myMap = new HashMap<String, String>();
		byte[] mapData = returnValue.getBytes();
		try {
			myMap = objectMapper.readValue(mapData, HashMap.class);
			System.out.println(myMap.get("message"));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    @Test
    void testJSonCreate() throws JsonProcessingException {
    	String transformMessage="{\r\n"
				+ "  \"transform\": {\r\n"
				+ "    \"clearValue\": \"santosh\",\r\n"
				+ "    \"dataElementName\": \"alpha\"\r\n"
				+ "  }\r\n"
				+ "}";
    	String transformMessageNoCR="{"
				+ "\"transform\":{"
				+ "\"clearValue\":\"santosh\","
				+ "\"dataElementName\":\"alpha\""
				+ "}"
				+ "}";
    	DataToBeProtected data=new DataToBeProtected();
    	data.setClearValue("santosh");
    	data.setDataElementName("alpha");
    	//data.setUserId("sk0001");
    	Transform transform =new Transform();
    	transform.setTransform(data);
    	ObjectMapper mapper = new ObjectMapper();
    	String writeValueAsString = mapper.writeValueAsString(transform);
    	System.out.println(writeValueAsString);
    	System.out.println(transformMessageNoCR);
    }
    class Transform {
    	private DataToBeProtected transform;

		public DataToBeProtected getTransform() {
			return transform;
		}

		public void setTransform(DataToBeProtected data) {
			this.transform = data;
		}
    	
    }
    
}
