import { Component, Input } from '@angular/core';
import { Article } from '../../core/models/article';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-article-edit-list',
  imports: [CommonModule, RouterModule],
  templateUrl: './article-edit-list.html',
  styleUrl: './article-edit-list.css'
})
export class ArticleEditList {
  constructor(private sanitizer: DomSanitizer){}

  @Input() articles : Article[] = [];

  getPreview(content: string, sentences: number = 3): string {
    // naive example: split by sentences
    const match = content.match(/.*?[.!?](\s|$)/g);
    if (!match) return content;
    const preview = match.slice(0, sentences).join(' ');
    return preview; // keep HTML tags intact
  }

  getSafeHtml(html: string): SafeHtml {
    return this.sanitizer.bypassSecurityTrustHtml(html);
  }

  editArticle(slug: string){}

  deleteArticle(slug: string){}
}
