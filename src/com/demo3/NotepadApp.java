package com.demo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class NotepadApp extends Application {

    private TextArea textArea;
    private File currentFile;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Notepad");

        textArea = new TextArea();

        MenuBar menuBar = createMenuBar();

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(textArea);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");

        MenuItem openItem = new MenuItem("Open");
        openItem.setOnAction(e -> openFile());

        MenuItem saveItem = new MenuItem("Save");
        saveItem.setOnAction(e -> saveFile());

        fileMenu.getItems().addAll(openItem, saveItem);

        menuBar.getMenus().add(fileMenu);

        return menuBar;
    }

    private void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File selectedFile = fileChooser.showOpenDialog(textArea.getScene().getWindow());

        if (selectedFile != null) {
            try {
                String fileContent = new String(Files.readAllBytes(selectedFile.toPath()));
                textArea.setText(fileContent);
                currentFile = selectedFile;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile() {
        if (currentFile != null) {
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                fileWriter.write(textArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save File");
            File selectedFile = fileChooser.showSaveDialog(textArea.getScene().getWindow());

            if (selectedFile != null) {
                try (FileWriter fileWriter = new FileWriter(selectedFile)) {
                    fileWriter.write(textArea.getText());
                    currentFile = selectedFile;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
