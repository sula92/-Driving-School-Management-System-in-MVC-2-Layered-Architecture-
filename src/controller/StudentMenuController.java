package controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentMenuController implements Initializable {
    public ScrollPane StdMenu;
    public Label lblMenu;
    public Label lblDescription;
    public ImageView ivStdPay;
    public ImageView ivStdMng;
    public ImageView ivStdCard;
    public FontAwesomeIconView home;
    public AnchorPane AncMenu;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AncMenu.setStyle("-fx-background-color: #2B3856");
        lblDescription.setStyle("-fx-text-fill: white");
        lblMenu.setStyle("-fx-text-fill: white");

        ivStdMng.getStyleClass().add("myButton");
        /*ivEmp.getStyleClass().add("myButton");
        ivExam.getStyleClass().add("myButton");
        ivLec.getStyleClass().add("myButton");
        ivTraining.getStyleClass().add("myButton");
        ivTrial.getStyleClass().add("myButton");*/

       /* miDashboard.getStyleClass().add("myButton");
        miEmp.getStyleClass().add("myButton");
        miExam.getStyleClass().add("myButton");
        miStd.getStyleClass().add("myButton");
        miTrial.getStyleClass().add("myButton");
        miBranch.getStyleClass().add("myButton");
        miTraining.getStyleClass().add("myButton");*/




        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000),StdMenu);
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
            case "ivStdMng":
                this.lblMenu.setText("Manage Students");
                this.lblDescription.setText("Click to add, update or delete Students");
                break;

            case "ivStdCard":
                this.lblMenu.setText("Generate Student Barcode");
                this.lblDescription.setText("Lets Make The Student barcode");
                break;

            case "ivPay":
                this.lblMenu.setText("Manage Employee");
                this.lblDescription.setText("Click to Add, edit, delete Employee");
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
                case "ivStdMng":
                    root = FXMLLoader.load(this.getClass().getResource("/view/StudForm.fxml"));
                    break;
                case "ivStdCard":
                    root = FXMLLoader.load(this.getClass().getResource("/view/Bcode.fxml"));
                    break;
                case "ivStdPay":
                    root = FXMLLoader.load(this.getClass().getResource("/view/Employee.fxml"));
                    break;
                case "ivLec":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/SearchOrdersForm.fxml"));
                    root = fxmlLoader.load();
                    break;
            }



            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.StdMenu.getScene().getWindow();

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
                case "millis":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/SearchOrdersForm.fxml"));
                    root = fxmlLoader.load();
                    break;
                case "home":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/SearchOrdersForm.fxml"));
                    root = fxmlLoader.load();
                    break;
            }



            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.StdMenu.getScene().getWindow();

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
        Stage stage= (Stage) this.StdMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.setFullScreen(false);

    }


    public void GoToHome(MouseEvent mouseEvent) throws IOException {
        URL url=this.getClass().getResource("/view/MainForm.fxml");
        Parent parent=FXMLLoader.load(url);
        Scene scene=new Scene(parent);
        Stage stage= (Stage) this.StdMenu.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.setFullScreen(false);

    }
}
