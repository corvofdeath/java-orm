package orm.SqlGenerator;

import utils.Logger;

import java.io.*;
import java.time.LocalDateTime;

public class WriteSql {

    public static void createDumpFile(String sql) {


        try (Writer write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dump-" + getDate() + ".sql"), "UTF-8"))) {
            write.write(sql);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.writeLine("Write File Error!");
        }
    }

    private static String getDate() {

        LocalDateTime dateTime = LocalDateTime.now();

        return dateTime.getDayOfMonth() + "-" + dateTime.getMonthValue() + "-" + dateTime.getYear();
    }
}
