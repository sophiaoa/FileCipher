package org.example;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CipherInputStream extends FilterInputStream {
    private final int key;

    public CipherInputStream(InputStream in, int key) {
        super(in);
        this.key = key;
    }

    // Перехоплюємо читання і повертаємо "виправлений" байт
    @Override
    public int read() throws IOException {
        int b = super.read();

        // Якщо кінець файлу (-1), то нічого не робимо
        if (b == -1) {
            return -1;
        }

        // Алгоритм дешифрування: віднімаємо ключ назад
        return b - key;
    }
}
