package com.example.java8;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

@SpringBootTest
class Java8ApplicationTests {

    @Test
    void contextLoads() throws IOException {
        List<String> words = new ArrayList<>();

        List<String> lines =
                Files.readAllLines(Paths.get("src/main/resources/Cheese.dat"));

        List<String> stringList = lines.subList(1, lines.size());
        for (String line : stringList) {
            for(String word : line.split("[ .?,]+"))
                words.add(word.toLowerCase());
        }
        stringList.stream().limit(10).forEach(System.out::println);
        System.out.println("///");
    }


    /**
     *
     */
    public class RandomWords implements Supplier<String> {
        List<String> words = new ArrayList<>();
        Random rand = new Random(47);
        RandomWords(String fname) throws IOException {
            List<String> lines =
                    Files.readAllLines(Paths.get(fname));
            // Skip the first line:
            for (String line : lines.subList(1, lines.size())) {
                for (String word : line.split("[ .?,]+"))
                    words.add(word.toLowerCase());
            }
        }
        @Override
        public String get() {
            return words.get(rand.nextInt(words.size()));
        }
        @Override
        public String toString() {
            return words.stream()
                    .collect(Collectors.joining(" "));
        }
    }
    @Test
    void contextLoads1() throws IOException{
        Stream.generate(new RandomWords("src/main/resources/Cheese.dat")).
                collect(Collectors.joining(" "));
    }



    @Test
    void contextLoads2() throws IOException{
        IntStream range = range(10, 20);
        int[] ints1 = range.toArray();

        int[] ints = range(10, 20).toArray();

        System.out.println(range(10, 20).sum());
    }


    static void repeat(int n,Runnable runnable){
        range(0,n).forEach(i->runnable.run());
    }
   static class Looping{
        static void hi(){
            System.out.println("?????");
        }
    }
    @Test
    void contextLoads3() throws IOException {
        repeat(3,()-> System.out.println("/////"));
        repeat(5,Looping::hi);
    }

}
