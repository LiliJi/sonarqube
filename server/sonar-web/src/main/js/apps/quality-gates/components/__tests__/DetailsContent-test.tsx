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
import { shallow } from 'enzyme';
import * as React from 'react';
import { mockQualityGate } from '../../../../helpers/mocks/quality-gates';
import { mockCondition } from '../../../../helpers/testMocks';
import { DetailsContent, DetailsContentProps } from '../DetailsContent';

it('should render correctly', () => {
  expect(shallowRender()).toMatchSnapshot('is not default');
  expect(shallowRender({ isDefault: true })).toMatchSnapshot('is default');
  expect(
    shallowRender({ isDefault: true, qualityGate: mockQualityGate({ conditions: [] }) })
  ).toMatchSnapshot('is default, no conditions');
  expect(
    shallowRender({
      qualityGate: mockQualityGate({ actions: { delegate: true } })
    })
  ).toMatchSnapshot('Admin');
});

function shallowRender(props: Partial<DetailsContentProps> = {}) {
  return shallow(
    <DetailsContent
      onAddCondition={jest.fn()}
      onRemoveCondition={jest.fn()}
      onSaveCondition={jest.fn()}
      qualityGate={mockQualityGate({ conditions: [mockCondition()] })}
      {...props}
    />
  );
}
