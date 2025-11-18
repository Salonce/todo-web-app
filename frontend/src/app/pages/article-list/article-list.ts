import { Component, Input } from '@angular/core';
import { Article } from '../../core/models/article';
import { CommonModule } from '@angular/common';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Component({
  selector: 'app-article-list',
  imports: [CommonModule],
  templateUrl: './article-list.html',
  styleUrl: './article-list.css'
})
export class ArticleList {

  constructor(private sanitizer: DomSanitizer){}

  @Input() articles : Article[] = [];

  getPreview = (content: string): string => {
    if (!content) return '';
    const sentences = content.split(/(?<=[.!?])\s+/);
    return sentences.slice(0, 3).join(' ');
  };

  getSafeHtml(html: string): SafeHtml {
    return this.sanitizer.bypassSecurityTrustHtml(html);
  }
}
