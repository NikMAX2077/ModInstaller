package com.nikmax.modinstaller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ModlistController {
    protected void SetData(String string) {
        path = string;
    }

    String path;
    @FXML
    private Button nextBtn;

    @FXML
    protected void onNextBtn_Click() {


    }

    @FXML
    protected void onCancelBtn_Click() {
        //вернуться на страницу назад
    }
}
