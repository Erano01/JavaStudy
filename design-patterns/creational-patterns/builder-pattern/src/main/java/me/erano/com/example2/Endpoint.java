package me.erano.com.example2;

public class Endpoint {
	
	//fields
	private String baseUrl;
    private String path;
    private String query;
    
	private Endpoint() {
		// Private constructor to enforce use of builder
	}
	
	public String getUrl() {
        return baseUrl + path + query;
    }
	// Endpoint fields getter setters if needed
	
	public static class EndpointBuilder{
		private String baseUrl;
        private String path = "";
        private StringBuilder queryBuilder = new StringBuilder("?");

        public EndpointBuilder(String baseUrl) {
            this.baseUrl = baseUrl;
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
            Endpoint endpoint = new Endpoint();
            endpoint.baseUrl = this.baseUrl;
            endpoint.path = this.path;
            endpoint.query = this.queryBuilder.toString();
            return endpoint;
        }
	}
}
