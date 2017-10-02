/*
 * Copyright 2015 Open mHealth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openmhealth.schema.domain.omh;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * A unit of length.
 *
 * @author Emerson Farrugia
 * @version 1.0
 * @see <a href="http://www.openmhealth.org/documentation/#/schema-docs/schema-library/schemas/omh_length-unit-value">length-unit-value</a>
 */
public enum LengthUnit implements Unit {

    FEMTOMETER("fm"),
    PICOMETER("pm"),
    NANOMETER("nm"),
    MICROMETER("um"),
    MILLIMETER("mm"),
    CENTIMETER("cm"),
    METER("m"),
    KILOMETER("km"),
    INCH("in"),
    FOOT("ft"),
    YARD("yd"),
    MILE("mi");

    private String schemaValue;
    private static final Map<String, LengthUnit> constantsBySchemaValue = new HashMap<>();

    static {
        for (LengthUnit constant : values()) {
            constantsBySchemaValue.put(constant.getSchemaValue(), constant);
        }
    }

    LengthUnit(String schemaValue) {
        this.schemaValue = schemaValue;
    }

    @Override
    @JsonValue
    public String getSchemaValue() {
        return this.schemaValue;
    }

    @Nullable
    @JsonCreator
    public static LengthUnit findBySchemaValue(String schemaValue) {
        return constantsBySchemaValue.get(schemaValue);
    }

    public LengthUnitValue newUnitValue(BigDecimal value) {
        return new LengthUnitValue(this, value);
    }

    public LengthUnitValue newUnitValue(double value) {
        return new LengthUnitValue(this, value);
    }

    public LengthUnitValue newUnitValue(long value) {
        return new LengthUnitValue(this, value);
    }
}
