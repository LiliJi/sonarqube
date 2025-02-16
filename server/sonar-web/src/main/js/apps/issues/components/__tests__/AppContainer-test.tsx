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
import { connect } from 'react-redux';
import { searchIssues } from '../../../../api/issues';
import { fetchBranchStatus } from '../../../../store/rootActions';
import '../AppContainer';

jest.mock('react-redux', () => ({
  connect: jest.fn(() => (a: any) => a)
}));

jest.mock('../../../../api/issues', () => ({
  searchIssues: jest.fn().mockResolvedValue({ issues: [{ some: 'issue' }], bar: 'baz' })
}));

jest.mock('../../../../helpers/issues', () => ({
  parseIssueFromResponse: jest.fn(() => 'parsedIssue')
}));

describe('redux', () => {
  it('should correctly map state and dispatch props', async () => {
    const [mapStateToProps, mapDispatchToProps] = (connect as jest.Mock).mock.calls[0];
    const { fetchIssues } = mapStateToProps({});

    expect(mapDispatchToProps).toEqual(expect.objectContaining({ fetchBranchStatus }));

    const result = await fetchIssues({ foo: 'bar' });
    expect(searchIssues).toBeCalledWith(
      expect.objectContaining({ foo: 'bar', additionalFields: '_all' })
    );
    expect(result).toEqual({ issues: ['parsedIssue'], bar: 'baz' });
  });
});
