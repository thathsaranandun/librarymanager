package models;

import java.util.ArrayList;

public interface LibraryManager {

    void addBook(String ISBN,String sector, String title,String authors,int numOfPages,String publisher);
    void addDVD(String sector, String title,String language,String subtitles,String producer,String actors);
    void removeBook(int bookID);
    void removeDVD(int dvdID);
    ArrayList<Book> displayAllBooks();
    ArrayList<DVD> displayAllDVDs();
    void borrowBook(int bookID, String burrowDate, Reader reader);
    void borrowDVD(int dvdID, String burrowDate, Reader reader);
    void returnBook(int bookID);
    void returnDVD(int dvdID);
    void generateList();

}
