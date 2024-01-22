package utils;

import java.io.*;
import java.util.ArrayList;

public class FileIo implements IFileIo {
    private final String filePath;

    public FileIo(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeLine(String line, boolean append) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("File created !");
            } else {
                System.out.println("File already exist !");
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, append));
            bw.write(line);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void writeList(ArrayList<String> list, boolean append) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("File created !");
            } else {
                System.out.println("File already exist !");
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, append));
            for (String s : list) {
                bw.write(s);
                bw.newLine();
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<String> readList() {
        ArrayList<String> result = new ArrayList<>();
        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist !");
        }
        return result;
    }
}
