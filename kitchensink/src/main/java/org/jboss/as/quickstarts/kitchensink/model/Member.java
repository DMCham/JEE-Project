/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Member implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min = 8, max = 12) // Changed phone number minimum to 8
    @Digits(fraction = 0, integer = 12)
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull // Add user name field
    @Size(min = 4, max = 25)
    @Column(name = "user_name")
    private String userName;

    @NotNull // Add password field
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="Must include at least one digit, lowercase, uppercase, special character, and at least 8 characters.")
    private String passwordField;

    @Column(name = "login_user_name") // Add login user name field
    private String login_userName;

    @Column(name = "login_passwordField") // Add login password field
    private String login_passwordField;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getuserName() { // username getter
        return userName;
    }

    public void setuserName(String userName) { // username setter
        this.userName = userName;
    }

    public String getpasswordField() { // passwordField getter
        return passwordField;
    }

    public void setpasswordField(String passwordField) { // passwordField setter
        this.passwordField = passwordField;
    }

    public String getlogin_userName() { // login_userName getter
        return login_userName;
    }

    public void setlogin_userName(String login_userName) { // login_userName setter
        this.login_userName = login_userName;
    }

    public String getlogin_passwordField() { // login_passwordField getter
        return login_passwordField;
    }

    public void setlogin_passwordField(String login_passwordField) { // login_passwordField setter
        this.login_passwordField = login_passwordField;
    }
}
