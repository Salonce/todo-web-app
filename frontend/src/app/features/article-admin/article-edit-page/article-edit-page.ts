import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../../core/article-service/article-service';
import { QuillModule } from 'ngx-quill';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ArticleEdit } from '../../../core/models/article-edit';
import { NewArticle } from '../../../core/models/new-article';

@Component({
  selector: 'app-article-edit-page',
  imports: [QuillModule, FormsModule],
  templateUrl: './article-edit-page.html',
  styleUrl: './article-edit-page.css'
})
export class ArticleEditPage implements OnInit{

    constructor(private articleService : ArticleService, private route: ActivatedRoute){}
  
    id! : number;

    article  : NewArticle | null = null;;

    ngOnInit(): void {
      this.route.params.subscribe(params => {
        this.id = params['id'];
        this.loadArticle(this.id);
      });
    }
  
    loadArticle(id: number) {
      this.articleService.getArticleById(id).subscribe({
        next: (article: NewArticle) => {
          this.article = article;
        },
        error: (err) => {
          console.error('Failed to load article:', err);
        }
      });
    }
    
    onSubmit() {
      if (!this.article) return;

      this.articleService.patchArticle(this.id, this.article).subscribe({
        next: res => console.log('Updated:', res),
        error: err => console.error('Failed to update:', err)
      });
    }
}
