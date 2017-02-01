package CreditParts;


/**
 *
 * @author elshan
 */
public class Borrower {

    
    
    private String Saygac;
    private String id;
    private String name;
    private String CountryCode;
    private String BankruptcyStatus;
    private String DateOfBirth;
    private String PlaceOfBirth;
    private String PinCode;
    
    public Borrower(){}

    public Borrower(String Saygac,String id, String name, String CountryCode, String BankruptcyStatus, String DateOfBirth, String PlaceOfBirth, String PinCode) {
        this.Saygac = Saygac;
        this.id = id;
        this.name = name;
        this.CountryCode = CountryCode;
        this.BankruptcyStatus = BankruptcyStatus;
        this.DateOfBirth = DateOfBirth;
        this.PlaceOfBirth = PlaceOfBirth;
        this.PinCode = PinCode;
    }


    public String getSaygac() {
        return Saygac;
    }

    public void setSaygac(String Saygac) {
        this.Saygac = Saygac;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getBankruptcyStatus() {
        return BankruptcyStatus;
    }

    public void setBankruptcyStatus(String BankruptcyStatus) {
        this.BankruptcyStatus = BankruptcyStatus;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getPlaceOfBirth() {
        return PlaceOfBirth;
    }

    public void setPlaceOfBirth(String PlaceOfBirth) {
        this.PlaceOfBirth = PlaceOfBirth;
    }

    public String getPinCode() {
        return PinCode;
    }

    public void setPinCode(String PinCode) {
        this.PinCode = PinCode;
    }

    
    @Override
    public String toString() {
        return  Saygac +"~"
               +id +"~"
               + name +"~"
               + CountryCode +"~" 
               + BankruptcyStatus +"~" 
               + DateOfBirth +"~"
               + PlaceOfBirth +"~"
               + PinCode 
                ;
    }

    
    
}
