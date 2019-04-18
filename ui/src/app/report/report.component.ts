import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  bookList=[];
  dvdList=[];
  constructor(private appService:AppService) {
    this.appService.reportBooks().subscribe((data: any) => {
      console.log(data);
      this.bookList=data;
    });

    this.appService.reportDVDs().subscribe((data: any) => {
      console.log(data);
      this.dvdList=data;
    });
  }

  ngOnInit() {
  }

}
