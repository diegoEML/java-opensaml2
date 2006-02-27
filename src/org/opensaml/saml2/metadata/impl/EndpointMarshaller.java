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

package org.opensaml.saml2.metadata.impl;

import org.opensaml.common.impl.AbstractSAMLObjectMarshaller;
import org.opensaml.saml2.metadata.Endpoint;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.parse.XMLParserException;
import org.w3c.dom.Element;

/**
 * A thread safe Marshaller for {@link org.opensaml.saml2.metadata.Endpoint} objects.
 */
public class EndpointMarshaller extends AbstractSAMLObjectMarshaller {

    /**
     * 
     * Constructor
     * 
     * @throws XMLParserException thrown when an JAXP DatatypeFactory can not be created
     */
    public EndpointMarshaller(String targetNamespaceURI, String targetLocalName) {
        super(targetNamespaceURI, targetLocalName);
    }

    /*
     * @see org.opensaml.xml.io.AbstractXMLObjectMarshaller#marshallAttributes(org.opensaml.xml.XMLObject,
     *      org.w3c.dom.Element)
     */
    public void marshallAttributes(XMLObject samlElement, Element domElement) {
        Endpoint endpoint = (Endpoint) samlElement;

        if (endpoint.getBinding() != null) {
            domElement.setAttributeNS(null, Endpoint.BINDING_ATTRIB_NAME, endpoint.getBinding().toString());
        }
        if (endpoint.getLocation() != null) {
            domElement.setAttributeNS(null, Endpoint.LOCATION_ATTRIB_NAME, endpoint.getLocation().toString());
        }

        if (endpoint.getResponseLocation() != null) {
            domElement.setAttributeNS(null, Endpoint.RESPONSE_LOCATION_ATTRIB_NAME, endpoint.getResponseLocation()
                    .toString());
        }
    }
}