package com.nikmax.modinstaller;

import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ModInstaller {
    //todo добавить поддержку 7z и rar, проверку расширения архива и выбор нужного метода
    //todo добавить проверку на случай нескольких архивов в одной папке (котянка и котянка+)
    public static String Download_fromYandex(String mod_URL) throws IOException {

        //ссылка-запрос на скачивание с Yandex Disk через REST API
        String URL_request = "https://cloud-api.yandex.net/v1/disk/public/resources/download?public_key=";
        //ключ (публичная ссылка на файл)
        //String URL_file = "https://disk.yandex.ru/d/hy_Mc0ZCw-FZtQ";

        //запрос на получение прямой ссылки для скачивания = ссылка-запрос + публичная ссылка на файл
        URL url = new URL(URL_request + mod_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        //получаем ответ от сервера
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        //парсим прмую ссылку из тела ответа
        int firstIndex = content.indexOf("https");
        int lastIndex = content.lastIndexOf("\",\"method\"");
        URL downloadURL = new URL(content.substring(firstIndex, lastIndex));

        //парсим имя файла из прямой ссылки
        String archiveName = content.substring(content.indexOf("filename="));
        archiveName = archiveName.substring(0, archiveName.indexOf("&"));
        archiveName = archiveName.replace("filename=", "");

        //скачиваем файл
        connection = (HttpURLConnection) downloadURL.openConnection();
        connection.setRequestMethod("GET");
        FileUtils.copyURLToFile(downloadURL, new File(System.getProperty("user.dir") + "/ЗАГРУЗКИ/" + archiveName));
        connection.disconnect();

        //возвращаем название архива для его передачи в метод-установщик
        return archiveName;
    }

    public static void Install(String archiveName, String gameFolder_Path) throws IOException {
        //zip
        if (archiveName.contains(".zip")) {
            ZipFile mod_zip = new ZipFile(System.getProperty("user.dir") + "/ЗАГРУЗКИ/" + archiveName);
            mod_zip.extractAll(gameFolder_Path);
        }
        //7z
        if (archiveName.contains(".7z")) {

        }
        //rar
        if (archiveName.contains(".rar")) {

        }
    }
}
