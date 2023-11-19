package edu.hw6.Task3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

class MagicFilter implements Task3.AbstractFilter {

    private final static int MAGIC_BYTES = 4;
    private byte[] data = new byte[MAGIC_BYTES];
    int code;
    char[] chars;

    MagicFilter(int code, char... chars) {
        this.code = code;
        this.chars = chars;
    }

    private void fileSignature(InputStream is)
        throws IOException, NullPointerException {
        is.read(data, 0, MAGIC_BYTES);
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        fileSignature(new FileInputStream(entry.toFile()));
        return Byte.toUnsignedInt(data[0]) == code && data[1] == chars[0] && data[2] == chars[1]
            && data[MAGIC_BYTES - 1] == chars[2];
    }
}
