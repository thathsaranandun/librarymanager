package models;

public abstract class LibraryItem {
    private String burrowDate;
    private Reader reader;
    private String sector;
    private String title;

    public LibraryItem(String burrowDate, Reader reader, String sector, String title) {
        this.burrowDate = burrowDate;
        this.reader = reader;
        this.sector = sector;
        this.title = title;
    }

    public String getBurrowDate() {
        return burrowDate;
    }

    public Reader getReader() {
        return reader;
    }

    public String getSector() {
        return sector;
    }

    public String getTitle() {
        return title;
    }

    public void setBurrowDate(String burrowDate) {
        this.burrowDate = burrowDate;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
