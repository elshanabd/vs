package CreditParts;

/**
 *
 * @author elshan
 */
public class Collateral {

    private String Saygac;


    private String CollateralTypeCode;
    private String AnyInfoToDisting;
    private String MarketValue;
    private String RegistryNo;
    private String RegistryDate;
    private String RegistryAgency;
    
     public Collateral() {
       }

       public Collateral(String Saygac,String CollateralTypeCode, String AnyInfoToDisting, String MarketValue, 
               String RegistryNo, String RegistryAgency) {
           
              this.Saygac = Saygac;  
              this.CollateralTypeCode = CollateralTypeCode;
              this.AnyInfoToDisting = AnyInfoToDisting;
              this.MarketValue = MarketValue;
              this.RegistryNo = RegistryNo;
              this.RegistryDate = RegistryDate;
              this.RegistryAgency = RegistryAgency;
       }

    public String getSaygac() {
        return Saygac;
    }

    public void setSaygac(String Saygac) {
        this.Saygac = Saygac;
    }

    public String getCollateralTypeCode() {
        return CollateralTypeCode;
    }

    public String getAnyInfoToDisting() {
        return AnyInfoToDisting;
    }

    public String getMarketValue() {
        return MarketValue;
    }

    public String getRegistryNo() {
        return RegistryNo;
    }

    public String getRegistryDate() {
        return RegistryDate;
    }

    public String getRegistryAgency() {
        return RegistryAgency;
    }
    

    public void setCollateralTypeCode(String CollateralTypeCode) {
        this.CollateralTypeCode = CollateralTypeCode;
    }

    public void setAnyInfoToDisting(String AnyInfoToDisting) {
        this.AnyInfoToDisting = AnyInfoToDisting;
    }

    public void setMarketValue(String MarketValue) {
        this.MarketValue = MarketValue;
    }

    public void setRegistryNo(String RegistryNo) {
        this.RegistryNo = RegistryNo;
    }

    public void setRegistryDate(String RegistryDate) {
        this.RegistryDate = RegistryDate;
    }

    public void setRegistryAgency(String RegistryAgency) {
        this.RegistryAgency = RegistryAgency;
    }
    
     @Override
    public String toString() {
        return Saygac+"~"
               +CollateralTypeCode + "~" 
               + AnyInfoToDisting + "~" 
               + MarketValue + "~" 
               + RegistryNo + "~" 
               + RegistryDate + "~" 
               + RegistryAgency
               ;
    }

    
    
    
}
