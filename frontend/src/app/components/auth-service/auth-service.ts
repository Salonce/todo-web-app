import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/internal/observable/of';

export interface Principal {
  id: number;
  email: string
}

@Injectable({ providedIn: 'root' })
export class AuthService {

  private principalSubject = new BehaviorSubject<Principal | null>(null);
  principal$ = this.principalSubject.asObservable();

  constructor(private http: HttpClient) {}

  checkAuth() {
    this.http.get<Principal>('http://localhost:8080/auth', { withCredentials: true })
      .pipe(
        catchError(() => of(null)) 
      )
      .subscribe(principal => {
        this.principalSubject.next(principal);
      });
  }

  setAccount(principal: Principal) {
    this.principalSubject.next(principal);
  }

  logout() {
    this.http.post('http://localhost:8080/logout', {}, { withCredentials: true })
      .subscribe({
        next: () => this.principalSubject.next(null),  
        error: () => this.principalSubject.next(null)   
      });
  }

  isLoggedIn(): boolean {
    return this.principalSubject.value !== null;
  }
}