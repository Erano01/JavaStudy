package me.erano.com.example;

public interface Builder {
	
	EndpointBuilder setBaseUrl(String baseUrl);
	
	EndpointBuilder setPath(String path);
	
	EndpointBuilder addQueryParam(String key, String value);
	
	Endpoint build();

}
