package CreditParts;


/**
 *
 * @author elshan
 */
public class CreditDetails {
    
    private String Saygac;

    
    private String AccountNo;
    private String CurrencyOfCredit;
    private String CreditType;
    private String InitialAmountOfCredit;
    private String CreditLineAmount;
    private String DisoutAmountOfCredit;
    private String AnnualInterestRate;
    private String PurposeOfCredit;
    private String CreditPeriodInMonths;
    private String DateOfGrant;
    private String DueTimeFirstContract;
    private String DueTimeLastContract;
    private String LastPaymentDate;
    private String MonthlyPaymentAmount;
    private String DaysMainSumIsOverdue;
    private String DaysInterestIsOverdue;
    private String OiaForRepperiod;
    private String NumberOfProlongs;
    private String CreditClassCode;

    
    private String CreditStatusCode;
    
    public CreditDetails() {
       }
    
    

    public CreditDetails(String Saygac,String AccountNo, String CurrencyOfCredit, String CreditType, String InitialAmountOfCredit, String CreditLineAmount, String DisoutAmountOfCredit, String AnnualInterestRate, String PurposeOfCredit, String CreditPeriodInMonths, String DateOfGrant, String DueTimeFirstContract, String DueTimeLastContract, String LastPaymentDate, String MonthlyPaymentAmount, String DaysMainSumIsOverdue, String DaysInterestIsOverdue, String OiaForRepperiod, String NumberOfProlongs, String CreditStatusCode, String CreditClassCode) {
        this.Saygac=Saygac;
        this.AccountNo = AccountNo;
        this.CurrencyOfCredit = CurrencyOfCredit;
        this.CreditType = CreditType;
        this.InitialAmountOfCredit = InitialAmountOfCredit;
        this.CreditLineAmount = CreditLineAmount;
        this.DisoutAmountOfCredit = DisoutAmountOfCredit;
        this.AnnualInterestRate = AnnualInterestRate;
        this.PurposeOfCredit = PurposeOfCredit;
        this.CreditPeriodInMonths = CreditPeriodInMonths;
        this.DateOfGrant = DateOfGrant;
        this.DueTimeFirstContract = DueTimeFirstContract;
        this.DueTimeLastContract = DueTimeLastContract;
        this.LastPaymentDate = LastPaymentDate;
        this.MonthlyPaymentAmount = MonthlyPaymentAmount;
        this.DaysMainSumIsOverdue = DaysMainSumIsOverdue;
        this.DaysInterestIsOverdue= DaysInterestIsOverdue;
        this.OiaForRepperiod = OiaForRepperiod;
        this.NumberOfProlongs = NumberOfProlongs;
        this.CreditStatusCode = CreditStatusCode;
        this.CreditClassCode = CreditClassCode;
        
    }


    public String getSaygac() {
        return Saygac;
    }

