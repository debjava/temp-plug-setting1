package com.ddlab.rnd.setting;

import com.ddlab.rnd.setting.ui.MySettingComponent;
import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyPluginConfigurable implements Configurable {

    private JPanel panel;
    MySettingComponent component = null;

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
        component = new MySettingComponent();
        return component.getMainPanel();
    }

    @Override
    public boolean isModified() {
        MyPluginSettings settings = MyPluginSettings.getInstance();

        return !component.getClientIdTxt().equals(settings.getClientIdStr())
                || !component.getClientSecretTxt().equals(settings.getClientSecretStr())
                || !component.getOauthEndPointTxt().equals(settings.getOauthEndPointUri())
                || !component.getLlmApiEndPointTxt().equals(settings.getLlmApiEndPointUri())
                || !component.getLlmModelComboBox().equals(settings.getComboSelection());
    }

    @Override
    public void apply() {
        MyPluginSettings settings = MyPluginSettings.getInstance();
        JComboBox llmModelComboBox = component.getLlmModelComboBox();

        settings.setClientIdStr(component.getClientIdTxt().getText());
        settings.setClientSecretStr(component.getClientSecretTxt().getText());
        settings.setOauthEndPointUri(component.getOauthEndPointTxt().getText());
        settings.setLlmApiEndPointUri(component.getLlmApiEndPointTxt().getText());

        java.util.List<String> allComboItems = getComboBoxItems(llmModelComboBox);
        settings.setComboItems(allComboItems);
        settings.setComboSelection((String) component.getLlmModelComboBox().getSelectedItem());

    }

    @Override
    public void reset() {
        MyPluginSettings settings = MyPluginSettings.getInstance();

        component.getClientIdTxt().setText(settings.getClientIdStr());
        component.getClientSecretTxt().setText(settings.getClientSecretStr());
        component.getOauthEndPointTxt().setText(settings.getOauthEndPointUri());
        component.getLlmApiEndPointTxt().setText(settings.getLlmApiEndPointUri());

        java.util.List<String> comboItems = settings.getComboItems();
        JComboBox comboBox = component.getLlmModelComboBox();
        for (String ss : comboItems)
            comboBox.addItem(ss);
        component.getLlmModelComboBox().setSelectedItem(settings.getComboSelection());
    }

    public static List<String> getComboBoxItems(JComboBox<String> comboBox) {
        ComboBoxModel<?> model = comboBox.getModel();
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