package com.shailesh.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Shailesh
 * @apiNote This class converts response to same structure
 */
public class ResponseHandler {
	
	/**
	 * 
	 * @param message
	 * @param status
	 * @param success
	 * @param obj
	 * @return map of response
	 */
	public static Map<String, Object> generateResponse(String message, HttpStatus status, Boolean success, Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("message", message);
			map.put("status", status);
			map.put("success", success);
			map.put("data", obj);
			map.put("time", new Date());
		} catch (Exception e) {
			map.put("message", e.getMessage());
			map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
			map.put("success", false);
			map.put("time", new Date());
		}
		return map;
	}

}
