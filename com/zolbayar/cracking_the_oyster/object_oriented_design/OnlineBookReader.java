package com.zolbayar.cracking_the_oyster.object_oriented_design;

/*
    Purpose: Design data structures for online eBook reader

    Design: Library, UserManager,
 */

import java.util.List;

public class OnlineBookReader {

    class Reader {
        List<Book> bookList;
        Book currentBook;
    }

    class Category {
        int id;
        String name;
    }

    class Chapter {
        int id;
        String name;
        String text;
    }

    class Book {
        String name;
        Category category;
        List<Chapter> chapterList;

    }

}
