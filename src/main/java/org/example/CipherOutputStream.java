package org.example;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CipherOutputStream extends FilterOutputStream {
    private final int key; // Наш секретний ключ зсуву

    public CipherOutputStream(OutputStream out, int key) {
        super(out);
        this.key = key;
    }

    // Перехоплюємо кожен байт перед записом
    @Override
    public void write(int b) throws IOException {
        // Замінюємо символ на такий, код якого більший на значення ключа
        super.write(b + key);
    }
}
