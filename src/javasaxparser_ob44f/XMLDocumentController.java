/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparser_ob44f;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 *
 * @author ob44f
 */
public class XMLDocumentController implements Initializable {
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private void handleOpen(ActionEvent event) throws Exception {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(textArea.getScene().getWindow());
        if (file != null) {
            ParseXMLLoader loader = new ParseXMLLoader();
            loader.load(file);
            if(!loader.getTextBody().isEmpty()){
               textArea.setText("");    // clear window before appending
               textArea.setText(loader.getTextBody());    // generate textBody
               loader.setTextBody();    // clear textBody after finishing
            }
        }
    } 
    @FXML
    private void handleClear(ActionEvent event) {
        textArea.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
