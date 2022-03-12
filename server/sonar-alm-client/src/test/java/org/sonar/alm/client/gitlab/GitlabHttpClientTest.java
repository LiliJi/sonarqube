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
package org.sonar.alm.client.gitlab;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sonar.alm.client.ConstantTimeoutConfiguration;
import org.sonar.alm.client.TimeoutConfiguration;
import org.sonar.api.utils.log.LogTester;
import org.sonar.api.utils.log.LoggerLevel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;

public class GitlabHttpClientTest {

  @Rule
  public LogTester logTester = new LogTester();

  private final MockWebServer server = new MockWebServer();
  private GitlabHttpClient underTest;
  private String gitlabUrl;

  @Before
  public void prepare() throws IOException {
    server.start();
    String urlWithEndingSlash = server.url("").toString();
    gitlabUrl = urlWithEndingSlash.substring(0, urlWithEndingSlash.length() - 1);

    TimeoutConfiguration timeoutConfiguration = new ConstantTimeoutConfiguration(10_000);
    underTest = new GitlabHttpClient(timeoutConfiguration);
  }

  @After
  public void stopServer() throws IOException {
    server.shutdown();
  }

  
}
