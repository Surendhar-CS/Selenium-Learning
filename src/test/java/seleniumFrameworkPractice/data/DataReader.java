package seleniumFrameworkPractice.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonData(String filename) throws IOException
	{
		
		
		File jsonfile=new File(System.getProperty("user.dir")+"\\src\\test\\java\\seleniumFrameworkPractice\\data\\"+filename);
		String JsonContent=FileUtils.readFileToString(jsonfile,StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){	});
		return data;
	}
}
