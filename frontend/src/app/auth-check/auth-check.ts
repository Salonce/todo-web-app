import { Component } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { catchError, of } from 'rxjs';

@Component({
  selector: 'app-auth-check',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  template: `
    <p *ngIf="status">{{ status }}</p>
  `,
})
export class AuthCheckComponent {
  status: string | null = null;

  constructor(private http: HttpClient) {
    this.checkAuth();
  }

  checkAuth() {
    this.http.get('http://localhost:8080/auth', { observe: 'response', withCredentials: true })
      .pipe(
        catchError(err => {
          
          if (err.status === 401 || err.status === 403) {
            window.location.href = 'http://localhost:8080/oauth2/authorization/google';
          }
          return of(null);
        })
      )
      .subscribe(response => {
        if (response && response.status === 200) {
          this.status = 'Authenticated';
        }
      });
  }
}