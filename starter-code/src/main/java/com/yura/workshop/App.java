package com.yura.workshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/views/employee-form.fxml")
        );
        Scene scene = new Scene(loader.load(), 620, 720);
        stage.setTitle("Registro de Empleado");
        stage.setScene(scene);
        stage.setMinWidth(420);
        stage.setMinHeight(620);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
