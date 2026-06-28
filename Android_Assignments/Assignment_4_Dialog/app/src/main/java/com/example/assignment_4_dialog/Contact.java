package com.example.assignment_4_dialog;
public class Contact {

    private String contactName;
    private String contactNumber;

    public Contact(){

        this.contactName="Contact1";
        this.contactNumber="1000";
    }

    public Contact(String cName,String cNumber){

        this.contactName=cName;
        this.contactNumber=cNumber;
    }


    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactName='" + contactName + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
