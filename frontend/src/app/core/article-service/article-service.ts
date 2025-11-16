import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { NewArticle } from '../models/new-article';
import { Page } from '../models/page';
import { Article } from '../models/article';

@Injectable({
  providedIn: 'root'
})

export class ArticleService {

  constructor(private http : HttpClient) {}

  private readonly apiUrl = 'http://localhost:8080/api/articles'

  getArticles(page: number = 0, size: number = 10): Observable<Page<Article>> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    return this.http.get<Page<Article>>(this.apiUrl, { 
        params, 
        withCredentials: true 
      }).pipe(
        catchError(err => {
          console.error('Failed to fetch articles', err);
          return throwError(() => new Error('Could not fetch articles'));
        })
      );
  }

  getArticleBySlug(slug : string) : Observable<Article> {
    return this.http.get<Article>(`http://localhost:8080/api/articles/${slug}`, {withCredentials: true}).pipe(
      catchError(err => {
        console.error('Failed to fetch article', err);
        return throwError(() => new Error('Could not fetch article'));
      })
    );
  }

  postArticle(article: NewArticle) : Observable<NewArticle> {
    return this.http.post<NewArticle>(this.apiUrl, article, {withCredentials : true}).pipe(
      catchError(err => {
        console.error('Failed to post article', err);
        return throwError(() => new Error('Could not fetch article'));
      })
    );
  }
}
