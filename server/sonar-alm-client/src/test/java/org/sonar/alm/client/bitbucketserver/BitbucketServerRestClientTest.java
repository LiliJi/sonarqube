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
package org.sonar.alm.client.bitbucketserver;

import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sonar.alm.client.ConstantTimeoutConfiguration;
import org.sonar.api.utils.log.LogTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;

public class BitbucketServerRestClientTest {
  private final MockWebServer server = new MockWebServer();
  private static final String REPOS_BODY = "{\n" +
    "  \"isLastPage\": true,\n" +
    "  \"values\": [\n" +
    "    {\n" +
    "      \"slug\": \"banana\",\n" +
    "      \"id\": 2,\n" +
    "      \"name\": \"banana\",\n" +
    "      \"project\": {\n" +
    "        \"key\": \"HOY\",\n" +
    "        \"id\": 2,\n" +
    "        \"name\": \"hoy\"\n" +
    "      }\n" +
    "    },\n" +
    "    {\n" +
    "      \"slug\": \"potato\",\n" +
    "      \"id\": 1,\n" +
    "      \"name\": \"potato\",\n" +
    "      \"project\": {\n" +
    "        \"key\": \"HEY\",\n" +
    "        \"id\": 1,\n" +
    "        \"name\": \"hey\"\n" +
    "      }\n" +
    "    }\n" +
    "  ]\n" +
    "}";

  @Rule
  public LogTester logTester = new LogTester();

  private BitbucketServerRestClient underTest;


  

}
