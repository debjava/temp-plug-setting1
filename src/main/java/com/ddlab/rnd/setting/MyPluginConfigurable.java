package com.ddlab.rnd.setting;

import com.ddlab.rnd.group.panel.AiDetailsPanel;
import com.ddlab.rnd.group.panel.SnykDetailsPanel;
import com.ddlab.rnd.setting.ui.MySettingComponent1;
import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyPluginConfigurable implements Configurable {

    private JPanel panel;
//    MySettingComponent component = null;

    MySettingComponent1 component;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "My Plugin Settings";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        panel = createUIAndGetPanel();
        return panel;

    }

    @Override
    public boolean isModified() {
        MyPluginSettings settings = MyPluginSettings.getInstance();
        return isAiPanelModified(settings) || isSnykPanelModified(settings);
    }

    @Override
    public void apply() {
        MyPluginSettings settings = MyPluginSettings.getInstance();

        saveAiPanelSetting(settings);
        saveSnykPanelSetting(settings);

//        // AI Part
//        AiDetailsPanel aiPanel = (AiDetailsPanel) component.getAiDetailsPanel();
//        settings.setClientIdStr(aiPanel.getClientIdTxt().getText());
//        settings.setClientSecretStr(aiPanel.getClientSecretTxt().getText());
//        settings.setOauthEndPointUri(aiPanel.getOauthEndPointTxt().getText());
//        settings.setLlmApiEndPointUri(aiPanel.getLlmApiEndPointTxt().getText());
//
//        JComboBox<String> llmModelComboBox = aiPanel.getLlmModelcomboBox();
//        java.util.List<String> allLlmModelComboItems = getComboBoxItems(llmModelComboBox);
////        if (!allLlmModelComboItems.isEmpty()) {
//            settings.setLlmModelComboItems(allLlmModelComboItems);
//            settings.setLlmModelComboSelection((String) llmModelComboBox.getSelectedItem());
////        }
//
//
//        // Snyk Part
//        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();
//        settings.setSnykUriTxt(snykPanel.getSnykUriTxt().getText());
//        settings.setSnykTokentxt(snykPanel.getSnykTokentxt().getText());
//
//        JComboBox<String> snykOrgComboBox = snykPanel.getOrgNameComboBox();
//        java.util.List<String> snykOrgComboItems = getComboBoxItems(snykOrgComboBox);
////        if (!snykOrgComboItems.isEmpty()) {
//            settings.setSnykOrgComboItems(snykOrgComboItems);
//            settings.setSnykOrgComboSelection((String) snykOrgComboBox.getSelectedItem());
////        }





        // To be deleted later
//        settings.setSnykOrgComboItems( (String) snykPanel.getOrgNameComboBox().getSelectedItem());
//        JComboBox llmModelComboBox = component.getLlmModelComboBox();
//
//        settings.setClientIdStr(component.getClientIdTxt().getText());
//        settings.setClientSecretStr(component.getClientSecretTxt().getText());
//        settings.setOauthEndPointUri(component.getOauthEndPointTxt().getText());
//        settings.setLlmApiEndPointUri(component.getLlmApiEndPointTxt().getText());
//
//        java.util.List<String> allComboItems = getComboBoxItems(llmModelComboBox);
//        settings.setComboItems(allComboItems);
//        settings.setComboSelection((String) component.getLlmModelComboBox().getSelectedItem());

    }





    @Override
    public void reset() {
        MyPluginSettings settings = MyPluginSettings.getInstance();

        resetAiPanel(settings);
        resetSnykPanel(settings);

//        // For AI
//        AiDetailsPanel aiPanel = (AiDetailsPanel) component.getAiDetailsPanel();
//        aiPanel.getClientIdTxt().setText(settings.getClientIdStr());
//        aiPanel.getClientSecretTxt().setText(settings.getClientSecretStr());
//        aiPanel.getOauthEndPointTxt().setText(settings.getOauthEndPointUri());
//        aiPanel.getLlmApiEndPointTxt().setText(settings.getLlmApiEndPointUri());
//
//
//        JComboBox<String> llmModelComboBox = aiPanel.getLlmModelcomboBox();
//        java.util.List<String> llmModelComboItems = settings.getLlmModelComboItems();
////        if(!llmModelComboItems.isEmpty()) {
//        if(llmModelComboItems != null) {
//            llmModelComboItems.forEach(value -> llmModelComboBox.addItem(value));
//        }
//
////            for(String llmModelComboItem : llmModelComboItems) {
////                llmModelComboItems.forEach(value -> llmModelComboBox.addItem(value));
////            }
//            llmModelComboBox.setSelectedItem(settings.getLlmModelComboSelection());
////        }
//
//        // For Snyk
//        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();
//        snykPanel.getSnykUriTxt().setText(settings.getSnykUriTxt());
//        snykPanel.getSnykTokentxt().setText(settings.getSnykTokentxt());
//
//        JComboBox<String> snykOrgNameComboBox = snykPanel.getOrgNameComboBox();
//        java.util.List<String> snykOrgComboItems = settings.getSnykOrgComboItems();
////        System.out.println("snykOrgComboItems: "+snykOrgComboItems);
////        if(!snykOrgComboItems.isEmpty()) {
//            //        snykOrgNameComboBox.removeAllItems();
//        if(snykOrgComboItems != null) {
//            snykOrgComboItems.forEach(value -> snykOrgNameComboBox.addItem(value));
//        }
////            snykOrgComboItems.forEach(value -> snykOrgNameComboBox.addItem(value));
//            snykOrgNameComboBox.setSelectedItem(settings.getSnykOrgComboSelection());
////        }



        // To be deleted later

//        component.getClientIdTxt().setText(settings.getClientIdStr());
//        component.getClientSecretTxt().setText(settings.getClientSecretStr());
//        component.getOauthEndPointTxt().setText(settings.getOauthEndPointUri());
//        component.getLlmApiEndPointTxt().setText(settings.getLlmApiEndPointUri());
//
//        java.util.List<String> comboItems = settings.getComboItems();
//        JComboBox comboBox = component.getLlmModelComboBox();
//        for (String ss : comboItems)
//            comboBox.addItem(ss);
//        component.getLlmModelComboBox().setSelectedItem(settings.getComboSelection());

    }

    // ~~~~~~~~ private methods ~~~~~~~~

    private JPanel createUIAndGetPanel() {
        component = new MySettingComponent1();
        return component.getMainPanel();
    }

    private void saveAiPanelSetting(MyPluginSettings settings) {
        // AI Part
        AiDetailsPanel aiPanel = (AiDetailsPanel) component.getAiDetailsPanel();
        settings.setClientIdStr(aiPanel.getClientIdTxt().getText());
        settings.setClientSecretStr(aiPanel.getClientSecretTxt().getText());
        settings.setOauthEndPointUri(aiPanel.getOauthEndPointTxt().getText());
        settings.setLlmApiEndPointUri(aiPanel.getLlmApiEndPointTxt().getText());

        JComboBox<String> llmModelComboBox = aiPanel.getLlmModelcomboBox();
        java.util.List<String> allLlmModelComboItems = getComboBoxItems(llmModelComboBox);
        settings.setLlmModelComboItems(allLlmModelComboItems);
        settings.setLlmModelComboSelection((String) llmModelComboBox.getSelectedItem());
    }

    private void saveSnykPanelSetting(MyPluginSettings settings) {
        // Snyk Part
        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();
        settings.setSnykUriTxt(snykPanel.getSnykUriTxt().getText());
        settings.setSnykTokenTxt(snykPanel.getSnykTokentxt().getText());

        JComboBox<String> snykOrgComboBox = snykPanel.getOrgNameComboBox();
        java.util.List<String> snykOrgComboItems = getComboBoxItems(snykOrgComboBox);
        settings.setSnykOrgComboItems(snykOrgComboItems);
        settings.setSnykOrgComboSelection((String) snykOrgComboBox.getSelectedItem());
    }

    private static List<String> getComboBoxItems(JComboBox<String> comboBox) {
        ComboBoxModel<String> model = comboBox.getModel();
        List<String> items = new ArrayList<>();

        for (int i = 0; i < model.getSize(); i++) {
            items.add(String.valueOf(model.getElementAt(i)));
        }
        return items;
    }

    private boolean isAiPanelModified(MyPluginSettings settings) {
        // For AI Panel
        AiDetailsPanel aiPanel = (AiDetailsPanel) component.getAiDetailsPanel();

        return !aiPanel.getClientIdTxt().getText().equals(settings.getClientIdStr())
                || !aiPanel.getClientSecretTxt().getText().equals(settings.getClientSecretStr())
                || !aiPanel.getOauthEndPointTxt().getText().equals(settings.getOauthEndPointUri())
                || !aiPanel.getLlmApiEndPointTxt().getText().equals(settings.getLlmApiEndPointUri())
                || !aiPanel.getLlmModelcomboBox().getSelectedItem().toString().equals(settings.getLlmModelComboSelection());
    }

    private boolean isSnykPanelModified(MyPluginSettings settings) {
        // For Snyk Panel
        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();
        return !snykPanel.getSnykUriTxt().getText().equals(settings.getSnykUriTxt())
                || !snykPanel.getSnykTokentxt().getText().equals(settings.getSnykTokenTxt())
                || !snykPanel.getOrgNameComboBox().getSelectedItem().toString().equals(settings.getSnykOrgComboSelection());
    }

    private void resetAiPanel(MyPluginSettings settings) {
        // For AI
        AiDetailsPanel aiPanel = (AiDetailsPanel) component.getAiDetailsPanel();
        aiPanel.getClientIdTxt().setText(settings.getClientIdStr());
        aiPanel.getClientSecretTxt().setText(settings.getClientSecretStr());
        aiPanel.getOauthEndPointTxt().setText(settings.getOauthEndPointUri());
        aiPanel.getLlmApiEndPointTxt().setText(settings.getLlmApiEndPointUri());

        JComboBox<String> llmModelComboBox = aiPanel.getLlmModelcomboBox();
        java.util.List<String> llmModelComboItems = settings.getLlmModelComboItems();
        if(llmModelComboItems != null) {
            llmModelComboItems.forEach(value -> llmModelComboBox.addItem(value));
        }
        llmModelComboBox.setSelectedItem(settings.getLlmModelComboSelection());
    }

    private void resetSnykPanel(MyPluginSettings settings) {
        // For Snyk
        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();
        snykPanel.getSnykUriTxt().setText(settings.getSnykUriTxt());
        snykPanel.getSnykTokentxt().setText(settings.getSnykTokenTxt());

        JComboBox<String> snykOrgNameComboBox = snykPanel.getOrgNameComboBox();
        java.util.List<String> snykOrgComboItems = settings.getSnykOrgComboItems();
        if(snykOrgComboItems != null) {
            snykOrgComboItems.forEach(value -> snykOrgNameComboBox.addItem(value));
        }
        snykOrgNameComboBox.setSelectedItem(settings.getSnykOrgComboSelection());
    }

//    @Override
//    public void disposeUIResources() {
//        panel = null;
//        textField = null;
//        comboBox = null;
//    }
}