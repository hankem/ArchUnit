/*
 * Copyright 2014-2025 TNG Technology Consulting GmbH
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
package com.tngtech.archunit.core.domain;

import com.tngtech.archunit.PublicAPI;
import com.tngtech.archunit.core.domain.properties.HasOwner;
import com.tngtech.archunit.core.domain.properties.HasSourceCodeLocation;
import com.tngtech.archunit.core.domain.properties.HasType;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.tngtech.archunit.PublicAPI.Usage.ACCESS;

@PublicAPI(usage = ACCESS)
public final class InstanceofCheck implements HasType, HasOwner<JavaCodeUnit>, HasSourceCodeLocation {

    private final JavaCodeUnit owner;
    private final JavaClass type;
    private final boolean declaredInLambda;
    private final SourceCodeLocation sourceCodeLocation;

    private InstanceofCheck(JavaCodeUnit owner, JavaClass type, int lineNumber, boolean declaredInLambda) {
        this.owner = checkNotNull(owner);
        this.type = checkNotNull(type);
        this.declaredInLambda = declaredInLambda;
        sourceCodeLocation = SourceCodeLocation.of(owner.getOwner(), lineNumber);
    }

    @Override
    @PublicAPI(usage = ACCESS)
    public JavaClass getRawType() {
        return type;
    }

    @Override
    @PublicAPI(usage = ACCESS)
    public JavaType getType() {
        return type;
    }

    @Override
    @PublicAPI(usage = ACCESS)
    public JavaCodeUnit getOwner() {
        return owner;
    }

    @PublicAPI(usage = ACCESS)
    public int getLineNumber() {
        return sourceCodeLocation.getLineNumber();
    }

    @PublicAPI(usage = ACCESS)
    public boolean isDeclaredInLambda() {
        return declaredInLambda;
    }

    @Override
    public SourceCodeLocation getSourceCodeLocation() {
        return sourceCodeLocation;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("owner", owner)
                .add("type", type)
                .add("sourceCodeLocation", sourceCodeLocation)
                .add("declaredInLambda", declaredInLambda)
                .toString();
    }

    static InstanceofCheck from(JavaCodeUnit owner, JavaClass type, int lineNumber, boolean declaredInLambda) {
        return new InstanceofCheck(owner, type, lineNumber, declaredInLambda);
    }
}
