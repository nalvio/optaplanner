/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.persistence.jaxb.api.score.buildin.hardmediumsoft;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.junit.Test;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.persistence.jaxb.api.score.AbstractScoreJaxbXmlAdapterTest;

import static org.junit.Assert.*;

public class HardMediumSoftScoreJaxbXmlAdapterTest extends AbstractScoreJaxbXmlAdapterTest {

    @Test
    public void serializeAndDeserialize() {
        assertSerializeAndDeserialize(null, new TestHardMediumSoftScoreWrapper(null));
        HardMediumSoftScore score = HardMediumSoftScore.valueOfInitialized(1200, 30, 4);
        assertSerializeAndDeserialize(score, new TestHardMediumSoftScoreWrapper(score));
        score = HardMediumSoftScore.valueOf(-7, 1200, 30, 4);
        assertSerializeAndDeserialize(score, new TestHardMediumSoftScoreWrapper(score));
    }

    @XmlRootElement
    public static class TestHardMediumSoftScoreWrapper extends TestScoreWrapper<HardMediumSoftScore> {

        @XmlJavaTypeAdapter(HardMediumSoftScoreJaxbXmlAdapter.class)
        private HardMediumSoftScore score;

        @SuppressWarnings("unused")
        private TestHardMediumSoftScoreWrapper() {
        }

        public TestHardMediumSoftScoreWrapper(HardMediumSoftScore score) {
            this.score = score;
        }

        @Override
        public HardMediumSoftScore getScore() {
            return score;
        }

    }

}