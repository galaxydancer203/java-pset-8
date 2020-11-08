public class AccountOwner {
    private String salutation;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private long phoneNumber;
    private MailingAddress mailingAddress;

    public AccountOwner(String salutation, String firstName, String lastName, String emailAddress, long phoneNumber, MailingAddress mailingAddress){
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;
    }


    public String getSalutation(){
        if(this.salutation != null){
            return this.salutation;
        } else return null;
    }

    public String getFirstName(){
        if(this.firstName != null){
            return this.firstName;
        } else return null;
    }

    public String getLastName(){
        if(this.lastName != null){
            return this.lastName;
        } else return null;
    }

    public String getEmailAddress(){
        if(this.emailAddress != null){
            return this.emailAddress;
        } else return null;
    }

    public long getPhoneNumber(){
        return this.phoneNumber;
    }

    public MailingAddress getMailingAddress(){
        return this.mailingAddress;
    }

    public String getFormattedPhoneNumber(){
        String part1 = "";
        String part2 = "";
        String part3 = "";
        String stringed = String.valueOf(this.phoneNumber);

        for(int i=0; i<3; i++){
            part1 += stringed.charAt(i);
        }
        for(int i=3; i<6; i++){
            part2 += stringed.charAt(i);
        }
        for(int i=6; i<10; i++){
            part3 += stringed.charAt(i);
        }

        return "(" + part1 + ") " + part2 + "-" + part3;
    }

    public String getName(int format){
        switch(format){
            case 1:
                return getFirstName() + " " + getLastName();
            case 2:
                return getSalutation() + ". " + getLastName();
            case 3:
                return getLastName() + ", " + getFirstName();
            default:
                return getFirstName() + " " + getLastName();
        }
    }


    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setMailingAddress(MailingAddress mailingAddress){
        this.mailingAddress = mailingAddress;
    }

    public void setSalutation(String salutation){
        this.salutation = salutation;
    }

    // TODO: make clever social media joke

    public String validateEmailAddress(String emailAddress){
        if (!(emailAddress.length() < 7) ||
                !(emailAddress.length() > 254) ||
                !(emailAddress.contains("@")) ||
                !(emailAddress.contains(".")) ||
                !(emailAddress.charAt(0) == '@') ||
                !(emailAddress.charAt(emailAddress.length() - 1) == '@') ||
                !(emailAddress.charAt(0) == '.') ||
                !(emailAddress.charAt(emailAddress.length() - 1) == '.') ||
                (emailAddress.indexOf(".") < emailAddress.indexOf("@") - 1) ||
                (emailAddress.length() - 1 - emailAddress.lastIndexOf(".") != 3)
        ){
            return null;
        } else return emailAddress;
    }

    public long validatePhoneNumber(long phoneNumber){
        String compareMe = String.valueOf(phoneNumber);
        if (compareMe.length() == 10){
            return phoneNumber;
        } else return 0L;
    }

    public String validateSalutation(String salutation){
        if (salutation != null && salutation.length() != 0){
            return salutation;
        } else return null;
    }
}