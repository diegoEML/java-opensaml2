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

import javax.xml.namespace.QName;

import org.opensaml.common.SAMLObject;
import org.opensaml.common.util.xml.XMLConstants;

/**
 * SAML 2.0 Metadata AttributeProfile
 */
public interface AttributeProfile extends SAMLObject {
    
    /** Element name, no namespace */
    public final static String LOCAL_NAME = "AttributeProfile";
    
    /** QName for this element */
    public final static QName QNAME = new QName(XMLConstants.SAML20MD_NS, LOCAL_NAME, XMLConstants.SAML20MD_PREFIX);
    
    /**
     * Gets the URI of this attribute profile.
     * 
     * @return the URI of this attribute profile
     */
    public String getProfileURI();
    
    /**
     * Sets the URI of this attribute profile.
     * 
     * @param profileID the URI of this attribute profile
     */
    public void setProfileURI(String profileURI);
}