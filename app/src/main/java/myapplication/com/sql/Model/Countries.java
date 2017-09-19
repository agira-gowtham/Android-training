package myapplication.com.sql.Model;

import java.util.Currency;

/**
 * Created by root on 19/9/17.
 */

public class Countries {
    private String flag;

    private String countryname;

    private String language;

    private String capital;

    private Currency currency;

    public String getFlag ()
    {
        return flag;
    }

    public void setFlag (String flag)
    {
        this.flag = flag;
    }

    public String getCountryname ()
    {
        return countryname;
    }

    public void setCountryname (String countryname)
    {
        this.countryname = countryname;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getCapital ()
    {
        return capital;
    }

    public void setCapital (String capital)
    {
        this.capital = capital;
    }

    public Currency getCurrency ()
    {
        return currency;
    }

    public void setCurrency (Currency currency)
    {
        this.currency = currency;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [flag = "+flag+", countryname = "+countryname+", language = "+language+", capital = "+capital+", currency = "+currency+"]";
    }

}
