// Nikita Dmitriev - Homework 8
// Executes from current directory
// Flags -d (directory only)
// Can get error if user doesn't have permissions for folder

import java.io.*;
import java.nio.file.*;

public class DirLs {
    public static void main(String[] args){
        try {
            PrintWriter out = new PrintWriter("output.txt", "UTF-8");

            // Check flag
            boolean dirOnly = false;
            if (args.length == 1) {
                // we only support 1 flag at the moment, most basic check
                if (args[0].toLowerCase().equals("-d")) {
                    dirOnly = true;
                    System.out.println("Listing directories only");
                    out.println("Listing directories only");
                }
            }
            File curDir = new File(Paths.get("").toAbsolutePath().toString());

            //current directory - info stripped for safety reasons, it's my machine
            out.println("./" + curDir.getName());

            printDir(curDir.listFiles(), 3, out, dirOnly);
            out.flush();
        } catch (IOException e){
            System.out.println(e);
        }
    }
    public static void printDir(File[] files, int t, PrintWriter out, boolean d){
        // Separate for loops to list folders before files
        for (File file : files) {
            if (file.isDirectory()) {
                printTab(t, out);
                out.printf("%s %s\n", file.getName(), "(d)"); // d for directory
                printDir(file.listFiles(), t+3, out, d);
            }
        }
        if (!d) {
            for (File file1 : files) {
                if (file1.isFile()) {
                    printTab(t, out);
                    out.printf("%s %s\n", file1.getName(), "(f)"); // f for file
                }
            }
        }
    }
    static void printTab(int i, PrintWriter out){
        // print spaces
        for (int j = 0; j < i-3; j++) {
            out.print(" ");
        }
        // print dashes
        out.print("|");
        for (int j=i-2; j<i;j++){
            out.print("_");
        }
    }
}
