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
 * SAML 2.0 Metadata Endpoint
 */
public interface Endpoint extends SAMLObject{

    /** Element name, no namespace */
    public final static String LOCAL_NAME = "Endpoint";
    
    /** QName for this element */
    public final static QName QNAME = new QName(XMLConstants.SAML20MD_NS, LOCAL_NAME, XMLConstants.SAML20MD_PREFIX);
    
    /** "Binding" attribute name */
    public final static String BINDING_ATTRIB_NAME = "Binding";
    
    /** "Binding" attribute's QName */
    public final static QName BINDING_ATTRIB_QNAME = new QName(XMLConstants.SAML20MD_NS, BINDING_ATTRIB_NAME, XMLConstants.SAML20MD_PREFIX);
    
    /** "Location" attribute name */
    public final static String LOCATION_ATTRIB_NAME = "Location";
    
    /** "Location" attribute's QName */
    public final static QName LOCATION_ATTRIB_QNAME = new QName(XMLConstants.SAML20MD_NS, LOCATION_ATTRIB_NAME, XMLConstants.SAML20MD_PREFIX);
    
    /** "ResponseLocation" attribute name */
    public final static String RESPONSE_LOCATION_ATTRIB_NAME = "ResponseLocation";
    
    /** "ResponseLocation" attribute's QName */
    public final static QName RESPONSE_LOCATION_ATTRIB_QNAME = new QName(XMLConstants.SAML20MD_NS, RESPONSE_LOCATION_ATTRIB_NAME, XMLConstants.SAML20MD_PREFIX);
    
    /**
     * Gets the URI identifier for the binding supported by this Endpoint.
     * 
     * @return the URI identifier for the binding supported by this Endpoint
     */
	public String getBinding();
    
    /**
     * Sets the URI identifier for the binding supported by this Endpoint.
     * 
     * @param binding the URI identifier for the binding supported by this Endpoint
     */
    public void setBinding(String binding);

    /**
     * Gets the URI, usually a URL, for the location of this Endpoint.
     * 
     * @return the location of this Endpoint
     */
	public String getLocation();
    
    /**
     * Sets the URI, usually a URL, for the location of this Endpoint.
     * 
     * @param location the location of this Endpoint
     */
    public void setLocation(String location);

    /**
     * Gets the URI, usually a URL, responses should be sent to this for this Endpoint.
     * 
     * @return the URI responses should be sent to this for this Endpoint
     */
	public String getResponseLocation();
    
    /**
     * Sets the URI, usually a URL, responses should be sent to this for this Endpoint.
     * 
     * @param location the URI responses should be sent to this for this Endpoint
     */
    public void setResponseLocation(String location);
}