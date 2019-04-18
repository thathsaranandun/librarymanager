import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  bookCount:number=0;
  dvdCount:number=0;
  bookList=[];
  dvdList=[];
  removeConfirm:boolean;


  firsLoad:boolean=true;

  constructor(private appService:AppService) {

    this.appService.displayDVDs().subscribe
    ((data: any) => {
      this.dvdList=data;
      console.log(this.dvdList);
      this.dvdCount=this.dvdList.length;
    });





    this.appService.displayBooks().subscribe
    ((data: any) => {
      this.bookList=data;
      console.log(this.bookList);
      this.bookCount=this.bookList.length;
    });


  }

  ngOnInit() {

  }

  public removeBook(i):void{
    this.removeConfirm=confirm("Are you sure you want to delete this book?");
    if(this.removeConfirm) {
      this.bookList.splice(i, 1);
      this.appService.deleteBook(i).subscribe((data:any)=>{
        this.bookCount=this.bookList.length;
        console.log(data);

      });
    }


  }

  public removeDVD(i):void {
    this.removeConfirm = confirm("Are you sure you want to delete this DVD?");
    if (this.removeConfirm) {
      this.dvdList.splice(i, 1);
      this.appService.deleteDVD(i).subscribe((data: any) => {
        console.log(data);
        this.dvdCount = this.dvdList.length;

      });
    }
  }


}
