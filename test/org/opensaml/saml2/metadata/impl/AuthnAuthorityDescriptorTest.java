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

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.opensaml.common.SAMLObjectBaseTestCase;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.common.Extensions;
import org.opensaml.saml2.metadata.AssertionIDRequestService;
import org.opensaml.saml2.metadata.AuthnAuthorityDescriptor;
import org.opensaml.saml2.metadata.AuthnQueryService;
import org.opensaml.saml2.metadata.ContactPerson;
import org.opensaml.saml2.metadata.NameIDFormat;
import org.opensaml.saml2.metadata.Organization;

/**
 * Test case for creating, marshalling, and unmarshalling
 * {@link org.opensaml.saml2.metadata.impl.AuthnAuthorityDescriptorImpl}.
 */
public class AuthnAuthorityDescriptorTest extends SAMLObjectBaseTestCase {

    /** Expected supported protocol enumeration */
    protected List<String> expectedSupportedProtocols;

    /** Expected cacheDuration value in miliseconds */
    protected long expectedCacheDuration;

    /** Expected validUntil value */
    protected DateTime expectedValidUntil;

    /** Expected errorURL value */
    protected String expectedErrorURL;

    /** Expected number of <code> KeyDescriptor </code> sub elements */
    protected int expectedKeyDescriptors;
    
    /** Expected number of <code> ContactPerson </code> sub elements */
    protected int expectedContactPersons;

    /** Expected number of <code> AuthnQueryService </code> sub elements */
    protected int expectedAuthnQueryServices;

    /** Expected number of <code> AssertionIdRequestService </code> sub elements */
    protected int expectedAssertionIdRequestServices;

    /** Expected number of <code> NameIdFormat </code> sub elements */
    protected int expectedNameIdFormats;
    /**
     * Constructor
     */
    public AuthnAuthorityDescriptorTest() {
        singleElementFile = "/data/org/opensaml/saml2/metadata/impl/AuthnAuthorityDescriptor.xml";
        singleElementOptionalAttributesFile = "/data/org/opensaml/saml2/metadata/impl/AuthnAuthorityDescriptorOptionalAttributes.xml";
        childElementsFile = "/data/org/opensaml/saml2/metadata/impl/AuthnAuthorityDescriptorChildElements.xml";
    }

    /*
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();

        expectedSupportedProtocols = new ArrayList<String>();
        expectedSupportedProtocols.add(SAMLConstants.SAML20P_NS);
        expectedCacheDuration = 90000;
        expectedValidUntil = new DateTime(2005, 12, 7, 10, 21, 0, 0, ISOChronology.getInstanceUTC());
        expectedErrorURL = "http://example.org";
        //
        // Element counts
        //
        expectedKeyDescriptors = 0;
        expectedContactPersons = 2;
        expectedAuthnQueryServices = 3;
        expectedAssertionIdRequestServices = 2;
        expectedNameIdFormats = 1;
    }

    /*
     * @see org.opensaml.common.BaseTestCase#testSingleElementUnmarshall()
     */
    public void testSingleElementUnmarshall() {
        AuthnAuthorityDescriptor authnAuthorityObj = (AuthnAuthorityDescriptor) unmarshallElement(singleElementFile);

        List<String> protoEnum = authnAuthorityObj.getSupportedProtocols();
        assertEquals("Supported protocol enumeration was not equal to expected enumeration",
                expectedSupportedProtocols, protoEnum);

        Long duration = authnAuthorityObj.getCacheDuration();
        assertNull("cacheDuration attribute has a value of " + duration + ", expected no value", duration);

        DateTime validUntil = authnAuthorityObj.getValidUntil();
        assertNull("validUntil attribute has a value of " + validUntil + ", expected no value", validUntil);

        String errorURL = authnAuthorityObj.getErrorURL();
        assertNull("errorURL attribute has a value of " + errorURL + ", expected no value", errorURL);
    }

