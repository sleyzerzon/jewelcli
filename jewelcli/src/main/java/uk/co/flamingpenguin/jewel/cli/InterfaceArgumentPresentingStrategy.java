package uk.co.flamingpenguin.jewel.cli;

import static com.lexicalscope.fluentreflection.bean.MapBean.bean;

import java.util.Map;

import com.lexicalscope.fluentreflection.ReflectedClass;

/*
 * Copyright 2011 Tim Wood
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

class InterfaceArgumentPresentingStrategy<O> implements ArgumentPresentingStrategy<O> {
    private final ReflectedClass<O> klass;

    public InterfaceArgumentPresentingStrategy(final ReflectedClass<O> klass) {
        this.klass = klass;
    }

    @Override public O presentArguments(final Map<String, Object> argumentMap) {
        return bean(klass, argumentMap);
    }
}