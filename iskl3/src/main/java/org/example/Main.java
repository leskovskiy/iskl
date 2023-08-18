package org.example;

import java.nio.channels.ScatteringByteChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.formatDate;

public class Main {
     /*
         Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
          разделенные пробелом (данные вводятся одной строкой без запятых):
    Фамилия Имя Отчество, дата рождения, номер телефона, пол

    Форматы данных:
    фамилия, имя, отчество - строки
    дата рождения - строка формата dd.mm.yyyy
    номер телефона - целое беззнаковое число без форматирования
    пол - символ латиницей f или m.
    Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки.
    Создать метод, который обработает его и покажет пользователю сообщение, что он ввел меньше или больше данных, чем требуется.
    Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
    Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
    Можно использовать встроенные типы java или создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
    Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии. В него в одну строку должны записаться полученные данные, вида:

    Фамилия Имя Отчество, дата рождения, номер телефона, пол
      */


    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String[] string = scanner.nextLine().split(" ");



    public static String indexOfNumber(String[] string){
        if (string.length == null){
            return null;
        }


        }
        try {
            String[] inf = string;
            if (inf.length != 6) {
                throw new IllegalArgumentException("Недостаточно данных");
            }


            String lastName = inf[0];
            String firstName = inf[1];
            String middleName = inf[2];
            Date BirthDate = parseDate(inf[3]);
            int phoneNum = Integer.parseInt(inf[4]);
            char gender = inf[5].charAt(0);


            System.out.println("Фамилия" + lastName);
            System.out.println("Имя" + firstName);
            System.out.println("Отчество" + middleName);
            System.out.println("дата рождения" + formatDate(BirthDate));
            System.out.println("номер телефона" + phoneNum);
            System.out.println("пол" + gender);

        }catch (IllegalArgumentException e){
            System.out.println("Error:" + e.getMessage());
        }catch (ParseException e){
            System.out.println("Error: Неверный формат данных");
        }catch (NumberFormatException e){
            System.out.println("Error: Телефон введен некорректно");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Недостаточно данных");
        }

    }

    private static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        return format.parse(dateStr);
    }

    private static String formateDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        return format.format(date);
    }

        String fileName = "files\\" + lastName.toLowerCase() + ".txt";
        File file = new File(lastName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
        if (file.length() > 0){
            fileWriter.write('\n');
        }
        fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patronymic, format.format(birthdate), phone, sex));
        }catch (IOException e){
        throw new FileSystemException("Возникла ошибка при работе с файлом");
    }
}