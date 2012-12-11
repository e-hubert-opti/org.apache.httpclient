/*
 * Copyright (C) 2011 Ahmed Yehia (ahmed.yehia.m@gmail.com)
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

package org.lightcouch;

import java.util.Properties;

/**
 * Provides configuration to client instance.
 * @author Ahmed Yehia
 */
class CouchDbConf {

	private static final String DEFAULT_FILE = "couchdb.properties";
	
	private Properties properties = new Properties();
	private CouchDbProperties dbProperties;


	public CouchDbConf(CouchDbProperties dbProperties) {
        CouchDbUtil.assertNotEmpty(dbProperties, "Properties");
        CouchDbUtil.assertNotEmpty(dbProperties.getDbName(), "Database");
        CouchDbUtil.assertNotEmpty(dbProperties.getProtocol(), "Protocol");
        CouchDbUtil.assertNotEmpty(dbProperties.getHost(), "Host");
        CouchDbUtil.assertNotEmpty(dbProperties.getPort(), "Port");
		this.dbProperties = dbProperties;
	}

	public CouchDbProperties getProperties() {
		return dbProperties;
	}



}
