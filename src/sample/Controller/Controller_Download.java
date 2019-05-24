package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Model.Download;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.nio.file.Paths.get;

public class Controller_Download {
  static   ArrayList<Download>d=new ArrayList<>();
   static ObservableList<Download> data_table= FXCollections.observableArrayList();
    Download f;
    @FXML
    private Label Enterurl_id;

    @FXML
    private Button cancel_id;

    @FXML
    private TextField txturl_id;

    @FXML
    private Button ok_buttn;
    @FXML
    private TableView<Download> info_tabel;

    @FXML
    private TableColumn<Download, String> Speed_id;

    @FXML
    private TableColumn<Download, String> Size_id;

    @FXML
    private TableColumn<Download, String> Name_id;

    @FXML
    private TableColumn<Download, String> Added_id;

    @FXML
    private TableColumn<Download, String> Status_id;



    @FXML
    private TableColumn<Download, String> Url_id;



   long fieldLength;







    public static void add(ArrayList<Download>downloads) throws IOException
    {
        d=downloads;


        Stage menu=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root =(Pane) loader.load(get("src/sample/View/Download.fxml").toUri().toURL());
        menu.setTitle("Add_Download");
        menu.setResizable(false);
        menu.setScene(new Scene(root, 500, 200));
        menu.show();
    }



    private class DownloadTask extends Task<Void> {

        private String url=txturl_id.getText();
        public DownloadTask(String url){
            this.url = url;
        }
        String fileName = url.substring(url.lastIndexOf('/') + 1);


        @Override
        protected Void call() throws Exception {
            String ext = url.substring(url.lastIndexOf("."), url.length());

            URLConnection connection = new URL(url).openConnection();


            try (InputStream is = connection.getInputStream();

                 OutputStream os = Files.newOutputStream(Paths.get(fileName))) {



                long nread = 0L;
                byte[] buf = new byte[8192];
                int n=0;


                while ((n = is.read(buf)) > 0) {
                    os.write(buf, 0, n);


                    nread += n;
                    d.get(0).setName(Long.toString(nread));
                    System.out.println(d.get(0).getName());
                    Controller_menu c=new Controller_menu(d);
                }
                updateProgress(nread, fieldLength);



//                fieldLength = connection.getContentLengthLong();

            }
            return null;

        }


        @Override
        protected void failed(){
            System.out.println("field");
        }
        @Override
        protected void succeeded(){
            System.out.println("Downloaded");
        }

;  }

public void addDownload(javafx.event.ActionEvent event) throws IOException, ParseException {



    String url=txturl_id.getText();
    URLConnection connection = new URL(url).openConnection();
    String fileName = url.substring(url.lastIndexOf('/') + 1);
    fieldLength = Long.valueOf(connection.getContentLength());

    Task<Void> task = new DownloadTask(txturl_id.getText());
    ProgressBar progressBar = new ProgressBar();
    progressBar.setPrefWidth(350);
    progressBar.progressProperty().bind(task.progressProperty());
    Thread thread = new Thread(task);
    thread.setDaemon(true);
    thread.start();
    Date today=new Date();





    String date=today.toString();
    String size=Long.toString(fieldLength);
    Download f=new Download(fileName,url,size,date);
    data_table.add(new Download(f.getName(),f.getUrl(),f.getSize(),f.getSpeed()
            )
    );

    Download de=new Download(f.getName(),f.getUrl(),f.getSize(),f.getSpeed());

    d.add(de);
    //-------------------------------------
   Controller_menu m=new Controller_menu(d);
   Stage stage;
    stage = (Stage)this.ok_buttn.getScene().getWindow();
    stage.close();//-----------------------------------------------
    m.menu();








}

}
