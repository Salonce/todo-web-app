import { Component } from '@angular/core';
import { Account, AccountService } from '../../core/account-service/account-service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-account-details-page',
  imports: [RouterModule],
  templateUrl: './account-details-page.html',
  styleUrl: './account-details-page.css'
})
export class AccountDetailsPage {

    account!: Account;
  
    constructor(private accountService: AccountService) {}
  
    ngOnInit(): void {
      this.accountService.getAccount().subscribe({
        next: (data) => this.account = data,
        error: (err) => console.error('Failed to fetch accounts', err)
      });
    }
}
