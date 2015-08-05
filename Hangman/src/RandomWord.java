import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class RandomWord {
	
	private int minCorpus;
	private int minLength;
	private int maxLength;
	
	RandomWord(int minCorpus, int minLength, int maxLength)
	{
		this.minCorpus = minCorpus;
		this.minLength = minLength;
		this.maxLength = maxLength;
	}
	
	public String getWord()
	{
		String word = null;
		String sURL = "http://api.wordnik.com:80/v4/words.json/randomWord?hasDictionaryDef=false"
				+ "&minCorpusCount=" + minCorpus + "&maxCorpusCount=-1&minDictionaryCount=1&maxDic"
				+ "tionaryCount=-1&minLength=" + minLength + "&maxLength=" + maxLength +"&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";	
		try 
		{
			URL url = new URL(sURL);
			HttpURLConnection  request = (HttpURLConnection) url.openConnection();
			request.connect();
			
			JsonParser parser = new JsonParser();
			JsonElement root = parser.parse(new InputStreamReader(request.getInputStream())); 
		    JsonObject rootobj = root.getAsJsonObject(); 
		    word = rootobj.get("word").getAsString();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return word;
		
		
	}

}
