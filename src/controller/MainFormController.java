package controller;

import com.sun.xml.internal.ws.api.pipe.Engine;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable  {

    public Label lblMenu;
    public ImageView ivStd;
    public ImageView ivExam;
    public ImageView ivEmp;
    public ImageView ivLec;
    public ImageView ivTrial;
    public ImageView ivTraining;
    public Label lblDescription;
    public Text miDashboard;
    public Text miStd;
    public Text miEmp;
    public Text miExam;
    public Text miTrial;
    public Text miBranch;
    public Text miVehicle;
    public Text miTraining;
    public Text miSupplier;
    public ProgressBar pgb;

    public ScrollPane MainForm;
    public AnchorPane AncMenu;
    public Hyperlink hlink;
    public ImageView ivBranch;
    public ImageView ivVehicle;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AncMenu.setStyle("-fx-background-color: #2C3539");
        lblDescription.setStyle("-fx-text-fill: white");

        pgb.setVisible(false);

        ivStd.getStyleClass().add("myButton");
        ivEmp.getStyleClass().add("myButton");
        ivExam.getStyleClass().add("myButton");
        ivLec.getStyleClass().add("myButton");
        ivTraining.getStyleClass().add("myButton");
        ivTrial.getStyleClass().add("myButton");

        miDashboard.getStyleClass().add("myButton");
        miEmp.getStyleClass().add("myButton");
        miExam.getStyleClass().add("myButton");
        miStd.getStyleClass().add("myButton");
        miTrial.getStyleClass().add("myButton");
        miBranch.getStyleClass().add("myButton");
        miTraining.getStyleClass().add("myButton");

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000),MainForm);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(2.0);
        fadeIn.play();

    }

    public void img_mouseEnterence(MouseEvent mouseEvent) {
        ImageView icon = (ImageView)mouseEvent.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200.0D), icon);
        scaleT.setToX(1.2D);
        scaleT.setToY(1.2D);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.RED);
        glow.setWidth(20.0D);
        glow.setHeight(20.0D);
        glow.setRadius(40.0D);
        icon.setEffect(glow);

        String cat =icon.getId();
        switch (cat){
            case "ivStd":
                this.lblMenu.setText("Manage Students");
                this.lblDescription.setText("Click to add, update or delete Students");
                break;

            case "ivExam":
                this.lblMenu.setText("Manage Exams");
                this.lblDescription.setText("Click to add, update or delete Exams");
                break;

            case "ivEmp":
                this.lblMenu.setText("Manage Employee");
                this.lblDescription.setText("Click to Add, edit, delete Employee");
                break;

            case "ivLec":
                this.lblMenu.setText("Manage Lectures");
                this.lblDescription.setText("Click to Manage Lecture Details Or Search Details");
                break;
            case "ivTraining":
                this.lblMenu.setText("Manage Lectures");
                this.lblDescription.setText("Click to Manage Lecture Details Or Search Details");
                break;
            case "ivBranch":
                this.lblMenu.setText("Manage Branches");
                this.lblDescription.setText("Click to Manage Branch Details Or Search Details");
            case "ivTrial":
                this.lblMenu.setText("Manage Trial");
                this.lblDescription.setText("Click to Manage Trial Details Or Search Details");
                break;
            case "ivVehicle":
                this.lblMenu.setText("Manage Vehicle");
                this.lblDescription.setText("Click to Manage Vehicle Details Or Search Details");
                break;
        }

    }



    public void img_mouseExit(MouseEvent mouseEvent) {
        ImageView icon = (ImageView) mouseEvent.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200.0D),icon);
        scaleT.setToX(1D);
        scaleT.setToY(1D);
        scaleT.play();
        icon.setEffect(null);
        DropShadow glow = new DropShadow();
        glow.setColor(Color.BLUE);
        glow.setWidth(20.0D);
        glow.setHeight(20.0D);
        glow.setRadius(40.0D);
        icon.setEffect(glow);
        lblMenu.setText("");
        lblDescription.setText("");
    }

    @FXML
    private void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            FXMLLoader fxmlLoader = null;
            switch (icon.getId()) {
                case "ivStd":
                    root = FXMLLoader.load(this.getClass().getResource("/view/StudentMenu.fxml"));
                    break;
                case "ivExam":
                    root = FXMLLoader.load(this.getClass().getResource("/view/Exam.fxml"));
                    break;
                case "ivEmp":
                    root = FXMLLoader.load(this.getClass().getResource("/view/Employee.fxml"));
                    break;
                case "ivTrial":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/Trial.fxml"));
                    root = fxmlLoader.load();
                    break;

                case "ivBranch":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/Branch.fxml"));
                    root = fxmlLoader.load();
                    break;
                case "ivTraining":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/Training.fxml"));
                    root = fxmlLoader.load();
                    break;
                case "ivLec":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/Lecture.fxml"));
                    root = fxmlLoader.load();
                    break;
                case "ivVehicle":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/vehicle.fxml"));
                    root = fxmlLoader.load();
                    break;
            }



            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.MainForm.getScene().getWindow();

                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }


    @FXML
    private void navigate2(MouseEvent event) throws IOException {
        if (event.getSource() instanceof Text) {
            Text icon = (Text) event.getSource();

            Parent root = null;

            FXMLLoader fxmlLoader = null;
            switch (icon.getId()) {
                case "miDashboard":
                    root = FXMLLoader.load(this.getClass().getResource("/view/DashBoard.fxml"));
                    break;
                case "miStd":
                    root = FXMLLoader.load(this.getClass().getResource("/view/StudentForm.fxml"));
                    break;
                case "miExam":
                    root = FXMLLoader.load(this.getClass().getResource("/view/Exam.fxml"));
                    break;
                case "miEmp":
                    root = FXMLLoader.load(this.getClass().getResource("/view/Employee.fxml"));
                    break;
                case "mibranch":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/Branch.fxml"));
                    root = fxmlLoader.load();
                case "mitrial":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/Trial.fxml"));
                    root = fxmlLoader.load();
                    break;


            }



            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.MainForm.getScene().getWindow();

                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    public void DashboardOnClick(MouseEvent mouseEvent) throws IOException {

        URL url=this.getClass().getResource("/view/DashBoard.fxml");
        Parent parent=FXMLLoader.load(url);
        Scene scene=new Scene(parent);
        Stage stage= (Stage) this.MainForm.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.setFullScreen(false);

    }


    public void GoToWeb(MouseEvent mouseEvent) throws URISyntaxException, IOException {

       Desktop d=Desktop.getDesktop();
       d.browse(new URI("http://localhost/samadhilearners/"));


    }
}
