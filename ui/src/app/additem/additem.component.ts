import { Component, OnInit } from '@angular/core';


import {AppService} from "../app.service";

@Component({
  selector: 'app-additem',
  templateUrl: './additem.component.html',
  styleUrls: ['./additem.component.css']
})
export class AdditemComponent implements OnInit {

  book:boolean=false;
  dvd:boolean=false;

  bookISBN:string="";
  bookSector:string="";
  bookTitle:string="";
  bookAuthors:string="";
  bookPages:string="";
  bookPublisher:string="";

  dvdSector:string="";
  dvdTitle:string="";
  dvdLanguage:string="";
  dvdSubtitles:string="";
  dvdProducer:string="";
  dvdActors:string="";



  constructor(private appService:AppService) { }

  ngOnInit() {

  }


  public addBook(): void {
    if(this.bookISBN!="" && this.bookSector!="" && this.bookTitle!="" && this.bookAuthors!="" && this.bookPages!="" && this.bookPublisher!="") {
      this.appService.sendBookData(this.bookISBN,this.bookSector, this.bookTitle, this.bookAuthors, this.bookPages, this.bookPublisher).subscribe((data: any) => {
      });
      this.bookISBN="";
      this.bookSector="";
      this.bookTitle="";
      this.bookAuthors="";
      this.bookPages="";
      this.bookPublisher="";
      alert("Book added successfully.");
    }else {
      alert("All fields must be filled. Please insert all the details.");
    }
  }

  public addDVD(): void {
    if(this.dvdSector!="" && this.dvdTitle!="" && this.dvdLanguage!="" && this.dvdSubtitles!="" && this.dvdProducer!="" && this.dvdActors!="") {
      this.appService.sendDVDData(this.dvdSector, this.dvdTitle, this.dvdLanguage, this.dvdSubtitles, this.dvdProducer, this.dvdActors).subscribe((data: any) => {
      });
      this.dvdSector="";
      this.dvdTitle="";
      this.dvdLanguage="";
      this.dvdSubtitles="";
      this.dvdProducer="";
      this.dvdActors="";
      alert("DVD added successfully.")
    }else {
      alert("All fields must be filled. Please insert all the details.")
    }
  }


}
