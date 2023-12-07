package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Path;

class AndFilter implements Task3.AbstractFilter {

    Task3.AbstractFilter f1;
    Task3.AbstractFilter f2;

    AndFilter(Task3.AbstractFilter filter1, Task3.AbstractFilter filter2) {
        f1 = filter1;
        f2 = filter2;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return f1.accept(entry) && f2.accept(entry);
    }
}
