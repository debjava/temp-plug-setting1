package com.ddlab.rnd.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "MyPluginSettings2",
        storages = @Storage("MyPluginSettings2.xml")
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
    private String snykTokenTxt;
    private java.util.List<String> snykOrgComboItems;
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
        this.snykTokenTxt = state.snykTokenTxt;
        this.snykOrgComboItems = state.snykOrgComboItems;
        this.snykOrgComboSelection = state.snykOrgComboSelection;
    }

}