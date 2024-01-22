package utils;

import java.util.ArrayList;

public interface IFileIo {
    void writeLine(String line, boolean append);

    void writeList(ArrayList<String> list, boolean append);
    ArrayList<String> readList();
}
