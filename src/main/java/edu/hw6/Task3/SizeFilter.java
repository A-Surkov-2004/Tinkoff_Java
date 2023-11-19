package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class SizeFilter implements Task3.AbstractFilter {

    int n;

    SizeFilter(int n) {
        this.n = n;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return Files.size(entry) > n;
    }
}
