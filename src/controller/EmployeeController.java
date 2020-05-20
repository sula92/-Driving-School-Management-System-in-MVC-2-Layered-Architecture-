package controller;

import business.BOFactory;
import business.BOTypes;
import business.custom.BranchBO;
import business.custom.EmployeeBO;
import com.jfoenix.controls.*;
import dto.BranchDTO;
import dto.EmployeeDTO;
import javafx.collections.ObservableFloatArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {
    public JFXButton btnSave;
    public JFXButton btnSave1;
    public ScrollPane Empform;
    public ImageView imgEmp;
    public JFXTextField txtEmpId;
    public JFXTextField txtNic;
    public JFXComboBox<String> cmbGen;
    public JFXDatePicker txtDob;
    public JFXTextField txtNm;
    public JFXTextField txtAge;
    public JFXTextArea txtAdd;
    public JFXTextField txtmob;
    public JFXTextField txtPhone;
    public JFXTextField txtEmail;
    public JFXTextField txtPos;
    public JFXTextField txtSal;
    public JFXComboBox cmbBra;
    public JFXDatePicker txtDORec;
    public JFXTextField txtGrade;
    public TableView tblEmp;
    public TableColumn colNm;
    public TableColumn colEmpId;
    public TableColumn colNic;
    public TableColumn colPos;
    public TableColumn colBra;
    public TableColumn colDORec;
    public TableColumn colCont;
    public TableColumn colDel;

    BranchBO branchBO= BOFactory.getInstance().getBO(BOTypes.BRANCH);
    EmployeeBO employeeBO=BOFactory.getInstance().getBO(BOTypes.EMPLOYEE);


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<BranchDTO> branchDTOS= null;
        try {
            branchDTOS = branchBO.findAllBranch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> branch=new ArrayList<>();
        for (BranchDTO branchDTO:branchDTOS) {

            branch.add(branchDTO.getBranchId());

        }
        cmbBra.getItems().addAll(branch);

        ArrayList<String> gen=new ArrayList<>();
        gen.add("Male");
        gen.add("Female");
        cmbGen.getItems().addAll(gen);

    }



    public void GoToHome(MouseEvent mouseEvent) throws IOException {
        URL url=this.getClass().getResource("/view/MainForm.fxml");
        Parent parent= FXMLLoader.load(url);
        Scene scene=new Scene(parent);
        Stage stage= (Stage) this.Empform.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.setFullScreen(false);

    }

    public void SaveAction(ActionEvent event) {

        ArrayList<EmployeeDTO> employeeDTOS=new ArrayList<EmployeeDTO>();
        EmployeeDTO employeeDTO=new EmployeeDTO(txtEmpId.getText(),txtNic.getText(),txtPos.getText(),txtSal.getText(),cmbBra.getValue().toString(),txtDORec.getValue().toString(),txtGrade.getText(),cmbGen.getValue().toString(),txtNm.getText(),txtDob.getValue().toString(),txtAge.getText(),"male",txtAdd.getText(),txtmob.getText(),txtPhone.getText(),txtEmail.getText());
        try {
            System.out.println("Con_s"+employeeDTO.toString());
            employeeBO.saveEmployee(employeeDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
