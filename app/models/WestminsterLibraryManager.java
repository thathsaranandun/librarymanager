package models;

import java.util.ArrayList;

public class WestminsterLibraryManager implements LibraryManager {
    private int bookCount;
    private int DVDCount;
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<DVD> dvdList = new ArrayList<>();
    private ArrayList<Author> authorList = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private ArrayList<DVD> borrowedDVDs = new ArrayList<>();
    private ArrayList<Reader> readerList = new ArrayList<>();
    private String allBook="";
    private String allDVD="";



    public String getAllBook() {
        return allBook;
    }

    public String getAllDVD() {
        return allDVD;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public ArrayList<DVD> getDvdList() {
        return dvdList;
    }

    public ArrayList<Reader> getReaderList() {
        return readerList;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public ArrayList<DVD> getBorrowedDVDs() {
        return borrowedDVDs;
    }

    @Override
    public void addBook(String ISBN,String sector, String title,String authors,int numOfPages,String publisher) {
        if(bookCount<100) {
            boolean already=false;
            for(int i=0;i<bookList.size();i++){
                if(ISBN.equals(bookList.get(i).getISBN())){
                    already=true;
                }
            }
            if(!already) {
                bookList.add(new Book(bookCount + 1, "Available", new Reader(), ISBN, sector, title, authors, numOfPages, publisher));
                String[] allAuthors = bookList.get(bookList.size() - 1).getAuthors().split(",");
                for (int i = 0; i < allAuthors.length; i++) {
                    authorList.add(new Author(allAuthors[i]));
                }
                bookCount += 1;
            }
        }
    }

    @Override
    public void addDVD(String sector, String title,String language,String subtitles,String producer,String actors) {
        if(DVDCount<50) {
            dvdList.add(new DVD(DVDCount + 1, "available", new Reader(), sector, title, language, subtitles, producer,actors));
            DVDCount+=1;
        }

    }

    @Override
    public ArrayList<Book> displayAllBooks() {
        return bookList;

    }

    @Override
    public ArrayList<DVD> displayAllDVDs(){
        return dvdList;

    }

    @Override
    public void borrowBook(int bookID, String burrowDate, Reader reader) {
        bookList.get(bookID-1).setBurrowDate(burrowDate);
        bookList.get(bookID-1).setReader(reader);
        borrowedBooks.add(bookList.get(bookID-1));
        readerList.add(reader);
    }

    @Override
    public void borrowDVD(int dvdID, String burrowDate, Reader reader) {
        dvdList.get(dvdID-1).setBurrowDate(burrowDate);
        dvdList.get(dvdID-1).setReader(reader);
        borrowedDVDs.add(dvdList.get(dvdID-1));
        readerList.add(reader);
    }

    @Override
    public void removeBook(int bookIndex) {
        bookList.remove(bookIndex);

    }

    @Override
    public void removeDVD(int dvdIndex) {
        dvdList.remove(dvdIndex);

    }

    @Override
    public void returnBook(int bookID) {

        bookList.get(bookID-1).setBurrowDate("Available");
        bookList.get(bookID-1).setReader(new Reader());
        borrowedBooks.remove(bookID-1);
    }

    @Override
    public void returnDVD(int dvdID) {
        dvdList.get(dvdID-1).setBurrowDate("Available");
        dvdList.get(dvdID-1).setReader(new Reader());
        borrowedDVDs.remove(dvdID-1);

    }


    @Override
    public void generateList() {
        /*
        for (int i=0;i<burrowedBooks.size();i++){
            System.out.println("Book: "+ burrowedBooks.get(i).getTitle() +"  Date burrowed: "+ burrowedBooks.get(i).getBurrowDate().printDate());
        }
        */
    }
}