import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs/index';

/**
 * Class representing application service.
 *
 * @class AppService.
 */
@Injectable()
export class AppService {
  private serviceUrl = '/api/summary';
  private bookDataPostUrl = '/api/postBook';
  private dvdDataPostUrl = '/api/postDVD';
  private borrowBookUrl = '/api/borrowBook';
  private borrowDVDUrl ='/api/borrowDVD';
  private deleteBookUrl='/api/deleteBook';
  private deleteDVDUrl='/api/deleteDVD';
  private searchBookUrl='/api/searchBook';
  private searchDVDUrl='/api/searchDVD';
  private displayBookUrl='/api/displayBooks';
  private displayDVDUrl='/api/displayDVDs';
  private returnBookUrl='/api/returnBook';
  private returnDVDUrl='/api/returnDVD';
  private reportBookUrl='/api/reportBooks';
  private reportDVDUrl='/api/reportDVDs';


  constructor(private http: HttpClient) {
  }

  /**
   * Makes a http get request to retrieve the welcome message from the backend service.
   */
  public getWelcomeMessage() {
    return this.http.get(this.serviceUrl).pipe(
      map(response => response)
    );
  }

  /**
   * Makes a http post request to send some data to backend & get response.
   */
  /*
  public sendData(bookname:string,author:string): Observable<any> {
    return this.http.post(this.dataPostTestUrl, {'bookname':bookname,'author':author});
  }
  */
  public sendBookData(bookISBN:string,bookSector:string,bookTitle:string,bookAuthors:string,bookPages:string,bookPublisher:string): Observable<any> {
    return this.http.post(this.bookDataPostUrl, {'bookISBN':bookISBN,'bookSector':bookSector,'bookTitle':bookTitle,'bookAuthors':bookAuthors,'bookPages':bookPages,'bookPublisher':bookPublisher});
  }


  public sendDVDData(dvdSector:string,dvdTitle:string,dvdLanguage:string,dvdSubtitles:string,dvdProducer:string,dvdActors:string): Observable<any> {
    return this.http.post(this.dvdDataPostUrl, {'dvdSector':dvdSector,'dvdTitle':dvdTitle,'dvdLanguage':dvdLanguage,'dvdSubtitles':dvdSubtitles,'dvdProducer':dvdProducer,'dvdActors':dvdActors});
  }

  public borrowBook(bookISBN:string,borrower:string,mobileNo:string,email:string,borrowDate:string,borrowTime:string): Observable<any>{
    return this.http.post(this.borrowBookUrl, {'bookISBN':bookISBN,'borrower':borrower,'mobileNo':mobileNo,'email':email,'borrowDate':borrowDate,'borrowTime':borrowTime});
  }

  public borrowDVD(dvdID:string,borrower:string,mobileNo:string,email:string,borrowDate:string,borrowTime:string): Observable<any>{
    return this.http.post(this.borrowDVDUrl, {'dvdID':dvdID,'borrower':borrower,'mobileNo':mobileNo,'email':email,'borrowDate':borrowDate,'borrowTime':borrowTime});
  }

  public deleteBook(bookID:string):Observable<any>{
    return this.http.post(this.deleteBookUrl,{'bookID':bookID});
  }

  public deleteDVD(dvdID:string):Observable<any>{
    return this.http.post(this.deleteDVDUrl,{'dvdID':dvdID});
  }

  public searchBook(bookTitle:string):Observable<any>{
    return this.http.post(this.searchBookUrl,{'bookTitle':bookTitle});
  }

  public searchDVD(dvdTitle:string):Observable<any>{
    return this.http.post(this.searchDVDUrl,{'dvdTitle':dvdTitle});
  }

  public displayBooks():Observable<any>{
    return this.http.post(this.displayBookUrl,{});
  }

  public displayDVDs():Observable<any>{
    return this.http.post(this.displayDVDUrl,{});
  }

  public returnBook(isbn:string,returnDate:string,returnTime:string):Observable<any>{
    return this.http.post(this.returnBookUrl,{'isbn':isbn,'returnDate':returnDate,'returnTime':returnTime});
  }

  public returnDVD(dvdID:string,returnDate:string,returnTime:string):Observable<any>{
    return this.http.post(this.returnDVDUrl,{'dvdID':dvdID,'returnDate':returnDate,'returnTime':returnTime});
  }

  public reportBooks():Observable<any>{
    return this.http.post(this.reportBookUrl,{});
  }

  public reportDVDs():Observable<any>{
    return this.http.post(this.reportDVDUrl,{});
  }


}
