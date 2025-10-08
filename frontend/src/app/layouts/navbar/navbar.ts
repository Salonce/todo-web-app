import { Component } from '@angular/core';
import { AuthService, Principal } from '../../core/auth-service/auth-service';
import { Observable } from 'rxjs/internal/Observable';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule, RouterModule],
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
