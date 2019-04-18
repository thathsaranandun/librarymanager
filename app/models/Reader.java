package models;

public class Reader {
    private int readerID;
    private String name,mobileNo,email;

    public Reader(int readerID, String name, String mobileNo, String email) {
        this.readerID = readerID;
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    public Reader(){
        //no reader
    }

    public int getReaderID() {
        return readerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void burrowItem(LibraryItem item){
        LibraryItem burrowItem;
    }
}
