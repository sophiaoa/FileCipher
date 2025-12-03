package org.example;
import java.io.*;

public class FileService {
    // Метод запису зашифрованого тексту
    public void saveEncrypted(String fileName, String content, int key) throws IOException {

        // FileOutputStream (пише у файл) - обгорнутий у CipherOutputStream (шифрує)
        try (FileOutputStream fos = new FileOutputStream(fileName);
             CipherOutputStream cos = new CipherOutputStream(fos, key)) {

            // Перетворюємо рядок у байти та пишемо
            for (char c : content.toCharArray()) {
                cos.write(c);
            }
        }
    }

    // Метод читання розшифрованого тексту
    public String readDecrypted(String fileName, int key) throws IOException {
        StringBuilder sb = new StringBuilder();

        // FileInputStream (читає з файлу) - обгорнутий у CipherInputStream (розшифровує)
        try (FileInputStream fis = new FileInputStream(fileName);
             CipherInputStream cis = new CipherInputStream(fis, key)) {

            int i;
            while ((i = cis.read()) != -1) {
                sb.append((char) i);
            }
        }
        return sb.toString();
    }
}