    /*
     * @see org.opensaml.common.BaseTestCase#testSingleElementOptionalAttributesUnmarshall()
     */
    public void testSingleElementOptionalAttributesUnmarshall() {
        AuthnAuthorityDescriptor authnAuthorityObj = (AuthnAuthorityDescriptor) unmarshallElement(singleElementOptionalAttributesFile);

        List<String> protoEnum = authnAuthorityObj.getSupportedProtocols();
        assertEquals("Supported protocol enumeration was not equal to expected enumeration",
                expectedSupportedProtocols, protoEnum);

        long duration = authnAuthorityObj.getCacheDuration().longValue();
        assertEquals("cacheDuration attribute has a value of " + duration + ", expected a value of "
                + expectedCacheDuration, expectedCacheDuration, duration);

        DateTime validUntil = authnAuthorityObj.getValidUntil();
        assertEquals("validUntil attribute value did not match expected value", 0, expectedValidUntil
                .compareTo(validUntil));

        String errorURL = authnAuthorityObj.getErrorURL();
        assertEquals("errorURL attribute has a value of " + errorURL + ", expected a value of " + expectedErrorURL,
                expectedErrorURL, errorURL);
    }
    
    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testChildElementsUnmarshall()
     */
    @Override
    public void testChildElementsUnmarshall()
    {
        AuthnAuthorityDescriptor authnAuthorityObj = (AuthnAuthorityDescriptor) unmarshallElement(childElementsFile);

        assertNotNull("<Extensions>", authnAuthorityObj.getExtensions());
        // TODO KeyDescriptor
        assertEquals("KeyDescriptor", 0, authnAuthorityObj.getKeyDescriptors().size());

        assertEquals("KeyDescriptors count", expectedKeyDescriptors, authnAuthorityObj.getKeyDescriptors().size());
        assertNotNull("Organization", authnAuthorityObj.getOrganization());
        assertEquals("ContactPersons count", expectedContactPersons, authnAuthorityObj.getContactPersons().size());
        assertEquals("AuthnQueryServices count", expectedAuthnQueryServices, authnAuthorityObj.getAuthnQueryServices().size());
        assertEquals("AssertionIDRequestServices count", expectedAssertionIdRequestServices, authnAuthorityObj.getAssertionIDRequestServices().size());
        assertEquals("NameIdFormats count", expectedNameIdFormats, authnAuthorityObj.getNameIDFormats().size());
    }

    /*
     * @see org.opensaml.common.BaseTestCase#testSingleElementMarshall()
     */
    public void testSingleElementMarshall() {
        QName qname = new QName(SAMLConstants.SAML20MD_NS, AuthnAuthorityDescriptor.LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        AuthnAuthorityDescriptor descriptor = (AuthnAuthorityDescriptor) buildXMLObject(qname);

        descriptor.addSupportedProtocol(SAMLConstants.SAML20P_NS);

        assertEquals(expectedDOM, descriptor);
    }

    /*
     * @see org.opensaml.common.BaseTestCase#testSingleElementOptionalAttributesMarshall()
     */
    public void testSingleElementOptionalAttributesMarshall() {
        QName qname = new QName(SAMLConstants.SAML20MD_NS, AuthnAuthorityDescriptor.LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        AuthnAuthorityDescriptor descriptor = (AuthnAuthorityDescriptor) buildXMLObject(qname);

        descriptor.addSupportedProtocol(SAMLConstants.SAML20P_NS);
        descriptor.setValidUntil(expectedValidUntil);
        descriptor.setCacheDuration(expectedCacheDuration);
        descriptor.setErrorURL(expectedErrorURL);

        assertEquals(expectedOptionalAttributesDOM, descriptor);
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testChildElementsMarshall()
     */
    @Override
    public void testChildElementsMarshall() {
        QName qname = new QName(SAMLConstants.SAML20MD_NS, AuthnAuthorityDescriptor.LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        AuthnAuthorityDescriptor descriptor = (AuthnAuthorityDescriptor) buildXMLObject(qname);

        descriptor.addSupportedProtocol(SAMLConstants.SAML20P_NS);
        
        QName extensionsQName = new QName(SAMLConstants.SAML20MD_NS, Extensions.LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        descriptor.setExtensions((Extensions) buildXMLObject(extensionsQName));
        
        // TODO KeyDescriptor
        
        QName orgQName = new QName(SAMLConstants.SAML20MD_NS, Organization.LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        descriptor.setOrganization((Organization) buildXMLObject(orgQName));
        
        QName contactPersonQName = new QName(SAMLConstants.SAML20MD_NS, ContactPerson.LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        for (int i = 0; i < expectedContactPersons; i++) {
            descriptor.getContactPersons().add((ContactPerson) buildXMLObject(contactPersonQName));
        }
        
        QName authnQueryServiceQName = new QName(SAMLConstants.SAML20MD_NS, AuthnQueryService.LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        for (int i = 0; i < expectedAuthnQueryServices; i++) {
            descriptor.getAuthnQueryServices().add((AuthnQueryService) buildXMLObject(authnQueryServiceQName));
        }

        QName assertionIDRequestServiceQName = new QName(SAMLConstants.SAML20MD_NS, AssertionIDRequestService.LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        for (int i = 0; i < expectedAssertionIdRequestServices; i++) {
            descriptor.getAssertionIDRequestServices().add((AssertionIDRequestService) buildXMLObject(assertionIDRequestServiceQName));
        }
        
        QName nameIDFormatQName = new QName(SAMLConstants.SAML20MD_NS, NameIDFormat.LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        for (int i = 0; i < expectedNameIdFormats; i++) {
            descriptor.getNameIDFormats().add((NameIDFormat) buildXMLObject(nameIDFormatQName));
        }
        
        assertEquals(expectedChildElementsDOM, descriptor);
    }
}