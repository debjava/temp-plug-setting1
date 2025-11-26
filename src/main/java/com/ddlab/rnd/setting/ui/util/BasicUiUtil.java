package com.ddlab.rnd.setting.ui.util;

import com.ddlab.rnd.group.panel.AiDetailsPanel;
import com.ddlab.rnd.group.panel.SnykDetailsPanel;
import com.ddlab.rnd.setting.MyPluginSettings;
import com.ddlab.rnd.setting.ui.MySettingComponent1;
import com.intellij.openapi.ui.Messages;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BasicUiUtil {

    public static List<String> getLLMModels() {
        java.util.List<String> comboItems = List.of("Option A", "Option B", "Option C");
        return comboItems;
    }

    public static List<String> getLLMModels(String clientId, String clientSecret) {
        System.out.println("Client Id: "+clientId);
        System.out.println("Client Secret: "+clientSecret);

        if(clientId == null || clientId.isEmpty()) {
            System.out.println("Client Id is empty ..");
            log.debug("Client Id is empty or blank..");
            Messages.showErrorDialog("Client Id cannot empty or blank", "Error title");
        }
        java.util.List<String> comboItems = List.of("Option A", "Option B", "Option C","Option D","Option E");
        return comboItems;
    }

    public static List<String> getOrgNames() {
        java.util.List<String> comboItems = List.of("Org-A", "Org-B", "Org-C","Org-D","Org-E");
        return comboItems;
    }

    public static void saveAiPanelSetting(MyPluginSettings settings, MySettingComponent1 component) {
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

    public static void saveSnykPanelSetting(MyPluginSettings settings, MySettingComponent1 component) {
        // Snyk Part
        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();
        settings.setSnykUriTxt(snykPanel.getSnykUriTxt().getText());
        settings.setSnykTokenTxt(snykPanel.getSnykTokentxt().getText());

        JComboBox<String> snykOrgComboBox = snykPanel.getOrgNameComboBox();
        java.util.List<String> snykOrgComboItems = getComboBoxItems(snykOrgComboBox);
        settings.setSnykOrgComboItems(snykOrgComboItems);
        settings.setSnykOrgComboSelection((String) snykOrgComboBox.getSelectedItem());
    }

    public static boolean isAiPanelModified(MyPluginSettings settings, MySettingComponent1 component) {
        // For AI Panel
        AiDetailsPanel aiPanel = (AiDetailsPanel) component.getAiDetailsPanel();

        return !aiPanel.getClientIdTxt().getText().equals(settings.getClientIdStr())
                || !aiPanel.getClientSecretTxt().getText().equals(settings.getClientSecretStr())
                || !aiPanel.getOauthEndPointTxt().getText().equals(settings.getOauthEndPointUri())
                || !aiPanel.getLlmApiEndPointTxt().getText().equals(settings.getLlmApiEndPointUri())
                || !aiPanel.getLlmModelcomboBox().getSelectedItem().toString().equals(settings.getLlmModelComboSelection());
    }

    public static boolean isSnykPanelModified(MyPluginSettings settings, MySettingComponent1 component) {
        // For Snyk Panel
        SnykDetailsPanel snykPanel = (SnykDetailsPanel) component.getSnykPanel();
        return !snykPanel.getSnykUriTxt().getText().equals(settings.getSnykUriTxt())
                || !snykPanel.getSnykTokentxt().getText().equals(settings.getSnykTokenTxt())
                || !snykPanel.getOrgNameComboBox().getSelectedItem().toString()
                .equals(settings.getSnykOrgComboSelection());
    }

    public static void resetAiPanel(MyPluginSettings settings, MySettingComponent1 component) {
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

    public static void resetSnykPanel(MyPluginSettings settings, MySettingComponent1 component) {
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

    private static List<String> getComboBoxItems(JComboBox<String> comboBox) {
        ComboBoxModel<String> model = comboBox.getModel();
        List<String> items = new ArrayList<>();

        for (int i = 0; i < model.getSize(); i++) {
            items.add(String.valueOf(model.getElementAt(i)));
        }
        return items;
    }
}
