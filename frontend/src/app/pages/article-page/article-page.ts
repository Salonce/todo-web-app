import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Article } from '../../core/models/article';
import { ArticleService } from '../../core/article-service/article-service';

@Component({
  selector: 'app-article-page',
  imports: [],
  templateUrl: './article-page.html',
  styleUrl: './article-page.css'
})


export class ArticlePage implements OnInit {

  slug!: string;
  article!: Article;

  constructor(private articleService: ArticleService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.slug = params['slug'];
      console.log('Current slug:', this.slug);
      this.loadArticle(this.slug);
    });
  }

  loadArticle(slug: string) {
      this.articleService.getArticleBySlug(slug).subscribe({
        next: (data: Article) => {
          this.article = data;
        },
        error: (err) => {
          console.error('Failed to load article:', err);
        }
      });
    }
}