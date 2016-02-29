package com.barracuda.rtdict.util.ebook;

import com.barracuda.rtdict.util.ebook.parser.InstantParser;
import com.barracuda.rtdict.util.ebook.parser.Parser;

/**
 *
 * @author artur
 */
public class EBookParser {

    public static void main(String[] args) {
        Parser parser = new InstantParser();
        EBook ebook = parser.parse("./books_fb2/The_Martian_copy.fb2");
        if (ebook.isOk) {
            System.out.println(ebook.fileName);
            System.out.println(ebook.fb2Genres);
            for (Person p : ebook.authors) {
                System.out.println(p.firstName + " " + p.lastName);
            }
            System.out.println(ebook.toString());
        }
    }
}
