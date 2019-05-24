package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.application.Application;
import jdk.dynalink.beans.StaticClass;
import sample.Model.Download;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.nio.file.Paths.get;

public class Controller_menu  implements Initializable{
    static ArrayList<Download>d=new ArrayList<>();
  static   ObservableList<Download> data_table= FXCollections.observableArrayList();
    @FXML
    private TableColumn<Download, String> Speed_id;

    @FXML
    private TableColumn<Download, String> Size_id;

    @FXML
    private Button Torrent_buttn;

    @FXML
    private Button Comleted_buttn;

    @FXML
    TableView<Download> info_tabele;

    @FXML
    private  TableColumn<Download, String> Name_id;

    @FXML
    private TableColumn<Download, String> Added_id;

    @FXML
    private TableColumn<Download, String> Status_id;

    @FXML
    private Button All_buttn;

    @FXML
    private Button add_buttn;

    @FXML
    private  TableColumn<Download, String> Url_id;

    @FXML
    private Button Active_buttn;





public static void menu() throws IOException
{


    Stage menu=new Stage();
    FXMLLoader loader=new FXMLLoader();
//    Parent root = loader.load(Controller_menu.class.getResource("src/sample/View/menu.fxml"));
    Pane root =(Pane) loader.load(get("src/sample/View/menu.fxml").toUri().toURL());
    menu.setTitle("Download_Manager");
    menu.setResizable(false);
        menu.setScene(new Scene(root, 678, 600));
        menu.show();

}
public Controller_menu(ArrayList<Download> de) throws IOException {
    d=de;


}
public Controller_menu() throws IOException {

}


    public void gotodownload(javafx.event.ActionEvent event) throws IOException {
    Stage stage=(Stage)add_buttn.getScene().getWindow();
    stage.close();
    Controller_Download.add(d);
}


    public  void initcols() throws IOException {

        Name_id.setCellValueFactory(new PropertyValueFactory<>("Name"));

        Url_id.setCellValueFactory(new PropertyValueFactory<>("Url"));

         Size_id.setCellValueFactory(new PropertyValueFactory<>("Size"));

          Added_id.setCellValueFactory(new PropertyValueFactory<>("speed"));
for(int i=0;i<d.size();i++) {
    if(i==d.size()-1){
    data_table.add(new Download(d.get(d.size() - 1).getName(), d.get(d.size() - 1).getUrl(), d.get(d.size() - 1).getSize()
   ,d.get(d.size() -1).getSpeed()     )
    );
    }
}

        info_tabele.setItems(data_table);




    }
    public void initialize(URL location, ResourceBundle resources)  {
        try {
            initcols();

        } catch (IOException e) {
            e.printStackTrace();
        }
//        loadData();

    }
//    public void editTablecols(){
//        Name_id.setCellFactory(TextFieldTableCell.forTableColumn());
//        Name_id.setOnEditCommit(e->{
//            e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
//        });
////        Size_id.setCellFactory(TextFieldTableCell.forTableColumn());
////        Size_id.setOnEditCommit(e->{
////            e.getTableView().getItems().get(e.getTablePosition().getRow()).setSize(e.getRowValue());
////        });
//        Url_id.setCellFactory(TextFieldTableCell.forTableColumn());
//        Url_id.setOnEditCommit(e->{
//            e.getTableView().getItems().get(e.getTablePosition().getRow()).setUrl(e.getNewValue());
//        });
//
//
//
//        info_tabele.setEditable(true);
//
//    }
//public void add(){
//  info_tabele.setItems(data_table);
//}

}
