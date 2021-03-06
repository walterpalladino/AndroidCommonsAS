/*
 * Copyright 2013 Walter Hugo Palladino
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
package com.whp.android.location.geocode;

import java.io.Serializable;
import java.util.List;

/**
 * @author Walter Hugo Palladino
 * @since 21/03/2014
 * 
 */
public class GeocodeAddress implements Serializable {

	/**
	 * Property Name : serialVersionUID
	 * 
	 */
	private static final long serialVersionUID = 2656468551514911880L;

	private String formattedAddress;
	private List <String> types;

	/**
	 * @return the formattedAddress
	 */
	public String getFormattedAddress() {
		return formattedAddress;
	}

	/**
	 * @param formattedAddress
	 *            the formattedAddress to set
	 */
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	/**
	 * @return the types
	 */
	public List <String> getTypes() {
		return types;
	}

	/**
	 * @param types
	 *            the types to set
	 */
	public void setTypes(List <String> types) {
		this.types = types;
	}

}
