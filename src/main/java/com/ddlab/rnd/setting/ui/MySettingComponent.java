package com.ddlab.rnd.setting.ui;

import com.ddlab.rnd.setting.util.BasicUiUtil;
import com.intellij.openapi.ui.ComboBox;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class MySettingComponent {
    private JPanel mainPanel;

    private JTextField clientIdTxt;
    private JTextField clientSecretTxt;
    private JTextField oauthEndPointTxt;
    private JComboBox<String> llmModelComboBox;
    private JTextField llmApiEndPointTxt;

    public MySettingComponent() {
        mainPanel = new JPanel();
        mainPanel.setLayout(getPanelLayout());

        createClientIdLabel();
        createClientIdText();

        createClientSecretLabel();
        createClientSecretText();

        createOAuthEndPointLabel();
        createOAuthEndPointText();

        createLLMModelLabel();
        createLLMModelCombo();

        createLlmModelGetButton();

        createLLMApiEndPointLabel();
        createLLMApiEndPointText();
        createTestButton();

        createInfoLabel();

    }

    // ~~~~~~ Specific UI Component Creation ~~~~~~~~

    private GridBagLayout getPanelLayout() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0,};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

        return gridBagLayout;
    }

    private void createClientIdLabel() {
        JLabel clientIdLbl = new JLabel("*Client Id:");
        GridBagConstraints gbc_clientIdLbl = new GridBagConstraints();
        gbc_clientIdLbl.insets = new Insets(0, 0, 5, 5);
        gbc_clientIdLbl.anchor = GridBagConstraints.EAST;
        gbc_clientIdLbl.gridx = 0;
        gbc_clientIdLbl.gridy = 0;
        mainPanel.add(clientIdLbl, gbc_clientIdLbl);
    }

    private void createClientIdText() {
        clientIdTxt = new JTextField();
        GridBagConstraints gbc_clientIdTxt = new GridBagConstraints();
        gbc_clientIdTxt.gridwidth = 3;
        gbc_clientIdTxt.insets = new Insets(0, 0, 5, 5);
        gbc_clientIdTxt.fill = GridBagConstraints.HORIZONTAL;
        gbc_clientIdTxt.gridx = 1;
        gbc_clientIdTxt.gridy = 0;
        mainPanel.add(clientIdTxt, gbc_clientIdTxt);
        clientIdTxt.setColumns(10);
    }

    private void createClientSecretLabel() {
        JLabel clientSecretLbl = new JLabel("*Client Secret:");
        GridBagConstraints gbc_clientSecretLbl = new GridBagConstraints();
        gbc_clientSecretLbl.anchor = GridBagConstraints.EAST;
        gbc_clientSecretLbl.insets = new Insets(0, 0, 5, 5);
        gbc_clientSecretLbl.gridx = 0;
        gbc_clientSecretLbl.gridy = 1;
        mainPanel.add(clientSecretLbl, gbc_clientSecretLbl);
    }

    private void createClientSecretText() {
        clientSecretTxt = new JTextField();
        GridBagConstraints gbc_clientSecretTxt = new GridBagConstraints();
        gbc_clientSecretTxt.gridwidth = 3;
        gbc_clientSecretTxt.anchor = GridBagConstraints.BELOW_BASELINE;
        gbc_clientSecretTxt.insets = new Insets(0, 0, 5, 0);
        gbc_clientSecretTxt.fill = GridBagConstraints.HORIZONTAL;
        gbc_clientSecretTxt.gridx = 1;
        gbc_clientSecretTxt.gridy = 1;
        mainPanel.add(clientSecretTxt, gbc_clientSecretTxt);
        clientSecretTxt.setColumns(10);
    }

    private void createOAuthEndPointLabel() {
        JLabel oauthEndPointLbl = new JLabel("*OAuth End Point:");
        GridBagConstraints gbc_oauthEndPointLbl = new GridBagConstraints();
        gbc_oauthEndPointLbl.anchor = GridBagConstraints.EAST;
        gbc_oauthEndPointLbl.insets = new Insets(0, 0, 5, 5);
        gbc_oauthEndPointLbl.gridx = 0;
        gbc_oauthEndPointLbl.gridy = 2;
        mainPanel.add(oauthEndPointLbl, gbc_oauthEndPointLbl);
    }

    private void createOAuthEndPointText() {
        oauthEndPointTxt = new JTextField();
        GridBagConstraints gbc_oauthEndPointTxt = new GridBagConstraints();
        gbc_oauthEndPointTxt.gridwidth = 3;
        gbc_oauthEndPointTxt.insets = new Insets(0, 0, 5, 5);
        gbc_oauthEndPointTxt.fill = GridBagConstraints.HORIZONTAL;
        gbc_oauthEndPointTxt.gridx = 1;
        gbc_oauthEndPointTxt.gridy = 2;
        mainPanel.add(oauthEndPointTxt, gbc_oauthEndPointTxt);
        oauthEndPointTxt.setColumns(10);
    }

    private void createLLMModelLabel() {
        JLabel llmModelLbl = new JLabel("LLM Models:");
        GridBagConstraints gbc_llmModelLbl = new GridBagConstraints();
        gbc_llmModelLbl.anchor = GridBagConstraints.BASELINE_TRAILING;
        gbc_llmModelLbl.insets = new Insets(0, 0, 5, 5);
        gbc_llmModelLbl.gridx = 0;
        gbc_llmModelLbl.gridy = 3;
        mainPanel.add(llmModelLbl, gbc_llmModelLbl);
    }

    private void createLLMModelCombo() {
        llmModelComboBox = new ComboBox();
        GridBagConstraints gbc_llmModelComboBox = new GridBagConstraints();
        gbc_llmModelComboBox.insets = new Insets(0, 0, 5, 5);
        gbc_llmModelComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_llmModelComboBox.gridx = 1;
        gbc_llmModelComboBox.gridy = 3;
        mainPanel.add(llmModelComboBox, gbc_llmModelComboBox);
        // Set default one
    }

    private void createLlmModelGetButton() {
        JButton llmModelBtn = new JButton("Get Models");
        GridBagConstraints gbc_llmModelBtn = new GridBagConstraints();
        gbc_llmModelBtn.gridwidth = 2;
        gbc_llmModelBtn.insets = new Insets(0, 0, 5, 0);
        gbc_llmModelBtn.anchor = GridBagConstraints.EAST;
        gbc_llmModelBtn.gridx = 2;
        gbc_llmModelBtn.gridy = 3;
        mainPanel.add(llmModelBtn, gbc_llmModelBtn);

        llmModelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llmModelComboBox.removeAllItems(); // clear existing items
                populateLLMModels();
            }
        });
    }



    private void createLLMApiEndPointLabel() {
        JLabel llmApiEndPointLbl = new JLabel("*LLM Api EndPoint:");
        GridBagConstraints gbc_llmApiEndPointLbl = new GridBagConstraints();
        gbc_llmApiEndPointLbl.anchor = GridBagConstraints.EAST;
        gbc_llmApiEndPointLbl.insets = new Insets(0, 0, 5, 5);
        gbc_llmApiEndPointLbl.gridx = 0;
        gbc_llmApiEndPointLbl.gridy = 4;
        mainPanel.add(llmApiEndPointLbl, gbc_llmApiEndPointLbl);
    }

    private void createLLMApiEndPointText() {
        llmApiEndPointTxt = new JTextField();
        GridBagConstraints gbc_llmApiEndPointTxt = new GridBagConstraints();
        gbc_llmApiEndPointTxt.gridwidth = 2;
        gbc_llmApiEndPointTxt.insets = new Insets(0, 0, 0, 5);
        gbc_llmApiEndPointTxt.fill = GridBagConstraints.HORIZONTAL;
        gbc_llmApiEndPointTxt.gridx = 1;
        gbc_llmApiEndPointTxt.gridy = 4;
        mainPanel.add(llmApiEndPointTxt, gbc_llmApiEndPointTxt);
        llmApiEndPointTxt.setColumns(10);
    }

    private void createTestButton() {
        JButton testBtn = new JButton("Test");
        GridBagConstraints gbc_testBtn = new GridBagConstraints();
        gbc_testBtn.insets = new Insets(0, 0, 0, 5);
        gbc_testBtn.gridx = 3;
        gbc_testBtn.gridy = 4;
        mainPanel.add(testBtn, gbc_testBtn);
    }

    private void createInfoLabel() {
        JLabel infoLabel = new JLabel("All * mark fields are mandatory");
        infoLabel.setForeground(new Color(255, 0, 0));
        GridBagConstraints gbc_infoLabel = new GridBagConstraints();
        gbc_infoLabel.gridwidth = 4;
        gbc_infoLabel.insets = new Insets(0, 0, 0, 5);
        gbc_infoLabel.gridx = 0;
        gbc_infoLabel.gridy = 9;
        mainPanel.add(infoLabel, gbc_infoLabel);
    }

    private void populateLLMModels() {
        String clientId = clientIdTxt.getText();
        String clientSecret = clientSecretTxt.getText();

        java.util.List<String> llmComboItems = BasicUiUtil.getLLMModels(clientId, clientSecret);
        for (String comboItem : llmComboItems) {
            llmModelComboBox.addItem(comboItem);
        }
    }

}
