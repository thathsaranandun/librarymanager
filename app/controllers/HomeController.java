package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.libs.Json;
import play.mvc.*;


class AppSummary {
    private String content;
    private String name;

    private WestminsterLibraryManager library = new WestminsterLibraryManager();
    private int bookCount=0;
    private int dvdCount=0;
    private String bookName="";
    private String dvdName="";


    private String borrowedBook="";
    private String borrowedBookTitle="";
    private String borrowedBookSector="";
    private String borrowedBookAuthors="";
    private String borrowedBookPages="";
    private String borrowedBookPublisher="";


    private String borrowedDVDID="";
    private String borrowedDVDSector="";
    private String borrowedDVDTitle="";
    private String borrowedDVDLang="";
    private String borrowedDVDSubt="";
    private String borrowedDVDProd="";
    private String borrowedDVDActors="";

    private String searchedBookISBN="";
    private String searchedBookSector="";
    private String searchedBookTitle="";
    private String searchedBookAuthors="";
    private String searchedBookPages="";
    private String searchedBookPublisher="";

    private String searchedDVDSector="";
    private String searchedDVDTitle="";
    private String searchedDVDLang="";
    private String searchedDVDsubt="";
    private String searchedDVDprod="";
    private String searchedDVDactors="";

    public WestminsterLibraryManager getLibrary() {
        return library;
    }

    public String getSearchedDVDSector() {        return searchedDVDSector;    }

    public String getSearchedDVDTitle() {        return searchedDVDTitle;    }

    public String getSearchedDVDLang() {        return searchedDVDLang;    }

    public String getSearchedDVDsubt() {        return searchedDVDsubt;    }

    public String getSearchedDVDprod() {        return searchedDVDprod;    }

    public String getSearchedDVDactors() {        return searchedDVDactors;    }

    public String getSearchedBookISBN() {        return searchedBookISBN;    }

    public String getSearchedBookSector() {        return searchedBookSector;    }

    public String getSearchedBookTitle() {        return searchedBookTitle;    }

    public String getSearchedBookAuthors() {        return searchedBookAuthors;    }

    public String getSearchedBookPages() {        return searchedBookPages;    }

    public String getSearchedBookPublisher() {        return searchedBookPublisher;    }

    public String getBorrowedDVDID() {        return borrowedDVDID;    }

    public String getBorrowedDVDSector() {        return borrowedDVDSector;    }

    public String getBorrowedDVDTitle() {        return borrowedDVDTitle;    }

    public String getBorrowedDVDLang() {        return borrowedDVDLang;    }

    public String getBorrowedDVDSubt() {        return borrowedDVDSubt;    }

    public String getBorrowedDVDProd() {        return borrowedDVDProd;    }

    public String getBorrowedDVDActors() {        return borrowedDVDActors;    }

    public String getBorrowedBookTitle() {        return borrowedBookTitle;    }

    public String getBorrowedBookSector() {        return borrowedBookSector;    }

    public String getBorrowedBookAuthors() {        return borrowedBookAuthors;    }

    public String getBorrowedBookPages() {        return borrowedBookPages;    }

    public String getBorrowedBookPublisher() {        return borrowedBookPublisher;    }

