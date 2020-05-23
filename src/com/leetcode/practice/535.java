public class Codec {
   private final Map<String,String> urlToKey= new HashMap<>();
	private final Map<String,String> keyToUrl= new HashMap<>();
	private final String baseUrl="http://tinyurl.com/";
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String key=null;
		if(urlToKey.containsKey(longUrl)){
			key= urlToKey.get(longUrl); 
		}
		else{
			key= getKey();
			urlToKey.put(longUrl,key);
			keyToUrl.put(key,longUrl);
		}
		StringBuilder shortUrl = new StringBuilder();
		shortUrl.append(baseUrl).append(key);
		return shortUrl.toString();
	}

	private String getKey(){
		String uuid=java.util.UUID.randomUUID().toString();
		StringBuilder key = new StringBuilder();
		Random random = new Random();
		for(int i=0;i<7;i++){
			key.append(uuid.charAt(random.nextInt(uuid.length())));
		}

		return key.toString();
	}

	private String decodeKey(String url){
		return url.substring(baseUrl.length(),url.length());

	}


	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {

		return keyToUrl.get(decodeKey(shortUrl));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
