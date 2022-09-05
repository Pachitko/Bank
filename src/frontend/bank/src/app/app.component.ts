import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ConfigService {
  constructor(private http: HttpClient) { }
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})

@Injectable()
export class AppComponent {
  title = 'Bank';

  constructor(private http: HttpClient) {
    // http.get("google.com")
  }
}
