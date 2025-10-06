package org.nigel;

import java.util.ArrayList;

public class Book {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return CheckedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        CheckedOutTo = checkedOutTo;
    }

    public ArrayList<Book> getLibary() {
        return Libary;
    }

    public void setLibary(ArrayList<Book> libary) {
        Libary = libary;
    }

    private String isbn;
    private String title;
    private Boolean isCheckedOut;
    private String CheckedOutTo;
    private ArrayList<Book> Libary;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    private String Author;

    //
    public Book() {}
    public Book(int id, String isbn, String title, Boolean isCheckedOut, String CheckedOutTo, String Author) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.CheckedOutTo = CheckedOutTo;
        this.Author = Author;
        // append to libary
    }
    // methods
    public String checkOut(String Name) {
        this.setCheckedOutTo(Name);
        this.setCheckedOut(true);
        return "";
    }
    public String checkIn() {
        this.setCheckedOutTo("");
        this.setCheckedOut(false);
        return "";
    }

}
