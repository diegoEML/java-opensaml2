/*
 * Copyright [2005] [University Corporation for Advanced Internet Development, Inc.]
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

package org.opensaml.saml2.metadata;

/**
 * Localized String with the language associated with it.
 */
public class LocalizedString {

	/** Localized string */
	private String localizedString;
	
	/** Language of the localized string */
	private String language;
	
	/**
	 * Constructor
	 *
	 * @param localString the localized string
	 * @param language the language of the string
	 */
	public LocalizedString(String localString, String language){
		localizedString = localString;
		this.language = language;
	}
	
	/**
	 * Gets the localized string.
	 * 
	 * @return the localized string
	 */
	public String getLocalString(){
		return localizedString;
	}
	
	/**
	 * Gets the language of the string.
	 * 
	 * @return the language of the string
	 */
	public String getLanguage(){
		return language;
	}
	
	/**
	 * Determines if two LocalizedStrings are equal, that is, if both thier localized string and language have case-sentivite equality.
	 * 
	 * @param obj the object this object is compared with
	 * 
	 * @return true if the objects are equal, false if not
	 */
	public boolean equals(Object obj){
		if(obj instanceof LocalizedString){
			LocalizedString otherLString = (LocalizedString) obj;
			return localizedString.equals(otherLString.getLocalString()) && language.equals(otherLString.getLanguage());
		}
        
		return false;
	}
}