package com.ddlab.rnd.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

@State(
        name = "MyPluginSettings",
        storages = @Storage("MyPluginSettings.xml")
)
@Getter @Setter
public class MyPluginSettings implements PersistentStateComponent<MyPluginSettings> {

    private String clientIdStr;
    private String clientSecretStr;
    private String oauthEndPointUri;
    private String llmModelComboSelection;
    private java.util.List<String> llmModelComboItems;
    private String llmApiEndPointUri;

    // Snyk details
    private String snykUriTxt;
    private String snykTokentxt;
//    private java.util.List snykOrgComboItems = new LinkedList<>();
    private String snykOrgComboSelection;


    public static MyPluginSettings getInstance() {
        return com.intellij.openapi.application.ApplicationManager
                .getApplication()
                .getService(MyPluginSettings.class);
    }

    @Nullable
    @Override
    public MyPluginSettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull MyPluginSettings state) {
//        XmlSerializerUtil.copyBean(state, this);
        this.clientIdStr = state.clientIdStr;
        this.clientSecretStr = state.clientSecretStr;
        this.oauthEndPointUri = state.oauthEndPointUri;

        this.llmModelComboItems = state.llmModelComboItems;
        this.llmModelComboSelection = state.llmModelComboSelection;
        this.llmApiEndPointUri = state.llmApiEndPointUri;

        // For Snyk
        this.snykUriTxt = state.snykUriTxt;
        this.snykTokentxt = state.snykTokentxt;
//        this.snykOrgComboItems = state.snykOrgComboItems;
//        this.snykOrgComboSelection = state.snykOrgComboSelection;
    }

}