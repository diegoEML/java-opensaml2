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

import org.opensaml.common.io.Unmarshaller;
import org.opensaml.common.io.UnmarshallingException;
import org.opensaml.common.io.impl.AbstractUnmarshaller;
import org.opensaml.saml2.common.impl.AbstractSAMLObject;
import org.opensaml.saml2.metadata.AdditionalMetadataLocation;

/**
 * A thread-safe {@link org.opensaml.common.io.Unmarshaller} for {@link org.opensaml.saml2.metadata.AdditionalMetadataLocation} objects.
 */
public class AdditionalMetadataLocationUnmarshaller extends AbstractUnmarshaller implements Unmarshaller {

    /**
     * Constructor
     */
    public AdditionalMetadataLocationUnmarshaller() {
        super(AdditionalMetadataLocation.QNAME);
    }
    
    /*
     * @see org.opensaml.common.io.impl.AbstractUnmarshaller#processChildElement(org.opensaml.saml2.common.impl.AbstractSAMLElement, org.opensaml.saml2.common.impl.AbstractSAMLElement)
     */
    protected void processChildElement(AbstractSAMLObject parentElement, AbstractSAMLObject childElement)
            throws UnmarshallingException {
        //No children elements
    }

    /*
     * @see org.opensaml.common.io.impl.AbstractUnmarshaller#processAttribute(org.opensaml.saml2.common.impl.AbstractSAMLElement, java.lang.String, java.lang.String)
     */
    protected void processAttribute(AbstractSAMLObject samlElement, String attributeName, String attributeValue)
            throws UnmarshallingException {
        if(attributeName.equals(AdditionalMetadataLocation.NAMESPACE_ATTRIB_NAME)) {
            AdditionalMetadataLocation aml = (AdditionalMetadataLocation) samlElement;
            aml.setNamespaceURI(attributeValue);
        }
        
        throw new UnmarshallingException(attributeName + " is not a supported attributed for AdditionalMetadataLocation objects");
    }
    
    /**
     * Sets the DOM element content as the location URI of the AdditionaMetadataLocation object.
     */
    protected void processElementContent(AbstractSAMLObject samlElement, String elementContent) {
        super.processElementContent(samlElement, elementContent);
        
        AdditionalMetadataLocation aml = (AdditionalMetadataLocation) samlElement;
        aml.setLocationURI(elementContent);
    }
}