package Tabulation;

import ServerConnection.ServerConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private static Stage primaryStage;
    private static ServerConnection serverConnection;

    @Override
    public void start(Stage stage) throws Exception{
        primaryStage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("../resources/styles/Main.fxml"));
        root.setStyle(
               // "-fx-background-color: rgba(255, 255, 255, 0.5);" +
                     //   "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);" +
                        "-fx-background-insets: 30;"
        );
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();

        serverConnection = new ServerConnection();
        serverConnection.start();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }
    public static ServerConnection getConnection() { return serverConnection; }
}
