package com.ddlab.rnd.setting;

import com.ddlab.rnd.setting.ui.MySettingComponent1;
import com.ddlab.rnd.setting.ui.util.BasicUiUtil;
import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MyPluginConfigurable implements Configurable {

    private JPanel panel;
    private MySettingComponent1 component;

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
        return BasicUiUtil.isAiPanelModified(settings,component)
                || BasicUiUtil.isSnykPanelModified(settings,component);
    }

    @Override
    public void apply() {
        MyPluginSettings settings = MyPluginSettings.getInstance();

        BasicUiUtil.saveAiPanelSetting(settings,component);
        BasicUiUtil.saveSnykPanelSetting(settings,component);
    }

    @Override
    public void reset() {
        MyPluginSettings settings = MyPluginSettings.getInstance();

        BasicUiUtil.resetAiPanel(settings,component);
        BasicUiUtil.resetSnykPanel(settings,component);

    }

    // ~~~~~~~~ private methods ~~~~~~~~

    private JPanel createUIAndGetPanel() {
        component = new MySettingComponent1();
        return component.getMainPanel();
    }

//    @Override
//    public void disposeUIResources() {
//        panel = null;
//        textField = null;
//        comboBox = null;
//    }
}