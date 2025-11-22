package com.ddlab.rnd.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "MyPluginSettings",
        storages = @Storage("MyPluginSettings.xml")
)
@Getter @Setter
public class MyPluginSettings implements PersistentStateComponent<MyPluginSettings> {

    private String clientIdStr;
    private String clientSecretStr;
    private String oauthEndPointUri;
    private String comboSelection = "";
    private java.util.List<String> comboItems;
    private String llmApiEndPointUri;

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
        this.clientIdStr = state.clientIdStr;
        this.clientSecretStr = state.clientSecretStr;
        this.oauthEndPointUri = state.oauthEndPointUri;

        this.comboItems = state.comboItems;
        this.comboSelection = state.comboSelection;
        this.llmApiEndPointUri = state.llmApiEndPointUri;
    }

}