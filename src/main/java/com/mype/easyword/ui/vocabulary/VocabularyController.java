package com.mype.easyword.ui.vocabulary;

import com.google.inject.Inject;
import com.mype.easyword.service.VocabularyService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

/**
 * @author Vitaliy Gerya
 */
public class VocabularyController implements Initializable {
    private ResourceBundle resources;
    @Inject
    private VocabularyService service;
    @FXML
    private ListView<VocabularyRow> vocabularyListView;


    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.resources = resources;
    }

    @FXML
    public void addVocabulary(javafx.event.ActionEvent actionEvent) {
        System.out.println(service == null);
        ObservableList<VocabularyRow> vocabularyList = vocabularyListView.getItems();
        VocabularyRow row = new VocabularyRow();
        // TODO get name from dialog;
        row.setName("Fill name");
        row.setCreationDate(LocalDateTime.now());
        vocabularyList.add(row);
    }

    public void removeVocabulary(ActionEvent actionEvent) {
        MultipleSelectionModel<VocabularyRow> selectionModel = vocabularyListView.getSelectionModel();
        ObservableList<VocabularyRow> selectedItems = selectionModel.getSelectedItems();
        ObservableList<VocabularyRow> items = vocabularyListView.getItems();
        selectedItems.stream().forEach(selectedItem -> items.remove(selectedItem));
    }

    public void addWord(ActionEvent actionEvent) {

    }

    public void removeWord(ActionEvent actionEvent) {

    }

}
