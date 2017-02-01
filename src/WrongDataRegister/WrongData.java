package WrongDataRegister;



/**
 *
 * @author elshan
 */
public class WrongData   {


private String Saygac;   
private String VLRkod;
private String VLRkod_description;
private String Wrong_data;   
private String Account_no;

    public String getSaygac() {
        return Saygac;
    }

    public void setSaygac(String Saygac) {
        this.Saygac = Saygac;
    }

    public String getVLRkod() {
        return VLRkod;
    }

    public void setVLRkod(String VLRkod) {
        this.VLRkod = VLRkod;
    }
    public String getVLRkod_description() {
        return VLRkod_description;
    }
    public void setVLRkod_description(String VLRkod_description) {
        this.VLRkod_description = VLRkod_description;
    }
    public String getWrong_data() {
        return Wrong_data;
    }

    public void setWrong_data(String Wrong_data) {
        this.Wrong_data = Wrong_data;
    }

    public String getAccount_no() {
        return Account_no;
    }

    public void setAccount_no(String Account_no) {
        this.Account_no = Account_no;
    }

    @Override
    public String toString() {
        return "WrongData{" + "Saygac=" + Saygac + ", VLRkod=" + VLRkod + ", VLRkod_description= "+ VLRkod_description + ", Wrong_data=" + Wrong_data + ", Account_no=" + Account_no + '}';
    }

   
   public void output(){
   System.out.println("GGGGG");
   }
       
 
    }
