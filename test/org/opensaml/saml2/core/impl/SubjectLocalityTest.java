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

package org.opensaml.saml2.core.impl;

import javax.xml.namespace.QName;

import org.opensaml.common.SAMLObjectBaseTestCase;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.SubjectLocality;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.opensaml.saml2.core.impl.SubjectLocalityImpl}.
 */
public class SubjectLocalityTest extends SAMLObjectBaseTestCase {

    /** Expected Address value */
    private String expectedAddress;

    /** Expected DNSName value */
    private String expectedDNSName;

    /** Constructor */
    public SubjectLocalityTest() {
        singleElementFile = "/data/org/opensaml/saml2/core/impl/SubjectLocality.xml";
        singleElementOptionalAttributesFile = "/data/org/opensaml/saml2/core/impl/SubjectLocalityOptionalAttributes.xml";
    }

    /*
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();

        expectedAddress = "ip address";
        expectedDNSName = "dns name";
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementUnmarshall()
     */
    public void testSingleElementUnmarshall() {
        SubjectLocality subjectLocality = (SubjectLocality) unmarshallElement(singleElementFile);
        String address = subjectLocality.getAddress();

        assertEquals("Address was " + address + ", expected " + expectedAddress, expectedAddress, address);

    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementOptionalAttributesUnmarshall()
     */
    public void testSingleElementOptionalAttributesUnmarshall() {
        SubjectLocality subjectLocality = (SubjectLocality) unmarshallElement(singleElementOptionalAttributesFile);

        String address = subjectLocality.getAddress();
        assertEquals("Address was " + address + ", expected " + expectedAddress, expectedAddress, address);

        String dnsName = subjectLocality.getDNSName();
        assertEquals("DNSName was " + dnsName + ", expected " + expectedDNSName, expectedDNSName, dnsName);
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementMarshall()
     */
    public void testSingleElementMarshall() {
        QName qname = new QName(SAMLConstants.SAML20_NS, SubjectLocality.LOCAL_NAME, SAMLConstants.SAML20_PREFIX);
        SubjectLocality subjectLocality = (SubjectLocality) buildSAMLObject(qname);

        subjectLocality.setAddress(expectedAddress);
        assertEquals(expectedDOM, subjectLocality);
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementOptionalAttributesMarshall()
     */
    public void testSingleElementOptionalAttributesMarshall() {
        QName qname = new QName(SAMLConstants.SAML20_NS, SubjectLocality.LOCAL_NAME, SAMLConstants.SAML20_PREFIX);
        SubjectLocality subjectLocality = (SubjectLocality) buildSAMLObject(qname);

        subjectLocality.setAddress(expectedAddress);
        subjectLocality.setDNSName(expectedDNSName);
        assertEquals(expectedOptionalAttributesDOM, subjectLocality);
    }
}