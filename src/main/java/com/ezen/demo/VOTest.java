package com.ezen.demo;

import java.io.DataInput;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
class DataVO{
	private DrinkVO drink;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class DrinkVO{
	private List<ListVO> list;
	private String hotBrand;
	private String hotBrandAddress;
}

@Data
class ListVO{
	private String name;
	private String price;
	private String brand;
}

@Slf4j
public class VOTest {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		String json = "{\r\n"
				+ "  \"drink\": {\r\n"
				+ "    \"list\": [\r\n"
				+ "      {\r\n"
				+ "        \"name\": \"coffee\",\r\n"
				+ "        \"price\": 2000,\r\n"
				+ "        \"brand\": \"back\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"name\": \"coffee\",\r\n"
				+ "        \"price\": 5000,\r\n"
				+ "        \"brand\": \"starbucks\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"name\": \"coffee\",\r\n"
				+ "        \"price\": 1700,\r\n"
				+ "        \"brand\": \"venti\"\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"hotBrand\": \"back\",\r\n"
				+ "    \"hotBrandAddress\": \"Seoul\"\r\n"
				+ "  }\r\n"
				+ "}\r\n";
		DataVO data = om.readValue(json, DataVO.class);
		log.info("data=>{}", data);
//		Map<String, Object> map = null;
//		map = om.readValue(json, Map.class);
//		log.info("data=>{}", map);
		
	}
	
}