/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.boot.spi;

import lombok.Data;
import org.apache.karaf.boot.config.KarafConfig;
import org.apache.karaf.boot.service.ServiceRegistry;

import java.util.Locale;

public interface Service {

    int DEFAULT_PRIORITY = 1000;

    default void onRegister(final Registration registration) throws Exception {
        // no-op, service
    }

    default int priority() {
        return DEFAULT_PRIORITY;
    }

    default String name() {
        return getClass().getSimpleName().toLowerCase(Locale.ROOT).replaceAll("Service", "");
    }

    @Data
    class Registration {
        private final KarafConfig config;
        private final ServiceRegistry registry;
    }

}
