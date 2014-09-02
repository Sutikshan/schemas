/*
 * Copyright 2014 Open mHealth
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

package org.openmhealth.schema.domain;

import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.regex.Pattern.compile;

/**
 * A sequence-based schema version, consisting of a major number, minor number, and an optional qualifier.
 *
 * @author Emerson Farrugia
 */
public class SchemaVersion {

    public static final Pattern QUALIFIER_PATTERN = compile("/[a-zA-Z0-9]+/");

    private int major;
    private int minor;
    private String qualifier;

    public SchemaVersion(int major, int minor) {
        this(major, minor, null);
    }

    public SchemaVersion(int major, int minor, String qualifier) {

        checkArgument(major >= 0);
        checkArgument(minor >= 0);
        checkArgument(qualifier == null || QUALIFIER_PATTERN.matcher(qualifier).matches());

        this.major = major;
        this.minor = minor;
        this.qualifier = qualifier;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public String getQualifier() {
        return qualifier;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(this.major);
        builder.append(".");
        builder.append(this.minor);

        if (qualifier != null) {
            builder.append(".");
            builder.append(qualifier);
        }

        return builder.toString();
    }
}