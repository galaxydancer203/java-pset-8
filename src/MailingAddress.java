import java.util.ArrayList;

public class MailingAddress {

    String primaryStreet;
    String secondaryStreet;
    String city;
    String state;
    String postalCode;

    public MailingAddress(String primaryStreet, String secondaryStreet, String city, String state, String postalCode) {
        this.primaryStreet = primaryStreet;
        this.secondaryStreet = secondaryStreet;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getPrimaryStreet(){
        if(this.primaryStreet != null){
            return this.primaryStreet;
        } else return null;
    }

    public String getSecondaryStreet(){
        if(this.secondaryStreet != null){
            return this.secondaryStreet;
        } else return null;
    }

    public String getPostalCode(){
        if(this.postalCode != null){
            return this.postalCode;
        } else return null;
    }

    public String getState(){
        if(this.state != null){
            return this.state;
        } else return null;
    }

    public String getCity(){
        if(this.city != null){
            return this.city;
        } else return null;
    }

    public String getFormattedAddress(){
        ArrayList<String> fullAddress = new ArrayList<String>();
        fullAddress.add(getPrimaryStreet());
        fullAddress.add(getSecondaryStreet());
        fullAddress.add(getCity());
        fullAddress.add(getState());
        fullAddress.add(getPostalCode());
        String notStringBuilder = "";
        notStringBuilder = fullAddress.get(0);
        for(int i=1; i<fullAddress.size(); i++){
            if(fullAddress.get(i) != null){
                notStringBuilder += ", " + fullAddress.get(i);
            }
        }
        return notStringBuilder;
    }

    public void setPrimaryStreet(String primaryStreet){
        this.primaryStreet = primaryStreet;
    }

    public void setSecondaryStreet(String secondaryStreet){
        this.secondaryStreet = secondaryStreet;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    public void setCity(String city){
        this.city = city;
    }
    public String validateStreet(String street){
        if (street != null && street.length() > 0){
            return street;
        } else return null;
    }

    public String validateCity(String city){
        if (city != null && city.length() > 0){
            return city;
        } else return null;
    }
    public String validatePostalCode(String postalCode){
        if (postalCode != null && postalCode.length() == 5){
            boolean notValid = true;
            for(int i=0; i<=5; i++){
                if(notValid && Character.isDigit(postalCode.charAt(i))){}
                else notValid = false;
            }
            if (notValid){
                return postalCode;
            } else return null;
        } else return null;
    }
}