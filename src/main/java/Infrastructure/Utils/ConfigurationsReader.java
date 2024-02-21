package Infrastructure.Utils;


public class ConfigurationsReader {

    /**
     * Return browser type from configuration file.
     */
    public String getBrowser(){
        return JsonReader.getValue("browser");
    }
    /**
     * Return base url type from configuration file.
     */
    public String getUrl(){
        return JsonReader.getValue("url");
    }
    /**
     * Return first name from configuration file.
     */
    public String getFirstName(){
        return JsonReader.getValue("firstName");
    }
    /**
     * Return last name from configuration file.
     */
    public String getLastName(){
        return JsonReader.getValue("lastName");
    }
    /**
     * Return email from configuration file.
     */
    public String getEmail(){
        return JsonReader.getValue("email");
    }
    /**
     * Return company name from configuration file.
     */
    public String getCompanyName(){
        return JsonReader.getValue("companyName");
    }
    /**
     * Return wrong email letter from configuration file.
     */
    public String getWrongEmailLetter(){
        return JsonReader.getValue("wrongEmailLetter");
    }
    /**
     * Return wrong email symbol from configuration file.
     */
    public String getWrongEmailSymbol(){
        return JsonReader.getValue("wrongEmailSymbol");
    }


}
