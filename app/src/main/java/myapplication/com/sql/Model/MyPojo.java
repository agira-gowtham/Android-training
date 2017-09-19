package myapplication.com.sql.Model;

import java.util.ArrayList;

/**
 * Created by root on 19/9/17.
 */

public class MyPojo {
    private ArrayList<Countries> countries;

    public ArrayList<Countries> getCountries ()
    {
        return countries;
    }

    public void setCountries (ArrayList<Countries> countries)
    {
        this.countries = countries;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [countries = "+countries+"]";
    }
}
