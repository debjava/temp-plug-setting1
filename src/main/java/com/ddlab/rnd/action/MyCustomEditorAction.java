package com.ddlab.rnd.action;

import com.ddlab.rnd.setting.MyPluginSettings;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;

// Example AnAction implementation
    public class MyCustomEditorAction extends AnAction {
        @Override
        public void actionPerformed(AnActionEvent e) {

            PsiFile file = e.getData(CommonDataKeys.PSI_FILE);

            String fileType = file.getFileType().getName();
            System.out.println("File Type: "+fileType);

            String text = file.getFileDocument().getText();
            System.out.println("Text : "+text);

            MyPluginSettings setting = MyPluginSettings.getInstance();
            String selectedComboItem = setting.getLlmModelComboSelection();
            System.out.println("Selected Combo Item: "+selectedComboItem);

            String clientSecret = setting.getClientSecretStr();
            System.out.println("Client Secret: "+clientSecret);


//            MySettingsState settings = MySettingsState.getInstance();

//            boolean enabled = settings.enableFeature;
//            String endpoint = settings.apiEndpoint;

//            System.out.println("Enabled: "+enabled);
//            System.out.println("End Point: "+endpoint);

            // Implement your action logic here
            // e.g., get the current editor, caret position, etc.
            Editor editor = e.getData(CommonDataKeys.EDITOR);
            if (editor != null) {
                // Perform actions on the editor content
                Messages.showMessageDialog(editor.getProject(), "Hello from custom editor action!", "Custom Action", Messages.getInformationIcon());
            }
        }

        @Override
        public void update(AnActionEvent e) {
            // Control visibility and enablement of the action
            // e.g., enable only if an editor is active
            Editor editor = e.getData(CommonDataKeys.EDITOR);
            e.getPresentation().setEnabledAndVisible(editor != null);
        }
    }