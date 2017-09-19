package myapplication.com.sql;

/**
 * Created by root on 18/9/17.
 */

public class AndroidVersion {
    private String version;
    private String name;
    private String api;

    public void setVersion(String version) {
        this.version = version;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public String getApi() {
        return api;
    }

    public String getName() {
        return name;
    }
}
