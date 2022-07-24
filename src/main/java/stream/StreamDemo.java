package stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        // 任意数量
        Stream<String> words = Stream.of("AAA", "bbb","cccc");

        // https://www.baeldung.com/java-stream-operated-upon-or-closed-exception
        Supplier<Stream<String>> wordsSupplier = () -> Stream.of("AAA", "bbb","cccc");

        // 不包含任何元素
        Stream<String> silence = Stream.empty();

        // filter
        Stream<String> longerWords = wordsSupplier.get().filter(w->w.length()>3);

        // map
        Stream<String> lowercaseWords = wordsSupplier.get().map(String::toLowerCase);

        // labmda表达式
        Stream<String> firstLetters = wordsSupplier.get().map(s->s.substring(0,1));



    }

}
