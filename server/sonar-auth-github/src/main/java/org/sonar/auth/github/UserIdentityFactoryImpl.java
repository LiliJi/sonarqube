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
package org.sonar.auth.github;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.sonar.api.server.authentication.UserIdentity;

public class UserIdentityFactoryImpl implements UserIdentityFactory {

  @Override
  public UserIdentity create(GsonUser user, @Nullable String email, @Nullable List<GsonTeam> teams) {
    UserIdentity.Builder builder = UserIdentity.builder()
      .setProviderId(user.getId())
      .setProviderLogin(user.getLogin())
      .setName(generateName(user))
      .setEmail(email);
    if (teams != null) {
      builder.setGroups(teams.stream()
        .map(team -> team.getOrganizationId() + "/" + team.getId())
        .collect(Collectors.toSet()));
    }
    return builder.build();
  }

  private static String generateName(GsonUser gson) {
    String name = gson.getName();
    return name == null || name.isEmpty() ? gson.getLogin() : name;
  }

}
