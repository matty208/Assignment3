package edu.monmouth.hw3;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;

public class HW3 {
    public static void main(String[] args) {
    	
        try {
            System.setOut(new PrintStream(new FileOutputStream("HW3.txt")));
            System.setErr(new PrintStream(new FileOutputStream("HW3.txt")));

            List<String> stringArrayList = new ArrayList<>();
            List<String> stringLinkedList = new LinkedList<>();

            BufferedReader stringFileReader = new BufferedReader(new FileReader("string.txt"));
            String line;
            while ((line = stringFileReader.readLine()) != null) {
                stringArrayList.add(line);
                stringLinkedList.add(line);
            }
            stringFileReader.close();

            List<Book> bookArrayList = new ArrayList<>();
            List<Book> bookLinkedList = new LinkedList<>();

            BufferedReader bookFileReader = new BufferedReader(new FileReader("books.txt"));
            while ((line = bookFileReader.readLine()) != null) {

                String[] bookData = line.split(",");
                if (bookData.length == 3) {
                    Book book = new Book(bookData[0].trim(), Integer.parseInt(bookData[1].trim()), bookData[2].trim());
                    bookArrayList.add(book);
                    bookLinkedList.add(book);
                }
            }
            bookFileReader.close();

            System.out.println("ArrayList isEmpty: " + stringArrayList.isEmpty());
            stringArrayList.remove(0);
            System.out.println("ArrayList size: " + stringArrayList.size());
            stringArrayList.add("New String");
            Iterator<String> stringIterator = stringArrayList.iterator();
            while (stringIterator.hasNext()) {
                System.out.println(stringIterator.next());
            }
            ListIterator<String> stringListIterator = stringArrayList.listIterator(stringArrayList.size());
            while (stringListIterator.hasPrevious()) {
                System.out.println(stringListIterator.previous());
            }

            System.out.println("LinkedList isEmpty: " + stringLinkedList.isEmpty());
            stringLinkedList.add("Another String");
            ListIterator<String> stringLinkedListIterator = stringLinkedList.listIterator(stringLinkedList.size());
            while (stringLinkedListIterator.hasPrevious()) {
                System.out.println(stringLinkedListIterator.previous());
            }

            Book bookToFind = new Book("Sample Book", 200, "Fiction");
            
            System.out.println("ArrayList contains bookToFind: " + bookArrayList.contains(bookToFind));
            System.out.println("ArrayList remove bookToFind: " + bookArrayList.remove(bookToFind));
            System.out.println("LinkedList contains bookToFind: " + bookLinkedList.contains(bookToFind));
            System.out.println("LinkedList remove bookToFind: " + bookLinkedList.remove(bookToFind));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
