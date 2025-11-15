import { Routes } from '@angular/router';
import { MainLayout } from './layouts/main-layout/main-layout';
import { HomePage } from './pages/home-page/home-page';
import { AuthLayout } from './layouts/auth-layout/auth-layout';
import { AccountDetailsPage } from './pages/account-details-page/account-details-page';
import { AccountEditPage } from './pages/account-edit-page/account-edit-page';
import { DashboardLayout } from './layouts/dashboard-layout/dashboard-layout';
import { DashboardHomePage } from './pages/dashboard-home-page/dashboard-home-page';
import { ArticleNewPage } from './pages/article-new-page/article-new-page';
import { ArticlePage } from './pages/article-page/article-page';

export const routes: Routes = [
    {
        path: '', 
        component: MainLayout,
        children: [
            { path: '', component: HomePage },
            { path: 'home', component: HomePage },
            { path: 'settings', component: AccountDetailsPage },
            { path: 'account-edit', component: AccountEditPage }
        ]
    },
        {
        path: '', 
        component: AuthLayout,
        children: [
            { path: 'auth', component: AccountDetailsPage }
        ]
    },
        {
        path: '', 
        component: DashboardLayout,
        children: [
            { path: 'dashboard', component: DashboardHomePage },
            { path: 'new-article', component: ArticleNewPage },
        ]
    },
    {
        path: '', 
        component: MainLayout,
        children: [
        { path: ':slug', component: ArticlePage }
        ]
    }
];
