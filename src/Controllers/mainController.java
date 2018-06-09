package Controllers;

import Tabulation.Main;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class mainController implements Initializable{

    @FXML
    private JFXButton btn_tabulation;

    @FXML
    private JFXButton btn_admin;

    @FXML
    private JFXButton btn_stats;

    @FXML
    private JFXButton btn_config;

    @FXML
    private JFXButton btn_about;

    @FXML
    private JFXButton btn_overview;

    @FXML
    private JFXButton btn_exit;

    @FXML
    private Pane pane;

    @FXML
    private Pane topPane;

    AnchorPane homePane;

    double xOffset,yOffset;

    Button active;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /**
         *
         * action listeners for draggable stage
         *
         */

        active = btn_overview;
        try {
            this.createPage(homePane, "../resources/styles/overview.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        topPane.setOnMousePressed(event -> {
            xOffset= Main.getPrimaryStage().getX()-event.getScreenX();
            yOffset=Main.getPrimaryStage().getY()-event.getScreenY();
            topPane.setCursor(Cursor.CLOSED_HAND);
        });

        topPane.setOnMouseDragged(event -> {
            Main.getPrimaryStage().setX(event.getScreenX()+xOffset);
            Main.getPrimaryStage().setY(event.getScreenY()+yOffset);
        });

        topPane.setOnMouseReleased(event -> {
            topPane.setCursor(Cursor.DEFAULT);
        });


    }

    public void exit(ActionEvent event){
        alertMsg("confirm", "Are your sure you want to close the application?");
    }

    public void alertMsg(String string, String msg){
        if(string.equals("confirm")){
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Confirmation Dialog");
            confirm.setHeaderText(msg);

            Optional<ButtonType> result = confirm.showAndWait();
            if(result.get() == ButtonType.OK){
                System.exit(1);
            }else {

            }
        }

    }

    public void setNode(Node node){

        pane.getChildren().clear();
        pane.getChildren().add((Node)node);
    }

    public void createPage(AnchorPane home,String loc) throws IOException{

        home = FXMLLoader.load(getClass().getResource(loc));
        setNode(home);
    }

    public void ButtonClick(ActionEvent event) throws IOException {

        /**
         *
         * method for loading scenes
         *
         */

        Button btn = (Button) event.getSource();
        active.setStyle("-fx-background-color: transparent");
        active = (Button) event.getSource();
        btn.setStyle("-fx-background-color: darkgrey");

        if(btn.getId().toString().equals("btn_overview")){
            this.createPage(homePane, "../resources/styles/overview.fxml");
        }else if(btn.getId().toString().equals("btn_tabulation")) {
            this.createPage(homePane, "../resources/styles/tab.fxml");
        }else if(btn.getId().toString().equals("btn_admin")) {
            this.createPage(homePane, "../resources/styles/admin.fxml");
        }

    }
}
