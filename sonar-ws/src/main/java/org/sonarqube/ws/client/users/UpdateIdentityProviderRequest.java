/*
 * SonarQube
 * Copyright (C) 2009-2022 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarqube.ws.client.users;

import javax.annotation.Generated;

/**
 * This is part of the internal API.
 * This is a POST request.
 * @see <a href="https://next.sonarqube.com/sonarqube/web_api/api/users/update_identity_provider">Further information about this action online (including a response example)</a>
 * @since 8.7
 */
@Generated("sonar-ws-generator")
public class UpdateIdentityProviderRequest {

  private String login;
  private String newExternalIdentity;
  private String newExternalProvider;

  /**
   * This is a mandatory parameter.
   */
  public UpdateIdentityProviderRequest setLogin(String login) {
    this.login = login;
    return this;
  }

  public String getLogin() {
    return login;
  }

  /**
   */
  public UpdateIdentityProviderRequest setNewExternalIdentity(String newExternalIdentity) {
    this.newExternalIdentity = newExternalIdentity;
    return this;
  }

  public String getNewExternalIdentity() {
    return newExternalIdentity;
  }

  /**
   * This is a mandatory parameter.
   */
  public UpdateIdentityProviderRequest setNewExternalProvider(String newExternalProvider) {
    this.newExternalProvider = newExternalProvider;
    return this;
  }

  public String getNewExternalProvider() {
    return newExternalProvider;
  }
}
