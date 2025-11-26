package com.ddlab.rnd.setting.util;

import com.intellij.openapi.ui.Messages;

import java.util.List;

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
            Messages.showErrorDialog("Client Id cannot empty or blank", "Error title");
        }
        java.util.List<String> comboItems = List.of("Option A", "Option B", "Option C","Option D","Option E");
        return comboItems;
    }

    public static List<String> getOrgNames() {
        java.util.List<String> comboItems = List.of("Org-A", "Org-B", "Org-C","Org-D","Org-E");
        return comboItems;
    }
}
