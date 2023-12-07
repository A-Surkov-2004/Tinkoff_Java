package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;

class GlobFilter implements Task3.AbstractFilter {

    String str;

    GlobFilter(String str) {
        this.str = str;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return Pattern.matches("." + str + "$", entry.toString());
    }
}
