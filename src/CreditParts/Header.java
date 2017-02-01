package CreditParts;

/**
 *
 * @author elshan
 */
public class Header {
    
    private String bankId;
    private String bankName;
    private String reportDate;
    

    public Header() {
       }

       public Header(String bankId, String bankName, String reportDate) {
              this.bankId = bankId;
              this.bankName = bankName;
              this.reportDate = reportDate;
       }


 
    public String getBankId() {
        return bankId;
    }
    public void setBankId(String bid) {
      //System.out.println("BankId >>>"+bid);
        this.bankId = bid;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bname) {
      //System.out.println("BankName >>>"+bname);
        this.bankName = bname;
    }
    public String getReportDate() {
        return reportDate;
    }
    public void setReportDate(String rdate) {
        this.reportDate = rdate;
    }
     
    @Override
    public String toString() {
       
        return "Header:: BankName=" + this.bankName + " Bank ID=" + this.bankId +" Report Date=" + this.reportDate;

    }
}
