import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hora {
    public static void main(String[] args) {
//        LocalDateTime ahora = LocalDateTime.now();
//        System.out.println(ahora);
//
//
//        String dateToParse = "2016-05-23 07:24:59";
//        LocalDateTime dateTime = LocalDateTime.parse(dateToParse, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        LocalDate localDate = dateTime.toLocalDate();
//        LocalTime localTime = dateTime.toLocalTime();
//
//        System.out.println(localDate);
//        System.out.println(localTime);
//
//    }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        System.out.println(formattedDate);

    }
}
