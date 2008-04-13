/*
 * Copyright [2006] [University Corporation for Advanced Internet Development, Inc.]
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

package org.opensaml.samlext.saml2mdquery.impl;

import org.opensaml.common.impl.AbstractSAMLObjectBuilder;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.samlext.saml2mdquery.ActionNamespace;

/**
 * Builder of {@link ActionNamespaceImpl} objects.
 */
public class ActionNamespaceBuilder extends AbstractSAMLObjectBuilder<ActionNamespace> {

    /** Constructor */
    public ActionNamespaceBuilder() {

    }

    /** {@inheritDoc} */
    public ActionNamespace buildObject() {
        return buildObject(SAMLConstants.SAML20MDQUERY_NS, ActionNamespace.DEFAULT_ELEMENT_LOCAL_NAME,
                SAMLConstants.SAML20MDQUERY_PREFIX);
    }

    /** {@inheritDoc} */
    public ActionNamespace buildObject(String namespaceURI, String localName, String namespacePrefix) {
        return new ActionNamespaceImpl(namespaceURI, localName, namespacePrefix);
    }
}