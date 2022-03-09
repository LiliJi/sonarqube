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
import { mockMetric } from '../../../../helpers/testMocks';
import { MetricSelectComponent } from '../MetricSelect';

it('should render correctly', () => {
  expect(shallowRender()).toMatchSnapshot();
});

it('should correctly handle change', () => {
  const onMetricChange = jest.fn();
  const metric = mockMetric();
  const metricsArray = [mockMetric({ key: 'duplication' }), metric];
  const wrapper = shallowRender({ metricsArray, onMetricChange });
  wrapper.instance().handleChange({ label: metric.name, value: metric.key });
  expect(onMetricChange).toBeCalledWith(metric);
});

function shallowRender(props: Partial<MetricSelectComponent['props']> = {}) {
  return shallow<MetricSelectComponent>(
    <MetricSelectComponent
      metricsArray={[mockMetric()]}
      metrics={{}}
      onMetricChange={jest.fn()}
      {...props}
    />
  );
}
