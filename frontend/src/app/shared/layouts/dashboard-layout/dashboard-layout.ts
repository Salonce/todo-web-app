import { Component } from '@angular/core';
import { Navbar } from "../navbar/navbar";
import { Dashboard } from "../dashboard/dashboard";
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-dashboard-layout',
  imports: [RouterOutlet, Navbar, Dashboard],
  templateUrl: './dashboard-layout.html',
  styleUrl: './dashboard-layout.css'
})
export class DashboardLayout {

}
