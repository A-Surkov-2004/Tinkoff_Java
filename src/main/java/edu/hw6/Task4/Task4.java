package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    private final static Logger LOGGER = LogManager.getLogger();

    FileOutputStream getStream(Path p) throws FileNotFoundException {
        return new FileOutputStream(p.toString());
    }

    CheckedOutputStream checkStream(Path p) throws FileNotFoundException {
        FileOutputStream fos = getStream(p);
        CheckedOutputStream out = new CheckedOutputStream(fos, new Adler32());
        return out;
    }

    BufferedOutputStream bufStream(Path p) throws FileNotFoundException {
        CheckedOutputStream out = checkStream(p);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        return bos;
    }

    OutputStreamWriter writeStream(Path p) throws UnsupportedEncodingException, FileNotFoundException {
        BufferedOutputStream bos = bufStream(p);
        return new OutputStreamWriter(bos, StandardCharsets.UTF_8);
    }

    public void writeInFile(Path p, String given) throws IOException {

        try (OutputStreamWriter writer = writeStream(p);) {
            writer.write(given);
        }
    }
}
