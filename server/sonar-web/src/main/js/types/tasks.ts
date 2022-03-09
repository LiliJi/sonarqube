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
export enum TaskTypes {
  Report = 'REPORT',
  IssueSync = 'ISSUE_SYNC',
  AppRefresh = 'APP_REFRESH',
  ViewRefresh = 'VIEW_REFRESH',
  ProjectExport = 'PROJECT_EXPORT',
  ProjectImport = 'PROJECT_IMPORT'
}

export enum TaskStatuses {
  Pending = 'PENDING',
  InProgress = 'IN_PROGRESS',
  Success = 'SUCCESS',
  Failed = 'FAILED',
  Canceled = 'CANCELED'
}

export interface Task {
  analysisId?: string;
  branch?: string;
  componentKey?: string;
  componentName?: string;
  componentQualifier?: string;
  errorMessage?: string;
  errorStacktrace?: string;
  errorType?: string;
  executedAt?: string;
  executionTimeMs?: number;
  hasErrorStacktrace?: boolean;
  hasScannerContext?: boolean;
  id: string;
  pullRequest?: string;
  pullRequestTitle?: string;
  scannerContext?: string;
  startedAt?: string;
  status: TaskStatuses;
  submittedAt: string;
  submitterLogin?: string;
  type: TaskTypes;
  warningCount?: number;
  warnings?: string[];
}

export interface TaskWarning {
  key: string;
  message: string;
  dismissable: boolean;
}
