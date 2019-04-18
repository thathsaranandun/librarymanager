import { Component } from '@angular/core';

import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;
  postRequestResponse: string;
  bookname='sasasd';
  author='adsada';

  firstLoad:boolean=true;
  

  constructor(private appService: AppService) {
    this.appService.getWelcomeMessage().subscribe((data: any) => {
      this.title = data.content;
    });

    if(this.firstLoad) {
      this.appService.sendBookData("123", "Art", "ClipArt", "Artist", "10", "Not me").subscribe((data: any) => {
      });
      this.appService.sendBookData("xxx-x-xx-xxxxxx-0","IT", "Geek4Geek", "Geek", "100", "Geek Publications").subscribe((data: any) => {
      });
      this.appService.sendBookData("xxx-x-xx-xxxxxx-1","Science","AsapScience","Mr.Nerd","500","Polar Publishers").subscribe((data: any) => {
      });
      this.appService.sendBookData("xxx-x-xx-xxxxxx-2","Fiction","Harry Potter","J.K.Rowling","200","Penguin").subscribe((data: any) => {
      });
      this.appService.sendBookData("xxx-x-xx-xxxxxx-3","Fiction","Batman","Goblin","200","Bat publications").subscribe((data: any) => {
      });
      this.firstLoad=false;
    }
  }


  /**
   * This method is used to test the post request
   */
  /*
  public postData(): void {
    this.appService.sendData(this.bookname,this.author).subscribe((data: any) => {
      this.postRequestResponse = data.content +":::"+data.name;
    });
  }
  */
}
