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
package org.sonar.db.qualitygate;

import java.util.Locale;
import org.sonar.db.user.SearchPermissionQuery;

import static java.util.Objects.requireNonNull;
import static org.sonar.db.DaoUtils.buildLikeValue;
import static org.sonar.db.WildcardPosition.BEFORE_AND_AFTER;

public class SearchQualityGatePermissionQuery extends SearchPermissionQuery {

  private final String qualityGateUuid;

  public SearchQualityGatePermissionQuery(Builder builder) {
    this.qualityGateUuid = builder.qualityGate.getUuid();
    this.query = builder.getQuery();
    this.membership = builder.getMembership();
    this.querySql = query == null ? null : buildLikeValue(query, BEFORE_AND_AFTER);
    this.querySqlLowercase = querySql == null ? null : querySql.toLowerCase(Locale.ENGLISH);
  }

  public String getQualityGateUuid() {
    return qualityGateUuid;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends SearchPermissionQuery.Builder<Builder> {
    private QualityGateDto qualityGate;

    public Builder setQualityGate(QualityGateDto qualityGate) {
      this.qualityGate = qualityGate;
      return this;
    }

    public SearchQualityGatePermissionQuery build() {
      requireNonNull(qualityGate, "Quality gate cant be null.");
      initMembership();
      return new SearchQualityGatePermissionQuery(this);
    }
  }
}
