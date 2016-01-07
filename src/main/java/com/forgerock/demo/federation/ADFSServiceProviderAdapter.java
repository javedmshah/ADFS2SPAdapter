/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2010-2015 ForgeRock, Inc. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://forgerock.org/license/CDDLv1.0.html
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at http://forgerock.org/license/CDDLv1.0.html
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 */

/*
 * author Javed Shah
 *
 */
package com.forgerock.demo.federation;

import com.sun.identity.saml2.common.SAML2Exception;
import com.sun.identity.saml2.plugins.SAML2ServiceProviderAdapter;
import com.sun.identity.saml2.protocol.AuthnRequest;
import com.sun.identity.saml2.protocol.Scoping;
import com.sun.identity.shared.debug.Debug;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ADFSServiceProviderAdapter extends SAML2ServiceProviderAdapter {

    protected Debug debug = Debug.getInstance("ADFSServiceProviderAdapter");

    @Override
    public void initialize(Map initParams) {
        if (debug.messageEnabled()) {
            debug.message("ADFSServiceProviderAdapter.initialize");
        }
    }

    @Override
    public void preSingleSignOnRequest(
            String hostedEntityID,
            String idpEntityID,
            String realm,
            HttpServletRequest request,
            HttpServletResponse response,
            AuthnRequest authnRequest)
            throws SAML2Exception {
        if (debug.messageEnabled()) {
            debug.message("ADFSServiceProviderAdapter.preSingleSignOnRequest");
        }
        // ADFS does not support Scoping element
        authnRequest.setScoping(null);
        
        if (debug.messageEnabled()) {
            debug.message("ADFSServiceProviderAdapter.preSingleSignOnRequest Scoping set to null");
        }
    }
    
}
