/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.springframework.geode.boot.autoconfigure;

import org.apache.geode.cache.GemFireCache;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.Session;
import org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession;
import org.springframework.session.data.gemfire.config.annotation.web.http.GemFireHttpSessionConfiguration;
import org.springframework.session.web.http.SessionRepositoryFilter;

/**
 * Spring Boot {@link EnableAutoConfiguration auto-configuration} for configuring either Apache Geode
 * or Pivotal GemFire as an (HTTP) {@link Session} state management provider in Spring Session.
 *
 * @author John Blum
 * @see org.apache.geode.cache.GemFireCache
 * @see org.springframework.boot.autoconfigure.EnableAutoConfiguration
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.session.Session
 * @see org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession
 * @see org.springframework.session.data.gemfire.config.annotation.web.http.GemFireHttpSessionConfiguration
 * @see org.springframework.session.web.http.SessionRepositoryFilter
 * @since 1.0.0
 */
@Configuration
@AutoConfigureAfter(ClientCacheAutoConfiguration.class)
@ConditionalOnBean(GemFireCache.class)
@ConditionalOnClass({ GemFireCache.class, GemFireHttpSessionConfiguration.class })
@ConditionalOnMissingBean(SessionRepositoryFilter.class)
@EnableGemFireHttpSession
@SuppressWarnings("unused")
public class SpringSessionAutoConfiguration {

}