    public void setSaygac(String Saygac) {
        this.Saygac = Saygac;
    }
    
    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String AccountNo) {
        this.AccountNo = AccountNo;
    }

    public String getCurrencyOfCredit() {
        return CurrencyOfCredit;
    }

    public void setCurrencyOfCredit(String CurrencyOfCredit) {
        this.CurrencyOfCredit = CurrencyOfCredit;
    }

    public String getCreditType() {
        return CreditType;
    }

    public void setCreditType(String CreditType) {
        this.CreditType = CreditType;
    }

    public String getInitialAmountOfCredit() {
        return InitialAmountOfCredit;
    }

    public void setInitialAmountOfCredit(String InitialAmountOfCredit) {
        this.InitialAmountOfCredit = InitialAmountOfCredit;
    }

    public String getCreditLineAmount() {
        return CreditLineAmount;
    }

    public void setCreditLineAmount(String CreditLineAmount) {
        this.CreditLineAmount = CreditLineAmount;
    }

    public String getDisoutAmountOfCredit() {
        return DisoutAmountOfCredit;
    }

    public void setDisoutAmountOfCredit(String DisoutAmountOfCredit) {
        this.DisoutAmountOfCredit = DisoutAmountOfCredit;
    }

    public String getAnnualInterestRate() {
        return AnnualInterestRate;
    }

    public void setAnnualInterestRate(String AnnualInterestRate) {
        this.AnnualInterestRate = AnnualInterestRate;
    }

    public String getPurposeOfCredit() {
        return PurposeOfCredit;
    }

    public void setPurposeOfCredit(String PurposeOfCredit) {
        this.PurposeOfCredit = PurposeOfCredit;
    }

    public String getCreditPeriodInMonths() {
        return CreditPeriodInMonths;
    }

    public void setCreditPeriodInMonths(String CreditPeriodInMonths) {
        this.CreditPeriodInMonths = CreditPeriodInMonths;
    }

    public String getDateOfGrant() {
        return DateOfGrant;
    }

    public void setDateOfGrant(String DateOfGrant) {
        this.DateOfGrant = DateOfGrant;
    }

    public String getDueTimeFirstContract() {
        return DueTimeFirstContract;
    }

    public void setDueTimeFirstContract(String DueTimeFirstContract) {
        this.DueTimeFirstContract = DueTimeFirstContract;
    }

    public String getDueTimeLastContract() {
        return DueTimeLastContract;
    }

    public void setDueTimeLastContract(String DueTimeLastContract) {
        this.DueTimeLastContract = DueTimeLastContract;
    }

    public String getLastPaymentDate() {
        return LastPaymentDate;
    }

    public void setLastPaymentDate(String LastPaymentDate) {
        this.LastPaymentDate = LastPaymentDate;
    }

    public String getMonthlyPaymentAmount() {
        return MonthlyPaymentAmount;
    }

    public void setMonthlyPaymentAmount(String MonthlyPaymentAmount) {
        this.MonthlyPaymentAmount = MonthlyPaymentAmount;
    }

    public String getDaysMainSumIsOverdue() {
        return DaysMainSumIsOverdue;
    }

    public void setDaysMainSumIsOverdue(String DaysMainSumIsOverdue) {
        this.DaysMainSumIsOverdue = DaysMainSumIsOverdue;
    }

    public String getDaysInterestIsOverdue() {
        return DaysInterestIsOverdue;
    }

    public void setDaysInterestIsOverdue(String DaysInterestIsOverdue) {
        this.DaysInterestIsOverdue = DaysInterestIsOverdue;
    }
    
    public String getOiaForRepperiod() {
        return OiaForRepperiod;
    }

    public void setOiaForRepperiod(String OiaForRepperiod) {
        this.OiaForRepperiod = OiaForRepperiod;
    }

    public String getNumberOfProlongs() {
        return NumberOfProlongs;
    }

    public void setNumberOfProlongs(String NumberOfProlongs) {
        this.NumberOfProlongs = NumberOfProlongs;
    }

    public String getCreditStatusCode() {
        return CreditStatusCode;
    }

    public void setCreditStatusCode(String CreditStatusCode) {
        this.CreditStatusCode = CreditStatusCode;
    }
    
    public String getCreditClassCode() {
        return CreditClassCode;
    }

    public void setCreditClassCode(String CreditClassCode) {
        this.CreditClassCode = CreditClassCode;
    }
    
        @Override
    public String toString() {
        return "Saygac="+Saygac+", AccountNo=" 
                + AccountNo + ", CurrencyOfCredit=" 
                + CurrencyOfCredit + ", CreditType=" 
                + CreditType + ", InitialAmountOfCredit=" 
                + InitialAmountOfCredit + ", CreditLineAmount=" 
                + CreditLineAmount + ", DisoutAmountOfCredit=" 
                + DisoutAmountOfCredit + ", AnnualInterestRate=" 
                + AnnualInterestRate + ", PurposeOfCredit=" 
                + PurposeOfCredit + ", CreditPeriodInMonths=" 
                + CreditPeriodInMonths + ", DateOfGrant=" 
                + DateOfGrant + ", DueTimeFirstContract=" 
                + DueTimeFirstContract + ", DueTimeLastContract=" 
                + DueTimeLastContract + ", LastPaymentDate=" 
                + LastPaymentDate + ", MonthlyPaymentAmount=" 
                + MonthlyPaymentAmount + ", DaysMainSumIsOverdue=" 
                + DaysMainSumIsOverdue + ", DaysInterestIsOverdue="
                + DaysInterestIsOverdue + ", OiaForRepperiod="
                + OiaForRepperiod + ", NumberOfProlongs=" 
                + NumberOfProlongs + ", CreditStatusCode=" 
                + CreditStatusCode +  ", CreditClassCode="
                + CreditClassCode;
    }
}
