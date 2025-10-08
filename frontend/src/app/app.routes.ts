import { Routes } from '@angular/router';
import { SettingsPageComponent } from './pages/settings-page/settings-page';
import { MainLayout } from './layouts/main-layout/main-layout';
import { HomePage } from './pages/home-page/home-page';
import { AuthLayout } from './layouts/auth-layout/auth-layout';
import { DashboardPage } from './pages/dashboard-page/dashboard-page';

export const routes: Routes = [
    {
        path: '', 
        component: MainLayout,
        children: [
            { path: '', component: HomePage },
            { path: 'home', component: HomePage },
            { path: 'settings', component: SettingsPageComponent },
            { path: 'dashboard', component: DashboardPage }
        ]
    },
        {
        path: '', 
        component: AuthLayout,
        children: [
            { path: 'auth', component: SettingsPageComponent }
        ]
    },
];
