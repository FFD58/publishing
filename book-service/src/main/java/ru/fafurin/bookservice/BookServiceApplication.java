package ru.fafurin.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner loadData (BookTypeRepository bookTypeRepository, BookFormatRepository bookFormatRepository){
//        return args -> {
//            BookType bookType = new BookType();
//            bookType.setTitle("Монография");
//            bookTypeRepository.save(bookType);
//
//            BookType bookType1 = new BookType();
//            bookType1.setTitle("Научный журнал");
//            bookTypeRepository.save(bookType1);
//
//            BookFormat bookFormat = new BookFormat();
//            bookFormat.setTitle("A4");
//            bookFormatRepository.save(bookFormat);
//
//        };
//    }

}
