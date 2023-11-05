package edu.monmouth.hw3;

import java.util.Objects;

public class Book {
    private String title;
    private int numberOfPages;
    private String booktype;

    public Book(String title, int numberOfPages, String booktype) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.booktype = booktype;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book otherBook = (Book) obj;
        return Objects.equals(title, otherBook.title) &&
               numberOfPages == otherBook.numberOfPages &&
               Objects.equals(booktype, otherBook.booktype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, numberOfPages, booktype);
    }
}
