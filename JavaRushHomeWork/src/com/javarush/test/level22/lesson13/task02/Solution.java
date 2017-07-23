package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        InputStream reader = new FileInputStream(args[0]);
        OutputStream out = new FileOutputStream(args[1]);
        byte[] b = new byte[reader.available()];
        reader.read(b);
        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        String str = new String(b,utf);
        b = str.getBytes(win1251);
        out.write(b);
        reader.close();
        out.close();
    }
}
