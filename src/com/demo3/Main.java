package com.demo3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void createFile(String namefile){
        try{
            File file = new File(namefile);
            if(file.createNewFile()){
                System.out.println("File is created" + file.getName());
            }else {
                System.out.println("File is exists");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeFile(String namefile, String contents){
        try {
            FileWriter writer = new FileWriter(namefile);
            writer.write(contents);
            writer.close();
            System.out.println("Noi dung da duoc viet vao file.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readFile(String namefile){
        StringBuilder contents = new StringBuilder();
        try {
            int kitu;
            FileReader reader = new FileReader(namefile);
            while ((kitu= reader.read()) != -1){
                contents.append((char) kitu);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return contents.toString();
    }

    public  static String linkFile(String namefile){
        File file = new File(namefile);
        return file.getAbsolutePath();
    }

    public static void deleteFile(String namefile){
        File file = new File(namefile);
        if(file.delete()){
            System.out.println("File: "+ file.getName()+" is deteled.");
        }else {
            System.out.println("khong the xoa file.");
        }
    }
    public static void createDirectory(String Directory){
            File file = new File(Directory);
            if(file.mkdir()){
                System.out.println("Directory" + file.getName() +"is created");
            }else{
                System.out.println("ko the tao thu muc.");
            }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten file: ");
        String namefile = scanner.nextLine();
        //tao file
        createFile(namefile);

        //viet vao file
        System.out.println("nhap noi dung:");
        String contents = scanner.nextLine();
        writeFile(namefile, contents);

        //doc file
        String read = readFile(namefile);
        System.out.println("noi dung cua file la: "+read);

        //duong dan file
        String linkofFile = linkFile(namefile);
        System.out.println("link of file "+ linkofFile);

        //tao thu muc
        System.out.println("Nhap ten thu muc");
        String Directory= scanner.nextLine();
        createDirectory(Directory);

        //xoa file
        System.out.println("nhap ten file ma ban muon xoa:");
        namefile = scanner.nextLine();
        deleteFile(namefile);



    }
}
