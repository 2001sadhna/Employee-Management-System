import { Component, OnInit } from '@angular/core';
import { Book } from './book.model';
import { BookService } from './book.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  books: Book[] = [];
  newBook: Book = { title: '', author: '', isbn: '' };
  loading = false;
  errorMessage = '';

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.loadBooks();
  }

  loadBooks(): void {
    this.loading = true;
    this.bookService.getBooks().subscribe({
      next: data => {
        this.books = data;
        this.loading = false;
      },
      error: err => {
        this.errorMessage = 'Unable to load books.';
        console.error(err);
        this.loading = false;
      }
    });
  }

  addBook(): void {
    if (!this.newBook.title || !this.newBook.author || !this.newBook.isbn) {
      this.errorMessage = 'All fields are required.';
      return;
    }

    this.bookService.addBook(this.newBook).subscribe({
      next: book => {
        this.books.push(book);
        this.newBook = { title: '', author: '', isbn: '' };
        this.errorMessage = '';
      },
      error: err => {
        this.errorMessage = 'Failed to add book.';
        console.error(err);
      }
    });
  }

  removeBook(id: number | undefined): void {
    if (id == null) {
      return;
    }
    this.bookService.deleteBook(id).subscribe({
      next: () => {
        this.books = this.books.filter(book => book.id !== id);
      },
      error: err => {
        this.errorMessage = 'Failed to delete book.';
        console.error(err);
      }
    });
  }
}
