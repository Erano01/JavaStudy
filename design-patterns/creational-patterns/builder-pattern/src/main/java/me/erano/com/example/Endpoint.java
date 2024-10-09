package me.erano.com.example;

public class Endpoint {
	
	//fields
	private String baseUrl;
    private String path;
    private String query;
    
	Endpoint() {
		// Make constructor private if you want to static buidler to enforce use of builder
		// Or make constructor non-public if you want to seperate builder and model class
	}

	Endpoint(String baseUrl, String path, String query) {
		super();
		this.baseUrl = baseUrl;
		this.path = path;
		this.query = query;
	}


	public String getUrl() {
        return baseUrl + path + query;
    }

	public String getBaseUrl() {
		return baseUrl;
	}

	public String getPath() {
		return path;
	}

	public String getQuery() {
		return query;
	}
	
	
	
	
}
