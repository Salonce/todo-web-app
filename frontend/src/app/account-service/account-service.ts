import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

export interface Account {
  id: number;
  email: string;
  name: string;
  roles: string[]
}

@Injectable({
  providedIn: 'root'
})

export class AccountService {

  private apiUrl = 'http://localhost:8080/account';

  constructor(private http: HttpClient) {}

  getAccount(): Observable<Account> {
    return this.http.get<Account>(this.apiUrl, { withCredentials: true });
  }
}