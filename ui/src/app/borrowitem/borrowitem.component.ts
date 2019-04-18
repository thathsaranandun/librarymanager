import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-borrowitem',
  templateUrl: './borrowitem.component.html',
  styleUrls: ['./borrowitem.component.css']
})
export class BorrowitemComponent implements OnInit {


  book:boolean=false;
  dvd:boolean=false;


  bookISBN:string="";
  dvdID:string="";
  borrower:string="";
  mobileNo:string="";
  email:string="";
  borrowDate:string="";
  borrowTime:string="";


  borrowedBook:boolean=false;
  borrowedBookISBN:string="";
  borrowedBookSector:string="";
  borrowedBookTitle:string="";
  borrowedBookAuthors:string="";
  borrowedBookPages:string="";
  borrowedBookPublisher:string="";


  borrowedDVD:boolean=false;
  borrowedDVDID:string="";
  borrowedDVDSector:string="";
  borrowedDVDTitle:string="";
  borrowedDVDLang:string="";
  borrowedDVDSubt:string="";
  borrowedDVDProd:string="";
  borrowedDVDActors:string="";


  constructor(private appService:AppService) { }

  ngOnInit() {
  }

  public borrowBook():void{
    if(this.bookISBN!="" && this.borrower!="" && this.mobileNo!="" && this.email!="" && this.borrowDate!="" && this.borrowTime!="") {
      this.appService.borrowBook(this.bookISBN,this.borrower, this.mobileNo, this.email, this.borrowDate, this.borrowTime).subscribe((data: any) => {
        this.borrowedBookISBN=data.borrowedBook;
        this.borrowedBookSector=data.borrowedBookSector;
        this.borrowedBookTitle=data.borrowedBookTitle;
        this.borrowedBookAuthors=data.borrowedBookAuthors;
        this.borrowedBookPages=data.borrowedBookPages;
        this.borrowedBookPublisher=data.borrowedBookPublisher;
        this.borrowedBook=true;


      });
      this.bookISBN="";
      this.borrower="";
      this.mobileNo="";
      this.email="";
      this.borrowDate="";
      this.borrowTime="";
      alert("Book borrowed successfully.");
    }else {
      alert("All fields must be filled. Please insert all the details.");
    }

  }

  public borrowDVD():void{
    if(this.dvdID!="" && this.borrower!="" && this.mobileNo!="" && this.email!="" && this.borrowDate!="" && this.borrowTime!="") {
      this.appService.borrowDVD(this.dvdID,this.borrower, this.mobileNo, this.email, this.borrowDate, this.borrowTime).subscribe((data: any) => {
        this.borrowedDVDID=data.borrowedDVDID;
        this.borrowedDVDSector=data.borrowedDVDSector;
        this.borrowedDVDTitle=data.borrowedDVDTitle;
        this.borrowedDVDLang=data.borrowedDVDLang;
        this.borrowedDVDSubt=data.borrowedDVDSubt;
        this.borrowedDVDProd=data.borrowedDVDProd;
        this.borrowedDVDActors=data.borrowedDVDActors;
        this.borrowedDVD=true;
      });
      this.dvdID="";
      this.borrower="";
      this.mobileNo="";
      this.email="";
      this.borrowDate="";
      this.borrowTime="";
      alert("DVD borrowed successfully.");
    }else {
      alert("All fields must be filled. Please insert all the details.");
    }

  }

}
