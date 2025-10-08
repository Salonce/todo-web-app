import { Component } from '@angular/core';
import { AuthService, Principal } from '../auth-service/auth-service';
import { Observable } from 'rxjs/internal/Observable';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css'
})
export class Navbar {

  constructor(private authService: AuthService, private router: Router){
    this.principal$ = this.authService.principal$;
  }
  
  principal$: Observable<Principal | null>;

  onLogout() : void {
    this.authService.logout();
  }
}
