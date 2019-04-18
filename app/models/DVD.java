package models;

public class DVD extends LibraryItem {
    private String language;
    private String subtitles;
    private String producer;
    private String actors;
    private int dvdID;

    public DVD(int dvdID,String burrowDate, Reader reader, String sector, String title,String language,String subtitles,String producer,String actors) {
        super(burrowDate, reader, sector, title);
        this.language=language;
        this.subtitles=subtitles;
        this.producer=producer;
        this.actors=actors;
        this.dvdID=dvdID;
    }

    public String getLanguage() {
        return language;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public String getProducer() {
        return producer;
    }

    public String getActors() {
        return actors;
    }

    public int getDvdID() {
        return dvdID;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }
}