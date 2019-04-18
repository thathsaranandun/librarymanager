import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { RouteExampleComponent } from './route-example/route-example.component';

import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import { AdditemComponent } from './additem/additem.component';
import { HomeComponent } from './home/home.component';
import { BorrowitemComponent } from './borrowitem/borrowitem.component';
import { ReturnitemComponent } from './returnitem/returnitem.component';
import { SearchBookComponent } from './search-book/search-book.component';
import { ReportComponent } from './report/report.component';

const routes: Routes = [

  {
    path: '',
    component: HomeComponent,

  },
  {
    path: 'play',
    component: RouteExampleComponent,

  },
  {
    path: 'additem',
    component: AdditemComponent,
  },
  {
    path: 'report',
    component: ReportComponent,
  },
  {
    path: 'search-book',
    component: SearchBookComponent,
  },
  {
    path: 'borrowitem',
    component: BorrowitemComponent,
  },
  {
    path: 'returnitem',
    component: ReturnitemComponent,
  },
  {
    path: '**',
    redirectTo: '/play',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    RouteExampleComponent,
    AdditemComponent,
    HomeComponent,
    BorrowitemComponent,
    ReturnitemComponent,
    SearchBookComponent,
    ReportComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes)
  ],
  providers: [
    AppService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
