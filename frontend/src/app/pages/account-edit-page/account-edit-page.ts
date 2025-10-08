import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Account, AccountService } from '../../core/account-service/account-service';

@Component({
  selector: 'app-account-edit-page',
  imports: [FormsModule],
  templateUrl: './account-edit-page.html',
  styleUrl: './account-edit-page.css'
})
export class AccountEditPage {

  originalAccount!: Account;
  account = { name: '', email: '' };

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.accountService.getAccount().subscribe({
      next: (data) => this.originalAccount = data,
      error: (err) => console.error('Failed to fetch accounts', err)
    });
  }

  onSave() {
    console.log(this.account);
  }

  onCancel() {
    this.account = { ...this.originalAccount }; // discard changes
  }
}