    public String getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(String borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public String getDvdName() {
        return dvdName;
    }

    public void setDvdName(String dvdName) {
        this.dvdName = dvdName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }




    public int getDvdCount() {
        return dvdCount;
    }

    public void setDvdCount(int dvdCount) {
        this.dvdCount = dvdCount;
    }


    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void sendBook(WestminsterLibraryManager library){
        this.library=library;
        bookCount=library.getBookList().size();


    }

    public void sendDVD(WestminsterLibraryManager library){
        this.library=library;
        dvdCount=library.getDvdList().size();

    }

    public void borrowedBook(WestminsterLibraryManager library){
        this.library=library;
        Book book=library.getBorrowedBooks().get(library.getBorrowedBooks().size()-1);
        borrowedBook= book.getISBN();
        borrowedBookSector=book.getSector();
        borrowedBookTitle=book.getTitle();
        borrowedBookAuthors=book.getAuthors();
        borrowedBookPages=Integer.toString(book.getNumOfPages());
        borrowedBookPublisher=book.getPublisher();
    }

    public void borrowedDVD(WestminsterLibraryManager library){
        this.library=library;
        DVD dvd = library.getBorrowedDVDs().get(library.getBorrowedDVDs().size()-1);
        borrowedDVDID=Integer.toString(dvd.getDvdID());
        borrowedDVDSector=dvd.getSector();
        borrowedDVDTitle=dvd.getTitle();
        borrowedDVDLang=dvd.getLanguage();
        borrowedDVDSubt=dvd.getLanguage();
        borrowedDVDProd=dvd.getProducer();
        borrowedDVDActors=dvd.getActors();

    }

    public void searchedBook(WestminsterLibraryManager library,int bookID){
        this.library=library;
        Book book=library.getBookList().get(bookID-1);
        searchedBookISBN= book.getISBN();
        searchedBookSector=book.getSector();
        searchedBookTitle=book.getTitle();
        searchedBookAuthors=book.getAuthors();
        searchedBookPages=Integer.toString(book.getNumOfPages());
        searchedBookPublisher=book.getPublisher();
    }

    public void searchedDVD(WestminsterLibraryManager library,int dvdID){
        this.library=library;
        DVD dvd=library.getDvdList().get(dvdID-1);
        searchedDVDSector=dvd.getSector();
        searchedDVDTitle=dvd.getTitle();
        searchedDVDLang=dvd.getLanguage();
        searchedDVDsubt=dvd.getSubtitles();
        searchedDVDprod=dvd.getProducer();
        searchedDVDactors=dvd.getActors();
    }

    public void update(WestminsterLibraryManager library){
        this.library=library;
    }
}

public class HomeController extends Controller {


    private AppSummary appSummary = new AppSummary();
    private WestminsterLibraryManager library = new WestminsterLibraryManager();

    private boolean firstLoad=true;




    public Result appSummary() {
        appSummary.setContent("Welcome to Westminster Library Manager!");
        /*if(firstLoad) {
            library.addBook("xxx-x-xx-xxxxxx-0","IT", "Geek4Geek", "Geek", 100, new Publisher("Geek Publications"));
            //appSummary.sendBook(library);
            library.addBook("xxx-x-xx-xxxxxx-1","Science","AsapScience","Mr.Nerd",500,new Publisher("Polar Publishers"));
            //appSummary.sendBook(library);
            library.addBook("xxx-x-xx-xxxxxx-2","Fiction","Harry Potter","J.K.Rowling",200,new Publisher("Penguin"));
            //appSummary.sendBook(library);
            library.addBook("xxx-x-xx-xxxxxx-3","Fiction","Batman","Goblin",200,new Publisher("Bat publications"));
            //appSummary.sendBook(library);
            library.addDVD("Cartoon","Naruto","Japanese","English","TokyoTv","Naruto, Sasuke");
            //appSummary.sendDVD(library);
            library.addDVD("Movie","Thor","English","English","Marvel","Thor");
            //appSummary.sendDVD(library);
            firstLoad=false;

        }*/
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");
    }

    public Result loadBooks(){

        JsonNode jsonNode=Json.toJson(appSummary.getLibrary().displayAllBooks());
        return ok(jsonNode).as("application/json");

    }

    public Result loadDVDs(){
        if(firstLoad && library.getDvdList().size()==0) {

            library.addDVD("Cartoon","Naruto","Japanese","English","TokyoTv","Naruto, Sasuke");
            appSummary.sendDVD(library);
            library.addDVD("Movie","Thor","English","English","Marvel","Thor");
            appSummary.sendDVD(library);
            firstLoad=false;


        }
        JsonNode jsonNode=Json.toJson(appSummary.getLibrary().getDvdList());
        return ok(jsonNode).as("application/json");
    }


    public Result reportBooks(){

        JsonNode jsonNode=Json.toJson(appSummary.getLibrary().getBorrowedBooks());
        return ok(jsonNode).as("application/json");
    }

    public Result reportDVDs(){

        JsonNode jsonNode=Json.toJson(appSummary.getLibrary().getBorrowedDVDs());
        return ok(jsonNode).as("application/json");
    }



    public Result postBook() {

        JsonNode body=request().body().asJson();
        String bookISBN=body.get("bookISBN").asText();
        String bookSector=body.get("bookSector").asText();
        String bookTitle =body.get("bookTitle").asText();
        String bookAuthors=body.get("bookAuthors").asText();
        String bookPages=body.get("bookPages").asText();
        String bookPublisher=body.get("bookPublisher").asText();

        library.addBook(bookISBN,bookSector,bookTitle,bookAuthors,Integer.valueOf(bookPages),bookPublisher);
        appSummary.sendBook(library);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");


    }


