package com.ddlab.rnd.setting;

import com.ddlab.rnd.group.panel.AiDetailsPanel;
import com.ddlab.rnd.group.panel.SnykDetailsPanel;
import com.ddlab.rnd.setting.ui.MySettingComponent;
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

    private JPanel createUIAndGetPanel() {
//        component = new MySettingComponent();
//        return component.getMainPanel();

        component = new MySettingComponent1();
        return component.getMainPanel();
    }

    @Override
    public boolean isModified() {
        MyPluginSettings settings = MyPluginSettings.getInstance();

        // For AI Panel
        AiDetailsPanel aiPanel = (AiDetailsPanel) component.getAiDetailsPanel();


        // For Snyk Panel
        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();


        return !aiPanel.getClientIdTxt().equals(settings.getClientIdStr())

//                || aiPanel.getLlmModelcomboBox().getSelectedItem().equals(settings.getLlmModelComboSelection())
                || snykPanel.getSnykUriTxt().getText().equals(settings.getSnykUriTxt());
//                || snykPanel.getOrgNameComboBox().getSelectedItem().equals(settings.getSnykOrgComboSelection());

//        return true;

//        return !component.getClientIdTxt().equals(settings.getClientIdStr())
//                || !component.getClientSecretTxt().equals(settings.getClientSecretStr())
//                || !component.getOauthEndPointTxt().equals(settings.getOauthEndPointUri())
//                || !component.getLlmApiEndPointTxt().equals(settings.getLlmApiEndPointUri())
//                || !component.getLlmModelComboBox().equals(settings.getComboSelection());
    }

    @Override
    public void apply() {
        MyPluginSettings settings = MyPluginSettings.getInstance();

        // AI Part
        AiDetailsPanel aiPanel = (AiDetailsPanel) component.getAiDetailsPanel();
        settings.setClientIdStr(aiPanel.getClientIdTxt().getText());

//        JComboBox<String> llmModelComboBox = aiPanel.getLlmModelcomboBox();
//        java.util.List<String> allLlmModelComboItems = getComboBoxItems(llmModelComboBox);
//        if (!allLlmModelComboItems.isEmpty()) {
//            settings.setLlmModelComboItems(allLlmModelComboItems);
//            settings.setLlmModelComboSelection((String) llmModelComboBox.getSelectedItem());
//        }


        // Snyk Part
        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();
        settings.setSnykUriTxt(snykPanel.getSnykUriTxt().getText());

//        JComboBox<String> snykOrgComboBox = snykPanel.getOrgNameComboBox();
//        java.util.List<String> snykOrgComboItems = getComboBoxItems(snykOrgComboBox);
//        if (!snykOrgComboItems.isEmpty()) {
//            settings.setSnykOrgComboItems(snykOrgComboItems);
//            settings.setSnykOrgComboSelection((String) snykOrgComboBox.getSelectedItem());
//        }


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

        // For AI
        AiDetailsPanel aiPanel = (AiDetailsPanel) component.getAiDetailsPanel();
        aiPanel.getClientIdTxt().setText(settings.getClientIdStr());


//        JComboBox<String> llmModelComboBox = aiPanel.getLlmModelcomboBox();
//        java.util.List<String> llmModelComboItems = settings.getLlmModelComboItems();
//        if(!llmModelComboItems.isEmpty()) {
//            llmModelComboItems.forEach(value -> llmModelComboBox.addItem(value));
//            llmModelComboBox.setSelectedItem(settings.getLlmModelComboSelection());
//        }

        // For Snyk
        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();
        snykPanel.getSnykUriTxt().setText(settings.getSnykUriTxt());

//        JComboBox<String> snykOrgNameComboBox = snykPanel.getOrgNameComboBox();
//        java.util.List<String> snykOrgComboItems = settings.getSnykOrgComboItems();
//        if(!snykOrgComboItems.isEmpty()) {
//            //        snykOrgNameComboBox.removeAllItems();
//            snykOrgComboItems.forEach(value -> snykOrgNameComboBox.addItem(value));
//            snykOrgNameComboBox.setSelectedItem(settings.getSnykOrgComboSelection());
//        }





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

    public static List<String> getComboBoxItems(JComboBox<String> comboBox) {
        ComboBoxModel<String> model = comboBox.getModel();
        List<String> items = new ArrayList<>();

        for (int i = 0; i < model.getSize(); i++) {
            items.add(String.valueOf(model.getElementAt(i)));
        }
        return items;
    }

//    @Override
//    public void disposeUIResources() {
//        panel = null;
//        textField = null;
//        comboBox = null;
//    }
}