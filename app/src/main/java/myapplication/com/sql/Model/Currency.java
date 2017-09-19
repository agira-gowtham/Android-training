package myapplication.com.sql.Model;

/**
 * Created by root on 19/9/17.
 */

public class Currency {
    private String code;

    private String currencyname;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getCurrencyname ()
    {
        return currencyname;
    }

    public void setCurrencyname (String currencyname)
    {
        this.currencyname = currencyname;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [code = "+code+", currencyname = "+currencyname+"]";
    }
}
