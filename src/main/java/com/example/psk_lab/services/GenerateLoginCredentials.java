package com.example.psk_lab.services;

import com.example.psk_lab.interceptors.LoggedInvocation;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class GenerateLoginCredentials implements Serializable {
    @Inject
    ICredentialsGenerator loginCredentialsGenerator;

    private CompletableFuture<String> loginCredentialsGenerationTask = null;

    @LoggedInvocation
    public String generateNewSecretId(String name, String surname) {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        loginCredentialsGenerationTask = CompletableFuture.supplyAsync(() -> loginCredentialsGenerator.generateLoginCredentials(name, surname));

        return  "/studentDetails.xhtml?faces-redirect=true&studentId=" + requestParameters.get("studentId");
    }

    public boolean isLoginCredentialsGenerationRunning() {
        return loginCredentialsGenerationTask != null && !loginCredentialsGenerationTask.isDone();
    }

    public String getLoginCredentialGenerationStatus() throws ExecutionException, InterruptedException {
        if (loginCredentialsGenerationTask == null) {
            return null;
        } else if (isLoginCredentialsGenerationRunning()) {
            return "Login credentials generation in progress... ";
        }
        return "Generated login credentials for student id: " + loginCredentialsGenerationTask.get();
    }
}