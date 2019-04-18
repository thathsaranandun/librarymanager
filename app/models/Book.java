package models;

public class Book extends LibraryItem {
    private String authors;
    private int numOfPages;
    private String publisher;
    private String ISBN;
    private int bookID;

    public Book(int bookID,String  burrowDate, Reader reader,String ISBN, String sector, String title,String authors,int numOfPages,String publisher) {
        super(burrowDate, reader, sector, title);
        this.ISBN=ISBN;
        this.authors=authors;
        this.numOfPages=numOfPages;
        this.publisher=publisher;
        this.bookID=bookID;
    }

    public String getAuthors() {
        return authors;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getBookID() {
        return bookID;
    }
}
