package me.erano.com.example1;

public interface Builder {
	
	EndpointBuilder setBaseUrl(String baseUrl);
	
	EndpointBuilder setPath(String path);
	
	EndpointBuilder addQueryParam(String key, String value);
	
	Endpoint build();

}
