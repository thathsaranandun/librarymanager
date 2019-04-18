import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-search-book',
  templateUrl: './search-book.component.html',
  styleUrls: ['./search-book.component.css']
})
export class SearchBookComponent implements OnInit {

  book:boolean=false;
  dvd:boolean=false;

  searchBookTitle:string="";
  searchDVDTitle:string="";

  searchedBook:boolean=false;
  bookISBN:string="";
  bookSector:string="";
  bookTitle:string="";
  bookAuthors:string="";
  bookPages:string="";
  bookPublisher:string="";


  searchedDVD:boolean=false;
  dvdID:string="";
  dvdSector:string="";
  dvdTitle:string="";
  dvdLang:string="";
  dvdSubt:string="";
  dvdProd:string="";
  dvdActors:string="";

  constructor(private appService:AppService) {

  }


  ngOnInit() {
  }

  public searchBook():void{
    if(this.searchBookTitle!="") {
      this.appService.searchBook(this.searchBookTitle).subscribe((data: any) => {
        this.bookISBN=data.searchedBookISBN;
        this.bookSector=data.searchedBookSector;
        this.bookTitle=data.searchedBookTitle;
        this.bookAuthors=data.searchedBookAuthors;
        this.bookPages=data.searchedBookPages;
        this.bookPublisher=data.searchedBookPublisher;
        this.searchedBook=true;
      });
      this.searchBookTitle="";
    }else {
      alert("Please enter the Title of the book you want to search.");
    }
  }

  public searchDVD():void{
    if(this.searchDVDTitle!="") {
      this.appService.searchDVD(this.searchDVDTitle).subscribe((data: any) => {
        this.dvdSector=data.searchedDVDSector;
        this.dvdTitle=data.searchedDVDTitle;
        this.dvdLang=data.searchedDVDLang;
        this.dvdSubt=data.searchedDVDsubt;
        this.dvdProd=data.searchedDVDprod;
        this.dvdActors=data.searchedDVDactors;
        this.searchedDVD=true;
      });
      this.searchDVDTitle="";
    }else {
      alert("Please enter the Title of the DVD you want to search.");
    }
  }


}
