import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-returnitem',
  templateUrl: './returnitem.component.html',
  styleUrls: ['./returnitem.component.css']
})
export class ReturnitemComponent implements OnInit {

  book:boolean=false;
  dvd:boolean=false;

  bookISBN:string;
  returnDate:string;
  returnTime:string;

  dvdID:string;



  constructor(private appService:AppService) { }

  ngOnInit() {
  }

  public returnBook():void{
    this.appService.returnBook(this.bookISBN,this.returnDate,this.returnTime).subscribe((data: any) => {
      console.log(data);
          });
  }

  public returnDVD():void{
    this.appService.returnDVD(this.dvdID,this.returnDate,this.returnTime).subscribe((data: any) => {
      console.log(data);
    });

  }

}
