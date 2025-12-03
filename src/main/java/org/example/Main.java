package org.example;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileService fileService = new FileService();

        try {
            System.out.println("=== ШИФРАТОР ТЕКСТУ ===");

            // 1. Введення даних
            System.out.println("Введіть текст, який треба зашифрувати:");
            String text = scanner.nextLine();

            // 2. Введення ключа
            System.out.print("Введіть один секретний символ-ключ (наприклад, 'K' або '7'): ");
            String keyStr = scanner.nextLine();

            // Беремо код першого символу як ключ
            int key = 0;
            if (!keyStr.isEmpty()) {
                key = keyStr.charAt(0);
            }

            // 3. Введення імені
            System.out.print("Введіть назву файлу для збереження (наприклад, secret.txt): ");
            String fileName = scanner.nextLine();

            System.out.println("\n... Шифруємо і зберігаємо ...");
            // Викликаємо наш сервіс
            fileService.saveEncrypted(fileName, text, key);
            System.out.println("Успішно! Якщо відкрити файл у блокноті, там буде шифр.");

            System.out.println("\n... Тепер читаємо і розшифровуємо назад ...");
            String decryptedText = fileService.readDecrypted(fileName, key);

            System.out.println("Розшифрований текст:");
            System.out.println(">> " + decryptedText);

            // Обробка помилок
        } catch (IOException e) {
            System.out.println("Помилка роботи з файлом: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Щось пішло не так: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
