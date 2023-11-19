package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;

class RegFilter implements Task3.AbstractFilter {

    String reg;

    RegFilter(String reg) {
        this.reg = reg;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return Pattern.matches(".*" + reg + ".*", entry.toString());
    }
}
