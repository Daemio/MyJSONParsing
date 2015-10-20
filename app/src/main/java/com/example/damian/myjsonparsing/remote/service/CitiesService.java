/*
 * Copyright (C) 2012 Square, Inc.
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
package com.example.damian.myjsonparsing.remote.service;

import com.example.damian.myjsonparsing.Environment;
import com.example.damian.myjsonparsing.model.Cities;
import com.example.damian.myjsonparsing.remote.IService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

public  class CitiesService {

    protected Cities cities;

    public Cities getCities() {
        return cities;
    }

    public IService getApi() {
        IService cities = new RestAdapter.Builder()
                .setEndpoint(Environment.SERVER_URL)
                .setConverter(new JacksonConverter(getObjectMapper()))
                .build().create(IService.class);
        return cities;
    }

    protected ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper;
    }

    public IService run(){
        return getApi();
    }
}