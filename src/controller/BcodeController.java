package controller;

import com.jfoenix.controls.JFXButton;
import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BcodeController implements Initializable {
    public FontAwesomeIconView home;
    public Label lblMenu;
    public AnchorPane AncMenu;
    public ImageView ivStdMng;
    public ImageView ivStdCard;
    public ImageView ivStdPay;
    public Label lblDescription;
    public TextField txtId;
    public Label lbldes;
    public JFXButton btnGen;
    public ScrollPane BcodeForm;
    public JFXButton btnfolder;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void btnGenAction(ActionEvent event) {

        BarCode code128 = new BarCode();

        String id=txtId.getText();

        code128.setCodeToEncode(id);
        code128.setSymbology(IBarCode.CODE128);
        code128.setX(2);
        code128.setY(50);
        code128.setRightMargin(0);
        code128.setLeftMargin(0);
        code128.setTopMargin(0);
        code128.setBottomMargin(0);
        code128.setChecksumEnabled(false);
        code128.setFnc1(IBarCode.FNC1_NONE);

        try
        {

            code128.draw("c://bcode/code128.gif");
            System.out.println("BCode Created");
            new Alert(Alert.AlertType.INFORMATION,"Barcode has been Generated for ID Number"+id+"Please Check the Bcode Folder").show();


        }
        catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Something went wrong, please contact DEPPO").show();
        }

    }

    public void GoToHome(MouseEvent mouseEvent) throws IOException {

        URL url=this.getClass().getResource("/view/MainForm.fxml");
        Parent parent= FXMLLoader.load(url);
        Scene scene=new Scene(parent);
        Stage stage= (Stage) this.BcodeForm.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.setFullScreen(false);

    }

    public void btnfolderAction(ActionEvent event) {

        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("c:\\bcode");
            desktop.open(dirToOpen);
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
