package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EditProfileData {
    public String firstName,lastName,gender,MobileNumber, idNumber,profilePhoto,currency;

    public void editProfileData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/editProfileData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject person = (JSONObject) object;

            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            gender = (String) person.get("gender");
            MobileNumber = (String) person.get("phone");
            idNumber = (String) person.get("phone");
            profilePhoto = (String) person.get("photo");
            currency = (String) person.get("currency");

        }
    }
}
