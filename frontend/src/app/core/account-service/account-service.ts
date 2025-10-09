import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Account } from '../models/account';


@Injectable({
  providedIn: 'root'
})

export class AccountService {

    private apiUrl = 'http://localhost:8080/account';
    private apiPatchUrl = 'http://localhost:8080/profile';

    constructor(private http: HttpClient) {}

    getAccount(): Observable<Account> {
      return this.http.get<Account>(this.apiUrl, { withCredentials: true });
    }

    patchAccount(partialAccount: Partial<Account>): Observable<Account> {
      return this.http.patch<Account>(
        this.apiPatchUrl,
        partialAccount,
        { withCredentials: true }
      );
    }
}
