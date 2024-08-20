package me.erano.com.example1;


public class EndpointBuilder implements Builder{
	
	private String baseUrl;
    private String path = "";
    private StringBuilder queryBuilder = new StringBuilder("?");

    public EndpointBuilder() {
    }
    public EndpointBuilder setBaseUrl(String baseUrl) {
    	this.baseUrl = baseUrl;
    	return this;
    }
    public EndpointBuilder setPath(String path) {
        this.path = path;
        return this;
    }
    public EndpointBuilder addQueryParam(String key, String value) {
        if (queryBuilder.length() > 1) {
            queryBuilder.append("&");
        }
        queryBuilder.append(key).append("=").append(value);
        return this;
    }
    public Endpoint build() {
        return new Endpoint(baseUrl, path, queryBuilder.toString());
    }
}
