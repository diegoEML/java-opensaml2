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

/**
 * 
 */
package org.opensaml.saml2.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.opensaml.common.SAMLObject;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.AssertionIDRef;
import org.opensaml.saml2.core.AssertionIDRequest;
import org.opensaml.xml.util.XMLObjectChildrenList;

/**
 * A concrete implementation of {@link org.opensaml.saml2.core.AssertionIDRequest}
 */
public class AssertionIDRequestImpl extends RequestImpl implements AssertionIDRequest {
    
    /** List of AssertionIDRef child elements */
    private XMLObjectChildrenList<AssertionIDRef> assertionIDRefs;

    /**
     * Constructor
     */
    public AssertionIDRequestImpl() {
        super(SAMLConstants.SAML20P_NS, AssertionIDRequest.LOCAL_NAME);
        setElementNamespacePrefix(SAMLConstants.SAML20P_PREFIX);
        assertionIDRefs = new XMLObjectChildrenList<AssertionIDRef>(this);
    }

    /**
     * @see org.opensaml.saml2.core.AssertionIDRequest#getAssertionIDRefs()
     */
    public List<AssertionIDRef> getAssertionIDRefs() {
        return assertionIDRefs;
    }

    /**
     * @see org.opensaml.saml2.core.impl.RequestImpl#getOrderedChildren()
     */
    public List<SAMLObject> getOrderedChildren() {
        ArrayList<SAMLObject> children = new ArrayList<SAMLObject>();
        
        if (super.getOrderedChildren() != null)
            children.addAll(super.getOrderedChildren());
        children.addAll(assertionIDRefs);
        
        if (children.size() == 0)
            return null;
        
        return Collections.unmodifiableList(children);
    }
    
    

}