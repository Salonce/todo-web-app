import { Component } from '@angular/core';
import { Account, AccountService } from './account-service/account-service';

@Component({
  selector: 'app-settings-page',
  imports: [],
  templateUrl: './settings-page.html',
  styleUrl: './settings-page.css'
})
export class SettingsPageComponent {

  account!: Account;

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.accountService.getAccount().subscribe({
      next: (data) => this.account = data,
      error: (err) => console.error('Failed to fetch accounts', err)
    });
  }
}
