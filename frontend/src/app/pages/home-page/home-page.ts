import { Component } from '@angular/core';
import { ArticleService } from '../../core/article-service/article-service';
import { Observable } from 'rxjs/internal/Observable';
import { Page } from '../../core/models/page';
import { Article } from '../../core/models/article';
import { AsyncPipe } from '@angular/common';
import { ArticleList } from '../article-list/article-list';
import { Pagination } from '../pagination/pagination';

@Component({
  selector: 'app-home-page',
  imports: [AsyncPipe, ArticleList, Pagination],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css'
})
export class HomePage {
  
  $articlesPage: Observable<Page<Article>>;

  constructor(private articleService : ArticleService){
    this.$articlesPage = articleService.getArticles();
  }

  loadPage(pageNumber: number) {
    this.$articlesPage = this.articleService.getArticles(pageNumber);
  }

  // getPreview = (content: string): string => {
  //   if (!content) return '';
  //   const sentences = content.split(/(?<=[.!?])\s+/);
  //   return sentences.slice(0, 3).join(' ');
  // };
}
