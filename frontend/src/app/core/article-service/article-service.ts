import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Article } from '../models/article';

@Injectable({
  providedIn: 'root'
})

export class ArticleService {

  constructor(private http : HttpClient) {}

  private readonly apiUrl = 'http://localhost:8080/api/articles'

  getArticleBySlug(slug : string) : Observable<Article> {
    return this.http.get<Article>(`http://localhost:8080/api/articles/${slug}`, {withCredentials: true}).pipe(
      catchError(err => {
        console.error('Failed to fetch article', err);
        return throwError(() => new Error('Could not fetch article'));
      })
    );
  }


  // getArticle(id : number) : Observable<Article> {
  //   return this.http.get<Article>(`${this.apiUrl}/${id}`, {withCredentials: true}).pipe(
  //     catchError(err => {
  //       console.error('Failed to fetch article', err);
  //       return throwError(() => new Error('Could not fetch article'));
  //     })
  //   );
  // }

  getArticles() : Observable<Article[]> {
    return this.http.get<Article[]>(this.apiUrl, {withCredentials : true}).pipe(
      catchError(err => {
        console.error('Failed to post article', err);
        return throwError(() => new Error('Could not fetch articles'));
      })
    )
  }

  postArticle(article: Article) : Observable<Article> {
    return this.http.post<Article>(this.apiUrl, article, {withCredentials : true}).pipe(
      catchError(err => {
        console.error('Failed to post article', err);
        return throwError(() => new Error('Could not fetch article'));
      })
    );
  }
}
