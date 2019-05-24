package sample;

import javafx.application.Application;
import sample.Controller.Controller_menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import sample.Controller.Controller_menu;
import sample.Model.Download;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<Download>d=new ArrayList<>();
        Controller_menu m=new Controller_menu(d);
        m.menu();





    }


    public static void main(String[] args) {

        launch(args);
    }
}
