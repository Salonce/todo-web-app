import { Component } from '@angular/core';
import { ArticleService } from '../../../core/article-service/article-service';
import { NewArticle } from '../../../core/models/new-article';
import Quill from 'quill';
import { QuillModule } from 'ngx-quill';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-article-edit-page',
  imports: [QuillModule, FormsModule],
  templateUrl: './article-edit-page.html',
  styleUrl: './article-edit-page.css'
})
export class ArticleEditPage {

    constructor(private articleService : ArticleService){}
  
    article : NewArticle = {
      title: '',
      content: ''
    };
  
    editorModules = {
      toolbar: [
        ['bold', 'italic', 'underline', 'strike'],
        ['blockquote', 'code-block'],
        [{ 'header': 1 }, { 'header': 2 }],
        [{ 'list': 'ordered'}, { 'list': 'bullet' }],
        [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
        ['link', 'image'],
        ['clean']
      ],
      imageResize: {
        modules: ['Resize', 'DisplaySize']
      }
    };
  
    onSubmit() {
      console.log('Article object:', this.article);
      console.log('Content value:', this.article.content);
      this.articleService.postArticle(this.article).subscribe(res => {
        console.log('New Article:', res);
      });
    }
  
    
}