    public Result postDVD() {

        JsonNode body=request().body().asJson();
        String dvdSector=body.get("dvdSector").asText();
        String dvdTitle =body.get("dvdTitle").asText();
        String dvdLanguage=body.get("dvdLanguage").asText();
        String dvdSubtitles=body.get("dvdSubtitles").asText();
        String dvdProducer=body.get("dvdProducer").asText();
        String dvdActors=body.get("dvdActors").asText();


        library.addDVD(dvdSector,dvdTitle,dvdLanguage,dvdSubtitles,dvdProducer,dvdActors);
        appSummary.sendDVD(library);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");

    }

    public Result borrowBook(){
        JsonNode body=request().body().asJson();
        String bookISBN=body.get("bookISBN").asText();
        String borrower =body.get("borrower").asText();
        String mobileNo=body.get("mobileNo").asText();
        String email=body.get("email").asText();
        String borrowDate=body.get("borrowDate").asText();
        String borrowTime=body.get("borrowTime").asText();

        int bookID;
        for(int i=0;i<library.getBookList().size();i++){
            if(bookISBN.equals(library.getBookList().get(i).getISBN())){
                bookID=i+1;
                library.borrowBook(bookID,borrowDate,new Reader(library.getReaderList().size(),borrower,mobileNo,email));
            }
        }

        appSummary.borrowedBook(library);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");
    }

    public Result borrowDVD(){
        JsonNode body=request().body().asJson();
        String dvdID=body.get("dvdID").asText();
        String borrower =body.get("borrower").asText();
        String mobileNo=body.get("mobileNo").asText();
        String email=body.get("email").asText();
        String borrowDate=body.get("borrowDate").asText();
        String borrowTime=body.get("borrowTime").asText();

        int dvdListID;
        for(int i=0;i<library.getDvdList().size();i++){
            if(Integer.valueOf(dvdID)==library.getDvdList().get(i).getDvdID()){
                dvdListID=i+1;
                library.borrowDVD(dvdListID,borrowDate,new Reader(library.getReaderList().size(),borrower,mobileNo,email));
            }
        }

        appSummary.borrowedDVD(library);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");

    }
    public Result returnBook(){
        JsonNode body=request().body().asJson();
        String isbn=body.get("isbn").asText();
        String returnDate=body.get("returnDate").asText();
        String returnTime=body.get("returnTime").asText();

        int bookID;
        for(int i=0;i<library.getBookList().size();i++){
            if(isbn.equals(library.getBookList().get(i).getISBN())){
                bookID=i+1;
                library.returnBook(bookID);
            }
        }
        appSummary.update(library);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");

    }

    public Result returnDVD(){
        JsonNode body=request().body().asJson();
        String dvdID=body.get("dvdID").asText();
        String returnDate=body.get("returnDate").asText();
        String returnTime=body.get("returnTime").asText();

        int dvdListID;
        for(int i=0;i<library.getDvdList().size();i++){
            if(Integer.valueOf(dvdID)==library.getDvdList().get(i).getDvdID()){
                dvdListID=i+1;
                library.returnDVD(dvdListID);
            }
        }
        appSummary.update(library);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");

    }

    public Result deleteBook(){
        JsonNode body=request().body().asJson();
        String bookID=body.get("bookID").asText();


        appSummary.setBookCount(appSummary.getBookCount()-1);
        library.removeBook(Integer.valueOf(bookID)-1);
        appSummary.update(library);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");

    }

    public Result deleteDVD(){
        JsonNode body=request().body().asJson();
        String dvdID=body.get("dvdID").asText();


        appSummary.setDvdCount(appSummary.getDvdCount()-1);
        library.removeDVD(Integer.valueOf(dvdID)-1);
        appSummary.update(library);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");

    }

    public Result searchBook(){
        JsonNode body=request().body().asJson();
        String bookTitle=body.get("bookTitle").asText();


        int bookID=101;
        for(int i=0;i<library.getBookList().size();i++){
            if(bookTitle.equals(library.getBookList().get(i).getTitle())){
                bookID=i+1;
            }
        }

        appSummary.searchedBook(library,bookID);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");
    }

    public Result searchDVD(){
        JsonNode body=request().body().asJson();
        String dvdTitle=body.get("dvdTitle").asText();


        int dvdListID=51;
        for(int i=0;i<library.getDvdList().size();i++){
            if(dvdTitle.equals(library.getDvdList().get(i).getTitle())){
                dvdListID=i+1;
            }
        }

        appSummary.searchedDVD(library,dvdListID);
        JsonNode jsonNode = Json.toJson(appSummary);
        return ok(jsonNode).as("application/json");
    }


}
